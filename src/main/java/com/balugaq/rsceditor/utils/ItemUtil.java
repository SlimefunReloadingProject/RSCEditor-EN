package com.balugaq.rsceditor.utils;

import com.balugaq.rsceditor.api.GroupType;
import com.balugaq.rsceditor.api.GroupTypeItem;
import com.balugaq.rsceditor.api.MenuMatrix;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;

import java.util.function.Consumer;

public class ItemUtil {
    public static void isGroupTypeItem(BlockMenu menu, MenuMatrix matrix, String label, Consumer<GroupType> consumer, Runnable defaulter) {
        if (SlimefunItem.getByItem(menu.getItemInSlot(matrix.getChar(label))) instanceof GroupTypeItem groupTypeItem) {
            consumer.accept(groupTypeItem.getType());
        } else {
            defaulter.run();
        }
    }
}
