package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.items.BooleanTypeItem;
import com.balugaq.rsceditor.api.items.DoubleTypeItem;
import com.balugaq.rsceditor.api.items.EnergyNetComponentTypeItem;
import com.balugaq.rsceditor.api.items.GroupTypeItem;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.items.ItemFlowTypeItem;
import com.balugaq.rsceditor.api.items.LinkedMachineRecipeItem;
import com.balugaq.rsceditor.api.items.MachineRecipeItem;
import com.balugaq.rsceditor.api.items.ProtectionTypeItem;
import com.balugaq.rsceditor.api.items.RadioactivityTypeItem;
import com.balugaq.rsceditor.api.items.RainbowTypeItem;
import com.balugaq.rsceditor.api.items.RegisterItem;
import com.balugaq.rsceditor.api.items.SimpleMachineTypeItem;
import com.balugaq.rsceditor.api.items.TemplateMachineRecipeItem;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.api.objects.types.GroupType;
import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.api.objects.types.RainbowType;
import com.balugaq.rsceditor.api.objects.types.SimpleMachineType;
import com.balugaq.rsceditor.utils.MaterialUtil;
import com.balugaq.rsceditor.utils.SlimefunItemUtil;
import com.balugaq.rsceditor.utils.TextUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;

@UtilityClass
public class TypeItems {
    public static void register() {
        BooleanTypeItem booleanTypeItem = new BooleanTypeItem(
                new SlimefunItemStack("RSC_EDITOR_BOOLEAN_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b布尔占位符"
                        )
                )
        );
        SlimefunItemUtil.registerItem(booleanTypeItem);

        IntegerTypeItem integerTypeItem = new IntegerTypeItem(
                new SlimefunItemStack("RSC_EDITOR_INTEGER_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b整数占位符"
                        )
                )
        );
        SlimefunItemUtil.registerItem(integerTypeItem);

        DoubleTypeItem doubleTypeItem = new DoubleTypeItem(
                new SlimefunItemStack("RSC_EDITOR_DOUBLE_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b浮点数占位符"
                        )
                )
        );
        SlimefunItemUtil.registerItem(doubleTypeItem);

        TextTypeItem textTypeItem = new TextTypeItem(
                new SlimefunItemStack("RSC_EDITOR_TEXT_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b文字占位符"
                        )
                )
        );
        SlimefunItemUtil.registerItem(textTypeItem);

        GroupTypeItem nested = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_NESTED",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&e父物品组"
                        )
                ),
                GroupType.NESTED
        );
        SlimefunItemUtil.registerItem(nested);

        GroupTypeItem normal = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_NORMAL",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&e正常物品组"
                        )
                ),
                GroupType.NORMAL
        );
        SlimefunItemUtil.registerItem(normal);

        GroupTypeItem sub = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_SUB",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&e子物品组"
                        )
                ),
                GroupType.SUB
        );
        SlimefunItemUtil.registerItem(sub);

        GroupTypeItem seasonal = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_SEASONAL",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&e季节性物品组"
                        )
                ),
                GroupType.SEASONAL
        );
        SlimefunItemUtil.registerItem(seasonal);

        GroupTypeItem button = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_BUTTON",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&e链接物品组"
                        )
                ),
                GroupType.BUTTON
        );
        SlimefunItemUtil.registerItem(button);

        GroupTypeItem locked = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_LOCKED",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&e锁定物品组"
                        )
                ),
                GroupType.LOCKED
        );
        SlimefunItemUtil.registerItem(locked);

        RadioactivityTypeItem low = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_LOW",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b辐射占位符",
                                Radioactivity.LOW.getLore()
                        )
                ),
                Radioactivity.LOW
        );
        SlimefunItemUtil.registerItem(low);

        RadioactivityTypeItem moderate = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_MODERATE",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b辐射占位符",
                                Radioactivity.MODERATE.getLore()
                        )
                ),
                Radioactivity.MODERATE
        );
        SlimefunItemUtil.registerItem(moderate);

        RadioactivityTypeItem high = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_HIGH",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b辐射占位符",
                                Radioactivity.HIGH.getLore()
                        )
                ),
                Radioactivity.HIGH
        );
        SlimefunItemUtil.registerItem(high);

        RadioactivityTypeItem veryHigh = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_VERY_HIGH",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b辐射占位符",
                                Radioactivity.VERY_HIGH.getLore()
                        )
                ),
                Radioactivity.VERY_HIGH
        );
        SlimefunItemUtil.registerItem(veryHigh);

        RadioactivityTypeItem veryDeadly = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_VERY_DEADLY",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b辐射占位符",
                                Radioactivity.VERY_DEADLY.getLore()
                        )
                ),
                Radioactivity.VERY_DEADLY
        );
        SlimefunItemUtil.registerItem(veryDeadly);

        RainbowTypeItem wool = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_WOOL",
                        new CustomItemStack(
                                Material.WHITE_WOOL,
                                "&b彩虹类型占位符",
                                "&e羊毛"
                        )
                ),
                RainbowType.WOOL
        );
        SlimefunItemUtil.registerItem(wool);

        RainbowTypeItem carpet = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CARPET",
                        new CustomItemStack(
                                Material.WHITE_CARPET,
                                "&b彩虹类型占位符",
                                "&e地毯"
                        )
                ),
                RainbowType.CARPET
        );
        SlimefunItemUtil.registerItem(carpet);

        RainbowTypeItem stained_glass = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_STAINED_GLASS",
                        new CustomItemStack(
                                Material.WHITE_STAINED_GLASS,
                                "&b彩虹类型占位符",
                                "&e玻璃"
                        )
                ),
                RainbowType.STAINED_GLASS
        );
        SlimefunItemUtil.registerItem(stained_glass);

        RainbowTypeItem stained_glass_pane = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_STAINED_GLASS_PANE",
                        new CustomItemStack(
                                Material.WHITE_STAINED_GLASS_PANE,
                                "&b彩虹类型占位符",
                                "&e玻璃板"
                        )
                ),
                RainbowType.STAINED_GLASS_PANE
        );
        SlimefunItemUtil.registerItem(stained_glass_pane);

        RainbowTypeItem terracotta = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_TERRACOTTA",
                        new CustomItemStack(
                                Material.TERRACOTTA,
                                "&b彩虹类型占位符",
                                "&e陶瓦"
                        )
                ),
                RainbowType.TERRACOTTA
        );
        SlimefunItemUtil.registerItem(terracotta);

        RainbowTypeItem glazed_terracotta = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_GLAZED_TERRACOTTA",
                        new CustomItemStack(
                                Material.WHITE_GLAZED_TERRACOTTA,
                                "&b彩虹类型占位符",
                                "&e带釉陶瓦"
                        )
                ),
                RainbowType.GLAZED_TERRACOTTA
        );
        SlimefunItemUtil.registerItem(glazed_terracotta);


        RainbowTypeItem concrete = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CONCRETE",
                        new CustomItemStack(
                                Material.WHITE_CONCRETE,
                                "&b彩虹类型占位符",
                                "&e混凝土"
                        )
                ),
                RainbowType.CONCRETE
        );
        SlimefunItemUtil.registerItem(concrete);

        RainbowTypeItem shulker_box = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_SHULKER_BOX",
                        new CustomItemStack(
                                Material.WHITE_SHULKER_BOX,
                                "&b彩虹类型占位符",
                                "&e潜影盒"
                        )
                ),
                RainbowType.SHULKER_BOX
        );
        SlimefunItemUtil.registerItem(shulker_box);

        RainbowTypeItem custom = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CUSTOM",
                        new CustomItemStack(
                                Material.WHITE_BANNER,
                                "&b彩虹类型占位符",
                                "&e自定义"
                        )
                ),
                RainbowType.CUSTOM
        );
        SlimefunItemUtil.registerItem(custom);

        ProtectionTypeItem BEES = new ProtectionTypeItem(
                new SlimefunItemStack("RSC_EDITOR_PROTECTION_TYPE_ITEM_BEES",
                        new CustomItemStack(
                                Material.BEEHIVE,
                                "&b保护类型占位符",
                                "&e蜜蜂毒针保护"
                        )
                ),
                ProtectionType.BEES
        );
        SlimefunItemUtil.registerItem(BEES);

        ProtectionTypeItem RADIATION = new ProtectionTypeItem(
                new SlimefunItemStack("RSC_EDITOR_PROTECTION_TYPE_ITEM_RADIATION",
                        new CustomItemStack(
                                Material.LAVA_BUCKET,
                                "&b保护类型占位符",
                                "&e抗辐射"
                        )
                ),
                ProtectionType.RADIATION
        );
        SlimefunItemUtil.registerItem(RADIATION);

        ProtectionTypeItem FLYING_INTO_WALL = new ProtectionTypeItem(
                new SlimefunItemStack("RSC_EDITOR_PROTECTION_TYPE_ITEM_FLYING_INTO_WALL",
                        new CustomItemStack(
                                Material.FEATHER,
                                "&b保护类型占位符",
                                "&e鞘翅动能免疫"
                        )
                ),
                ProtectionType.FLYING_INTO_WALL
        );
        SlimefunItemUtil.registerItem(FLYING_INTO_WALL);

        ItemFlowTypeItem none = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_NONE",
                        new CustomItemStack(
                                Material.GRAY_STAINED_GLASS_PANE,
                                "&b物品流向占位符",
                                "&e无"
                        )
                ),
                ItemFlowType.NONE
        );
        SlimefunItemUtil.registerItem(none);

        ItemFlowTypeItem insert = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_INSERT",
                        new CustomItemStack(
                                Material.BLUE_STAINED_GLASS_PANE,
                                "&b物品流向占位符",
                                "&e输入槽"
                        )
                ),
                ItemFlowType.INSERT
        );
        SlimefunItemUtil.registerItem(insert);

        ItemFlowTypeItem withdraw = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_WITHDRAW",
                        new CustomItemStack(
                                Material.ORANGE_STAINED_GLASS_PANE,
                                "&b物品流向占位符",
                                "&e输出槽"
                        )
                ),
                ItemFlowType.WITHDRAW
        );
        SlimefunItemUtil.registerItem(withdraw);

        ItemFlowTypeItem insert_and_withdraw = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_INSERT_AND_WITHDRAW",
                        new CustomItemStack(
                                Material.PURPLE_STAINED_GLASS_PANE,
                                "&b物品流向占位符",
                                "&e输入且输出"
                        )
                ),
                ItemFlowType.INSERT_AND_WITHDRAW
        );
        SlimefunItemUtil.registerItem(insert_and_withdraw);

        ItemFlowTypeItem free_output = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_FREE_OUTPUT",
                        new CustomItemStack(
                                Material.GREEN_STAINED_GLASS_PANE,
                                "&b物品流向占位符",
                                "&e自由输出"
                        )
                ),
                ItemFlowType.FREE_OUTPUT
        );
        SlimefunItemUtil.registerItem(free_output);

        MachineRecipeItem mri = new MachineRecipeItem(
                new SlimefunItemStack("RSC_EDITOR_MACHINE_RECIPE_ITEM",
                        new CustomItemStack(
                                Material.KNOWLEDGE_BOOK,
                                "&b机器配方占位符"
                        )
                )
        );
        SlimefunItemUtil.registerItem(mri);

        TemplateMachineRecipeItem tmri = new TemplateMachineRecipeItem(
                new SlimefunItemStack("RSC_EDITOR_TEMPLATE_MACHINE_RECIPE_ITEM",
                        new CustomItemStack(
                                Material.KNOWLEDGE_BOOK,
                                "&b模板机器配方占位符"
                        )
                )
        );
        SlimefunItemUtil.registerItem(tmri);

        LinkedMachineRecipeItem lmri = new LinkedMachineRecipeItem(
                new SlimefunItemStack("RSC_EDITOR_LINKED_MACHINE_RECIPE_ITEM",
                        new CustomItemStack(
                                Material.KNOWLEDGE_BOOK,
                                "&b链接机器配方占位符"
                        )
                )
        );
        SlimefunItemUtil.registerItem(lmri);

        EnergyNetComponentTypeItem capacitor = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_CAPACITOR",
                        new CustomItemStack(
                                Material.IRON_INGOT,
                                "&b能源组件类型占位符",
                                "&e电容"
                        )
                ),
                EnergyNetComponentType.CAPACITOR
        );
        SlimefunItemUtil.registerItem(capacitor);

        EnergyNetComponentTypeItem connector = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_CONNECTOR",
                        new CustomItemStack(
                                Material.OBSIDIAN,
                                "&b能源组件类型占位符",
                                "&e连接器"
                        )
                ),
                EnergyNetComponentType.CONNECTOR
        );
        SlimefunItemUtil.registerItem(connector);

        EnergyNetComponentTypeItem consumer = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_CONSUMER",
                        new CustomItemStack(
                                Material.REDSTONE,
                                "&b能源组件类型占位符",
                                "&e用电器"
                        )
                ),
                EnergyNetComponentType.CONSUMER
        );
        SlimefunItemUtil.registerItem(consumer);

        EnergyNetComponentTypeItem generator = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_GENERATOR",
                        new CustomItemStack(
                                Material.DIAMOND,
                                "&b能源组件类型占位符",
                                "&e发电机"
                        )
                ),
                EnergyNetComponentType.GENERATOR
        );
        SlimefunItemUtil.registerItem(generator);

        EnergyNetComponentTypeItem enct_none = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_NONE",
                        new CustomItemStack(
                                Material.GRAY_STAINED_GLASS_PANE,
                                "&b能源组件类型占位符",
                                "&e无"
                        )
                ),
                EnergyNetComponentType.NONE
        );
        SlimefunItemUtil.registerItem(enct_none);

        for (SimpleMachineType type : SimpleMachineType.values()) {
            SimpleMachineTypeItem smti = new SimpleMachineTypeItem(
                    new SlimefunItemStack("RSC_EDITOR_SIMPLE_MACHINE_TYPE_ITEM_" + type.name().toUpperCase(),
                            new CustomItemStack(
                                    MaterialUtil.getMaterial(type),
                                    "&b简单机器类型占位符",
                                    "&e" + type.name().toUpperCase(),
                                    "&e" + TextUtil.getName(type)
                            )
                    ),
                    type
            );
            SlimefunItemUtil.registerItem(smti);
        }

        RegisterItem registerItem = new RegisterItem(
                new SlimefunItemStack("RSC_EDITOR_REGISTER_ITEM",
                        new CustomItemStack(
                                Material.REDSTONE,
                                "&b注册物品占位符"
                        )
                )
        );
        SlimefunItemUtil.registerItem(registerItem);
    }
}
