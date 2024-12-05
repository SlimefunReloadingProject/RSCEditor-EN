package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.api.objects.types.GroupType;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class GroupTypeItem extends PlaceholderItem {
    private final GroupType type;

    public GroupTypeItem(@NotNull SlimefunItemStack item, GroupType type) {
        super(RSCEItemGroups.TYPE_GROUP, item);
        this.type = type;
    }
}