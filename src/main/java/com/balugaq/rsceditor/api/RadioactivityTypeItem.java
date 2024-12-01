package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import lombok.Getter;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Getter
public class RadioactivityTypeItem extends PlaceholderItem {
    private final Radioactivity radioactivity;

    public RadioactivityTypeItem(@NotNull SlimefunItemStack item, Radioactivity radioactivity) {
        super(MyItemGroups.TYPE_GROUP, item);
        this.radioactivity = radioactivity;
    }
}
