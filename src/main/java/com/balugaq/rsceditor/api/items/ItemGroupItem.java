package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class ItemGroupItem extends PlaceholderItem {
    private final ItemGroup itemGroup;

    public ItemGroupItem(@NotNull SlimefunItemStack item, ItemGroup itemGroup) {
        super(RSCEItemGroups.ITEM_GROUP_GROUP, item);
        this.itemGroup = itemGroup;
    }
}
