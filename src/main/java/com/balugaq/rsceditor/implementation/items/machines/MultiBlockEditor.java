package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.items.RegisterItem;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.api.objects.types.MachineRecipe;
import com.balugaq.rsceditor.utils.ClipboardUtil;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import com.balugaq.rsceditor.utils.YamlWriter;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @noinspection DataFlowIssue
 */
public class MultiBlockEditor extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("npiwsqrrr")
            .addLine("NPIWSQrrr")
            .addLine("mmmmmMrrr")
            .addLine("mmmmmMBBB")
            .addLine("mmmmmmmMB")
            .addLine("mmmmmmmMG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("Q", Icons.register_card)
            .addItem("N", Icons.id)
            .addItem("P", Icons.item_group)
            .addItem("I", Icons.item)
            .addItem("W", Icons.work_block)
            .addItem("S", Icons.sound)
            .addItem("M", Icons.machine_recipes)
            .addItem("G", Icons.build_multi_block);

    public MultiBlockEditor(@NotNull SlimefunItemStack item) {
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

                // Work block button
                menu.addMenuClickHandler(matrix.getChar("w"), (p, s, i, a) -> {
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

                    Pair<Boolean, List<ItemStack>> recipes = ItemUtil.isItems(menu, matrix, "r");
                    for (int j = 1; j <= 9; j++) {
                        writer.set("recipe." + j, recipes.getSecondValue().get(j - 1), false);
                    }

                    Pair<Boolean, List<MachineRecipe>> p6 = ItemUtil.isMachineRecipes(menu, matrix, "m");
                    if (p6.getFirstValue()) {
                        for (MachineRecipe recipe : p6.getSecondValue()) {
                            writer.set("recipes", recipe);
                        }
                    }

                    Pair<Boolean, Integer> p3 = ItemUtil.isInteger(menu, matrix, "w");
                    if (!p3.getFirstValue()) {
                        p.sendMessage("你还没有设置这个物品的工作方块");
                        return false;
                    }
                    int work = p3.getSecondValue();
                    writer.set("work", work);

                    Pair<Boolean, Sound> p4 = ItemUtil.isSound(menu, matrix, "s");
                    if (!p4.getFirstValue()) {
                        p.sendMessage("你还没有设置音效");
                        return false;
                    }
                    Sound sound = p4.getSecondValue();
                    writer.set("sound", sound.name());

                    Pair<Boolean, ItemStack> p99 = ItemUtil.isItem(menu, matrix, "Q");
                    if (p99.getFirstValue()) {
                        ItemStack registerCard = p99.getSecondValue();
                        if (SlimefunItem.getByItem(registerCard) instanceof RegisterItem ri) {
                            writer.set("register", ri.getRegister(registerCard));
                        }
                    }

                    ClipboardUtil.send(p, "多方块结构编辑器: ", writer.toString());

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
