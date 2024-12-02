package com.balugaq.rsceditor.api;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class MachineRecipe {
    private final String name;
    private final int energyCost;
    private final int processingTime;
    private final ItemStack[] inputs;
    private final ItemStack[] outputs;

    public MachineRecipe(String name, int energyCost, int processingTime, ItemStack[] inputs, ItemStack[] outputs) {
        this.name = name;
        this.energyCost = energyCost;
        this.processingTime = processingTime;
        this.inputs = inputs;
        this.outputs = outputs;
    }
}
