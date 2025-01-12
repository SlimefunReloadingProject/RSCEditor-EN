package com.balugaq.rsceditor.api.objects.types;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

@Getter
public class TemplateMachineRecipe {
    private final String id;
    private final String name;
    private final boolean chooseOne;
    private final boolean forDisplay;
    private final boolean hide;
    private final int processingTime;
    private final ItemStack[] inputs;
    private final ItemStack[] outputs;

    public TemplateMachineRecipe(@NotNull SlimefunItem item, String name, boolean chooseOne, boolean forDisplay, boolean hide, int processingTime, ItemStack[] inputs, ItemStack[] outputs) {
        this(item.getId(), name, chooseOne, forDisplay, hide, processingTime, inputs, outputs);
    }

    public TemplateMachineRecipe(String id, String name, boolean chooseOne, boolean forDisplay, boolean hide, int processingTime, ItemStack[] inputs, ItemStack[] outputs) {
        this.id = id;
        this.name = name;
        this.chooseOne = chooseOne;
        this.forDisplay = forDisplay;
        this.hide = hide;
        this.processingTime = processingTime;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    public int hashCode() {
        int hash = 31;
        hash = 31 * hash + (id != null ? id.hashCode() : 0);
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        hash = 31 * hash + (chooseOne ? 1 : 0);
        hash = 31 * hash + (forDisplay ? 1 : 0);
        hash = 31 * hash + (hide ? 1 : 0);
        hash = 31 * hash + processingTime;
        hash = 31 * hash + (inputs != null ? Arrays.hashCode(inputs) : 0);
        hash = 31 * hash + (outputs != null ? Arrays.hashCode(outputs) : 0);
        return hash;
    }
}
