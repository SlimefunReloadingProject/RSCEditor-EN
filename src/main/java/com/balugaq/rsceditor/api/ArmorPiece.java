package com.balugaq.rsceditor.api;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class ArmorPiece extends SlimefunItem {
    private final ArmorPieceType type;
    public ArmorPiece(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, ArmorPieceType type) {
        super(itemGroup, item, recipeType, recipe);
        this.type = type;
    }
}
