package com.balugaq.rsceditor.utils;

import com.google.common.collect.Multimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.net.URL;
import java.util.List;

@Getter
public class YamlWriter {
    private String root;
    private File file;
    private FileConfiguration outputTo;

    public YamlWriter() {
        outputTo = new YamlConfiguration();
    }

    public @NotNull YamlWriter setFile(@NotNull File file) {
        this.file = file;
        this.outputTo = YamlConfiguration.loadConfiguration(file);
        return this;
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter setRoot(@NotNull String root) {
        this.root = root;
        return this;
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter set(String key, @Nullable ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            outputTo.set(getKey(key + ".material_type"), "none");
            return this;
        }

        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        if (slimefunItem != null) {
            outputTo.set(getKey(key + ".material_type"), "slimefun");
            outputTo.set(getKey(key + ".material"), slimefunItem.getId());
            outputTo.set(getKey(key + ".amount"), itemStack.getAmount());
            return this;
        }

        if (itemStack.getType() == Material.PLAYER_HEAD) {
            ItemMeta meta = itemStack.getItemMeta();
            if (meta instanceof SkullMeta skullMeta) {
                try {
                    URL url = skullMeta.getOwnerProfile().getTextures().getSkin();
                    String path = url.getPath();
                    String[] parts = path.split("/");
                    String hash = parts[parts.length - 1];

                    outputTo.set(getKey(key + ".material_type"), "skull_hash");
                    outputTo.set(getKey(key + ".material"), hash);
                    outputTo.set(getKey(key + ".amount"), itemStack.getAmount());
                } catch (Throwable ignored) {
                }
            }
        }

        ItemMeta meta = itemStack.getItemMeta();
        Multimap<Attribute, AttributeModifier> modifier = meta.getAttributeModifiers();
        // unsupport args
        if (
                meta.isUnbreakable()
                        || !meta.getPersistentDataContainer().isEmpty()
                        || meta.hasEnchants()
                        || !meta.getItemFlags().isEmpty()
                        || (modifier != null && !modifier.isEmpty())
        ) {
            outputTo.set(getKey(key + ".material_type"), "saveditem");
            outputTo.set(getKey(key + ".material"), "unsupport_saveditem");
            outputTo.set(getKey(key + ".amount"), itemStack.getAmount());
            return this;
        }

        outputTo.set(getKey(key + ".material_type"), "mc");
        outputTo.set(getKey(key + ".material"), itemStack.getType().name());
        outputTo.set(getKey(key + ".amount"), itemStack.getAmount());

        if (meta.hasCustomModelData()) {
            int modelData = meta.getCustomModelData();
            outputTo.set(getKey(key + ".modelId"), modelData);
        }

        if (meta.hasLore()) {
            List<String> lore = meta.getLore();
            if (lore != null && !lore.isEmpty()) {
                outputTo.set(getKey(key + ".lore"), lore.toArray(new String[0]));
            }
        }

        if (meta.hasDisplayName()) {
            outputTo.set(getKey(key + ".name"), meta.getDisplayName());
        }

        return this;
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter set(@NotNull String key, Object value) {
        outputTo.set(getKey(key), value);
        return this;
    }

    public @NotNull String getKey(@NotNull String key) {
        if (root == null) {
            return key;
        }

        return root + "." + key;
    }

    public @NotNull String toString() {
        return outputTo.saveToString();
    }

    public void save() {
        try {
            outputTo.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
