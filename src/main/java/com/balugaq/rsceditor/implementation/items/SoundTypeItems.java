package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.BiomeItem;
import com.balugaq.rsceditor.api.SoundTypeItem;
import com.balugaq.rsceditor.implementation.RSCEditor;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Biome;

public class SoundTypeItems {
    public static void register() {
        for (Sound sound : Sound.values()) {
            SoundTypeItem soundTypeItem = new SoundTypeItem(
                    new SlimefunItemStack(
                            "RSC_EDITOR_SOUND_TYPE_" + sound.name().toUpperCase(),
                            new CustomItemStack(
                                    Material.NOTE_BLOCK,
                                    "&6音效占位符",
                                    sound.name().toUpperCase()
                            )
                    ),
                    sound
            );

            soundTypeItem.register(RSCEditor.getInstance());
        }
    }
}
