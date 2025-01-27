package com.balugaq.rsceditor.core.listeners;

import com.balugaq.rsceditor.utils.Debug;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ItemEditListener implements Listener {
    private final Set<Player> editingPlayers = new HashSet<>();
    private final Map<Player, Integer> selectingLines = new HashMap<>();
    @EventHandler(priority = EventPriority.LOW)
    public void onEditing(PlayerChatEvent event) {
        Debug.log("editing");
        String message = event.getMessage();
        Player player = event.getPlayer();
        if (!player.isOp()) {
            return;
        }
        if ("rhelp".equals(message)) {
            player.sendMessage(compile("&2=========ItemEditor Help========="));
            player.sendMessage(compile("&brhelp - Show this help message."));
            player.sendMessage(compile("&bdone - Exit the editor."));
            player.sendMessage(compile("&bl - Enter edit mode"));
            player.sendMessage(compile("&2=====ItemEditor Name Commands====="));
            player.sendMessage(compile("&bn [content] - Set the display name of the item to the specified content. %0 = old name."));
            player.sendMessage(compile("&bp [content] - Preview the specified content."));
            player.sendMessage(compile("&2=====ItemEditor Lore Commands====="));
            player.sendMessage(compile("&eScroll to select lore lines!"));
            player.sendMessage(compile("&bdd - Delete the selected line."));
            player.sendMessage(compile("&baa [content] - Add a new line at the end of the lore with the specified content."));
            player.sendMessage(compile("&bii [content] - Insert a new line at the selected line with the specified content."));
            player.sendMessage(compile("&bmm [content] - Modify the selected line with the specified content. %0 = old line content."));
            player.sendMessage(compile("&2=========ItemEditor Help========="));
            event.setCancelled(true);
            return;
        }
        else if (message.startsWith("l")) {
            editingPlayers.add(player);
            clearScreen(player);
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            if (itemStack.getType() == Material.AIR) {
                player.sendMessage(compile("&c[RSCEditor] ItemEditor: &cYou need to hold an item in your main hand."));
                return;
            }
            sendLore(player, itemStack.getItemMeta().getLore(), 0);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onSelecting(PlayerChatEvent event) {
        Debug.log("selecting");
        String message = event.getMessage();
        Player player = event.getPlayer();
        if (!player.isOp()) {
            return;
        }
        if (editingPlayers.contains(player)) {
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                player.sendMessage(compile("&c[RSCEditor] ItemEditor: &cYou need to hold an item in your main hand."));
                return;
            }
            // commands
            if ("done".equals(message)) {
                Debug.log("trigger done editing");
                doneEditing(player);
                event.setCancelled(true);
            }
            else if ("dd".equals(message)) {
                Debug.log("trigger delete line");
                removeLine(player, getSelectingLine(player));
                clearScreen(player);
                sendLore(player, itemStack.getItemMeta().getLore(), getSelectingLine(player));
                event.setCancelled(true);
            }
            else if (message.startsWith("aa ")) {
                Debug.log("trigger add line");
                String value = message.substring(3);
                addLine(player, "&f" + value);
                clearScreen(player);
                sendLore(player, itemStack.getItemMeta().getLore(), getSelectingLine(player));
                event.setCancelled(true);
            }
            else if (message.startsWith("ii ")) {
                Debug.log("trigger insert line");
                String value = message.substring(3);
                insertLine(player, getSelectingLine(player), "&f" + value);
                clearScreen(player);
                sendLore(player, itemStack.getItemMeta().getLore(), getSelectingLine(player));
                event.setCancelled(true);
            }
            else if (message.startsWith("mm ")) {
                Debug.log("trigger modify line");
                String value = message.substring(3);
                modifyLine(player, getSelectingLine(player), "&f" + value);
                clearScreen(player);
                sendLore(player, itemStack.getItemMeta().getLore(), getSelectingLine(player));
                event.setCancelled(true);
            }
            else if (message.startsWith("p")) {
                String value = message.substring(1);
                player.sendMessage(compile("&c[RSCEditor] ItemEditor: &ePreview: " + compile(value)));
                event.setCancelled(true);
            }
            else if (message.startsWith("n")) {
                String value = message.substring(1);
                if (itemStack.getType() == Material.AIR) {
                    player.sendMessage(compile("&c[RSCEditor] ItemEditor: &cYou need to hold an item in your main hand."));
                    return;
                }
                ItemMeta meta = itemStack.getItemMeta();
                meta.setDisplayName(compile("&f" + value));
                itemStack.setItemMeta(meta);
                player.updateInventory();
                event.setCancelled(true);
            }
            else {
                player.sendMessage(compile("&c[RSCEditor] ItemEditor: type \"help\" for information."));
            }
        }
    }

    public void modifyLine(Player player, int line, String value) {
        Debug.log("modify line " + line + ": " + value);
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        List<String> lore = Objects.requireNonNullElse(itemStack.getItemMeta().getLore(), new ArrayList<>());
        if (line < lore.size()) {
            String oldLine = lore.get(line);
            lore.set(line, compile(value.replace("%0", oldLine)));
            ItemMeta meta = itemStack.getItemMeta();
            meta.setLore(lore);
            itemStack.setItemMeta(meta);
            player.updateInventory();
        }
    }

    public void addLine(Player player, String value) {
        Debug.log("add line: " + value);
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        List<String> lore = Objects.requireNonNullElse(itemStack.getItemMeta().getLore(), new ArrayList<>());
        lore.add(compile(value));
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        player.updateInventory();
    }

    public void insertLine(Player player, int line, String value) {
        Debug.log("insert line " + line + ": " + value);
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        List<String> lore = Objects.requireNonNullElse(itemStack.getItemMeta().getLore(), new ArrayList<>());
        if (line < lore.size()) {
            lore.add(line, compile(value));
            ItemMeta meta = itemStack.getItemMeta();
            meta.setLore(lore);
            itemStack.setItemMeta(meta);
            player.updateInventory();
        }
    }
    @EventHandler
    public void onLineSelect(PlayerItemHeldEvent event) {
        Debug.log("line select");
        Player player = event.getPlayer();
        if (editingPlayers.contains(player)) {
            ItemStack itemStack = player.getInventory().getItem(event.getPreviousSlot());
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                player.sendMessage(compile("&c[RSCEditor] ItemEditor: &cYou need to hold an item in your main hand."));
                return;
            }
            List<String> lore = Objects.requireNonNullElse(itemStack.getItemMeta().getLore(), new ArrayList<>());
            int newSlot = event.getNewSlot();
            int previousSlot = event.getPreviousSlot();
            Debug.log("new slot: " + newSlot + ", previous slot: " + previousSlot);
            if (newSlot >= 5 && previousSlot == 0) { // scroll left
                Debug.log("scroll left type 1");
                setSelectingLine(player, getSelectingLine(player) - 1, lore.size());
            }
            else if (newSlot < 5 && previousSlot == 8) { // scroll right
                Debug.log("scroll right type 2");
                setSelectingLine(player, getSelectingLine(player) + 1, lore.size());
            }
            else if (newSlot > previousSlot) { // scroll right
                Debug.log("scroll right type 3");
                setSelectingLine(player, getSelectingLine(player) + 1, lore.size());
            }
            else if (newSlot < previousSlot) { // scroll left
                Debug.log("scroll left type 4");
                setSelectingLine(player, getSelectingLine(player) - 1, lore.size());
            }
            if (itemStack != null && itemStack.getType() != Material.AIR) {
                clearScreen(player);
                sendLore(player, lore, getSelectingLine(player));
                event.setCancelled(true);
            }
        }
    }

    public void removeLine(Player player, int line) {
        Debug.log("remove line " + line);
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        List<String> lore = Objects.requireNonNullElse(itemStack.getItemMeta().getLore(), new ArrayList<>());
        if (line < lore.size()) {
            lore.remove(line);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setLore(lore);
            itemStack.setItemMeta(meta);
            player.updateInventory();
        }
    }

    public int getSelectingLine(Player player) {
        if (!selectingLines.containsKey(player)) {
            selectingLines.put(player, 0);
            return 0;
        }

        return selectingLines.get(player);
    }

    public int setSelectingLine(Player player, int line, int loreSize) {
        if (line < 0) {
            line = 0;
        }
        if (line > loreSize - 1) {
            line = loreSize - 1;
        }
        selectingLines.put(player, line);
        return line;
    }

    public void clearScreen(Player player) {
        for (int i = 0; i < 20; i++) {
            player.sendMessage("");
        }
    }

    public void sendLore(Player player, List<String> lore, int selectingLine) {
        Debug.log("send lore");
        List<String> showLines = new ArrayList<>();
        List<String> lines;
        if (lore == null) {
            lines = new ArrayList<>();
        } else {
            lines = lore;
        }
        // Show as: " &7|&r    [content]"
        // selecting line show as: "&a>&r    [content]"
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (i == selectingLine) {
                showLines.add(compile(" &a>&r    " + line));
            } else {
                showLines.add(compile(" &7|&r    " + line));
            }
        }
        player.sendMessage(compile("&2=======Edit lore======="));
        for (String line : showLines) {
            player.sendMessage(compile(line));
        }
        player.sendMessage(compile("&2=======Edit lore======="));
    }

    public String compile(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public void doneEditing(Player player) {
        Debug.log("done editing");
        editingPlayers.remove(player);
        selectingLines.remove(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Debug.log("quit");
        Player player = event.getPlayer();
        doneEditing(player);
    }
}
