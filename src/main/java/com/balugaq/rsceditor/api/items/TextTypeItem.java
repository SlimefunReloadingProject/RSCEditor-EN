package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.BaseTypeItem;
import com.balugaq.rsceditor.api.objects.types.PlaceHolderType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TextTypeItem extends BaseTypeItem<String> {
    public TextTypeItem(@NotNull SlimefunItemStack item) {
        super(item, PlaceHolderType.TEXT_PLACEHOLDER);
    }

    @Override
    public void setContent(@Nullable ItemStack itemStack, @NotNull String content) {
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

        itemMeta.getPersistentDataContainer().set(CONTENT_KEY, PersistentDataType.STRING, content);
        List<String> lore = new ArrayList<>();

        lore.add("§a已设置内容: " + content);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
    }

    @Override
    public @Nullable String getContent(@Nullable ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return null;
        }

        String data = itemMeta.getPersistentDataContainer().get(CONTENT_KEY, PersistentDataType.STRING);
        return data == null ? "" : data;
    }
}
