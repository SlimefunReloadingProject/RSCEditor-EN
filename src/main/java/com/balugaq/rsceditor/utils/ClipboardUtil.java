package com.balugaq.rsceditor.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.entity.Player;

public class ClipboardUtil {
    public static void send(Player player) {
        send(player, "YAML 配置: ");
    }
    public static void send(Player player, String text) {
        TextComponent msg = new TextComponent(text);
        msg.setUnderlined(true);
        msg.setItalic(true);
        msg.setColor(ChatColor.GRAY);
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("点击复制到剪贴板")));
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, text));
        player.spigot().sendMessage(msg, msg);
    }
}
