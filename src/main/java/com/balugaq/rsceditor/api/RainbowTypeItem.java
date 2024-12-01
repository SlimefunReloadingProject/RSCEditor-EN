package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.Getter;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Getter
public class RainbowTypeItem extends PlaceholderItem {
    private final RainbowType rainbowType;

    public RainbowTypeItem(@NotNull SlimefunItemStack item, RainbowType rainbowType) {
        super(MyItemGroups.TYPE_GROUP, item);
        this.rainbowType = rainbowType;
    }

    public boolean isCustom() {
        return rainbowType == RainbowType.CUSTOM;
    }
}
