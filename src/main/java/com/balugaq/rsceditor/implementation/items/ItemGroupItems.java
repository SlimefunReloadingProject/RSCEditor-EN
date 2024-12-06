package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.items.ItemGroupItem;
import com.balugaq.rsceditor.implementation.RSCEditor;
import com.balugaq.rsceditor.utils.ReflectionUtil;
import com.balugaq.rsceditor.utils.SlimefunItemUtil;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import lombok.experimental.UtilityClass;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;

@UtilityClass
public class ItemGroupItems {
    public static void register() {
        Iterator<ItemGroup> iterator = Slimefun.getRegistry().getAllItemGroups().iterator();
        while (iterator.hasNext()) {
            ItemGroup itemGroup = iterator.next();
            ItemStack item = (ItemStack) ReflectionUtil.getValue(itemGroup, "item");
            if (item != null) {
                ItemGroupItem itemGroupItem = new ItemGroupItem(
                        new SlimefunItemStack(
                                "RSC_EDITOR_ITEM_GROUP_" + itemGroup.getKey().getNamespace().toUpperCase() + "_" + itemGroup.getKey().getKey().toUpperCase(),
                                item
                        ),
                        itemGroup
                );
                SlimefunItemUtil.registerItem(itemGroupItem);
            }
        }
    }
}
