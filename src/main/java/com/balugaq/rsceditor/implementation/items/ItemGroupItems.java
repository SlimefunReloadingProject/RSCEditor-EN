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
            new ItemGroupItem(
                    new SlimefunItemStack(
                            "RSC_EDITOR_ITEM_GROUP_" + itemGroup.getKey().getKey().toUpperCase(),
                            (ItemStack) ReflectionUtil.getValue(itemGroup.getClass(), "item")
                    ),
                    itemGroup
            ).register(RSCEditor.getInstance());
        });
    }
}
