package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class SimpleMachineTypeItem extends PlaceholderItem {
    private final SimpleMachineType simpleMachineType;

    public SimpleMachineTypeItem(@NotNull SlimefunItemStack item, SimpleMachineType simpleMachineType) {
        super(MyItemGroups.TYPE_GROUP, item);
        this.simpleMachineType = simpleMachineType;
    }
}
