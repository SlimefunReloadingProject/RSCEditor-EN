package com.balugaq.rsceditor.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class ItemStackHelper {
    @NotNull
    public static String getDisplayName(@NotNull ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return "";
        }

        if (itemStack instanceof SlimefunItemStack slimefunItemStack) {
            return slimefunItemStack.getDisplayName();
        }

        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return "";
        }

        String displayName0 = meta.getDisplayName();
        if (displayName0 != null) {
            return displayName0;
        }

        Component displayName1 = meta.displayName();
        if (displayName1 instanceof TextComponent textComponent) {
            return textComponent.content();
        }

        if (itemStack.getType() == Material.PLAYER_HEAD || itemStack.getType() == Material.PLAYER_WALL_HEAD) {
            if (meta instanceof SkullMeta skullMeta) {
                String owner = skullMeta.getOwner();
                if (owner != null) {
                    OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(owner);
                    return offlinePlayer.getPlayer().getName() + " 的头";
                }

                PlayerProfile ownerProfile = skullMeta.getOwnerProfile();
                if (ownerProfile != null) {
                    String playerName = ownerProfile.getName();
                    if (playerName != null) {
                        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerName);
                        return offlinePlayer.getPlayer().getName() + " 的头";
                    }
                }

                com.destroystokyo.paper.profile.PlayerProfile playerProfile = skullMeta.getPlayerProfile();
                if (playerProfile != null) {
                    String playerName = playerProfile.getName();
                    if (playerName != null) {
                        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerName);
                        return offlinePlayer.getPlayer().getName() + " 的头";
                    }
                }

                return skullMeta.getOwningPlayer().getName() + " 的头";
            }
        }

        String i18n = itemStack.getI18NDisplayName();
        if (i18n != null) {
            return i18n;
        }

        return itemStack.getType().name();
    }
}
