package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.ItemGroupItem;
import com.balugaq.rsceditor.implementation.RSCEditor;
import com.balugaq.rsceditor.utils.ReflectionUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.inventory.ItemStack;

public class ItemGroupItems {
    public static void register() {
        Slimefun.getRegistry().getAllItemGroups().forEach(itemGroup -> {
            ItemStack item = (ItemStack) ReflectionUtil.getValue(itemGroup, "item");
            if (item != null) {
                new ItemGroupItem(
                        new SlimefunItemStack(
                                "RSC_EDITOR_ITEM_GROUP_" + itemGroup.getKey().getNamespace().toUpperCase() + "_" + itemGroup.getKey().getKey().toUpperCase(),
                                item
                        ),
                        itemGroup
                ).register(RSCEditor.getInstance());
            }
        });
    }
}
