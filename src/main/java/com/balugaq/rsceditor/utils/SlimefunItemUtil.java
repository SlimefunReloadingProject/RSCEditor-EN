package com.balugaq.rsceditor.utils;

import com.balugaq.rsceditor.implementation.RSCEditor;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.RandomMobDrop;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

import java.util.ArrayList;
import java.util.List;

public class SlimefunItemUtil {
    private static final List<SlimefunItem> registeredItems = new ArrayList<>();
    @CanIgnoreReturnValue
    public static SlimefunItem registerItem(SlimefunItem item) {
        item.register(RSCEditor.getInstance());
        return item;
    }
    public static void unregisterItem(SlimefunItem item) {
        if (item instanceof Radioactive) {
            Slimefun.getRegistry().getRadioactiveItems().remove(item);
        }

        if (item instanceof GEOResource geor) {
            Slimefun.getRegistry().getGEOResources().remove(geor.getKey());
        }

        Slimefun.getRegistry().getTickerBlocks().remove(item.getId());
        Slimefun.getRegistry().getEnabledSlimefunItems().remove(item);

        Slimefun.getRegistry().getSlimefunItemIds().remove(item.getId());
        Slimefun.getRegistry().getAllSlimefunItems().remove(item);
        Slimefun.getRegistry().getMenuPresets().remove(item.getId());
        Slimefun.getRegistry().getBarteringDrops().remove(item.getItem());
    }

    public static void unregisterAllItems() {
        for (SlimefunItem item : registeredItems) {
            unregisterItem(item);
        }
        registeredItems.clear();

        List<SlimefunItem> items = new ArrayList<>(Slimefun.getRegistry().getAllSlimefunItems());
        for (SlimefunItem item : items) {
            if (item.getAddon().getName().equals(RSCEditor.getInstance().getName())) {
                unregisterItem(item);
            }
        }
    }
}
