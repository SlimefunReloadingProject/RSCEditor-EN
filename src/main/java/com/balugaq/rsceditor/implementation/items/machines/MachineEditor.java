package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.items.RegisterItem;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.implementation.items.machines.container.ItemFlowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.MenuContainer;
import com.balugaq.rsceditor.utils.ClipboardUtil;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import com.balugaq.rsceditor.utils.YamlWriter;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @noinspection DataFlowIssue
 */
@SuppressWarnings("deprecation")
public class MachineEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("npitsqrrr")
            .addLine("NPITSQrrr")
            .addLine("celwaBrrr")
            .addLine("CELWABBBB")
            .addLine("BBBBBBBBB")
            .addLine("BBBBBBBBG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("Q", Icons.register_card)
            .addItem("N", Icons.id)
            .addItem("P", Icons.item_group)
            .addItem("I", Icons.item)
            .addItem("T", Icons.recipe_type)
            .addItem("S", Icons.script)
            .addItem("C", Icons.capacity)
            .addItem("E", Icons.energy_net_component_type)
            .addItem("L", Icons.title)
            .addItem("W", Icons.work)
            .addItem("A", Icons.progress_bar_slot)
            .addItem("G", Icons.build_machine);

    public MachineEditor(@NotNull SlimefunItemStack item) {
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
                // Id button
                menu.addMenuClickHandler(matrix.getChar("n"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof TextTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("Input content: ");
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // Script button
                menu.addMenuClickHandler(matrix.getChar("s"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof TextTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("Input content: ");
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // Energy capacity button
                menu.addMenuClickHandler(matrix.getChar("c"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof IntegerTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("Input content: ");
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });

                        return false;
                    }

                    return true;
                });

                // Title button
                menu.addMenuClickHandler(matrix.getChar("l"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof TextTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("Input content: ");
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });

                        return false;
                    }

                    return true;
                });

                // Work button
                menu.addMenuClickHandler(matrix.getChar("w"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof IntegerTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("Input content: ");
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });

                        return false;
                    }

                    return true;
                });

                // Progress bar slot button
                menu.addMenuClickHandler(matrix.getChar("a"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof IntegerTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("Input content: ");
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
                    YamlWriter writer = new YamlWriter();
                    Pair<Boolean, String> p0 = ItemUtil.isString(menu, matrix, "n");
                    if (!p0.getFirstValue()) {
                        p.sendMessage("You haven't set the item's id");
                        return false;
                    }
                    String id = p0.getSecondValue();
                    Pair<Boolean, ItemStack> p1 = ItemUtil.isItem(menu, matrix, "i");
                    if (!p1.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的物品模型");
                        return false;
                    }
                    writer.setRoot(id);

                    ItemStack itemStack = p1.getSecondValue();
                    writer.set("item", itemStack);

                    Pair<Boolean, ItemGroup> p2 = ItemUtil.isItemGroupItem(menu, matrix, "p");
                    if (!p2.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的物品组");
                        return false;
                    }
                    ItemGroup itemGroup = p2.getSecondValue();
                    writer.set("item_group", itemGroup.getKey().getKey());

                    Pair<Boolean, RecipeType> p3 = ItemUtil.isRecipeTypeItem(menu, matrix, "t");
                    RecipeType recipeType = RecipeType.NULL;
                    if (p3.getFirstValue()) {
                        recipeType = p3.getSecondValue();
                    }
                    writer.set("recipe_type", recipeType.getKey().getKey().toUpperCase());

                    Pair<Boolean, List<ItemStack>> recipes = ItemUtil.isItems(menu, matrix, "r");
                    for (int j = 1; j <= 9; j++) {
                        writer.set("recipe." + j, recipes.getSecondValue().get(j - 1), false);
                    }

                    Pair<Boolean, Integer> p4 = ItemUtil.isInteger(menu, matrix, "c");
                    if (!p4.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的能量容量");
                        return false;
                    }
                    int capacity = p4.getSecondValue();
                    writer.set("energy.capacity", capacity);

                    EnergyNetComponentType energyNetComponentType = EnergyNetComponentType.NONE;
                    Pair<Boolean, EnergyNetComponentType> p5 = ItemUtil.isEnergyNetComponentType(menu, matrix, "e");
                    if (p5.getFirstValue()) {
                        energyNetComponentType = p5.getSecondValue();
                    }
                    writer.set("energy.type", energyNetComponentType.name());

                    Pair<Boolean, String> p6 = ItemUtil.isString(menu, matrix, "s");
                    if (p6.getFirstValue()) {
                        String script = p6.getSecondValue();
                        writer.set("script", script);
                    }

                    String title = ItemStackHelper.getDisplayName(itemStack);
                    Pair<Boolean, String> p7 = ItemUtil.isString(menu, matrix, "l");
                    if (p7.getFirstValue()) {
                        title = p7.getSecondValue();
                    }

                    Pair<Boolean, Integer> p8 = ItemUtil.isInteger(menu, matrix, "w");
                    if (p8.getFirstValue()) {
                        int work = p8.getSecondValue();
                        writer.set("work", work);
                    }

                    // for input, output slots and menu
                    int progress_bar_slot = 22;
                    Pair<Boolean, Integer> p9 = ItemUtil.isInteger(menu, matrix, "a");
                    if (p9.getFirstValue()) {
                        progress_bar_slot = p9.getSecondValue();
                    }

                    int[] input = new int[0];
                    int[] output = new int[0];
                    Location flowContainer = b.getRelative(BlockFace.DOWN).getLocation();
                    SlimefunItem flowItem = StorageCacheUtils.getSfItem(flowContainer);
                    if (flowItem instanceof ItemFlowContainer ifc) {
                        BlockMenu flowMenu = StorageCacheUtils.getMenu(flowContainer);
                        if (flowMenu == null) {
                            p.sendMessage("未检测到物流容器!");
                        } else {
                            Map<Integer, ItemFlowType> types = ifc.getFlowTypes(flowMenu);

                            List<Integer> input_slots = new ArrayList<>();
                            List<Integer> output_slots = new ArrayList<>();

                            for (Integer slot : types.keySet()) {
                                ItemFlowType type = types.get(slot);
                                if (type == ItemFlowType.INSERT || type == ItemFlowType.INSERT_AND_WITHDRAW) {
                                    input_slots.add(slot);
                                }

                                if (type == ItemFlowType.WITHDRAW || type == ItemFlowType.INSERT_AND_WITHDRAW || type == ItemFlowType.FREE_OUTPUT) {
                                    output_slots.add(slot);
                                }
                            }

                            input = new int[input_slots.size()];
                            output = new int[output_slots.size()];

                            for (int j = 0; j < input_slots.size(); j++) {
                                input[j] = input_slots.get(j);
                            }

                            for (int j = 0; j < output_slots.size(); j++) {
                                output[j] = output_slots.get(j);
                            }

                            writer.set("input", input);
                            writer.set("output", output);
                        }
                    }

                    Location menuContainer = b.getRelative(BlockFace.UP).getLocation();
                    SlimefunItem menuItem = StorageCacheUtils.getSfItem(menuContainer);
                    if (menuItem instanceof MenuContainer mc) {
                        BlockMenu menuBlockMenu = StorageCacheUtils.getMenu(menuContainer);
                        if (menuBlockMenu == null) {
                            return false;
                        }

                        YamlWriter menuWriter = mc.getAsYamlWriter(menuBlockMenu, input, output, id, title, progress_bar_slot);
                        ClipboardUtil.send(p, "菜单编辑器: ", menuWriter.toString());
                        p.sendMessage(ChatColor.YELLOW + "==============================");
                    }

                    Pair<Boolean, ItemStack> p99 = ItemUtil.isItem(menu, matrix, "Q");
                    if (p99.getFirstValue()) {
                        ItemStack registerCard = p99.getSecondValue();
                        if (SlimefunItem.getByItem(registerCard) instanceof RegisterItem ri) {
                            writer.set("register", ri.getRegister(registerCard));
                        }
                    }

                    ClipboardUtil.send(p, "机器编辑器: ", writer.toString());

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
