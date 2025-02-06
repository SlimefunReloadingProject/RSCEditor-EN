package com.balugaq.rsceditor.implementation.items.machines.builder;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.BooleanTypeItem;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.items.MachineRecipeItem;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.api.objects.types.MachineRecipe;
import com.balugaq.rsceditor.implementation.items.machines.container.ItemFlowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.MenuContainer;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
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
            .addLine("cntodhBBB")
            .addLine("CNTODHBBB")
            .addLine("BBBBBBBBB")
            .addLine("BBBBBBBBB")
            .addLine("BBBBBBBBB")
            .addLine("BBBBBBBBG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("C", Icons.machine_recipe_card)
            .addItem("N", Icons.recipe_name)
            .addItem("T", Icons.processing_time)
            .addItem("O", Icons.choose_one)
            .addItem("D", Icons.for_display)
            .addItem("H", Icons.hide)
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

                // Processing Time button
                menu.addMenuClickHandler(matrix.getChar("t"), (p, s, i, a) -> {
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

                // Choose One button
                menu.addMenuClickHandler(matrix.getChar("o"), (p, s, i, a) -> {
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

                // For Display button
                menu.addMenuClickHandler(matrix.getChar("d"), (p, s, i, a) -> {
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

                // Hide button
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

                // Build button
                menu.addMenuClickHandler(matrix.getChar("G"), (p, s, i, a) -> {
                    ItemStack machineRecipeCard = menu.getItemInSlot(matrix.getChar("c"));
                    if (!(SlimefunItem.getByItem(machineRecipeCard) instanceof MachineRecipeItem mri)) {
                        p.sendMessage("You need a machine recipe card to build a machine recipe!");
                        return false;
                    }

                    Pair<Boolean, String> p0 = ItemUtil.isString(menu, matrix, "n");
                    if (!p0.getFirstValue()) {
                        p.sendMessage("You need to set the name of the machine recipe!");
                        return false;
                    }

                    String name = p0.getSecondValue();

                    Pair<Boolean, Integer> p2 = ItemUtil.isInteger(menu, matrix, "t");
                    if (!p2.getFirstValue()) {
                        p.sendMessage("You need to set the processing time of the machine recipe!");
                        return false;
                    }

                    int processingTime = p2.getSecondValue();

                    // let's read the item flow from the below container
                    Map<Integer, ItemFlowType> types;
                    Location flowContainer = b.getRelative(BlockFace.DOWN).getLocation();
                    SlimefunItem flowItem = BlockStorage.check(flowContainer);
                    if (flowItem instanceof ItemFlowContainer ifc) {
                        BlockMenu flowMenu = BlockStorage.getInventory(flowContainer);
                        if (flowMenu == null) {
                            p.sendMessage("Item flow container not found!");
                            return false;
                        }

                        types = ifc.getFlowTypes(flowMenu);
                    } else {
                        p.sendMessage("The item flow container below the machine is not correct!");
                        return false;
                    }

                    Map<Integer, ItemStack> contents;
                    // then read the menu from the above container
                    Location menuContainer = b.getRelative(BlockFace.UP).getLocation();
                    SlimefunItem menuItem = BlockStorage.check(menuContainer);
                    if (menuItem instanceof MenuContainer mc) {
                        BlockMenu menuBlockMenu = BlockStorage.getInventory(menuContainer);
                        if (menuBlockMenu == null) {
                            p.sendMessage("Menu container not found!");
                            return false;
                        }

                        contents = mc.getMenuContent(menuBlockMenu);
                    } else {
                        p.sendMessage("The menu container above the machine is not correct!");
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

                    boolean chooseOne = false;
                    Pair<Boolean, Boolean> p1 = ItemUtil.isBoolean(menu, matrix, "o");
                    if (p1.getFirstValue()) {
                        chooseOne = p1.getSecondValue();
                    }

                    boolean forDisplay = false;
                    Pair<Boolean, Boolean> p3 = ItemUtil.isBoolean(menu, matrix, "d");
                    if (p3.getFirstValue()) {
                        forDisplay = p3.getSecondValue();
                    }

                    boolean hide = false;
                    Pair<Boolean, Boolean> p4 = ItemUtil.isBoolean(menu, matrix, "h");
                    if (p4.getFirstValue()) {
                        hide = p4.getSecondValue();
                    }

                    MachineRecipe recipe = new MachineRecipe(name, chooseOne, forDisplay, hide, processingTime, inputs, outputs);
                    mri.setRecipe(machineRecipeCard, recipe);

                    p.sendMessage("The machine recipe has been saved successfully!");

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
