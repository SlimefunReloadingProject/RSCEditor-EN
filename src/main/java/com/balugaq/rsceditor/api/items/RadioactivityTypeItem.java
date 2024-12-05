package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class RadioactivityTypeItem extends PlaceholderItem {
    private final Radioactivity radioactivity;

    public RadioactivityTypeItem(@NotNull SlimefunItemStack item, Radioactivity radioactivity) {
        super(RSCEItemGroups.TYPE_GROUP, item);
        this.radioactivity = radioactivity;
    }
}
