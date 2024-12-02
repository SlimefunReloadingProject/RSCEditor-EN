package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class ItemGroupItem extends PlaceholderItem {
    private final ItemGroup itemGroup;

    public ItemGroupItem(@NotNull SlimefunItemStack item, ItemGroup itemGroup) {
        super(MyItemGroups.ITEM_GROUP_GROUP, item);
        this.itemGroup = itemGroup;
    }
}
