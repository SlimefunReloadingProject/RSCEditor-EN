package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.BooleanTypeItem;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.api.objects.types.TemplateMachineRecipe;
import com.balugaq.rsceditor.api.items.TextTypeItem;
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
public class TemplateRecipeMachineEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("npithfrrr")
            .addLine("NPITHFrrr")
            .addLine("ceslaorrr")
            .addLine("CESLAOBBB")
            .addLine("mmmmmmmMB")
            .addLine("mmmmmmmMG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("N", Icons.id)
            .addItem("P", Icons.item_group)
            .addItem("I", Icons.item)
            .addItem("T", Icons.recipe_type)
            .addItem("H", Icons.hide_all_recipes)
            .addItem("F", Icons.faster_if_more_templates)
            .addItem("C", Icons.energy_capacity)
            .addItem("E", Icons.energy_consumption)
            .addItem("S", Icons.template_slot)
            .addItem("L", Icons.title)
            .addItem("A", Icons.progress_bar_slot)
            .addItem("O", Icons.more_output_if_more_templates)
            .addItem("M", Icons.template_machine_recipes)
            .addItem("G", Icons.build_template_machine);

    public TemplateRecipeMachineEditor(@NotNull SlimefunItemStack item) {
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

                // Hide all recipes button
                menu.addMenuClickHandler(matrix.getChar("h"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
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

                // Faster if more templates button
                menu.addMenuClickHandler(matrix.getChar("f"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
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

                // Energy consumption button
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

                // Template slot button
                menu.addMenuClickHandler(matrix.getChar("s"), (p, s, i, a) -> {
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

                // Progress bar slot button
                menu.addMenuClickHandler(matrix.getChar("a"), (p, s, i, a) -> {
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

                // More output button
                menu.addMenuClickHandler(matrix.getChar("o"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
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
                        p.sendMessage("你还没有设置这个物品的电容量");
                        return false;
                    }
                    int capacity = p4.getSecondValue();
                    writer.set("capacity", capacity);

                    // energy per craft
                    Pair<Boolean, Integer> p5 = ItemUtil.isInteger(menu, matrix, "e");
                    if (!p5.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的每次制作消耗的能量");
                        return false;
                    }
                    int consumption = p5.getSecondValue();
                    writer.set("consumption", consumption);

                    // template slot
                    Pair<Boolean, Integer> p8 = ItemUtil.isInteger(menu, matrix, "s");
                    if (!p8.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的模板槽位");
                        return false;
                    }
                    int template_slot = p8.getSecondValue();
                    writer.set("templateSlot", template_slot);

                    // hide all recipes
                    boolean hide_all_recipes = false;
                    Pair<Boolean, Boolean> p10 = ItemUtil.isBoolean(menu, matrix, "h");
                    if (p10.getFirstValue()) {
                        hide_all_recipes = p10.getSecondValue();
                    }
                    writer.set("hideAllRecipes", hide_all_recipes);

                    // faster if more templates
                    boolean faster_if_more_templates = false;
                    Pair<Boolean, Boolean> p11 = ItemUtil.isBoolean(menu, matrix, "f");
                    if (p11.getFirstValue()) {
                        faster_if_more_templates = p11.getSecondValue();
                    }
                    writer.set("fasterIfMoreTemplates", faster_if_more_templates);

                    // more output if more templates
                    boolean more_output_if_more_templates = false;
                    Pair<Boolean, Boolean> p12 = ItemUtil.isBoolean(menu, matrix, "o");
                    if (p12.getFirstValue()) {
                        more_output_if_more_templates = p12.getSecondValue();
                    }
                    writer.set("moreOutputIfMoreTemplates", more_output_if_more_templates);

                    Pair<Boolean, List<TemplateMachineRecipe>> p6 = ItemUtil.isTemplateMachineRecipes(menu, matrix, "m");
                    if (p6.getFirstValue()) {
                        for (TemplateMachineRecipe recipe : p6.getSecondValue()) {
                            writer.set("recipes", recipe);
                        }
                    }

                    String title = ItemStackHelper.getDisplayName(itemStack);
                    Pair<Boolean, String> p7 = ItemUtil.isString(menu, matrix, "l");
                    if (p7.getFirstValue()) {
                        title = p7.getSecondValue();
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

                        YamlWriter menuWriter = mc.getAsYamlWriter(menu, input, output, id, title, progress_bar_slot);
                        ClipboardUtil.send(p, "菜单编辑器: ", menuWriter.toString());
                        p.sendMessage(ChatColor.YELLOW + "==============================");
                    }

                    ClipboardUtil.send(p, "模板机器编辑器: ", writer.toString());

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
