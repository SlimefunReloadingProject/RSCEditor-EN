package com.balugaq.rsceditor.api.objects.types;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

@Getter
public class LinkedMachineRecipe {
    private final String name;
    private final boolean chooseOne;
    private final boolean forDisplay;
    private final boolean hide;
    private final int processingTime;
    private final Map<Integer, ItemStack> linkedInputs;
    private final Map<Integer, ItemStack> linkedOutputs;
    private final ItemStack[] freeOutputs;

    public LinkedMachineRecipe(String name, boolean chooseOne, boolean forDisplay, boolean hide, int processingTime, Map<Integer, ItemStack> linkedInputs, Map<Integer, ItemStack> linkedOutputs, ItemStack[] freeOutputs) {
        this.name = name;
        this.chooseOne = chooseOne;
        this.forDisplay = forDisplay;
        this.hide = hide;
        this.processingTime = processingTime;
        this.linkedInputs = linkedInputs;
        this.linkedOutputs = linkedOutputs;
        this.freeOutputs = freeOutputs;
    }
}
