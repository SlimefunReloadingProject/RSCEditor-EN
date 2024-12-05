package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class ItemFlowTypeItem extends PlaceholderItem {
    private final ItemFlowType itemFlowType;

    public ItemFlowTypeItem(@NotNull SlimefunItemStack item, ItemFlowType itemFlowType) {
        super(RSCEItemGroups.TYPE_GROUP, item);
        this.itemFlowType = itemFlowType;
    }
}