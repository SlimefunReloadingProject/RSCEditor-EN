package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.api.objects.types.LinkedMachineRecipe;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import com.balugaq.rsceditor.utils.KeyUtil;
import com.balugaq.rsceditor.utils.PersistentUtil;
import com.balugaq.rsceditor.utils.datatypes.PersistentLinkedMachineRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class LinkedMachineRecipeItem extends PlaceholderItem {
    public LinkedMachineRecipeItem(@NotNull SlimefunItemStack item) {
        super(RSCEItemGroups.TYPE_GROUP, item);
    }

    public @Nullable LinkedMachineRecipe getLinkedRecipe(ItemStack itemStack) {
        return PersistentUtil.get(itemStack, PersistentLinkedMachineRecipeType.TYPE, KeyUtil.MACHINE_RECIPE_KEY);
    }

    public void setRecipe(@NotNull ItemStack itemStack, @NotNull LinkedMachineRecipe recipe) {
        PersistentUtil.set(itemStack, PersistentLinkedMachineRecipeType.TYPE, KeyUtil.MACHINE_RECIPE_KEY, recipe);

        List<String> lore = new ArrayList<>();
        lore.add("&b强配方机器配方数据");
        lore.add("&b 名称: " + recipe.getName());
        lore.add("&d 生产耗时: " + recipe.getProcessingTime());

        for (Map.Entry<Integer, ItemStack> entry : recipe.getLinkedInputs().entrySet()) {
            lore.add("&b 链接至槽位（输入） " + entry.getKey() + ": " + ItemStackHelper.getDisplayName(entry.getValue()));
        }

        for (Map.Entry<Integer, ItemStack> entry : recipe.getLinkedOutputs().entrySet()) {
            lore.add("&e 链接至槽位（输出） " + entry.getKey() + ": " + ItemStackHelper.getDisplayName(entry.getValue()));
        }

        int i = 0;
        for (ItemStack item : recipe.getFreeOutputs()) {
            lore.add("&b 自由输出 " + i + ": " + ItemStackHelper.getDisplayName(item));
            i++;
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
