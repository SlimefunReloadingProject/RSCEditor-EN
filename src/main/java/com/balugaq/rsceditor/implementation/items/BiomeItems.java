package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.items.BiomeItem;
import com.balugaq.rsceditor.implementation.RSCEditor;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.block.Biome;

public class BiomeItems {
    public static void register() {
        for (Biome biome : Biome.values()) {
            BiomeItem biomeItem = new BiomeItem(
                    new SlimefunItemStack(
                            "RSC_EDITOR_BIOME_" + biome.name().toUpperCase(),
                            new CustomItemStack(
                                    Material.MOSS_BLOCK,
                                    "&6群系占位符",
                                    biome.name().toUpperCase()
                            )
                    ),
                    biome
            );

            biomeItem.register(RSCEditor.getInstance());
        }
    }
}
