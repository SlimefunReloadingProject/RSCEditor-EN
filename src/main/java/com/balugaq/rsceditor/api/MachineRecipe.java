package com.balugaq.rsceditor.api;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

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
}
