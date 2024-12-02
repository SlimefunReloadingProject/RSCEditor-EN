package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;

@Getter
public class BiomeItem extends PlaceholderItem {
    private final Biome biome;

    public BiomeItem(@NotNull SlimefunItemStack item, Biome biome) {
        super(MyItemGroups.BIOME_GROUP, item);
        this.biome = biome;
    }
}
