package com.balugaq.rsceditor.utils;

import com.balugaq.rsceditor.api.BiomeItem;
import com.balugaq.rsceditor.api.BooleanTypeItem;
import com.balugaq.rsceditor.api.DoubleTypeItem;
import com.balugaq.rsceditor.api.GroupType;
import com.balugaq.rsceditor.api.GroupTypeItem;
import com.balugaq.rsceditor.api.IntegerTypeItem;
import com.balugaq.rsceditor.api.ItemGroupItem;
import com.balugaq.rsceditor.api.MenuMatrix;
import com.balugaq.rsceditor.api.RadioactivityTypeItem;
import com.balugaq.rsceditor.api.RecipeTypeItem;
import com.balugaq.rsceditor.api.TextTypeItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ItemUtil {
    public static @NotNull Pair<Boolean, Integer> isInteger(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        ItemStack item = menu.getItemInSlot(matrix.getChar(label));
        if (SlimefunItem.getByItem(item) instanceof IntegerTypeItem typeItem) {
            return new Pair<>(true, typeItem.getContent(item));
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, List<Integer>> isIntegers(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        List<Integer> integers = new ArrayList<>();
        for (int slot : matrix.getChars(label)) {
            ItemStack item = menu.getItemInSlot(slot);
            if (SlimefunItem.getByItem(item) instanceof IntegerTypeItem typeItem) {
                integers.add(typeItem.getContent(item));
            }
        }
        if (!integers.isEmpty()) {
            return new Pair<>(true, integers);
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, Double> isDouble(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        ItemStack item = menu.getItemInSlot(matrix.getChar(label));
        if (SlimefunItem.getByItem(item) instanceof DoubleTypeItem typeItem) {
            return new Pair<>(true, typeItem.getContent(item));
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, List<Double>> isDoubles(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        List<Double> doubles = new ArrayList<>();
        for (int slot : matrix.getChars(label)) {
            ItemStack item = menu.getItemInSlot(slot);
            if (SlimefunItem.getByItem(item) instanceof DoubleTypeItem typeItem) {
                doubles.add(typeItem.getContent(item));
            }
        }
        if (!doubles.isEmpty()) {
            return new Pair<>(true, doubles);
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, Boolean> isBoolean(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        ItemStack item = menu.getItemInSlot(matrix.getChar(label));
        if (SlimefunItem.getByItem(item) instanceof BooleanTypeItem typeItem) {
            return new Pair<>(true, typeItem.getContent(item));
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, List<Boolean>> isBooleans(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        List<Boolean> booleans = new ArrayList<>();
        for (int slot : matrix.getChars(label)) {
            ItemStack item = menu.getItemInSlot(slot);
            if (SlimefunItem.getByItem(item) instanceof BooleanTypeItem typeItem) {
                booleans.add(typeItem.getContent(item));
            }
        }
        if (!booleans.isEmpty()) {
            return new Pair<>(true, booleans);
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, String> isString(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        ItemStack item = menu.getItemInSlot(matrix.getChar(label));
        if (SlimefunItem.getByItem(item) instanceof TextTypeItem typeItem) {
            return new Pair<>(true, typeItem.getContent(item));
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, List<String>> isStrings(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        List<String> strings = new ArrayList<>();
        for (int slot : matrix.getChars(label)) {
            ItemStack item = menu.getItemInSlot(slot);
            if (SlimefunItem.getByItem(item) instanceof TextTypeItem typeItem) {
                strings.add(typeItem.getContent(item));
            }
        }
        if (!strings.isEmpty()) {
            return new Pair<>(true, strings);
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, ItemStack> isItem(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        ItemStack item = menu.getItemInSlot(matrix.getChar(label));
        if (item != null) {
            return new Pair<>(true, item.clone());
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, List<ItemStack>> isItems(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        List<ItemStack> items = new ArrayList<>();
        for (int slot : matrix.getChars(label)) {
            ItemStack item = menu.getItemInSlot(slot);
            if (item != null) {
                items.add(item.clone());
            } else {
                items.add(null);
            }
        }

        return new Pair<>(!items.isEmpty(), items);
    }

    public static @NotNull Pair<Boolean, GroupType> isGroupType(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        if (SlimefunItem.getByItem(menu.getItemInSlot(matrix.getChar(label))) instanceof GroupTypeItem groupTypeItem) {
            return new Pair<>(true, groupTypeItem.getType());
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, ItemGroup> isItemGroupItem(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        if (SlimefunItem.getByItem(menu.getItemInSlot(matrix.getChar(label))) instanceof ItemGroupItem itemGroupItem) {
            return new Pair<>(true, itemGroupItem.getItemGroup());
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, List<ItemGroup>> isItemGroupItems(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        List<ItemGroup> itemGroups = new ArrayList<>();
        for (int slot : matrix.getChars(label)) {
            if (SlimefunItem.getByItem(menu.getItemInSlot(slot)) instanceof ItemGroupItem itemGroupItem) {
                itemGroups.add(itemGroupItem.getItemGroup());
            }
        }

        if (!itemGroups.isEmpty()) {
            return new Pair<>(true, itemGroups);
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, Biome> isBiome(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        ItemStack item = menu.getItemInSlot(matrix.getChar(label));
        if (SlimefunItem.getByItem(item) instanceof BiomeItem typeItem) {
            return new Pair<>(true, typeItem.getBiome());
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, List<Biome>> isBiomes(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        List<Biome> biomes = new ArrayList<>();
        for (int slot : matrix.getChars(label)) {
            ItemStack item = menu.getItemInSlot(slot);
            if (SlimefunItem.getByItem(item) instanceof BiomeItem typeItem) {
                biomes.add(typeItem.getBiome());
            }
        }
        if (!biomes.isEmpty()) {
            return new Pair<>(true, biomes);
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, RecipeType> isRecipeTypeItem(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        if (SlimefunItem.getByItem(menu.getItemInSlot(matrix.getChar(label))) instanceof RecipeTypeItem recipeTypeItem) {
            return new Pair<>(true, recipeTypeItem.getRecipeType());
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, List<RecipeType>> isRecipeTypeItems(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        List<RecipeType> recipeTypes = new ArrayList<>();
        for (int slot : matrix.getChars(label)) {
            if (SlimefunItem.getByItem(menu.getItemInSlot(slot)) instanceof RecipeTypeItem recipeTypeItem) {
                recipeTypes.add(recipeTypeItem.getRecipeType());
            }
        }

        if (!recipeTypes.isEmpty()) {
            return new Pair<>(true, recipeTypes);
        } else {
            return new Pair<>(false, null);
        }
    }

    public static @NotNull Pair<Boolean, Radioactivity> isRadioactivity(@NotNull BlockMenu menu, @NotNull MenuMatrix matrix, @NotNull String label) {
        ItemStack item = menu.getItemInSlot(matrix.getChar(label));
        if (SlimefunItem.getByItem(item) instanceof RadioactivityTypeItem typeItem) {
            return new Pair<>(true, typeItem.getRadioactivity());
        } else {
            return new Pair<>(false, null);
        }
    }
}
