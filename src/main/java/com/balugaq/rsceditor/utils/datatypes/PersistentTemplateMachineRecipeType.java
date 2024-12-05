package com.balugaq.rsceditor.utils.datatypes;

import com.balugaq.rsceditor.api.objects.types.TemplateMachineRecipe;
import com.balugaq.rsceditor.utils.KeyUtil;
import com.jeff_media.morepersistentdatatypes.DataType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;

public class PersistentTemplateMachineRecipeType implements PersistentDataType<PersistentDataContainer, TemplateMachineRecipe> {

    public static final PersistentDataType<PersistentDataContainer, TemplateMachineRecipe> TYPE = new PersistentTemplateMachineRecipeType();
    public static final NamespacedKey ID = KeyUtil.newKey("id");
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
    public Class<TemplateMachineRecipe> getComplexType() {
        return TemplateMachineRecipe.class;
    }

    @Override
    @Nonnull
    public PersistentDataContainer toPrimitive(@Nonnull TemplateMachineRecipe complex, @Nonnull PersistentDataAdapterContext context) {
        final PersistentDataContainer container = context.newPersistentDataContainer();

        container.set(ID, PersistentDataType.STRING, complex.getId());
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
    public TemplateMachineRecipe fromPrimitive(@Nonnull PersistentDataContainer primitive, @Nonnull PersistentDataAdapterContext context) {
        final String id = primitive.get(ID, PersistentDataType.STRING);
        final String name = primitive.getOrDefault(NAME, PersistentDataType.STRING, "");
        final boolean chooseOne = primitive.getOrDefault(CHOOSE_ONE, DataType.BOOLEAN, false);
        final boolean forDisplay = primitive.getOrDefault(FOR_DISPLAY, DataType.BOOLEAN, false);
        final boolean hide = primitive.getOrDefault(HIDE, DataType.BOOLEAN, false);
        final int processingTime = primitive.getOrDefault(PROCESSING_TIME, DataType.INTEGER, 0);
        final ItemStack[] inputs = primitive.get(INPUTS, DataType.ITEM_STACK_ARRAY);
        if (inputs == null) {
            return new TemplateMachineRecipe(id, name, chooseOne, forDisplay, hide, processingTime, new ItemStack[0], new ItemStack[0]);
        }
        final ItemStack[] outputs = primitive.get(OUTPUTS, DataType.ITEM_STACK_ARRAY);
        if (outputs == null) {
            return new TemplateMachineRecipe(id, name, chooseOne, forDisplay, hide, processingTime, inputs, new ItemStack[0]);
        }

        return new TemplateMachineRecipe(id, name, chooseOne, forDisplay, hide, processingTime, inputs, outputs);
    }
}
