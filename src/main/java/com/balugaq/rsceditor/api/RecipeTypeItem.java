package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class RecipeTypeItem extends SlimefunItem {
    private final RecipeType recipeType;
    public RecipeTypeItem(SlimefunItemStack item, RecipeType recipeType) {
        super(MyItemGroups.RECIPE_TYPE_GROUP, item, RecipeType.NULL, new ItemStack[] {null, null, null, null, null, null, null, null});
        this.recipeType = recipeType;
    }
}
