package com.balugaq.rsceditor.api.objects.types;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
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

    public int hashCode() {
        int hash = 31;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (chooseOne ? 1 : 0);
        hash = 31 * hash + (forDisplay ? 1 : 0);
        hash = 31 * hash + (hide ? 1 : 0);
        hash = 31 * hash + processingTime;
        hash = 31 * hash + (linkedInputs == null ? 0 : linkedInputs.hashCode());
        hash = 31 * hash + (linkedOutputs == null ? 0 : linkedOutputs.hashCode());
        hash = 31 * hash + (freeOutputs == null ? 0 : Arrays.hashCode(freeOutputs));
        return hash;
    }
}
