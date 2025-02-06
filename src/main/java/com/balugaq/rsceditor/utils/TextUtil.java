package com.balugaq.rsceditor.utils;

import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.api.objects.types.RainbowType;
import com.balugaq.rsceditor.api.objects.types.SimpleMachineType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class TextUtil {
    private static boolean langHelperInit = true;

    public static @NotNull String getName(@NotNull SimpleMachineType type) {
        return switch (type) {
            case ELECTRIC_CRUCIBLE -> "Electric Crucible";
            case ELECTRIC_FURNACE -> "Electric Furnace";
            case ELECTRIC_GOLD_PAN -> "Electric Gold Pan";
            case ELECTRIC_DUST_WASHER -> "Electric Dust Washer";
            case ELECTRIC_ORE_GRINDER -> "Electric Ore Grinder";
            case ELECTRIC_INGOT_FACTORY -> "Electric Ingot Factory";
            case ELECTRIC_INGOT_PULVERIZER -> "Electric Ingot Pulverizer";
            case CHARGING_BENCH -> "Charging Bench";
            case ANIMAL_GROWTH_ACCELERATOR -> "Animal Growth Accelerator";
            case TREE_GROWTH_ACCELERATOR -> "Tree Growth Accelerator";
            case CROP_GROWTH_ACCELERATOR -> "Crop Growth Accelerator";
            case FREEZER -> "Freezer";
            case CARBON_PRESS -> "Carbon Press";
            case ELECTRIC_PRESS -> "Electric Press";
            case ELECTRIC_SMELTERY -> "Electric Smeltery";
            case FOOD_FABRICATOR -> "Food Fabricator";
            case HEATED_PRESSURE_CHAMBER -> "Heated Pressure Chamber";
            case AUTO_ENCHANTER -> "Auto Enchanter";
            case AUTO_DISENCHANTER -> "Auto Disenchanter";
            case BOOK_BINDER -> "Book Binder";
            case AUTO_ANVIL -> "Auto Anvil";
            case AUTO_DRIER -> "Auto Drier";
            case AUTO_BREWER -> "Auto Brewer";
            case REFINERY -> "Refinery";
            case PRODUCE_COLLECTOR -> "Produce Collector";
            //default -> "Unknown Machine";
        };
    }

    public static @NotNull String getName(@NotNull Biome biome) {
        String key = biome.translationKey();
        String name = null;
        if (langHelperInit) {
            try {
                name = LegacyComponentSerializer.legacySection().serialize(Component.translatable(key));
            } catch (Throwable ignored) {
                langHelperInit = false;
            }
        }
        if (name == null) {
            return biome.name();
        }

        return name;
    }

    public static @NotNull String getName(@NotNull EnergyNetComponentType type) {
        return switch (type) {
            case GENERATOR -> "Generator";
            case CAPACITOR -> "Capacitor";
            case CONSUMER -> "Consumer";
            case CONNECTOR -> "Connector";
            default -> "None";
        };
    }

    public static @NotNull String getName(@NotNull ItemFlowType type) {
        return switch (type) {
            case INSERT -> "Insert";
            case WITHDRAW -> "Withdraw";
            case INSERT_AND_WITHDRAW -> "Insert and Withdraw";
            case FREE_OUTPUT -> "Free Output";
            default -> "None";
        };
    }

    public static @NotNull String getName(@NotNull RainbowType type) {
        return switch (type) {
            case WOOL -> "Wool";
            case CARPET -> "Carpet";
            case STAINED_GLASS -> "Stained Glass";
            case STAINED_GLASS_PANE -> "Stained Glass Pane";
            case TERRACOTTA -> "Terracotta";
            case GLAZED_TERRACOTTA -> "Glazed Terracotta";
            case CONCRETE -> "Concrete";
            case SHULKER_BOX -> "Shulker Box";
            case CUSTOM -> "Custom";
        };
    }

    // Sound enum is too huge, so we just use the name of the sound.
    public static @NotNull String getName(@NotNull Sound sound) {
        String rawName = sound.name().replace("_", " ").toLowerCase();
        return rawName.substring(0, 1).toUpperCase() + rawName.substring(1);
    }
}
