package com.balugaq.rsceditor.implementation.items.tools;

import com.balugaq.rsceditor.api.base.AbstractTool;
import com.balugaq.rsceditor.utils.KeyUtil;
import com.balugaq.rsceditor.utils.PersistentUtil;
import com.jeff_media.morepersistentdatatypes.DataType;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("deprecation")
public class MenuCopier extends AbstractTool {
    public MenuCopier(@NotNull SlimefunItemStack item) {
        super(item);
    }

    public static void saveMenu0(@NotNull ItemStack tool, @NotNull BlockMenu menu) {
        PersistentUtil.set(tool, DataType.ITEM_STACK_ARRAY, KeyUtil.MENU_CONTENTS, menu.getContents().clone());
        ItemMeta meta = tool.getItemMeta();
        SlimefunItem slimefunItem = SlimefunItem.getByItem(tool);
        if (!(slimefunItem instanceof MenuCopier mc)) {
            return;
        }
        List<String> lore = new ArrayList<>(mc.getItem().getLore());

        Location location = menu.getLocation();
        lore.add(compile("&aSaved: " + menu.getPreset().getTitle()));
        lore.add(compile("&aLocation: " + location.getWorld().getName() + ";" + location.getBlockX() + ":" + location.getBlockY() + ":" + location.getBlockZ()));
        lore.add(compile("&aSlimefun Item ID: " + menu.getPreset().getID()));
        meta.setLore(lore);
        tool.setItemMeta(meta);
    }

    public static void pasteMenu0(@NotNull ItemStack tool, @NotNull BlockMenu menu) {
        ItemStack[] contents = PersistentUtil.get(tool, DataType.ITEM_STACK_ARRAY, KeyUtil.MENU_CONTENTS);
        if (contents == null) {
            return;
        }

        int size = menu.getPreset().getSize();

        for (int i = 0; i < size; i++) {
            ItemStack itemStack = contents[i];
            if (itemStack == null) {
                menu.replaceExistingItem(i, null);
            } else {
                menu.replaceExistingItem(i, itemStack.clone());
            }
        }
    }

    public static String compile(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    @Override
    public void toolUse(@NotNull BlockBreakEvent event, @NotNull ItemStack tool, int fortune, @NotNull List<ItemStack> drops) {
    }

    @Override
    public void rightClick(@NotNull PlayerRightClickEvent event) {
        event.cancel();

        Player player = event.getPlayer();
        Optional<Block> optional = event.getClickedBlock();
        if (player.isSneaking()) {
            if (optional.isPresent()) {
                ItemStack tool = event.getItem();
                if (tool.getType() == Material.AIR) {
                    player.sendMessage("§cYou must hold a tool in your hand to copy or paste a menu.");
                    return;
                }

                Block block = optional.get();
                Location location = block.getLocation();
                BlockMenu menu = BlockStorage.getInventory(location);
                if (menu == null) {
                    player.sendMessage("§cThere is no menu on this block.");
                    return;
                }

                ItemStack[] contents = menu.getContents();
                if (contents == null) {
                    player.sendMessage("§cThe menu is the block is empty.");
                    return;
                }
                saveMenu0(tool, menu);
                player.sendMessage("§aCopied menu contents successfully.");
            }
        } else {
            ItemStack[] contents = PersistentUtil.get(event.getItem(), DataType.ITEM_STACK_ARRAY, KeyUtil.MENU_CONTENTS);
            if (contents == null) {
                player.sendMessage("§cYou have not copied a menu yet.");
                return;
            }

            if (optional.isPresent()) {
                Block block = optional.get();
                Location location = block.getLocation();
                BlockMenu menu = BlockStorage.getInventory(location);
                if (menu == null) {
                    player.sendMessage("§cThere is no menu on this block, cannot paste.");
                    return;
                }

                pasteMenu0(event.getItem(), menu);

                player.sendMessage("§aPasted menu contents successfully.");
            } else {
                player.sendMessage("§cYou must right-click on a block to paste the menu contents.");
            }
        }
    }
}
