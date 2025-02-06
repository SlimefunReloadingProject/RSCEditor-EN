package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.BooleanTypeItem;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.items.RegisterItem;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.api.objects.types.LinkedMachineRecipe;
import com.balugaq.rsceditor.implementation.items.machines.container.ItemFlowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.MenuContainer;
import com.balugaq.rsceditor.utils.*;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
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
@SuppressWarnings("deprecation")
public class LinkedRecipeMachineEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("npithurrr")
            .addLine("NPITHUrrr")
            .addLine("ceslaqrrr")
            .addLine("CESLAQBBB")
            .addLine("mmmmmmmMB")
            .addLine("mmmmmmmMG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("Q", Icons.register_card)
            .addItem("N", Icons.id)
            .addItem("P", Icons.item_group)
            .addItem("I", Icons.item)
            .addItem("T", Icons.recipe_type)
            .addItem("H", Icons.hide_all_recipes)
            .addItem("U", Icons.save_amount)
            .addItem("C", Icons.capacity)
            .addItem("E", Icons.energy_per_craft)
            .addItem("S", Icons.speed)
            .addItem("L", Icons.title)
            .addItem("A", Icons.progress_bar_slot)
            .addItem("M", Icons.linked_machine_recipes)
            .addItem("G", Icons.build_linked_recipe_machine);

    public LinkedRecipeMachineEditor(@NotNull SlimefunItemStack item) {
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

                // Hide all recipes button
                menu.addMenuClickHandler(matrix.getChar("h"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
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

                // Save amount button
                menu.addMenuClickHandler(matrix.getChar("u"), (p, s, i, a) -> {
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

                // Energy per craft button
                menu.addMenuClickHandler(matrix.getChar("e"), (p, s, i, a) -> {
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

                // Speed button
                menu.addMenuClickHandler(matrix.getChar("s"), (p, s, i, a) -> {
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
                        p.sendMessage("You haven't set the item of the slimefun item");
                        return false;
                    }
                    writer.setRoot(id);

                    ItemStack itemStack = p1.getSecondValue();
                    writer.set("item", itemStack);

                    Pair<Boolean, ItemGroup> p2 = ItemUtil.isItemGroupItem(menu, matrix, "p");
                    if (!p2.getFirstValue()) {
                        p.sendMessage("You haven't set the item group of the item");
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
                        p.sendMessage("You haven't set the energy capacity of the item");
                        return false;
                    }
                    int capacity = p4.getSecondValue();
                    writer.set("capacity", capacity);

                    // energy per craft
                    Pair<Boolean, Integer> p5 = ItemUtil.isInteger(menu, matrix, "e");
                    if (!p5.getFirstValue()) {
                        p.sendMessage("You haven't set the energy consumption each craft for the machine");
                        return false;
                    }
                    int energy_per_craft = p5.getSecondValue();
                    writer.set("energyPerCraft", energy_per_craft);

                    // speed
                    int speed = 1;
                    Pair<Boolean, Integer> p8 = ItemUtil.isInteger(menu, matrix, "s");
                    if (p8.getFirstValue()) {
                        speed = p8.getSecondValue();
                    }
                    writer.set("speed", speed);

                    // hide all recipes
                    boolean hide_all_recipes = false;
                    Pair<Boolean, Boolean> p10 = ItemUtil.isBoolean(menu, matrix, "h");
                    if (p10.getFirstValue()) {
                        hide_all_recipes = p10.getSecondValue();
                    }
                    writer.set("hideAllRecipes", hide_all_recipes);

                    Pair<Boolean, List<LinkedMachineRecipe>> p6 = ItemUtil.isLinkedMachineRecipes(menu, matrix, "m");
                    if (p6.getFirstValue()) {
                        for (LinkedMachineRecipe recipe : p6.getSecondValue()) {
                            writer.set("recipes", recipe);
                        }
                    }

                    Pair<Boolean, Integer> p11 = ItemUtil.isInteger(menu, matrix, "u");
                    if (p11.getFirstValue()) {
                        int save_amount = p11.getSecondValue();
                        writer.set("saveAmount", save_amount);
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
                    SlimefunItem flowItem = BlockStorage.check(flowContainer);
                    if (flowItem instanceof ItemFlowContainer ifc) {
                        BlockMenu flowMenu = BlockStorage.getInventory(flowContainer);
                        if (flowMenu == null) {
                            p.sendMessage("No item flow containers detected!");
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
                    SlimefunItem menuItem = BlockStorage.check(menuContainer);
                    if (menuItem instanceof MenuContainer mc) {
                        BlockMenu menuBlockMenu = BlockStorage.getInventory(menuContainer);
                        if (menuBlockMenu == null) {
                            return false;
                        }

                        YamlWriter menuWriter = mc.getAsYamlWriter(menuBlockMenu, input, output, id, title, progress_bar_slot);
                        ClipboardUtil.send(p, "Menu Editor: ", menuWriter.toString());
                        p.sendMessage(ChatColor.YELLOW + "==============================");
                    }

                    Pair<Boolean, ItemStack> p99 = ItemUtil.isItem(menu, matrix, "Q");
                    if (p99.getFirstValue()) {
                        ItemStack registerCard = p99.getSecondValue();
                        if (SlimefunItem.getByItem(registerCard) instanceof RegisterItem ri) {
                            writer.set("register", ri.getRegister(registerCard));
                        }
                    }

                    ClipboardUtil.send(p, "Linked Recipe Machine Editor: ", writer.toString());

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
