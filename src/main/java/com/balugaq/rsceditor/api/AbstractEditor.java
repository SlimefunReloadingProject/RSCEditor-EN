package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractEditor extends SlimefunItem implements InventoryBlock {
    public AbstractEditor(SlimefunItemStack item) {
        super(MyItemGroups.MACHINE_GROUP, item, RecipeType.NULL, new ItemStack[] {null, null, null, null, null, null, null, null, null});
    }

    @Override
    public int[] getInputSlots() {
        return new int[0];
    }

    @Override
    public int[] getOutputSlots() {
        return new int[0];
    }

    @Override
    public void preRegister() {
        super.preRegister();
    }

    @CanIgnoreReturnValue
    public abstract BlockMenuPreset setBlockMenuPreset();
}
