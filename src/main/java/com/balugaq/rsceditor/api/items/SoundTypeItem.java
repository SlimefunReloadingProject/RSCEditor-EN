package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.bukkit.Sound;
import org.jetbrains.annotations.NotNull;

@Getter
public class SoundTypeItem extends PlaceholderItem {
    private final Sound sound;

    public SoundTypeItem(@NotNull SlimefunItemStack item, Sound sound) {
        super(RSCEItemGroups.SOUND_TYPE_GROUP, item);
        this.sound = sound;
    }
}