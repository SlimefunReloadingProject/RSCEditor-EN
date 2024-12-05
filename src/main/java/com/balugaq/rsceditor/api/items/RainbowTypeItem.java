package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.api.objects.types.RainbowType;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class RainbowTypeItem extends PlaceholderItem {
    private final RainbowType rainbowType;

    public RainbowTypeItem(@NotNull SlimefunItemStack item, RainbowType rainbowType) {
        super(RSCEItemGroups.TYPE_GROUP, item);
        this.rainbowType = rainbowType;
    }

    public boolean isCustom() {
        return rainbowType == RainbowType.CUSTOM;
    }
}
