package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.BooleanTypeItem;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.items.RainbowTypeItem;
import com.balugaq.rsceditor.api.items.RegisterItem;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.implementation.items.machines.container.CustomRainbowContainer;
import com.balugaq.rsceditor.utils.ClipboardUtil;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import com.balugaq.rsceditor.utils.YamlWriter;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
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

import java.util.List;

/**
 * @noinspection DataFlowIssue
 */
public class ItemEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("npiteqrrr")
            .addLine("NPITEQrrr")
            .addLine("sydwhBrrr")
            .addLine("SYDWHBBBB")
            .addLine("olmvfcaBB")
            .addLine("OLMVFCABG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("Q", Icons.register_card)
            .addItem("N", Icons.id)
            .addItem("P", Icons.item_group)
            .addItem("I", Icons.item)
            .addItem("T", Icons.recipe_type)
            .addItem("E", Icons.placeable)
            .addItem("S", Icons.script)
            .addItem("Y", Icons.energy_capacity)
            .addItem("D", Icons.radiation)
            .addItem("W", Icons.rainbow)
            .addItem("H", Icons.anti_wither)
            .addItem("O", Icons.soul_bound)
            .addItem("L", Icons.piglin_chance)
            .addItem("M", Icons.man_made)
            .addItem("V", Icons.hidden)
            .addItem("F", Icons.drop_from)
            .addItem("C", Icons.drop_chance)
            .addItem("A", Icons.drop_amount)
            .addItem("G", Icons.build_item);

    public ItemEditor(@NotNull SlimefunItemStack item) {
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

                // Placeable button
                menu.addMenuClickHandler(matrix.getChar("e"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("Input content: ");
                        ChatUtils.awaitInput(p, bool -> {
                            typeItem.setContent(i, bool);
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

                // Energy Capacity button
                menu.addMenuClickHandler(matrix.getChar("y"), (p, s, i, a) -> {
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

                // Anti wither button
                menu.addMenuClickHandler(matrix.getChar("h"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("Input content: ");
                        ChatUtils.awaitInput(p, bool -> {
                            typeItem.setContent(i, bool);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // Soul bound button
                menu.addMenuClickHandler(matrix.getChar("o"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("Input content: ");
                        ChatUtils.awaitInput(p, bool -> {
                            typeItem.setContent(i, bool);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // Piglin chance button
                menu.addMenuClickHandler(matrix.getChar("l"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
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

                // Man made button
                menu.addMenuClickHandler(matrix.getChar("m"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, bool -> {
                            typeItem.setContent(i, bool);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // Hidden button
                menu.addMenuClickHandler(matrix.getChar("v"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("Input content: ");
                        ChatUtils.awaitInput(p, bool -> {
                            typeItem.setContent(i, bool);
                            menu.open(p);
                        });
                        return false;
                    }

                    return true;
                });

                // Drop Chance button
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

                // Drop Amount button
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

                    // recipe
                    Pair<Boolean, List<ItemStack>> recipes = ItemUtil.isItems(menu, matrix, "r");
                    for (int j = 1; j <= 9; j++) {
                        writer.set("recipe." + j, recipes.getSecondValue().get(j - 1), false);
                    }

                    // below are optional fields

                    // placeable
                    boolean placeable = true;
                    Pair<Boolean, Boolean> p4 = ItemUtil.isBoolean(menu, matrix, "e");
                    if (p4.getFirstValue()) {
                        placeable = p4.getSecondValue();
                    }
                    writer.set("placeable", placeable);

                    // script
                    String script = "";
                    Pair<Boolean, String> p5 = ItemUtil.isString(menu, matrix, "s");
                    if (p5.getFirstValue()) {
                        script = p5.getSecondValue();
                    }

                    if (script != null && !script.isEmpty()) {
                        writer.set("script", script);
                    }

                    // energy charge
                    Pair<Boolean, Integer> p6 = ItemUtil.isInteger(menu, matrix, "y");
                    if (p6.getFirstValue()) {
                        int energyCapacity = p6.getSecondValue();
                        writer.set("energy_capacity", energyCapacity);
                    }

                    // radiation
                    Radioactivity radioactivity = null;
                    Pair<Boolean, Radioactivity> p7 = ItemUtil.isRadioactivity(menu, matrix, "d");
                    if (p7.getFirstValue()) {
                        radioactivity = p7.getSecondValue();
                    }
                    if (radioactivity != null) {
                        writer.set("radiation", radioactivity.name());
                    }

                    // rainbow custom
                    ItemStack p9 = menu.getItemInSlot(matrix.getChar("w"));
                    if (SlimefunItem.getByItem(p9) instanceof RainbowTypeItem typeItem) {
                        writer.set("rainbow", typeItem.getRainbowType().name());
                        if (typeItem.isCustom()) {
                            Location containerLocation = b.getRelative(BlockFace.DOWN).getLocation();
                            SlimefunItem slimefunItem = StorageCacheUtils.getSfItem(containerLocation);
                            if (slimefunItem instanceof CustomRainbowContainer container) {
                                BlockMenu containerMenu = StorageCacheUtils.getMenu(containerLocation);
                                List<Material> materials = container.getMaterials(containerMenu);
                                writer.set("rainbow_materials", materials.stream().map(Enum::name).toArray());
                            } else {
                                p.sendMessage("你还没有放置自定义彩虹物品容器");
                            }
                        }
                    }

                    // anti wither
                    Pair<Boolean, Boolean> p8 = ItemUtil.isBoolean(menu, matrix, "h");
                    if (p8.getFirstValue()) {
                        writer.set("anti_wither", p8.getSecondValue());
                    }

                    // soul bound
                    Pair<Boolean, Boolean> p10 = ItemUtil.isBoolean(menu, matrix, "o");
                    if (p10.getFirstValue()) {
                        writer.set("soul_bound", p10.getSecondValue());
                    }

                    // piglin chance
                    int piglinChance = 0;
                    Pair<Boolean, Integer> p11 = ItemUtil.isInteger(menu, matrix, "l");
                    if (p11.getFirstValue()) {
                        piglinChance = p11.getSecondValue();
                    }
                    if (piglinChance > 0) {
                        writer.set("piglin_chance", piglinChance);
                    }

                    // man made
                    Pair<Boolean, Boolean> p15 = ItemUtil.isBoolean(menu, matrix, "m");
                    if (p15.getFirstValue()) {
                        writer.set("vanilla", p15.getSecondValue());
                    }

                    // hidden
                    Pair<Boolean, Boolean> p12 = ItemUtil.isBoolean(menu, matrix, "v");
                    if (p12.getFirstValue()) {
                        writer.set("hidden", p12.getSecondValue());
                    }

                    // drop from
                    ItemStack dropFrom = menu.getItemInSlot(matrix.getChar("f"));
                    if (dropFrom != null && dropFrom.getType() != Material.AIR) {
                        if (!dropFrom.getType().isAir() && dropFrom.getType().isBlock()) {
                            writer.set("drop_from", dropFrom.getType().name());
                            Pair<Boolean, Integer> p13 = ItemUtil.isInteger(menu, matrix, "c");
                            int dropChance = 100;
                            if (p13.getFirstValue()) {
                                dropChance = p13.getSecondValue();
                            }
                            writer.set("drop_chance", dropChance);

                            Pair<Boolean, Integer> p14 = ItemUtil.isInteger(menu, matrix, "a");
                            int dropAmount = 1;
                            if (p14.getFirstValue()) {
                                dropAmount = p14.getSecondValue();
                            }
                            writer.set("drop_amount", dropAmount);
                        }
                    }

                    Pair<Boolean, ItemStack> p99 = ItemUtil.isItem(menu, matrix, "Q");
                    if (p99.getFirstValue()) {
                        ItemStack registerCard = p99.getSecondValue();
                        if (SlimefunItem.getByItem(registerCard) instanceof RegisterItem ri) {
                            writer.set("register", ri.getRegister(registerCard));
                        }
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
