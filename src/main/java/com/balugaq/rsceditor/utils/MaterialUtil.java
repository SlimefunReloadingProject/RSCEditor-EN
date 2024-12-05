package com.balugaq.rsceditor.utils;

import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.api.objects.types.RainbowType;
import com.balugaq.rsceditor.api.objects.types.SimpleMachineType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.block.Biome;

public class MaterialUtil {
    public static Material getMaterial(SimpleMachineType type) {
        return switch (type) {
            case ELECTRIC_CRUCIBLE -> Material.RED_TERRACOTTA;
            case ELECTRIC_FURNACE -> Material.FURNACE;
            case ELECTRIC_GOLD_PAN -> Material.BROWN_TERRACOTTA;
            case ELECTRIC_DUST_WASHER -> Material.BLUE_STAINED_GLASS;
            case ELECTRIC_ORE_GRINDER -> Material.FURNACE;
            case ELECTRIC_INGOT_FACTORY -> Material.RED_TERRACOTTA;
            case ELECTRIC_INGOT_PULVERIZER -> Material.FURNACE;
            case CHARGING_BENCH -> Material.CRAFTING_TABLE;
            case ANIMAL_GROWTH_ACCELERATOR -> Material.HAY_BLOCK;
            case TREE_GROWTH_ACCELERATOR -> Material.BROWN_TERRACOTTA;
            case CROP_GROWTH_ACCELERATOR -> Material.GREEN_TERRACOTTA;
            case FREEZER -> Material.LIGHT_BLUE_STAINED_GLASS;
            case CARBON_PRESS -> Material.BLACK_STAINED_GLASS;
            case ELECTRIC_PRESS -> SlimefunItems.ELECTRIC_PRESS.getType();
            case ELECTRIC_SMELTERY -> Material.FURNACE;
            case FOOD_FABRICATOR -> Material.GREEN_STAINED_GLASS;
            case HEATED_PRESSURE_CHAMBER -> Material.LIGHT_GRAY_STAINED_GLASS;
            case AUTO_ENCHANTER -> Material.ENCHANTING_TABLE;
            case AUTO_DISENCHANTER -> Material.ENCHANTING_TABLE;
            case BOOK_BINDER -> Material.BOOKSHELF;
            case AUTO_ANVIL -> Material.IRON_BLOCK;
            case AUTO_DRIER -> Material.SMOKER;
            case AUTO_BREWER -> Material.SMOKER;
            case REFINERY -> Material.PISTON;
            case PRODUCE_COLLECTOR -> Material.HAY_BLOCK;
            default -> Material.BARRIER;
        };
    }

    public static Material getMaterial(Biome biome) {
        return switch (biome) {
            case OCEAN -> Material.WATER_BUCKET;
            case PLAINS -> Material.GRASS_BLOCK;
            case DESERT -> Material.SAND;
            case WINDSWEPT_HILLS -> Material.STONE;
            case FOREST -> Material.OAK_LOG;
            case TAIGA -> Material.SPRUCE_LOG;
            case SWAMP -> Material.LILY_PAD;
            case MANGROVE_SWAMP -> Material.MANGROVE_ROOTS;
            case RIVER -> Material.WATER_BUCKET;
            case NETHER_WASTES -> Material.NETHERRACK;
            case THE_END -> Material.END_STONE;
            case FROZEN_OCEAN -> Material.ICE;
            case FROZEN_RIVER -> Material.ICE;
            case SNOWY_PLAINS -> Material.SNOW_BLOCK;
            case MUSHROOM_FIELDS -> Material.RED_MUSHROOM_BLOCK;
            case BEACH -> Material.SAND;
            case JUNGLE -> Material.JUNGLE_LOG;
            case SPARSE_JUNGLE -> Material.JUNGLE_LOG;
            case DEEP_OCEAN -> Material.WATER_BUCKET;
            case STONY_SHORE -> Material.COBBLESTONE;
            case SNOWY_BEACH -> Material.SAND;
            case BIRCH_FOREST -> Material.BIRCH_LOG;
            case DARK_FOREST -> Material.DARK_OAK_LOG;
            case SNOWY_TAIGA -> Material.SPRUCE_LOG;
            case OLD_GROWTH_PINE_TAIGA -> Material.SPRUCE_LOG;
            case WINDSWEPT_FOREST -> Material.OAK_LOG;
            case SAVANNA -> Material.ACACIA_LOG;
            case SAVANNA_PLATEAU -> Material.ACACIA_LOG;
            case BADLANDS -> Material.TERRACOTTA;
            case WOODED_BADLANDS -> Material.ACACIA_LOG;
            case SMALL_END_ISLANDS -> Material.END_STONE;
            case END_MIDLANDS -> Material.END_STONE;
            case END_HIGHLANDS -> Material.END_STONE;
            case END_BARRENS -> Material.END_STONE;
            case WARM_OCEAN -> Material.WATER_BUCKET;
            case LUKEWARM_OCEAN -> Material.WATER_BUCKET;
            case COLD_OCEAN -> Material.WATER_BUCKET;
            case DEEP_LUKEWARM_OCEAN -> Material.WATER_BUCKET;
            case DEEP_COLD_OCEAN -> Material.WATER_BUCKET;
            case DEEP_FROZEN_OCEAN -> Material.ICE;
            case THE_VOID -> Material.BARRIER;
            case SUNFLOWER_PLAINS -> Material.SUNFLOWER;
            case WINDSWEPT_GRAVELLY_HILLS -> Material.GRAVEL;
            case FLOWER_FOREST -> Material.DANDELION;
            case ICE_SPIKES -> Material.ICE;
            case OLD_GROWTH_BIRCH_FOREST -> Material.BIRCH_LOG;
            case OLD_GROWTH_SPRUCE_TAIGA -> Material.SPRUCE_LOG;
            case WINDSWEPT_SAVANNA -> Material.ACACIA_LOG;
            case ERODED_BADLANDS -> Material.TERRACOTTA;
            case BAMBOO_JUNGLE -> Material.BAMBOO;
            case SOUL_SAND_VALLEY -> Material.SOUL_SAND;
            case CRIMSON_FOREST -> Material.CRIMSON_STEM;
            case WARPED_FOREST -> Material.WARPED_STEM;
            case BASALT_DELTAS -> Material.BASALT;
            case DRIPSTONE_CAVES -> Material.POINTED_DRIPSTONE;
            case LUSH_CAVES -> Material.MOSS_BLOCK;
            case DEEP_DARK -> Material.CALCITE;
            case MEADOW -> Material.GRASS_BLOCK;
            case GROVE -> Material.SPRUCE_LOG;
            case SNOWY_SLOPES -> Material.SNOW_BLOCK;
            case FROZEN_PEAKS -> Material.ICE;
            case JAGGED_PEAKS -> Material.STONE;
            case STONY_PEAKS -> Material.COBBLESTONE;
            case CHERRY_GROVE -> Material.CHERRY_LOG;
            default -> Material.BARRIER;
        };
    }

    public static Material getMaterial(RainbowType type) {
        return switch (type) {
            case WOOL -> Material.WHITE_WOOL;
            case CARPET -> Material.WHITE_CARPET;
            case STAINED_GLASS -> Material.WHITE_STAINED_GLASS;
            case STAINED_GLASS_PANE -> Material.WHITE_STAINED_GLASS_PANE;
            case CONCRETE -> Material.WHITE_CONCRETE;
            case TERRACOTTA -> Material.WHITE_TERRACOTTA;
            case GLAZED_TERRACOTTA -> Material.WHITE_GLAZED_TERRACOTTA;
            case SHULKER_BOX -> Material.WHITE_SHULKER_BOX;
            default -> Material.BARRIER;
        };
    }

    public static Material getMaterial(EnergyNetComponentType type) {
        return switch (type) {
            case GENERATOR -> Material.GLOWSTONE;
            case CAPACITOR -> Material.IRON_BLOCK;
            case CONSUMER ->  Material.GOLD_BLOCK;
            case CONNECTOR -> Material.REDSTONE_BLOCK;
            default -> Material.BARRIER;
        };
    }

    public static Material getMaterial(ItemFlowType type) {
        return switch (type) {
            case NONE -> Material.GRAY_STAINED_GLASS_PANE;
            case INSERT -> Material.BLUE_STAINED_GLASS_PANE;
            case WITHDRAW -> Material.ORANGE_STAINED_GLASS_PANE;
            case INSERT_AND_WITHDRAW -> Material.PURPLE_STAINED_GLASS_PANE;
            case FREE_OUTPUT -> Material.GREEN_STAINED_GLASS_PANE;
            default -> Material.BARRIER;
        };
    }
}
