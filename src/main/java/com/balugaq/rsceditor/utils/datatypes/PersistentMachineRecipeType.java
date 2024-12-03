package com.balugaq.rsceditor.utils.datatypes;

import com.balugaq.rsceditor.api.MachineRecipe;
import com.balugaq.rsceditor.utils.KeyUtil;
import com.jeff_media.morepersistentdatatypes.DataType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;

public class PersistentMachineRecipeType implements PersistentDataType<PersistentDataContainer, MachineRecipe> {

    public static final PersistentDataType<PersistentDataContainer, MachineRecipe> TYPE = new PersistentMachineRecipeType();

    public static final NamespacedKey NAME = KeyUtil.newKey("name");
    public static final NamespacedKey CHOOSE_ONE = KeyUtil.newKey("choose_one");
    public static final NamespacedKey FOR_DISPLAY = KeyUtil.newKey("for_display");
    public static final NamespacedKey HIDE = KeyUtil.newKey("hide");
    public static final NamespacedKey PROCESSING_TIME = KeyUtil.newKey("processing_time");
    public static final NamespacedKey INPUTS = KeyUtil.newKey("inputs");
    public static final NamespacedKey OUTPUTS = KeyUtil.newKey("outputs");

    @Override
    @Nonnull
    public Class<PersistentDataContainer> getPrimitiveType() {
        return PersistentDataContainer.class;
    }

    @Override
    @Nonnull
    public Class<MachineRecipe> getComplexType() {
        return MachineRecipe.class;
    }

    @Override
    @Nonnull
    public PersistentDataContainer toPrimitive(@Nonnull MachineRecipe complex, @Nonnull PersistentDataAdapterContext context) {
        final PersistentDataContainer container = context.newPersistentDataContainer();

        container.set(NAME, PersistentDataType.STRING, complex.getName());
        container.set(CHOOSE_ONE, DataType.BOOLEAN, complex.isChooseOne());
        container.set(FOR_DISPLAY, DataType.BOOLEAN, complex.isForDisplay());
        container.set(HIDE, DataType.BOOLEAN, complex.isHide());
        container.set(PROCESSING_TIME, DataType.INTEGER, complex.getProcessingTime());
        container.set(INPUTS, DataType.ITEM_STACK_ARRAY, complex.getInputs());
        container.set(OUTPUTS, DataType.ITEM_STACK_ARRAY, complex.getOutputs());

        return container;
    }

    @Override
    @Nonnull
    public MachineRecipe fromPrimitive(@Nonnull PersistentDataContainer primitive, @Nonnull PersistentDataAdapterContext context) {
        final String name = primitive.getOrDefault(NAME, PersistentDataType.STRING, "");
        final boolean chooseOne = primitive.getOrDefault(CHOOSE_ONE, DataType.BOOLEAN, false);
        final boolean forDisplay = primitive.getOrDefault(FOR_DISPLAY, DataType.BOOLEAN, false);
        final boolean hide = primitive.getOrDefault(HIDE, DataType.BOOLEAN, false);
        final int processingTime = primitive.getOrDefault(PROCESSING_TIME, DataType.INTEGER, 0);
        final ItemStack[] inputs = primitive.get(INPUTS, DataType.ITEM_STACK_ARRAY);
        if (inputs == null) {
            return new MachineRecipe(name, chooseOne, forDisplay, hide, processingTime, new ItemStack[0], new ItemStack[0]);
        }
        final ItemStack[] outputs = primitive.get(OUTPUTS, DataType.ITEM_STACK_ARRAY);
        if (outputs == null) {
            return new MachineRecipe(name, chooseOne, forDisplay, hide, processingTime, inputs, new ItemStack[0]);
        }

        return new MachineRecipe(name, chooseOne, forDisplay, hide, processingTime, inputs, outputs);
    }
}
