package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType;
import lombok.Getter;
import org.bukkit.Sound;
import org.jetbrains.annotations.NotNull;

@Getter
public class SoundTypeItem extends PlaceholderItem {
    private final Sound sound;

    public SoundTypeItem(@NotNull SlimefunItemStack item, Sound sound) {
        super(MyItemGroups.SOUND_TYPE_GROUP, item);
        this.sound = sound;
    }
}