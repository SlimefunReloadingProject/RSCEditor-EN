package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.items.SoundTypeItem;
import com.balugaq.rsceditor.implementation.RSCEditor;
import com.balugaq.rsceditor.utils.MaterialUtil;
import com.balugaq.rsceditor.utils.SlimefunItemUtil;
import com.balugaq.rsceditor.utils.TextUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Sound;

@UtilityClass
public class SoundTypeItems {
    public static void register() {
        for (Sound sound : Sound.values()) {
            SoundTypeItem soundTypeItem = new SoundTypeItem(
                    new SlimefunItemStack(
                            "RSC_EDITOR_SOUND_TYPE_" + sound.name().toUpperCase(),
                            new CustomItemStack(
                                    MaterialUtil.getMaterial(sound),
                                    "&6音效占位符: " + "&b" + TextUtil.getName(sound),
                                    "&b" + sound.name().toUpperCase()
                            )
                    ),
                    sound
            );

            SlimefunItemUtil.registerItem(soundTypeItem);
        }
    }
}
