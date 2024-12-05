package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.items.SoundTypeItem;
import com.balugaq.rsceditor.implementation.RSCEditor;
import com.balugaq.rsceditor.utils.MaterialUtil;
import com.balugaq.rsceditor.utils.TextUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.Sound;

public class SoundTypeItems {
    public static void register() {
        for (Sound sound : Sound.values()) {
            try {
                SoundTypeItem soundTypeItem = new SoundTypeItem(
                        new SlimefunItemStack(
                                "RSC_EDITOR_SOUND_TYPE_" + sound.name().toUpperCase(),
                                new CustomItemStack(
                                        MaterialUtil.getMaterial(sound),
                                        "&6音效占位符",
                                        "&b" + sound.name().toUpperCase(),
                                        "&b" + TextUtil.getName(sound)
                                )
                        ),
                        sound
                );

                soundTypeItem.register(RSCEditor.getInstance());
            } catch (Exception e) {
                RSCEditor.getInstance().getLogger().warning("Failed to register sound type item for " + sound.name());
                e.printStackTrace();
            }
        }
    }
}
