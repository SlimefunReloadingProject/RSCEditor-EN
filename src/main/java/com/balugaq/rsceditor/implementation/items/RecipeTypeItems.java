package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.RecipeTypeItem;
import com.balugaq.rsceditor.implementation.RSCEditor;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class RecipeTypeItems {
    public static void register() {
        Set<RecipeType> recipeTypes = new HashSet<>();
        Slimefun.getRegistry().getAllSlimefunItems().forEach(item -> {
            recipeTypes.add(item.getRecipeType());
        });
        recipeTypes.forEach(type -> {
            ItemStack item = type.toItem();
            if (item == null) {
                return;
            }
            new RecipeTypeItem(
                    new SlimefunItemStack(
                        "RSC_EDITOR_RECIPE_TYPE_" + type.getKey().getKey().toUpperCase(),
                            item
                    ),
                    type
            ).register(RSCEditor.getInstance());
        });
    }
}
