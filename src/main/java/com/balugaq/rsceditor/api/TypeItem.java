package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.RSCEditor;
import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import lombok.Getter;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@Getter
public abstract class TypeItem<T> extends PlaceholderItem {
    protected static final NamespacedKey CONTENT_KEY = new NamespacedKey(RSCEditor.getInstance(), "content");
    private final PlaceHolderType placeHolderType;

    public TypeItem(@NotNull SlimefunItemStack item, PlaceHolderType placeHolderType) {
        super(MyItemGroups.TYPE_GROUP, item);
        this.placeHolderType = placeHolderType;
    }

    public abstract void setContent(ItemStack itemStack, String content);

    public abstract T getContent(ItemStack itemStack);
}
