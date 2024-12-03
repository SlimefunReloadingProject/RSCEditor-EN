package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import com.balugaq.rsceditor.utils.ItemStackHelper;
import com.balugaq.rsceditor.utils.KeyUtil;
import com.balugaq.rsceditor.utils.PersistentUtil;
import com.balugaq.rsceditor.utils.datatypes.PersistentLinkedMachineRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LinkedMachineRecipeItem extends PlaceholderItem {
    public LinkedMachineRecipeItem(@NotNull SlimefunItemStack item) {
        super(MyItemGroups.TYPE_GROUP, item);
    }

    public @Nullable LinkedMachineRecipe getLinkedRecipe(ItemStack itemStack) {
        return PersistentUtil.get(itemStack, PersistentLinkedMachineRecipeType.TYPE, KeyUtil.MACHINE_RECIPE_KEY);
    }

    public void setRecipe(@NotNull ItemStack itemStack, @NotNull LinkedMachineRecipe recipe) {
        PersistentUtil.set(itemStack, PersistentLinkedMachineRecipeType.TYPE, KeyUtil.MACHINE_RECIPE_KEY, recipe);

        List<String> lore = new ArrayList<>();
        lore.add("&bLinked Machine Recipe Data");
        lore.add("&b Name: " + recipe.getName());
        lore.add("&d Processing Time: " + recipe.getProcessingTime());

        for (Map.Entry<Integer, ItemStack> entry : recipe.getLinkedInputs().entrySet()) {
            lore.add("&b Linked Input Slot " + entry.getKey() + ": " + ItemStackHelper.getDisplayName(entry.getValue()));
        }

        for (Map.Entry<Integer, ItemStack> entry : recipe.getLinkedOutputs().entrySet()) {
            lore.add("&b Linked Output Slot " + entry.getKey() + ": " + ItemStackHelper.getDisplayName(entry.getValue()));
        }

        int i = 0;
        for (ItemStack item : recipe.getFreeOutputs()) {
            lore.add("&b Free Output " + i + ": " + ItemStackHelper.getDisplayName(item));
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
