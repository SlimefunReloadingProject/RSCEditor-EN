package com.balugaq.rsceditor.api;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Getter
public class ArmorPiece {
    private final String id;
    private final ItemStack item;
    private final RecipeType recipeType;
    private final ItemStack[] recipe;
    private final List<String> protections;
    public ArmorPiece(String id, ItemStack item, RecipeType recipeType, ItemStack[] recipe, List<String> protections) {
        this.id = id;
        this.item = item;
        this.recipeType = recipeType;
        this.recipe = recipe;
        this.protections = protections;
    }
    public ArmorPiece(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, List<String> protections) {
        this(item.getItemId(), new ItemStack(item), recipeType, recipe, protections);
    }
}
