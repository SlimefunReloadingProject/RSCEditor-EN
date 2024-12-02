package com.balugaq.rsceditor.utils;

import com.balugaq.rsceditor.implementation.RSCEditor;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class KeyUtil {
    public static final NamespacedKey MACHINE_RECIPE_KEY = newKey("machine_recipe");
    public static final NamespacedKey LINKED_MACHINE_RECIPE_KEY = newKey("linked_machine_recipe");

    public static @NotNull NamespacedKey newKey(@NotNull String key) {
        return new NamespacedKey(RSCEditor.getInstance(), key);
    }

    public static @NotNull NamespacedKey newKey(@NotNull String pluginName, @NotNull String key) {
        return new NamespacedKey(pluginName, key);
    }

    public static @NotNull NamespacedKey newKey(@NotNull Plugin plugin, @NotNull String key) {
        return new NamespacedKey(plugin, key);
    }
}
