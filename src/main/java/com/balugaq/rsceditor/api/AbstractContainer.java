package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractContainer extends AContainer {
    public AbstractContainer(@NotNull SlimefunItemStack item) {
        super(MyItemGroups.MACHINE_GROUP, item, RecipeType.NULL, new ItemStack[]{null, null, null, null, null, null, null, null, null});
        setCapacity(1);
        setEnergyConsumption(1);
        setProcessingSpeed(1);
        setBlockMenuPreset();
    }

    @Override
    public void tick(Block b) {

    }

    @Override
    public ItemStack getProgressBar() {
        return null;
    }

    @NotNull
    @Override
    public String getMachineIdentifier() {
        return getId();
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
