package com.balugaq.rsceditor.api.objects.types;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

@Getter
public class MachineRecipe {
    private final String name;
    private final boolean chooseOne;
    private final boolean forDisplay;
    private final boolean hide;
    private final int processingTime;
    private final ItemStack[] inputs;
    private final ItemStack[] outputs;

    public MachineRecipe(String name, boolean chooseOne, boolean forDisplay, boolean hide, int processingTime, ItemStack[] inputs, ItemStack[] outputs) {
        this.name = name;
        this.chooseOne = chooseOne;
        this.forDisplay = forDisplay;
        this.hide = hide;
        this.processingTime = processingTime;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (name == null? 0 : name.hashCode());
        hash = 31 * hash + (chooseOne  ? 1 : 0);
        hash = 31 * hash + (forDisplay ? 1 : 0);
        hash = 31 * hash + (hide       ? 1 : 0);
        hash = 31 * hash + processingTime;
        hash = 31 * hash + (inputs == null ? 0 : Arrays.hashCode(inputs));
        hash = 31 * hash + (outputs == null ? 0 : Arrays.hashCode(outputs));
        return hash;
    }
}
