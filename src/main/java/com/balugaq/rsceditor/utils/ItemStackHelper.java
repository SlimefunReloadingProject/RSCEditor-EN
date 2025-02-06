package com.balugaq.rsceditor.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslatableComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;

import javax.annotation.Nonnull;

public class ItemStackHelper {
    @Nonnull
    public static String getDisplayName(@Nonnull ItemStack item) {
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
            return item.getItemMeta().getDisplayName();
        } else {
            return getName(item);
        }
    }

    @Nonnull
    public static String getName(@Nonnull ItemStack item) {
        Material type = item.getType();

        if (type == Material.POTION
                || type == Material.SPLASH_POTION
                || type == Material.LINGERING_POTION
                || type == Material.TIPPED_ARROW) {
            String potion = ((PotionMeta) item.getItemMeta()).getBasePotionData().getType().toString().toLowerCase();
            return LegacyComponentSerializer.legacySection().serialize(Component.translatable(type.translationKey() + ".effect." + potion));
        } else if (type == Material.PLAYER_HEAD || type == Material.PLAYER_WALL_HEAD) {
            return getPlayerSkullName(item);
        }

        if (item.displayName() instanceof TranslatableComponent tc) {
            Component component = tc.children().get(0);

            return LegacyComponentSerializer.legacySection().serialize(component);
        }

        return type.name();
    }

    @Nonnull
    private static String getPlayerSkullName(@Nonnull ItemStack skull) {
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        if (meta != null && meta.hasOwner()) {
            return LegacyComponentSerializer.legacySection().serialize(
                    Component.translatable("block.minecraft.player_head.named").args(Component.text(meta.getOwningPlayer().getName()))
            );
        } else {
            return LegacyComponentSerializer.legacySection().serialize(Component.translatable("block.minecraft.player_head"));
        }
    }
}
