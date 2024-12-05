package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.ArmorPiece;
import com.balugaq.rsceditor.api.items.BooleanTypeItem;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.implementation.items.machines.container.ArmorPieceContainer;
import com.balugaq.rsceditor.utils.ClipboardUtil;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import com.balugaq.rsceditor.utils.YamlWriter;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @noinspection DataFlowIssue
 */
public class ArmorEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("npfoooBBB")
            .addLine("NPFOOOBHB")
            .addLine("BBBBBBBCB")
            .addLine("BBBBBBBLB")
            .addLine("BBBBBBBTB")
            .addLine("BBBBBBBBG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("N", Icons.id)
            .addItem("P", Icons.item_group)
            .addItem("F", Icons.fullset)
            .addItem("O", Icons.protection_type)
            .addItem("H", Icons.helmet)
            .addItem("C", Icons.chestplate)
            .addItem("L", Icons.leggings)
            .addItem("T", Icons.boots)
            .addItem("G", Icons.build_armor);

    public ArmorEditor(@NotNull SlimefunItemStack item) {
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

                // Fullset button
                menu.addMenuClickHandler(matrix.getChar("f"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, integer -> {
                            typeItem.setContent(i, integer);
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
                    writer.setRoot(id);

                    Pair<Boolean, ItemGroup> p2 = ItemUtil.isItemGroupItem(menu, matrix, "p");
                    if (!p2.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的物品组");
                        return false;
                    }
                    ItemGroup itemGroup = p2.getSecondValue();
                    writer.set("item_group", itemGroup.getKey().getKey());

                    // helmet
                    ArmorPiece helmetPart = null;
                    Location helmetContainer = b.getLocation().add(0, 4, 0);
                    SlimefunItem helmet = StorageCacheUtils.getSfItem(helmetContainer);

                    if (helmet instanceof ArmorPieceContainer apc) {
                        BlockMenu helmetMenu = StorageCacheUtils.getMenu(helmetContainer);
                        if (helmetMenu == null) {
                            return false;
                        }

                        helmetPart = apc.getArmorPiece(helmetMenu);
                    }

                    if (helmetPart == null) {
                        p.sendMessage("你还没有设置这个装备的头部");
                        return false;
                    }

                    writer.set("helmet.id", helmetPart.getId());
                    writer.set("helmet.item", helmetPart.getItem());
                    writer.set("helmet.recipe_type", helmetPart.getRecipeType());
                    writer.set("helmet.potion_effects", helmetPart.getProtections().toArray());

                    // chestplate
                    ArmorPiece chestplatePart = null;
                    Location chestplateContainer = b.getLocation().add(0, 3, 0);
                    SlimefunItem chestplate = StorageCacheUtils.getSfItem(chestplateContainer);

                    if (chestplate instanceof ArmorPieceContainer apc) {
                        BlockMenu chestplateMenu = StorageCacheUtils.getMenu(chestplateContainer);
                        if (chestplateMenu == null) {
                            return false;
                        }

                        chestplatePart = apc.getArmorPiece(chestplateMenu);
                    }

                    if (chestplatePart == null) {
                        p.sendMessage("你还没有设置这个装备的胸甲");
                        return false;
                    }

                    writer.set("chestplate.id", chestplatePart.getId());
                    writer.set("chestplate.item", chestplatePart.getItem());
                    writer.set("chestplate.recipe_type", chestplatePart.getRecipeType());
                    writer.set("chestplate.potion_effects", chestplatePart.getProtections().toArray());

                    // leggings
                    ArmorPiece leggingsPart = null;
                    Location leggingsContainer = b.getLocation().add(0, 2, 0);
                    SlimefunItem leggings = StorageCacheUtils.getSfItem(leggingsContainer);

                    if (leggings instanceof ArmorPieceContainer apc) {
                        BlockMenu leggingsMenu = StorageCacheUtils.getMenu(leggingsContainer);
                        if (leggingsMenu == null) {
                            return false;
                        }

                        leggingsPart = apc.getArmorPiece(leggingsMenu);
                    }

                    if (leggingsPart == null) {
                        p.sendMessage("你还没有设置这个装备的护腿");
                        return false;
                    }

                    writer.set("leggings.id", leggingsPart.getId());
                    writer.set("leggings.item", leggingsPart.getItem());
                    writer.set("leggings.recipe_type", leggingsPart.getRecipeType());
                    writer.set("leggings.potion_effects", leggingsPart.getProtections().toArray());

                    // boots
                    ArmorPiece bootsPart = null;
                    Location bootsContainer = b.getLocation().add(0, 1, 0);
                    SlimefunItem boots = StorageCacheUtils.getSfItem(bootsContainer);

                    if (boots instanceof ArmorPieceContainer apc) {
                        BlockMenu bootsMenu = StorageCacheUtils.getMenu(bootsContainer);
                        if (bootsMenu == null) {
                            return false;
                        }

                        bootsPart = apc.getArmorPiece(bootsMenu);
                    }

                    if (bootsPart == null) {
                        p.sendMessage("你还没有设置这个装备的靴子");
                        return false;
                    }

                    writer.set("boots.id", bootsPart.getId());
                    writer.set("boots.item", bootsPart.getItem());
                    writer.set("boots.recipe_type", bootsPart.getRecipeType());
                    writer.set("boots.potion_effects", bootsPart.getProtections().toArray());

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
