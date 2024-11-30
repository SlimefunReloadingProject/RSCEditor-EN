package com.balugaq.rsceditor.implementation.items.machines;

import com.balugaq.rsceditor.api.AbstractEditor;
import com.balugaq.rsceditor.api.GroupType;
import com.balugaq.rsceditor.api.GroupTypeItem;
import com.balugaq.rsceditor.api.MenuMatrix;
import com.balugaq.rsceditor.utils.ItemUtil;
import com.balugaq.rsceditor.utils.YamlWriter;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ItemGroupEditor extends AbstractEditor {
    private final MenuMatrix matrix = new MenuMatrix()
            .addLine("itepmBBBB")
            .addLine("ITEPMBBBB")
            .addLine("ssssssssB")
            .addLine("SSSSSSSSB")
            .addLine("aaaaaaaaB")
            .addLine("AAAAAAAAG")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("I", new CustomItemStack(
                    Material.ENCHANTED_BOOK,
                    "&bItem",
                    "&b^ Place an item ^"
            ))
            .addItem("T", new CustomItemStack(
                    Material.BEACON,
                    "&bType",
                    "&b^ Place a group type placeholder ^"
            ))
            .addItem("E", new CustomItemStack(
                    Material.LADDER,
                    "&bTier",
                    "&b^ Place a integer placeholder ^"
            ))
            .addItem("P", new CustomItemStack(
                    Material.GLASS,
                    "&bParent",
                    "&b^ Place a group placeholder ^",
                    "&cWhen Type is Sub"
            ))
            .addItem("M", new CustomItemStack(
                    Material.MOSS_BLOCK,
                    "&bMonth",
                    "&b^ Place a integer placeholder ^",
                    "&cWhen Type is Seasonal"
            ))
            .addItem("S", new CustomItemStack(
                    Material.OBSIDIAN,
                    "&bParents",
                    "&b^ Place a group placeholder ^",
                    "&cWhen Type is Locked"
            ))
            .addItem("A", new CustomItemStack(
                    Material.ORANGE_GLAZED_TERRACOTTA,
                    "&bAction",
                    "&b^ Place a text placeholder ^",
                    "&cWhen Type is Button"
            ));
    public ItemGroupEditor(SlimefunItemStack item) {
        super(item);
    }

    @Override
    public BlockMenuPreset setBlockMenuPreset() {
        return new BlockMenuPreset(getId(), getItemName()) {
            @Override
            public void init() {
                matrix.build(this);
            }

            @Override
            public void newInstance(@NotNull BlockMenu menu, @NotNull Block b) {
                menu.addMenuClickHandler(matrix.getChar("G"), (p, s, i, a) -> {
                    ItemUtil.isGroupTypeItem(menu, matrix, "t", (type) -> {
                        switch (type) {

                        }
                    }, () -> {
                        p.sendMessage("Not a group type item");
                    });
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
