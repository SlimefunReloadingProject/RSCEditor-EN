package com.balugaq.rsceditor.api;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

@Getter
public class LinkedMachineRecipe {
    private final String name;
    private final int energyCost;
    private final int processingTime;
    private final Map<Integer, ItemStack> linkedInputs;
    private final Map<Integer, ItemStack> linkedOutputs;
    private final ItemStack[] freeOutputs;

    public LinkedMachineRecipe(String name, int energyCost, int processingTime, Map<Integer, ItemStack> linkedInputs, Map<Integer, ItemStack> linkedOutputs, ItemStack[] freeOutputs) {
        this.name = name;
        this.energyCost = energyCost;
        this.processingTime = processingTime;
        this.linkedInputs = linkedInputs;
        this.linkedOutputs = linkedOutputs;
        this.freeOutputs = freeOutputs;
    }
}
