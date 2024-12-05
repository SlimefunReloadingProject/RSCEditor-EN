package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.items.BiomeItem;
import com.balugaq.rsceditor.implementation.RSCEditor;
import com.balugaq.rsceditor.utils.MaterialUtil;
import com.balugaq.rsceditor.utils.TextUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import net.guizhanss.guizhanlib.minecraft.LanguageHelper;
import org.bukkit.Material;
import org.bukkit.block.Biome;

public class BiomeItems {
    public static void register() {
        for (Biome biome : Biome.values()) {
            BiomeItem biomeItem = new BiomeItem(
                    new SlimefunItemStack(
                            "RSC_EDITOR_BIOME_" + biome.name().toUpperCase(),
                            new CustomItemStack(
                                    MaterialUtil.getMaterial(biome),
                                    "&6群系占位符",
                                    "&b" + biome.name().toUpperCase(),
                                    "&b" + TextUtil.getName(biome)
                            )
                    ),
                    biome
            );

            biomeItem.register(RSCEditor.getInstance());
        }
    }
}
