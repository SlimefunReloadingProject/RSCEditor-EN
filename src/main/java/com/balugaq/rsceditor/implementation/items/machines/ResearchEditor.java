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
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @noinspection DataFlowIssue
 */
public class ResearchEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("kinlcBBBG")
            .addLine("KINLCMMMM")
            .addLine("mmmmmmmmm")
            .addLine("mmmmmmmmm")
            .addLine("mmmmmmmmm")
            .addLine("mmmmmmmmm")
            .addItem("K", Icons.id)
            .addItem("I", Icons.research_id)
            .addItem("N", Icons.name)
            .addItem("L", Icons.level_cost)
            .addItem("C", Icons.currency_cost)
            .addItem("M", Icons.slimefun_items)
            .addItem("G", Icons.build_research);

    public ResearchEditor(@NotNull SlimefunItemStack item) {
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
                menu.addMenuClickHandler(matrix.getChar("K"), (p, s, i, a) -> {
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


                // Research Id button
                menu.addMenuClickHandler(matrix.getChar("i"), (p, s, i, a) -> {
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

                // Name button
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

                // Level cost button
                menu.addMenuClickHandler(matrix.getChar("l"), (p, s, i, a) -> {
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

                // Currency cost button
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

                // Build button
                menu.addMenuClickHandler(matrix.getChar("G"), (p, s, i, a) -> {
                    YamlWriter writer = new YamlWriter();

                    Pair<Boolean, String> p9 = ItemUtil.isString(menu, matrix, "k");
                    if (!p9.getFirstValue()) {
                        p.sendMessage("请先输入研究ID!");
                        return false;
                    }

                    String id = p9.getSecondValue();
                    writer.setRoot(id);

                    int research_id = RandomUtils.nextInt();
                    Pair<Boolean, Integer> p0 = ItemUtil.isInteger(menu, matrix, "i");
                    if (p0.getFirstValue()) {
                        research_id = p0.getSecondValue();
                    }
                    writer.set("id", research_id);

                    Pair<Boolean, String> p1 = ItemUtil.isString(menu, matrix, "n");
                    if (!p1.getFirstValue()) {
                        p.sendMessage("请先输入研究名称!");
                        return false;
                    }

                    String name = p1.getSecondValue();
                    writer.set("name", name);

                    Pair<Boolean, Integer> p2 = ItemUtil.isInteger(menu, matrix, "l");
                    if (p2.getFirstValue()) {
                        writer.set("levelCost", p2.getSecondValue());
                    }

                    Pair<Boolean, Integer> p3 = ItemUtil.isInteger(menu, matrix, "c");
                    if (p3.getFirstValue()) {
                        writer.set("currencyCost", p3.getSecondValue());
                    }

                    Pair<Boolean, List<ItemStack>> p4 = ItemUtil.isItems(menu, matrix, "m");
                    if (p4.getFirstValue()) {
                        List<String> sitems = new ArrayList<>();
                        List<ItemStack> items = p4.getSecondValue();
                        for (ItemStack item : items) {
                            SlimefunItem slimefunItem = SlimefunItem.getByItem(item);
                            if (slimefunItem != null) {
                                sitems.add(slimefunItem.getId());
                            }
                        }
                        String[] sitemArray = sitems.toArray(new String[0]);
                        writer.set("items", sitemArray);
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
