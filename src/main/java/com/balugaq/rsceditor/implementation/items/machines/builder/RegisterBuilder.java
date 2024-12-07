package com.balugaq.rsceditor.implementation.items.machines.builder;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.BooleanTypeItem;
import com.balugaq.rsceditor.api.items.RegisterItem;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.api.objects.types.Register;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
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

import java.util.ArrayList;
import java.util.List;

public class RegisterBuilder extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("dalwuBBBB")
            .addLine("DALWUBBBB")
            .addLine("ccccccccB")
            .addLine("CCCCCCCCB")
            .addLine("BBBBBBBBB")
            .addLine("BBBBBBBBG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("D", Icons.register_card)
            .addItem("A", Icons.id_alias)
            .addItem("L", Icons.late_init)
            .addItem("W", Icons.warn)
            .addItem("U", Icons.unfinished)
            .addItem("C", Icons.condition)
            .addItem("G", Icons.build_register);

    public RegisterBuilder(@NotNull SlimefunItemStack item) {
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
                menu.addMenuClickHandler(matrix.getChar("a"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof TextTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, content -> {
                            typeItem.setContent(i, content);
                            menu.open(p);
                        });
                        return false;
                    }
                    return true;
                });

                menu.addMenuClickHandler(matrix.getChar("l"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, content -> {
                            typeItem.setContent(i, content);
                            menu.open(p);
                        });
                        return false;
                    }
                    return true;
                });

                menu.addMenuClickHandler(matrix.getChar("w"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, content -> {
                            typeItem.setContent(i, content);
                            menu.open(p);
                        });
                        return false;
                    }
                    return true;
                });

                menu.addMenuClickHandler(matrix.getChar("u"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof BooleanTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, content -> {
                            typeItem.setContent(i, content);
                            menu.open(p);
                        });
                        return false;
                    }
                    return true;
                });

                menu.addMenuClickHandler(matrix.getChar("c"), (p, s, i, a) -> {
                    if (a.isShiftClicked()) {
                        return true;
                    }
                    if (SlimefunItem.getByItem(i) instanceof TextTypeItem typeItem) {
                        p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                        p.sendMessage("输入内容: ");
                        ChatUtils.awaitInput(p, content -> {
                            typeItem.setContent(i, content);
                            menu.open(p);
                        });
                        return false;
                    }
                    return true;
                });

                // Build button
                menu.addMenuClickHandler(matrix.getChar("G"), (p, s, i, a) -> {
                    ItemStack register_card = menu.getItemInSlot(matrix.getChar("d"));
                    if (!(SlimefunItem.getByItem(register_card) instanceof RegisterItem ri)) {
                        p.sendMessage("你还没有放置注册选项占位符!");
                        return false;
                    }
                    String id_alias = null;
                    Pair<Boolean, String> p1 = ItemUtil.isString(menu, matrix, "i");
                    if (p1.getFirstValue()) {
                        id_alias = p1.getSecondValue();
                    }

                    boolean late_init = false;
                    Pair<Boolean, Boolean> p2 = ItemUtil.isBoolean(menu, matrix, "l");
                    if (p2.getFirstValue()) {
                        late_init = p2.getSecondValue();
                    }

                    boolean warn = false;
                    Pair<Boolean, Boolean> p3 = ItemUtil.isBoolean(menu, matrix, "w");
                    if (p3.getFirstValue()) {
                        warn = p3.getSecondValue();
                    }

                    boolean unfinished = false;
                    Pair<Boolean, Boolean> p4 = ItemUtil.isBoolean(menu, matrix, "u");
                    if (p4.getFirstValue()) {
                        unfinished = p4.getSecondValue();
                    }

                    List<String> conditions = new ArrayList<>();
                    Pair<Boolean, List<String>> p5 = ItemUtil.isStrings(menu, matrix, "c");
                    if (p5.getFirstValue()) {
                        conditions = p5.getSecondValue();
                    }

                    Register register = new Register(id_alias, late_init, warn, unfinished, conditions);
                    ri.setRegister(register_card, register);
                    p.sendMessage("已设置注册选项占位符!");
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
