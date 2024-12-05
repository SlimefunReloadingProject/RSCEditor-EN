package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class EnergyNetComponentTypeItem extends PlaceholderItem {
    private final EnergyNetComponentType type;

    public EnergyNetComponentTypeItem(@NotNull SlimefunItemStack item, EnergyNetComponentType type) {
        super(RSCEItemGroups.TYPE_GROUP, item);
        this.type = type;
    }
}