package com.balugaq.rsceditor.api;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DoubleTypeItem extends BaseTypeItem<Double> {
    public DoubleTypeItem(@NotNull SlimefunItemStack item) {
        super(item, PlaceHolderType.DOUBLE_PLACEHOLDER);
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

        try {
            double value = Double.parseDouble(content);
            itemMeta.getPersistentDataContainer().set(CONTENT_KEY, PersistentDataType.DOUBLE, value);
            List<String> lore = new ArrayList<>(itemMeta.getLore());

            lore.add("§a已设置内容: " + content);
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
        } catch (NumberFormatException ignored) {
            // Ignored, content is not a valid integer
        }
    }

    @Override
    public @Nullable Double getContent(@Nullable ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return null;
        }

        Double data = itemMeta.getPersistentDataContainer().get(CONTENT_KEY, PersistentDataType.DOUBLE);
        return data == null ? 0.0D : data;
    }
}
