package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.AbstractContainer;
import com.balugaq.rsceditor.api.IntegerTypeItem;
import com.balugaq.rsceditor.api.ItemFlowType;
import com.balugaq.rsceditor.api.MachineRecipe;
import com.balugaq.rsceditor.api.MenuMatrix;
import com.balugaq.rsceditor.api.TextTypeItem;
import com.balugaq.rsceditor.implementation.items.machines.container.ItemFlowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.MenuContainer;
import com.balugaq.rsceditor.utils.ClipboardUtil;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemStackHelper;
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
public class MaterialGeneratorEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("npitkBrrr")
            .addLine("NPITKBrrr")
            .addLine("celuBBrrr")
            .addLine("CELUBBBBB")
            .addLine("mmmmmmmMB")
            .addLine("mmmmmmmMG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("N", Icons.id)
            .addItem("P", Icons.item_group)
            .addItem("I", Icons.item)
            .addItem("T", Icons.recipe_type)
            .addItem("K", Icons.tick_rate)
            .addItem("C", Icons.energy_capacity)
            .addItem("E", Icons.per)
            .addItem("L", Icons.title)
            .addItem("U", Icons.status)
            .addItem("M", Icons.machine_recipes)
            .addItem("G", Icons.build_material_generator);

    public MaterialGeneratorEditor(@NotNull SlimefunItemStack item) {
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
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // Tick rate button
                menu.addMenuClickHandler(matrix.getChar("k"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
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

                // Energy capacity button
                menu.addMenuClickHandler(matrix.getChar("c"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
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

                // Per button
                menu.addMenuClickHandler(matrix.getChar("e"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
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

                // Status button
                menu.addMenuClickHandler(matrix.getChar("u"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
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

                // Title button
                menu.addMenuClickHandler(matrix.getChar("l"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
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

                //

                // Build button
                menu.addMenuClickHandler(matrix.getChar("G"), (p, s, i, a) -> {
                    YamlWriter writer = new YamlWriter();
                    Pair<Boolean, String> p0 = ItemUtil.isString(menu, matrix, "n");
                    if (!p0.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的ID");
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
                        writer.set("recipe." + j, recipes.getSecondValue().get(j - 1));
                    }

                    Pair<Boolean, Integer> p4 = ItemUtil.isInteger(menu, matrix, "c");
                    if (!p4.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的能量容量");
                        return false;
                    }
                    int capacity = p4.getSecondValue();
                    writer.set("capacity", capacity);

                    // tick rate
                    Pair<Boolean, Integer> p5 = ItemUtil.isInteger(menu, matrix, "k");
                    if (!p5.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的产出物品间隔");
                        return false;
                    }
                    int tickRate = p5.getSecondValue();
                    writer.set("tickRate", tickRate);

                    // per
                    Pair<Boolean, Integer> p6 = ItemUtil.isInteger(menu, matrix, "e");
                    if (!p6.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的产出物品耗电量");
                        return false;
                    }
                    int per = p6.getSecondValue();
                    writer.set("per", per);

                    // status
                    Pair<Boolean, Integer> p8 = ItemUtil.isInteger(menu, matrix, "u");
                    if (!p8.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的状态槽");
                        return false;
                    }
                    int status = p8.getSecondValue();
                    writer.set("status", status);

                    // recipe
                    Pair<Boolean, List<MachineRecipe>> p9 = ItemUtil.isMachineRecipes(menu, matrix, "m");
                    if (p9.getFirstValue()) {
                        int index = 1;
                        for (MachineRecipe recipe : p9.getSecondValue()) {
                            for (ItemStack output : recipe.getOutputs()) {
                                writer.set("recipes." + index, output);
                            }
                            index++;
                        }
                    }

                    String title = ItemStackHelper.getDisplayName(itemStack);
                    Pair<Boolean, String> p7 = ItemUtil.isString(menu, matrix, "l");
                    if (p7.getFirstValue()) {
                        title = p7.getSecondValue();
                    }

                    // for input, output slots and menu
                    int[] output = new int[0];
                    Location flowContainer = b.getRelative(BlockFace.DOWN).getLocation();
                    SlimefunItem flowItem = StorageCacheUtils.getSfItem(flowContainer);
                    if (flowItem instanceof ItemFlowContainer ifc) {
                        BlockMenu flowMenu = StorageCacheUtils.getMenu(flowContainer);
                        if (flowMenu == null) {
                            p.sendMessage("未检测到物流容器!");
                        } else {
                            Map<Integer, ItemFlowType> types = ifc.getFlowTypes(flowMenu);

                            List<Integer> output_slots = new ArrayList<>();

                            for (Integer slot : types.keySet()) {
                                ItemFlowType type = types.get(slot);
                                if (type == ItemFlowType.WITHDRAW || type == ItemFlowType.INSERT_AND_WITHDRAW || type == ItemFlowType.FREE_OUTPUT) {
                                    output_slots.add(slot);
                                }
                            }

                            output = new int[output_slots.size()];

                            for (int j = 0; j < output_slots.size(); j++) {
                                output[j] = output_slots.get(j);
                            }

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

                        YamlWriter menuWriter = mc.getAsYamlWriter(menu, new int[0], output, id, title);
                        ClipboardUtil.send(p, "菜单编辑器: ", menuWriter.toString());
                        p.sendMessage(ChatColor.YELLOW + "==============================");
                    }

                    ClipboardUtil.send(p, "材料生成器编辑器: ", writer.toString());

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
