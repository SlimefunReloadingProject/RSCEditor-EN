package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class TypeItem extends SlimefunItem {
    private final PlaceHolderType placeHolderType;
    private final String content;
    public TypeItem(SlimefunItemStack item, PlaceHolderType placeHolderType, String content) {
        super(MyItemGroups.TYPE_GROUP, item, RecipeType.NULL, new ItemStack[] {null, null, null, null, null, null, null, null, null});
        this.placeHolderType = placeHolderType;
        this.content = content;
    }
}
