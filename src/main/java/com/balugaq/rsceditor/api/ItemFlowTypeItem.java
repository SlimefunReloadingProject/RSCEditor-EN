package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class ItemFlowTypeItem extends PlaceholderItem {
    private final ItemFlowType itemFlowType;

    public ItemFlowTypeItem(@NotNull SlimefunItemStack item, ItemFlowType itemFlowType) {
        super(MyItemGroups.TYPE_GROUP, item);
        this.itemFlowType = itemFlowType;
    }
}