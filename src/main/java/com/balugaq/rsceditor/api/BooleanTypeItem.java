package com.balugaq.rsceditor.api;

import com.jeff_media.morepersistentdatatypes.DataType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BooleanTypeItem extends BaseTypeItem<Boolean> {
    public BooleanTypeItem(@NotNull SlimefunItemStack item) {
        super(item, PlaceHolderType.BOOLEAN_PLACEHOLDER);
    }

    @Override
    public void setContent(@Nullable ItemStack itemStack, String content) {
        if (itemStack == null) {
            return;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }

        if ("!cancel".equals(content)) {
            return;
        }

        try {
            boolean value = Boolean.parseBoolean(content);
            itemMeta.getPersistentDataContainer().set(CONTENT_KEY, DataType.BOOLEAN, value);
            List<String> lore = new ArrayList<>();

            lore.add("§a已设置内容: " + value);
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
        } catch (NumberFormatException ignored) {
            // Ignored, content is not a valid integer
        }
    }

    @Override
    public @Nullable Boolean getContent(@Nullable ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return null;
        }

        Boolean data = itemMeta.getPersistentDataContainer().get(CONTENT_KEY, DataType.BOOLEAN);
        return data == null ? false : data;
    }
}
