package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.api.objects.types.MachineRecipe;
import com.balugaq.rsceditor.api.objects.types.Register;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import com.balugaq.rsceditor.utils.KeyUtil;
import com.balugaq.rsceditor.utils.PersistentUtil;
import com.balugaq.rsceditor.utils.datatypes.PersistentMachineRecipeType;
import com.balugaq.rsceditor.utils.datatypes.PersistentRegisterType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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
            lore.add("&aID 注册名: " + id_alias);
        }

        boolean lateInit = register.isLateInit();
        lore.add("&b延迟加载: " + lateInit);

        boolean warn = register.isWarn();
        lore.add("&e警告: " + warn);

        boolean unfinished = register.isUnfinished();
        lore.add("&c未完成: " + unfinished);

        List<String> conditions = register.getConditions();
        if (conditions != null && !conditions.isEmpty()) {
            for (String condition : conditions) {
                lore.add("&e条件: " + condition);
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
