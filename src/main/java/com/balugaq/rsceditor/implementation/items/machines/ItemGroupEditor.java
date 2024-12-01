package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.AbstractContainer;
import com.balugaq.rsceditor.api.GroupType;
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
import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @noinspection DataFlowIssue
 */
public class ItemGroupEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("nitepmBBB")
            .addLine("NITEPMBBB")
            .addLine("ssssssssB")
            .addLine("SSSSSSSSB")
            .addLine("aaaaaaaaB")
            .addLine("AAAAAAAAG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("N", Icons.id)
            .addItem("I", Icons.item)
            .addItem("T", Icons.group_type)
            .addItem("E", Icons.tier)
            .addItem("P", Icons.parent_group)
            .addItem("M", Icons.month)
            .addItem("S", Icons.parents_group)
            .addItem("A", Icons.action)
            .addItem("G", Icons.build_item_group);

    public ItemGroupEditor(@NotNull SlimefunItemStack item) {
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

                // Tier button
                menu.addMenuClickHandler(matrix.getChar("e"), (p, s, i, a) -> {
                    if (SlimefunItem.getByItem(i) instanceof IntegerTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        ChatUtils.awaitInput(p, integer -> {
                            typeItem.setContent(i, integer);
                            menu.open(p);
                        });
                        return false;
                    }
                    return true;
                });

                // Month button
                menu.addMenuClickHandler(matrix.getChar("m"), (p, s, i, a) -> {
                    if (SlimefunItem.getByItem(i) instanceof IntegerTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
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
                        p.sendMessage("你还没有设置这个物品组的ID");
                        return false;
                    }
                    String id = p0.getSecondValue();
                    writer.setRoot(id);
                    Pair<Boolean, ItemStack> p1 = ItemUtil.isItem(menu, matrix, "i");
                    if (!p1.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品组的物品模型");
                        return false;
                    }
                    ItemStack itemStack = p1.getSecondValue();
                    writer.set("item", itemStack);

                    int tier = 3; // default tier
                    Pair<Boolean, Integer> p2 = ItemUtil.isInteger(menu, matrix, "e");
                    if (p2.getFirstValue()) {
                        tier = p2.getSecondValue();
                    }


                    GroupType groupType = GroupType.NORMAL; // default type
                    Pair<Boolean, GroupType> p3 = ItemUtil.isGroupType(menu, matrix, "t");
                    if (p3.getFirstValue()) {
                        groupType = p3.getSecondValue();
                    }

                    writer.set("item", itemStack);
                    writer.set("tier", tier);
                    switch (groupType) {
                        case NESTED -> {
                            writer.set("type", "nested");
                        }
                        case NORMAL -> {
                            writer.set("type", "normal");
                        }
                        case SUB -> {
                            Pair<Boolean, ItemGroup> p4 = ItemUtil.isItemGroupItem(menu, matrix, "p");
                            if (!p4.getFirstValue()) {
                                p.sendMessage("你还没有设置这个物品组的父组");
                                return false;
                            }

                            ItemGroup parent = p4.getSecondValue();
                            if (!(parent instanceof FlexItemGroup)) {
                                p.sendMessage("父物品组不能是 非正常物品组");
                                return false;
                            }
                            writer.set("type", "sub");
                            writer.set("parent", parent.getKey().getKey());
                        }
                        case SEASONAL -> {
                            Pair<Boolean, Integer> p5 = ItemUtil.isInteger(menu, matrix, "m");
                            if (!p5.getFirstValue()) {
                                p.sendMessage("你还没有设置月份");
                                return false;
                            }
                            int month = p5.getSecondValue();
                            if (month < 1 || month > 12) {
                                p.sendMessage("月份必须在1-12之间");
                                return false;
                            }
                            writer.set("type", "seasonal");
                            writer.set("month", month);
                        }
                        case LOCKED -> {
                            Pair<Boolean, List<ItemGroup>> p6 = ItemUtil.isItemGroupItems(menu, matrix, "s");
                            if (!p6.getFirstValue()) {
                                p.sendMessage("你还没有设置这个物品组的爷物品组");
                                return false;
                            }

                            List<ItemGroup> parents = p6.getSecondValue();
                            writer.set("type", "locked");
                            writer.set("parents", parents.stream().map(ItemGroup::getKey).toArray());
                        }
                        case BUTTON -> {
                            writer.set("type", "button");
                            Pair<Boolean, List<String>> p7 = ItemUtil.isStrings(menu, matrix, "a");
                            if (p7.getFirstValue()) {
                                writer.set("actions", p7.getSecondValue().toArray());
                            }
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
