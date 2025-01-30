package com.balugaq.rsceditor.implementation.items.tools;

import com.balugaq.rsceditor.api.base.AbstractTool;
import com.balugaq.rsceditor.utils.KeyUtil;
import com.balugaq.rsceditor.utils.PersistentUtil;
import com.jeff_media.morepersistentdatatypes.DataType;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
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
        lore.add(compile("&a已保存: " + menu.getPreset().getTitle()));
        lore.add(compile("&a位置: " + location.getWorld().getName() + ";" + location.getBlockX() + ":" + location.getBlockY() + ":" + location.getBlockZ()));
        lore.add(compile("&a粘液ID: " + menu.getPreset().getID()));
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
                    player.sendMessage("§c你必须持有工具才能使用该功能。");
                    return;
                }

                Block block = optional.get();
                Location location = block.getLocation();
                BlockMenu menu = StorageCacheUtils.getMenu(location);
                if (menu == null) {
                    player.sendMessage("§c该方块没有菜单，无法复制。");
                    return;
                }

                ItemStack[] contents = menu.getContents();
                if (contents == null) {
                    player.sendMessage("§c该方块的菜单内容为空，无法复制。");
                    return;
                }
                saveMenu0(tool, menu);
                player.sendMessage("§a成功复制菜单内容。");
            }
        } else {
            ItemStack[] contents = PersistentUtil.get(event.getItem(), DataType.ITEM_STACK_ARRAY, KeyUtil.MENU_CONTENTS);
            if (contents == null) {
                player.sendMessage("§c你还没有复制任何菜单内容，无法粘贴。");
                return;
            }

            if (optional.isPresent()) {
                Block block = optional.get();
                Location location = block.getLocation();
                BlockMenu menu = StorageCacheUtils.getMenu(location);
                if (menu == null) {
                    player.sendMessage("§c该方块没有菜单，无法粘贴。");
                    return;
                }

                pasteMenu0(event.getItem(), menu);

                player.sendMessage("§a成功粘贴菜单内容。");
            } else {
                player.sendMessage("§c你必须对粘液机器右键才能粘贴菜单内容。");
                return;
            }
        }
    }
}
