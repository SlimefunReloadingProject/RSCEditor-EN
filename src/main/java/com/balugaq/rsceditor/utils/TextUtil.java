package com.balugaq.rsceditor.utils;

import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.api.objects.types.RainbowType;
import com.balugaq.rsceditor.api.objects.types.SimpleMachineType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhanlib.minecraft.LanguageHelper;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class TextUtil {
    public static @NotNull String getName(@NotNull SimpleMachineType type) {
        return switch (type) {
            case ELECTRIC_CRUCIBLE -> "电动坩埚";
            case ELECTRIC_FURNACE -> "电炉";
            case ELECTRIC_GOLD_PAN -> "电动淘金机";
            case ELECTRIC_DUST_WASHER -> "电动洗矿机";
            case ELECTRIC_ORE_GRINDER -> "电动碎矿机";
            case ELECTRIC_INGOT_FACTORY -> "电动铸造机";
            case ELECTRIC_INGOT_PULVERIZER -> "电动打碎机";
            case CHARGING_BENCH -> "充电台";
            case ANIMAL_GROWTH_ACCELERATOR -> "动物生长加速器";
            case TREE_GROWTH_ACCELERATOR -> "树木生长加速器";
            case CROP_GROWTH_ACCELERATOR -> "作物生长加速器";
            case FREEZER -> "冰箱";
            case CARBON_PRESS -> "碳压机";
            case ELECTRIC_PRESS -> "压缩机";
            case ELECTRIC_SMELTERY -> "电动冶炼炉";
            case FOOD_FABRICATOR -> "食品加工机";
            case HEATED_PRESSURE_CHAMBER -> "加热压力舱";
            case AUTO_ENCHANTER -> "自动附魔机";
            case AUTO_DISENCHANTER -> "自动祛魔机";
            case BOOK_BINDER -> "附魔书整合机";
            case AUTO_ANVIL -> "自动铁砧";
            case AUTO_DRIER -> "自动烘干机";
            case AUTO_BREWER -> "自动酿造机";
            case REFINERY -> "炼油机";
            case PRODUCE_COLLECTOR -> "全自动收集机";
            default -> "未知";
        };
    }

    private static boolean langHelperInit = true;
    public static @NotNull String getName(@NotNull Biome biome) {
        String key = biome.translationKey();
        String name = null;
        if (langHelperInit) {
            try {
                name = LanguageHelper.getLangOrNull(key);
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
            case GENERATOR -> "发电机";
            case CAPACITOR -> "电容";
            case CONSUMER -> "用电器";
            case CONNECTOR -> "连接器";
            case NONE -> "无";
            default -> "未知";
        };
    }

    public static @NotNull String getName(@NotNull ItemFlowType type) {
        return switch (type) {
            case NONE -> "无";
            case INSERT -> "输入";
            case WITHDRAW -> "输出";
            case INSERT_AND_WITHDRAW -> "输入且输出";
            case FREE_OUTPUT -> "自由输出";
            default -> "未知";
        };
    }

    public static @NotNull String getName(@NotNull RainbowType type) {
        return switch (type) {
            case WOOL -> "羊毛";
            case CARPET -> "地毯";
            case STAINED_GLASS -> "染色玻璃";
            case STAINED_GLASS_PANE -> "染色玻璃板";
            case TERRACOTTA -> "陶瓦";
            case GLAZED_TERRACOTTA -> "带釉陶瓦";
            case CONCRETE -> "混凝土";
            case SHULKER_BOX -> "潜影盒";
            case CUSTOM -> "自定义";
            default -> "未知";
        };
    }

    // Sound enum is too huge, so we just use the name of the sound.
    public static @NotNull String getName(@NotNull Sound sound) {
        String rawName = sound.name().replace("_", " ").toLowerCase();
        return rawName.substring(0, 1).toUpperCase() + rawName.substring(1);
    }
}
