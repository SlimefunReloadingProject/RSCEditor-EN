package com.balugaq.rsceditor.implementation.items.machines.container;

import com.balugaq.rsceditor.api.AbstractContainer;
import com.balugaq.rsceditor.api.MenuMatrix;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MenuContainer extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("NNNNNNNNN")
            .addLine("NNNNNNNNN")
            .addLine("NNNNNNNNN")
            .addLine("NNNNNNNNN")
            .addLine("NNNNNNNNN")
            .addLine("NNNNNNNNN");

    public MenuContainer(@NotNull SlimefunItemStack item) {
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
            public boolean canOpen(@NotNull Block block, @NotNull Player player) {
                return player.isOp();
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow itemTransportFlow) {
                return new int[0];
            }
        };
    }

    public @NotNull Map<Integer, ItemStack> getMenuContent(@NotNull BlockMenu menu) {
        Map<Integer, ItemStack> content = new HashMap<>();
        for (int i = 0; i < 54; i++) {
            ItemStack item = menu.getItemInSlot(i);
            content.put(i, item);
        }

        return content;
    }
}
