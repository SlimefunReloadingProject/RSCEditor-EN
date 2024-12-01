package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Getter
public class GroupTypeItem extends SlimefunItem {
    private final GroupType type;

    public GroupTypeItem(@NotNull SlimefunItemStack item, GroupType type) {
        super(MyItemGroups.TYPE_GROUP, item, RecipeType.NULL, new ItemStack[]{null, null, null, null, null, null, null, null, null});
        this.type = type;
    }
}