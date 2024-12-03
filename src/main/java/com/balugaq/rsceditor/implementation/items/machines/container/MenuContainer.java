package com.balugaq.rsceditor.implementation.items.machines.container;

import com.balugaq.rsceditor.api.AbstractContainer;
import com.balugaq.rsceditor.api.MenuMatrix;
import com.balugaq.rsceditor.utils.YamlWriter;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
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

    public @NotNull YamlWriter getAsYamlWriter(@NotNull BlockMenu menu, int[] input_slots, int[] output_slots, String id, String title, int progress_bar_slot) {
        YamlWriter writer = new YamlWriter();
        Map<Integer, ItemStack> content = getMenuContent(menu);

        writer.setRoot(id);
        writer.set("title", title);

        int cached_slot = 0;
        ItemStack cached_item = null;
        for (int i = 0; i < progress_bar_slot; i++) {
            ItemStack itemStack = content.get(i);
            if (SlimefunUtils.isItemSimilar(cached_item, itemStack, true, true, true, true)) {
                cached_item = itemStack;
            } else {
                if (cached_item != null) {
                    writer.set("slots." + cached_slot + "-" + i, cached_item.clone());
                } else {
                    writer.set("slots." + i, itemStack.clone());
                }
                cached_slot = i + 1;
                cached_item = null;
            }
        }

        if (cached_item != null) {
            writer.set("slots." + cached_slot + "-" + (progress_bar_slot - 1), cached_item.clone());
        }

        ItemStack progress_bar = content.get(progress_bar_slot);
        if (progress_bar != null) {
            writer.set("slots." + progress_bar_slot, progress_bar.clone());
            writer.set("slots." + progress_bar_slot + ".progressbar", progress_bar.clone());
        }

        cached_slot = progress_bar_slot + 1;
        cached_item = null;
        for (int i = progress_bar_slot + 1; i < 54; i++) {
            ItemStack itemStack = content.get(i);
            if (SlimefunUtils.isItemSimilar(cached_item, itemStack, true)) {
                cached_item = itemStack;
            } else {
                if (cached_item != null) {
                    writer.set("slots." + cached_slot + "-" + i, cached_item.clone());
                } else {
                    writer.set("slots." + i, itemStack.clone());
                }
                cached_slot = i + 1;
                cached_item = null;
            }
        }

        if (cached_item != null) {
            writer.set("slots." + cached_slot + "-" + 53, cached_item.clone());
        }

        return writer;
    }
}
