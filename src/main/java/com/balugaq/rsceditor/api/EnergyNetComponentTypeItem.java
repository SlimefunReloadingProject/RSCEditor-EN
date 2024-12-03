package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class EnergyNetComponentTypeItem extends PlaceholderItem {
    private final EnergyNetComponentType type;

    public EnergyNetComponentTypeItem(@NotNull SlimefunItemStack item, EnergyNetComponentType type) {
        super(MyItemGroups.TYPE_GROUP, item);
        this.type = type;
    }
}