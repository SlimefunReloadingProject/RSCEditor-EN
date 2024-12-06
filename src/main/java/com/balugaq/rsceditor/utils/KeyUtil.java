package com.balugaq.rsceditor.utils;

import com.balugaq.rsceditor.implementation.RSCEditor;
import lombok.experimental.UtilityClass;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class KeyUtil {
    public static final NamespacedKey MACHINE_RECIPE_KEY = newKey("machine_recipe");
    public static final NamespacedKey TEMPLATE_MACHINE_RECIPE_KEY = newKey("template_machine_recipe");
    public static final NamespacedKey LINKED_MACHINE_RECIPE_KEY = newKey("linked_machine_recipe");
    public static final NamespacedKey MENU_CONTENTS = newKey("menu_contents");
    public static final NamespacedKey REGISTER_KEY = newKey("register");

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
