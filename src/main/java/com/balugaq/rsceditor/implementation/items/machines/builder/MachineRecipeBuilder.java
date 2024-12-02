package com.balugaq.rsceditor.implementation.items.machines.builder;

import com.balugaq.rsceditor.api.AbstractContainer;
import com.balugaq.rsceditor.api.IntegerTypeItem;
import com.balugaq.rsceditor.api.ItemFlowType;
import com.balugaq.rsceditor.api.MachineRecipe;
import com.balugaq.rsceditor.api.MachineRecipeItem;
import com.balugaq.rsceditor.api.MenuMatrix;
import com.balugaq.rsceditor.api.TextTypeItem;
import com.balugaq.rsceditor.implementation.items.machines.container.ItemFlowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.MenuContainer;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MachineRecipeBuilder extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("cnetBBBBB")
            .addLine("CNETBBBBB")
            .addLine("BBBBBBBBB")
            .addLine("BBBBBBBBB")
            .addLine("BBBBBBBBB")
            .addLine("BBBBBBBBG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("N", Icons.recipe_name)
            .addItem("E", Icons.energy_cost)
            .addItem("T", Icons.processing_time)
            .addItem("G", Icons.build_machine_recipe);

    public MachineRecipeBuilder(@NotNull SlimefunItemStack item) {
        super(item);
    }

    @Override
    public @NotNull BlockMenuPreset setBlockMenuPreset() {
        return new BlockMenuPreset(getId(), getItemName()) {
            @Override
            public void init() {
                matrix.build(this);
            }

            @Override
            public void newInstance(@NotNull BlockMenu menu, @NotNull Block b) {
                // Name button
                menu.addMenuClickHandler(matrix.getChar("n"), (p, s, i, a) -> {
                    if (SlimefunItem.getByItem(i) instanceof TextTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // Energy Cost button
                menu.addMenuClickHandler(matrix.getChar("e"), (p, s, i, a) -> {
                    if (SlimefunItem.getByItem(i) instanceof IntegerTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // Build button
                menu.addMenuClickHandler(matrix.getChar("G"), (p, s, i, a) -> {
                    ItemStack machineRecipeCard = menu.getItemInSlot(matrix.getChar("c"));
                    if (!(SlimefunItem.getByItem(machineRecipeCard) instanceof MachineRecipeItem mri)) {
                        p.sendMessage("该物品不是机器配方卡!");
                        return false;
                    }

                    Pair<Boolean, String> p0 = ItemUtil.isString(menu, matrix, "n");
                    if (!p0.getFirstValue()) {
                        p.sendMessage("你还没有设置这个配方的名字");
                        return false;
                    }

                    String name = p0.getSecondValue();

                    Pair<Boolean, Integer> p1 = ItemUtil.isInteger(menu, matrix, "e");
                    if (!p1.getFirstValue()) {
                        p.sendMessage("你还没有设置这个配方的能量消耗");
                        return false;
                    }

                    int energyCost = p1.getSecondValue();

                    Pair<Boolean, Integer> p2 = ItemUtil.isInteger(menu, matrix, "t");
                    if (!p2.getFirstValue()) {
                        p.sendMessage("你还没有设置这个配方的处理时间");
                        return false;
                    }

                    int processingTime = p2.getSecondValue();

                    // let's read the item flow from the below container
                    Map<Integer, ItemFlowType> types;
                    Location flowContainer = b.getRelative(BlockFace.DOWN).getLocation();
                    SlimefunItem flowItem = StorageCacheUtils.getSfItem(flowContainer);
                    if (flowItem instanceof ItemFlowContainer ifc) {
                        BlockMenu flowMenu = StorageCacheUtils.getMenu(flowContainer);
                        if (flowItem == null) {
                            p.sendMessage("物流容器不正确!");
                            return false;
                        }

                        types = ifc.getFlowTypes(flowMenu);
                    } else {
                        p.sendMessage("下方的物流容器不正确!");
                        return false;
                    }

                    Map<Integer, ItemStack> contents;
                    // then read the menu from the above container
                    Location menuContainer = b.getRelative(BlockFace.UP).getLocation();
                    SlimefunItem menuItem = StorageCacheUtils.getSfItem(menuContainer);
                    if (menuItem instanceof MenuContainer mc) {
                        BlockMenu menuBlockMenu = StorageCacheUtils.getMenu(menuContainer);
                        if (menuItem == null) {
                            p.sendMessage("菜单容器不正确!");
                            return false;
                        }

                        contents = mc.getMenuContent(menuBlockMenu);
                    } else {
                        p.sendMessage("上方的菜单容器不正确!");
                        return false;
                    }

                    List<ItemStack> lInputs = new ArrayList<>();
                    List<ItemStack> lOutputs = new ArrayList<>();

                    for (int slot : types.keySet()) {
                        ItemFlowType type = types.get(slot);
                        if (type == ItemFlowType.INSERT || type == ItemFlowType.INSERT_AND_WITHDRAW) {
                            ItemStack item = contents.get(slot);
                            if (item != null && item.getType() != Material.AIR) {
                                lInputs.add(item);
                            }
                        }
                        if (type == ItemFlowType.WITHDRAW || type == ItemFlowType.INSERT_AND_WITHDRAW || type == ItemFlowType.FREE_OUTPUT) {
                            ItemStack item = contents.get(slot);
                            if (item != null && item.getType() != Material.AIR) {
                                lOutputs.add(item);
                            }
                        }
                    }

                    ItemStack[] inputs = new ItemStack[lInputs.size()];
                    ItemStack[] outputs = new ItemStack[lOutputs.size()];

                    for (int j = 0; j < lInputs.size(); j++) {
                        inputs[j] = lInputs.get(j);
                    }

                    for (int j = 0; j < lOutputs.size(); j++) {
                        outputs[j] = lOutputs.get(j);
                    }

                    MachineRecipe recipe = new MachineRecipe(name, energyCost, processingTime, inputs, outputs);
                    mri.setRecipe(machineRecipeCard, recipe);

                    p.sendMessage("机器配方已保存!");

                    return false;
                });
            }

            @Override
            public boolean canOpen(@NotNull Block block, @NotNull Player player) {
                return player.isOp();
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow itemTransportFlow) {
                return new int[0];
            }
        };
    }
}
