package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.api.objects.types.Register;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import com.balugaq.rsceditor.utils.KeyUtil;
import com.balugaq.rsceditor.utils.PersistentUtil;
import com.balugaq.rsceditor.utils.datatypes.PersistentRegisterType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class RegisterItem extends PlaceholderItem {
    public RegisterItem(@NotNull SlimefunItemStack item) {
        super(RSCEItemGroups.TYPE_GROUP, item);
    }

    public @Nullable Register getRegister(ItemStack itemStack) {
        return PersistentUtil.get(itemStack, PersistentRegisterType.TYPE, KeyUtil.REGISTER_KEY);
    }

    public void setRegister(@NotNull ItemStack itemStack, @NotNull Register register) {
        PersistentUtil.set(itemStack, PersistentRegisterType.TYPE, KeyUtil.REGISTER_KEY, register);

        List<String> lore = new ArrayList<>();
        String id_alias = register.getIdAlias();
        if (id_alias != null) {
            lore.add("&aFinal Register ID: " + id_alias);
        }

        boolean lateInit = register.isLateInit();
        lore.add("&bInit later: " + lateInit);

        boolean warn = register.isWarn();
        lore.add("&eWarnings on register: " + warn);

        boolean unfinished = register.isUnfinished();
        lore.add("&cIs unfinished: " + unfinished);

        List<String> conditions = register.getConditions();
        if (conditions != null && !conditions.isEmpty()) {
            for (String condition : conditions) {
                lore.add("&eRegister condition: " + condition);
            }
        }

        List<String> coloredLore = new ArrayList<>();
        for (String line : lore) {
            coloredLore.add(ChatColor.translateAlternateColorCodes('&', line));
        }

        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(coloredLore);
        itemStack.setItemMeta(meta);
    }
}
