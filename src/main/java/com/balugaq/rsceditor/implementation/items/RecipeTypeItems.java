package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.items.RecipeTypeItem;
import com.balugaq.rsceditor.utils.SlimefunItemUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@UtilityClass
public class RecipeTypeItems {
    public static void register() {
        Set<RecipeType> recipeTypes = new HashSet<>();
        Slimefun.getRegistry().getAllSlimefunItems().forEach(item -> recipeTypes.add(item.getRecipeType()));
        Iterator<RecipeType> iterator = recipeTypes.iterator();
        while (iterator.hasNext()) {
            RecipeType type = iterator.next();
            ItemStack item = type.toItem();
            if (item == null) {
                item = new CustomItemStack(
                        Material.BARRIER,
                        "&4null"
                );
            }
            RecipeTypeItem recipeTypeItem = new RecipeTypeItem(
                    new SlimefunItemStack(
                            "RSC_EDITOR_RECIPE_TYPE_" + type.getKey().getNamespace().toUpperCase() + "_" + type.getKey().getKey().toUpperCase(),
                            item
                    ),
                    type
            );
            SlimefunItemUtil.registerItem(recipeTypeItem);
        }
    }
}
