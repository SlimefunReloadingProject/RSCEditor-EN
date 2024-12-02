package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Getter
public class ProtectionTypeItem extends PlaceholderItem {
    private final ProtectionType type;

    public ProtectionTypeItem(@NotNull SlimefunItemStack item, ProtectionType type) {
        super(MyItemGroups.TYPE_GROUP, item);
        this.type = type;
    }
}