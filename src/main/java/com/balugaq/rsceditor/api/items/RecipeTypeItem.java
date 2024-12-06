package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class RecipeTypeItem extends PlaceholderItem {
    private final RecipeType type;

    public RecipeTypeItem(@NotNull SlimefunItemStack item, RecipeType type) {
        super(RSCEItemGroups.RECIPE_TYPE_GROUP, item);
        this.type = type;
    }
}
