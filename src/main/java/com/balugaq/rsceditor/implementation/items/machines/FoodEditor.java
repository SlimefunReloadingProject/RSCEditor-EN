package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.AbstractContainer;
import com.balugaq.rsceditor.api.BooleanTypeItem;
import com.balugaq.rsceditor.api.DoubleTypeItem;
import com.balugaq.rsceditor.api.IntegerTypeItem;
import com.balugaq.rsceditor.api.MenuMatrix;
import com.balugaq.rsceditor.api.TextTypeItem;
import com.balugaq.rsceditor.utils.ClipboardUtil;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import com.balugaq.rsceditor.utils.YamlWriter;
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
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @noinspection DataFlowIssue
 */
public class FoodEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("npitsBrrr")
            .addLine("NPITSBrrr")
            .addLine("uoeaBrrr")
            .addLine("UOEABBBBB")
            .addLine("BBBBBBBBB")
            .addLine("BBBBBBBBG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("N", Icons.id)
            .addItem("P", Icons.item_group)
            .addItem("I", Icons.item)
            .addItem("T", Icons.recipe_type)
            .addItem("S", Icons.script)
            .addItem("U", Icons.nutrition)
            .addItem("O", Icons.saturation)
            .addItem("E", Icons.eatseconds)
            .addItem("A", Icons.always_eatable)
            .addItem("G", Icons.build_food);

    public FoodEditor(@NotNull SlimefunItemStack item) {
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
                    if (SlimefunItem.getByItem(i) instanceof TextTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // script button
                menu.addMenuClickHandler(matrix.getChar("s"), (p, s, i, a) -> {
                    if (SlimefunItem.getByItem(i) instanceof TextTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // nutrition button
                menu.addMenuClickHandler(matrix.getChar("u"), (p, s, i, a) -> {
                    if (SlimefunItem.getByItem(i) instanceof IntegerTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // saturation button
                menu.addMenuClickHandler(matrix.getChar("o"), (p, s, i, a) -> {
                    if (SlimefunItem.getByItem(i) instanceof DoubleTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // eat seconds button
                menu.addMenuClickHandler(matrix.getChar("e"), (p, s, i, a) -> {
                    if (SlimefunItem.getByItem(i) instanceof DoubleTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // always eatable button
                menu.addMenuClickHandler(matrix.getChar("a"), (p, s, i, a) -> {
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
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

                    Pair<Boolean, RecipeType> p3 = ItemUtil.isRecipeTypeItem(menu, matrix, "t");
                    RecipeType recipeType = RecipeType.NULL;
                    if (p3.getFirstValue()) {
                        recipeType = p3.getSecondValue();
                    }
                    writer.set("recipe_type", recipeType.getKey().getKey().toUpperCase());

                    // recipe
                    Pair<Boolean, List<ItemStack>> recipes = ItemUtil.isItems(menu, matrix, "r");
                    for (int j = 1; j <= 9; j++) {
                        writer.set("recipe." + j, recipes.getSecondValue().get(j - 1));
                    }

                    // script
                    Pair<Boolean, String> p4 = ItemUtil.isString(menu, matrix, "s");
                    if (p4.getFirstValue()) {
                        writer.set("script", p4.getSecondValue());
                    }

                    // nutrition
                    Pair<Boolean, Integer> p5 = ItemUtil.isInteger(menu, matrix, "u");
                    if (p5.getFirstValue()) {
                        writer.set("nutrition", p5.getSecondValue());
                    }

                    // saturation
                    Pair<Boolean, Double> p6 = ItemUtil.isDouble(menu, matrix, "o");
                    if (p6.getFirstValue()) {
                        writer.set("saturation", p6.getSecondValue());
                    }

                    // eat seconds
                    Pair<Boolean, Double> p7 = ItemUtil.isDouble(menu, matrix, "e");
                    if (p7.getFirstValue()) {
                        writer.set("eat_seconds", p7.getSecondValue());
                    }

                    // always eatable
                    Pair<Boolean, Boolean> p8 = ItemUtil.isBoolean(menu, matrix, "a");
                    if (p8.getFirstValue()) {
                        writer.set("always_eatable", p8.getSecondValue());
                    }

                    ClipboardUtil.send(p, writer.toString());

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
