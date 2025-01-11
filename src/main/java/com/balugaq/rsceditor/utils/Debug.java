package com.balugaq.rsceditor.utils;

import com.balugaq.rsceditor.implementation.RSCEditor;
import org.bukkit.ChatColor;

public class Debug {
    public static void log(String message) {
        RSCEditor.getInstance().getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void log(Object object) {
        log(object == null ? "null" : object.toString());
    }
}
