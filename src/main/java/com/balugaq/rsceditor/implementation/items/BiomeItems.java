package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.items.BiomeItem;
import com.balugaq.rsceditor.utils.MaterialUtil;
import com.balugaq.rsceditor.utils.SlimefunItemUtil;
import com.balugaq.rsceditor.utils.TextUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.block.Biome;

@UtilityClass
public class BiomeItems {
    public static void register() {
        for (Biome biome : Biome.values()) {
            BiomeItem biomeItem = new BiomeItem(
                    new SlimefunItemStack(
                            "RSC_EDITOR_BIOME_" + biome.name().toUpperCase(),
                            new CustomItemStack(
                                    MaterialUtil.getMaterial(biome),
                                    "&6Biome Placeholder: " + "&b" + TextUtil.getName(biome),
                                    "&b" + biome.name().toUpperCase()
                            )
                    ),
                    biome
            );

            SlimefunItemUtil.registerItem(biomeItem);
        }
    }
}
