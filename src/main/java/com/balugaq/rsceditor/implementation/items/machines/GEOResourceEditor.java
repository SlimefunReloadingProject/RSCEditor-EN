package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.BooleanTypeItem;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.items.RegisterItem;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.implementation.items.machines.container.SupplyContainer;
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
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @noinspection DataFlowIssue
 */
@SuppressWarnings("deprecation")
public class GEOResourceEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("npirdomBB")
            .addLine("NPIRDOMBB")
            .addLine("fcaqBBBBB")
            .addLine("FCAQBBBBB")
            .addLine("BBBBBBBBB")
            .addLine("BBBBBBBBG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("Q", Icons.register_card)
            .addItem("N", Icons.id)
            .addItem("P", Icons.item_group)
            .addItem("I", Icons.item)
            .addItem("R", Icons.recipe_type)
            .addItem("D", Icons.max_deviation)
            .addItem("O", Icons.obtain_from_geo_miner)
            .addItem("M", Icons.geo_name)
            .addItem("F", Icons.drop_from)
            .addItem("C", Icons.drop_chance)
            .addItem("A", Icons.drop_amount)
            .addItem("G", Icons.build_geo);

    public GEOResourceEditor(@NotNull SlimefunItemStack item) {
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

                // Geo Name button
                menu.addMenuClickHandler(matrix.getChar("m"), (p, s, i, a) -> {
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

                // Max Deviation button
                menu.addMenuClickHandler(matrix.getChar("d"), (p, s, i, a) -> {
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
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
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
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, text -> {
                            typeItem.setContent(i, text);
                            menu.open(p);
                        });
                    }
                    return true;
                });

                // Obtain From Geo Miner button
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
                    }
                    return true;
                });

                // Build button
                menu.addMenuClickHandler(matrix.getChar("G"), (p, s, i, a) -> {
                    YamlWriter writer = new YamlWriter();
                    Pair<Boolean, String> p0 = ItemUtil.isString(menu, matrix, "n");
                    if (!p0.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的 ID.");
                        return false;
                    }
                    String id = p0.getSecondValue();
                    Pair<Boolean, ItemStack> p1 = ItemUtil.isItem(menu, matrix, "i");
                    if (!p1.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的物品模型.");
                        return false;
                    }
                    writer.setRoot(id);

                    ItemStack itemStack = p1.getSecondValue();
                    writer.set("item", itemStack);

                    Pair<Boolean, ItemGroup> p2 = ItemUtil.isItemGroupItem(menu, matrix, "p");
                    if (!p2.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的物品组.");
                        return false;
                    }
                    ItemGroup itemGroup = p2.getSecondValue();
                    writer.set("item_group", itemGroup.getKey().getKey());

                    Pair<Boolean, RecipeType> p8 = ItemUtil.isRecipeTypeItem(menu, matrix, "r");
                    RecipeType recipeType = RecipeType.NULL;
                    if (p8.getFirstValue()) {
                        recipeType = p8.getSecondValue();
                    }
                    writer.set("recipe_type", recipeType.getKey().getKey().toUpperCase());

                    Pair<Boolean, Integer> p3 = ItemUtil.isInteger(menu, matrix, "d");
                    int maxDeviation = 1;
                    if (p3.getFirstValue()) {
                        maxDeviation = p3.getSecondValue();
                    }
                    writer.set("max_deviation", maxDeviation);

                    Pair<Boolean, Boolean> p4 = ItemUtil.isBoolean(menu, matrix, "o");
                    boolean obtainFromGeoMiner = true;
                    if (p4.getFirstValue()) {
                        obtainFromGeoMiner = p4.getSecondValue();
                    }
                    writer.set("obtain_from_geo_miner", obtainFromGeoMiner);

                    Pair<Boolean, String> p5 = ItemUtil.isString(menu, matrix, "m");
                    String geoName = itemStack.getItemMeta().getDisplayName();
                    if (p5.getFirstValue()) {
                        geoName = p5.getSecondValue();
                    }

                    writer.set("geo_name", geoName);

                    ItemStack dropFrom = menu.getItemInSlot(matrix.getChar("f"));
                    if (dropFrom != null && dropFrom.getType() != Material.AIR) {
                        if (!dropFrom.getType().isAir() && dropFrom.getType().isBlock()) {
                            writer.set("drop_from", dropFrom.getType().name());
                            Pair<Boolean, Integer> p6 = ItemUtil.isInteger(menu, matrix, "c");
                            int dropChance = 100;
                            if (p6.getFirstValue()) {
                                dropChance = p6.getSecondValue();
                            }
                            writer.set("drop_chance", dropChance);

                            Pair<Boolean, Integer> p7 = ItemUtil.isInteger(menu, matrix, "a");
                            int dropAmount = 1;
                            if (p7.getFirstValue()) {
                                dropAmount = p7.getSecondValue();
                            }
                            writer.set("drop_amount", dropAmount);
                        }
                    }

                    Location containLocation = b.getRelative(BlockFace.DOWN).getLocation();
                    SlimefunItem slimefunItem = StorageCacheUtils.getSfItem(containLocation);
                    if (slimefunItem instanceof SupplyContainer container) {
                        BlockMenu blockMenu = StorageCacheUtils.getMenu(containLocation);
                        Map<World.Environment, Map<Biome, Integer>> supply = container.getSupply(blockMenu);
                        if (supply.isEmpty()) {
                            p.sendMessage("你没有设置GEO供应容器");
                            return false;
                        }

                        for (World.Environment environment : supply.keySet()) {
                            for (Biome biome : supply.get(environment).keySet()) {
                                int amount = supply.get(environment).get(biome);
                                writer.set("supply." + environment.name().toLowerCase() + "." + biome.name().toLowerCase(), amount);
                            }
                        }
                    } else {
                        p.sendMessage("你没有放置GEO供应容器");
                        return false;
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
