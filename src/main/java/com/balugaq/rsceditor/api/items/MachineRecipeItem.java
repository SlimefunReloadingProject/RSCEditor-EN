package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.objects.types.MachineRecipe;
import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import com.balugaq.rsceditor.utils.KeyUtil;
import com.balugaq.rsceditor.utils.PersistentUtil;
import com.balugaq.rsceditor.utils.datatypes.PersistentMachineRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MachineRecipeItem extends PlaceholderItem {
    public MachineRecipeItem(@NotNull SlimefunItemStack item) {
        super(RSCEItemGroups.TYPE_GROUP, item);
    }

    public @Nullable MachineRecipe getRecipe(ItemStack itemStack) {
        return PersistentUtil.get(itemStack, PersistentMachineRecipeType.TYPE, KeyUtil.MACHINE_RECIPE_KEY);
    }

    public void setRecipe(@NotNull ItemStack itemStack, @NotNull MachineRecipe recipe) {
        PersistentUtil.set(itemStack, PersistentMachineRecipeType.TYPE, KeyUtil.MACHINE_RECIPE_KEY, recipe);

        List<String> lore = new ArrayList<>();
        lore.add("&b机器配方数据");
        lore.add("&b 名字: " + recipe.getName());
        lore.add("&d 生产耗时: " + recipe.getProcessingTime());

        int i = 1;
        for (ItemStack input : recipe.getInputs()) {
            lore.add("&b 输入 " + i + ": " + ItemStackHelper.getDisplayName(input));
            i++;
        }

        i = 1;
        for (ItemStack output : recipe.getOutputs()) {
            lore.add("&e 输出 " + i + ": " + ItemStackHelper.getDisplayName(output));
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
