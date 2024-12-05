package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class ProtectionTypeItem extends PlaceholderItem {
    private final ProtectionType type;

    public ProtectionTypeItem(@NotNull SlimefunItemStack item, ProtectionType type) {
        super(RSCEItemGroups.TYPE_GROUP, item);
        this.type = type;
    }
}