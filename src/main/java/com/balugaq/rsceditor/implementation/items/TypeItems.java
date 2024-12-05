package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.items.BooleanTypeItem;
import com.balugaq.rsceditor.api.items.DoubleTypeItem;
import com.balugaq.rsceditor.api.items.EnergyNetComponentTypeItem;
import com.balugaq.rsceditor.api.objects.types.GroupType;
import com.balugaq.rsceditor.api.items.GroupTypeItem;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.api.items.ItemFlowTypeItem;
import com.balugaq.rsceditor.api.items.LinkedMachineRecipeItem;
import com.balugaq.rsceditor.api.items.MachineRecipeItem;
import com.balugaq.rsceditor.api.items.ProtectionTypeItem;
import com.balugaq.rsceditor.api.items.RadioactivityTypeItem;
import com.balugaq.rsceditor.api.objects.types.RainbowType;
import com.balugaq.rsceditor.api.items.RainbowTypeItem;
import com.balugaq.rsceditor.api.objects.types.SimpleMachineType;
import com.balugaq.rsceditor.api.items.SimpleMachineTypeItem;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.implementation.RSCEditor;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;

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
        booleanTypeItem.register(RSCEditor.getInstance());

        IntegerTypeItem integerTypeItem = new IntegerTypeItem(
                new SlimefunItemStack("RSC_EDITOR_INTEGER_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b整数占位符"
                        )
                )
        );
        integerTypeItem.register(RSCEditor.getInstance());

        DoubleTypeItem doubleTypeItem = new DoubleTypeItem(
                new SlimefunItemStack("RSC_EDITOR_DOUBLE_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b浮点数占位符"
                        )
                )
        );
        doubleTypeItem.register(RSCEditor.getInstance());

        TextTypeItem textTypeItem = new TextTypeItem(
                new SlimefunItemStack("RSC_EDITOR_TEXT_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b文字占位符"
                        )
                )
        );
        textTypeItem.register(RSCEditor.getInstance());

        GroupTypeItem nested = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_NESTED",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eNested"
                        )
                ),
                GroupType.NESTED
        );
        nested.register(RSCEditor.getInstance());

        GroupTypeItem normal = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_NORMAL",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eNormal"
                        )
                ),
                GroupType.NORMAL
        );
        normal.register(RSCEditor.getInstance());

        GroupTypeItem sub = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_SUB",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eSub"
                        )
                ),
                GroupType.SUB
        );
        sub.register(RSCEditor.getInstance());

        GroupTypeItem seasonal = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_SEASONAL",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eSeasonal"
                        )
                ),
                GroupType.SEASONAL
        );
        seasonal.register(RSCEditor.getInstance());

        GroupTypeItem button = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_BUTTON",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eButton"
                        )
                ),
                GroupType.BUTTON
        );
        button.register(RSCEditor.getInstance());

        GroupTypeItem locked = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_LOCKED",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eLocked"
                        )
                ),
                GroupType.LOCKED
        );
        locked.register(RSCEditor.getInstance());

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
        low.register(RSCEditor.getInstance());

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
        moderate.register(RSCEditor.getInstance());

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
        high.register(RSCEditor.getInstance());

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
        veryHigh.register(RSCEditor.getInstance());

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
        veryDeadly.register(RSCEditor.getInstance());

        RainbowTypeItem wool = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_WOOL",
                        new CustomItemStack(
                                Material.WHITE_WOOL,
                                "&b彩虹类型占位符",
                                "&eWool"
                        )
                ),
                RainbowType.WOOL
        );
        wool.register(RSCEditor.getInstance());

        RainbowTypeItem carpet = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CARPET",
                        new CustomItemStack(
                                Material.WHITE_CARPET,
                                "&b彩虹类型占位符",
                                "&eCarpet"
                        )
                ),
                RainbowType.CARPET
        );
        carpet.register(RSCEditor.getInstance());

        RainbowTypeItem stained_glass = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_STAINED_GLASS",
                        new CustomItemStack(
                                Material.WHITE_STAINED_GLASS,
                                "&b彩虹类型占位符",
                                "&eStained Glass"
                        )
                ),
                RainbowType.STAINED_GLASS
        );
        stained_glass.register(RSCEditor.getInstance());

        RainbowTypeItem stained_glass_pane = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_STAINED_GLASS_PANE",
                        new CustomItemStack(
                                Material.WHITE_STAINED_GLASS_PANE,
                                "&b彩虹类型占位符",
                                "&eStained Glass Pane"
                        )
                ),
                RainbowType.STAINED_GLASS_PANE
        );
        stained_glass_pane.register(RSCEditor.getInstance());

        RainbowTypeItem terracotta = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_TERRACOTTA",
                        new CustomItemStack(
                                Material.TERRACOTTA,
                                "&b彩虹类型占位符",
                                "&eTerracotta"
                        )
                ),
                RainbowType.TERRACOTTA
        );
        terracotta.register(RSCEditor.getInstance());

        RainbowTypeItem glazed_terracotta = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_GLAZED_TERRACOTTA",
                        new CustomItemStack(
                                Material.WHITE_GLAZED_TERRACOTTA,
                                "&b彩虹类型占位符",
                                "&eGlazed Terracotta"
                        )
                ),
                RainbowType.GLAZED_TERRACOTTA
        );
        glazed_terracotta.register(RSCEditor.getInstance());


        RainbowTypeItem concrete = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CONCRETE",
                        new CustomItemStack(
                                Material.WHITE_CONCRETE,
                                "&b彩虹类型占位符",
                                "&eConcrete"
                        )
                ),
                RainbowType.CONCRETE
        );
        concrete.register(RSCEditor.getInstance());

        RainbowTypeItem shulker_box = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_SHULKER_BOX",
                        new CustomItemStack(
                                Material.WHITE_SHULKER_BOX,
                                "&b彩虹类型占位符",
                                "&eShulker Box"
                        )
                ),
                RainbowType.SHULKER_BOX
        );
        shulker_box.register(RSCEditor.getInstance());

        RainbowTypeItem custom = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CUSTOM",
                        new CustomItemStack(
                                Material.WHITE_BANNER,
                                "&b彩虹类型占位符",
                                "&eCustom"
                        )
                ),
                RainbowType.CUSTOM
        );
        custom.register(RSCEditor.getInstance());

        ProtectionTypeItem BEES = new ProtectionTypeItem(
                new SlimefunItemStack("RSC_EDITOR_PROTECTION_TYPE_ITEM_BEES",
                        new CustomItemStack(
                                Material.BEEHIVE,
                                "&b保护类型占位符",
                                "&eBees"
                        )
                ),
                ProtectionType.BEES
        );
        BEES.register(RSCEditor.getInstance());

        ProtectionTypeItem RADIATION = new ProtectionTypeItem(
                new SlimefunItemStack("RSC_EDITOR_PROTECTION_TYPE_ITEM_RADIATION",
                        new CustomItemStack(
                                Material.LAVA_BUCKET,
                                "&b保护类型占位符",
                                "&eRadiation"
                        )
                ),
                ProtectionType.RADIATION
        );
        RADIATION.register(RSCEditor.getInstance());

        ProtectionTypeItem FLYING_INTO_WALL = new ProtectionTypeItem(
                new SlimefunItemStack("RSC_EDITOR_PROTECTION_TYPE_ITEM_FLYING_INTO_WALL",
                        new CustomItemStack(
                                Material.FEATHER,
                                "&b保护类型占位符",
                                "&eFlying into Wall"
                        )
                ),
                ProtectionType.FLYING_INTO_WALL
        );
        FLYING_INTO_WALL.register(RSCEditor.getInstance());

        ItemFlowTypeItem none = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_NONE",
                        new CustomItemStack(
                                Material.GRAY_STAINED_GLASS_PANE,
                                "&b物品流向占位符",
                                "&eNone"
                        )
                ),
                ItemFlowType.NONE
        );
        none.register(RSCEditor.getInstance());

        ItemFlowTypeItem insert = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_INSERT",
                        new CustomItemStack(
                                Material.BLUE_STAINED_GLASS_PANE,
                                "&b物品流向占位符",
                                "&eInsert"
                        )
                ),
                ItemFlowType.INSERT
        );
        insert.register(RSCEditor.getInstance());

        ItemFlowTypeItem withdraw = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_WITHDRAW",
                        new CustomItemStack(
                                Material.ORANGE_STAINED_GLASS_PANE,
                                "&b物品流向占位符",
                                "&eWithdraw"
                        )
                ),
                ItemFlowType.WITHDRAW
        );
        withdraw.register(RSCEditor.getInstance());

        ItemFlowTypeItem insert_and_withdraw = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_INSERT_AND_WITHDRAW",
                        new CustomItemStack(
                                Material.PURPLE_STAINED_GLASS_PANE,
                                "&b物品流向占位符",
                                "&eInsert and Withdraw"
                        )
                ),
                ItemFlowType.INSERT_AND_WITHDRAW
        );
        insert_and_withdraw.register(RSCEditor.getInstance());

        ItemFlowTypeItem free_output = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_FREE_OUTPUT",
                        new CustomItemStack(
                                Material.GREEN_STAINED_GLASS_PANE,
                                "&b物品流向占位符",
                                "&eFree Output"
                        )
                ),
                ItemFlowType.FREE_OUTPUT
        );
        free_output.register(RSCEditor.getInstance());

        MachineRecipeItem mri = new MachineRecipeItem(
                new SlimefunItemStack("RSC_EDITOR_MACHINE_RECIPE_ITEM",
                        new CustomItemStack(
                                Material.KNOWLEDGE_BOOK,
                                "&b机器配方占位符"
                        )
                )
        );
        mri.register(RSCEditor.getInstance());

        LinkedMachineRecipeItem lmri = new LinkedMachineRecipeItem(
                new SlimefunItemStack("RSC_EDITOR_LINKED_MACHINE_RECIPE_ITEM",
                        new CustomItemStack(
                                Material.KNOWLEDGE_BOOK,
                                "&b链接机器配方占位符"
                        )
                )
        );
        lmri.register(RSCEditor.getInstance());

        EnergyNetComponentTypeItem capacitor = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_CAPACITOR",
                        new CustomItemStack(
                                Material.IRON_INGOT,
                                "&b能源组件类型占位符",
                                "&eCapacitor"
                        )
                ),
                EnergyNetComponentType.CAPACITOR
        );
        capacitor.register(RSCEditor.getInstance());

        EnergyNetComponentTypeItem connector = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_CONNECTOR",
                        new CustomItemStack(
                                Material.OBSIDIAN,
                                "&b能源组件类型占位符",
                                "&eConnector"
                        )
                ),
                EnergyNetComponentType.CONNECTOR
        );
        connector.register(RSCEditor.getInstance());

        EnergyNetComponentTypeItem consumer = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_CONSUMER",
                        new CustomItemStack(
                                Material.REDSTONE,
                                "&b能源组件类型占位符",
                                "&eConsumer"
                        )
                ),
                EnergyNetComponentType.CONSUMER
        );
        consumer.register(RSCEditor.getInstance());

        EnergyNetComponentTypeItem generator = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_GENERATOR",
                        new CustomItemStack(
                                Material.DIAMOND,
                                "&b能源组件类型占位符",
                                "&eGenerator"
                        )
                ),
                EnergyNetComponentType.GENERATOR
        );
        generator.register(RSCEditor.getInstance());

        EnergyNetComponentTypeItem enct_none = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_NONE",
                        new CustomItemStack(
                                Material.GRAY_STAINED_GLASS_PANE,
                                "&b能源组件类型占位符",
                                "&eNone"
                        )
                ),
                EnergyNetComponentType.NONE
        );
        enct_none.register(RSCEditor.getInstance());

        for (SimpleMachineType type : SimpleMachineType.values()) {
            SimpleMachineTypeItem smti = new SimpleMachineTypeItem(
                    new SlimefunItemStack("RSC_EDITOR_SIMPLE_MACHINE_TYPE_ITEM_" + type.name().toUpperCase(),
                            new CustomItemStack(
                                    Material.HEART_OF_THE_SEA,
                                    "&b简单机器类型占位符",
                                    "&e" + type.name().toUpperCase()
                            )
                    ),
                    type
            );
            smti.register(RSCEditor.getInstance());
        }
    }
}
