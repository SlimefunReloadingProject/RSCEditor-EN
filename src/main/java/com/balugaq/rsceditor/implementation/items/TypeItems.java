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
                                "&bBoolean Placeholder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(booleanTypeItem);

        IntegerTypeItem integerTypeItem = new IntegerTypeItem(
                new SlimefunItemStack("RSC_EDITOR_INTEGER_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&bInteger Placeholder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(integerTypeItem);

        DoubleTypeItem doubleTypeItem = new DoubleTypeItem(
                new SlimefunItemStack("RSC_EDITOR_DOUBLE_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&bDouble Placeholder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(doubleTypeItem);

        TextTypeItem textTypeItem = new TextTypeItem(
                new SlimefunItemStack("RSC_EDITOR_TEXT_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&bText Placeholder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(textTypeItem);

        GroupTypeItem nested = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_NESTED",
                        new CustomItemStack(
                                Material.PAPER,
                                "&bGroup Type Placeholder",
                                "&eParent Group"
                        )
                ),
                GroupType.NESTED
        );
        SlimefunItemUtil.registerItem(nested);

        GroupTypeItem normal = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_NORMAL",
                        new CustomItemStack(
                                Material.PAPER,
                                "&bGroup Type Placeholder",
                                "&eNormal Group"
                        )
                ),
                GroupType.NORMAL
        );
        SlimefunItemUtil.registerItem(normal);

        GroupTypeItem sub = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_SUB",
                        new CustomItemStack(
                                Material.PAPER,
                                "&bGroup Type Placeholder",
                                "&eSub Group"
                        )
                ),
                GroupType.SUB
        );
        SlimefunItemUtil.registerItem(sub);

        GroupTypeItem seasonal = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_SEASONAL",
                        new CustomItemStack(
                                Material.PAPER,
                                "&bGroup Type Placeholder",
                                "&eSeasonal Group"
                        )
                ),
                GroupType.SEASONAL
        );
        SlimefunItemUtil.registerItem(seasonal);

        GroupTypeItem button = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_BUTTON",
                        new CustomItemStack(
                                Material.PAPER,
                                "&bGroup Type Placeholder",
                                "&eBrowser Link Button"
                        )
                ),
                GroupType.BUTTON
        );
        SlimefunItemUtil.registerItem(button);

        GroupTypeItem locked = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_LOCKED",
                        new CustomItemStack(
                                Material.PAPER,
                                "&bGroup Type Placeholder",
                                "&eLocked Group"
                        )
                ),
                GroupType.LOCKED
        );
        SlimefunItemUtil.registerItem(locked);

        RadioactivityTypeItem low = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_LOW",
                        new CustomItemStack(
                                Material.PAPER,
                                "&bRadioactivity Placeholder",
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
                                "&bRadioactivity Placeholder",
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
                                "&bRadioactivity Placeholder",
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
                                "&bRadioactivity Placeholder",
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
                                "&bRadioactivity Placeholder",
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
                                "&bRainbow Type Placeholder",
                                "&eWools"
                        )
                ),
                RainbowType.WOOL
        );
        SlimefunItemUtil.registerItem(wool);

        RainbowTypeItem carpet = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CARPET",
                        new CustomItemStack(
                                Material.WHITE_CARPET,
                                "&bRainbow Type Placeholder",
                                "&eCarpets"
                        )
                ),
                RainbowType.CARPET
        );
        SlimefunItemUtil.registerItem(carpet);

        RainbowTypeItem stained_glass = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_STAINED_GLASS",
                        new CustomItemStack(
                                Material.WHITE_STAINED_GLASS,
                                "&bRainbow Type Placeholder",
                                "&eGlass Blocks"
                        )
                ),
                RainbowType.STAINED_GLASS
        );
        SlimefunItemUtil.registerItem(stained_glass);

        RainbowTypeItem stained_glass_pane = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_STAINED_GLASS_PANE",
                        new CustomItemStack(
                                Material.WHITE_STAINED_GLASS_PANE,
                                "&bRainbow Type Placeholder",
                                "&eGlass Panels"
                        )
                ),
                RainbowType.STAINED_GLASS_PANE
        );
        SlimefunItemUtil.registerItem(stained_glass_pane);

        RainbowTypeItem terracotta = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_TERRACOTTA",
                        new CustomItemStack(
                                Material.TERRACOTTA,
                                "&bRainbow Type Placeholder",
                                "&eTerracotta"
                        )
                ),
                RainbowType.TERRACOTTA
        );
        SlimefunItemUtil.registerItem(terracotta);

        RainbowTypeItem glazed_terracotta = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_GLAZED_TERRACOTTA",
                        new CustomItemStack(
                                Material.WHITE_GLAZED_TERRACOTTA,
                                "&bRainbow Type Placeholder",
                                "&eGlazed Terracotta"
                        )
                ),
                RainbowType.GLAZED_TERRACOTTA
        );
        SlimefunItemUtil.registerItem(glazed_terracotta);


        RainbowTypeItem concrete = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CONCRETE",
                        new CustomItemStack(
                                Material.WHITE_CONCRETE,
                                "&bRainbow Type Placeholder",
                                "&eConcrete"
                        )
                ),
                RainbowType.CONCRETE
        );
        SlimefunItemUtil.registerItem(concrete);

        RainbowTypeItem shulker_box = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_SHULKER_BOX",
                        new CustomItemStack(
                                Material.WHITE_SHULKER_BOX,
                                "&bRainbow Type Placeholder",
                                "&eShulker Boxes"
                        )
                ),
                RainbowType.SHULKER_BOX
        );
        SlimefunItemUtil.registerItem(shulker_box);

        RainbowTypeItem custom = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CUSTOM",
                        new CustomItemStack(
                                Material.WHITE_BANNER,
                                "&bRainbow Type Placeholder",
                                "&eCustom"
                        )
                ),
                RainbowType.CUSTOM
        );
        SlimefunItemUtil.registerItem(custom);

        ProtectionTypeItem BEES = new ProtectionTypeItem(
                new SlimefunItemStack("RSC_EDITOR_PROTECTION_TYPE_ITEM_BEES",
                        new CustomItemStack(
                                Material.BEEHIVE,
                                "&bProtection Type Placeholder",
                                "&eBee Protection"
                        )
                ),
                ProtectionType.BEES
        );
        SlimefunItemUtil.registerItem(BEES);

        ProtectionTypeItem RADIATION = new ProtectionTypeItem(
                new SlimefunItemStack("RSC_EDITOR_PROTECTION_TYPE_ITEM_RADIATION",
                        new CustomItemStack(
                                Material.LAVA_BUCKET,
                                "&bProtection Type Placeholder",
                                "&eRadiation Protection"
                        )
                ),
                ProtectionType.RADIATION
        );
        SlimefunItemUtil.registerItem(RADIATION);

        ProtectionTypeItem FLYING_INTO_WALL = new ProtectionTypeItem(
                new SlimefunItemStack("RSC_EDITOR_PROTECTION_TYPE_ITEM_FLYING_INTO_WALL",
                        new CustomItemStack(
                                Material.FEATHER,
                                "&bProtection Type Placeholder",
                                "&eFlying into Wall Protection"
                        )
                ),
                ProtectionType.FLYING_INTO_WALL
        );
        SlimefunItemUtil.registerItem(FLYING_INTO_WALL);

        ItemFlowTypeItem none = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_NONE",
                        new CustomItemStack(
                                Material.GRAY_STAINED_GLASS_PANE,
                                "&bItem Flow Type Placeholder",
                                "&eNone"
                        )
                ),
                ItemFlowType.NONE
        );
        SlimefunItemUtil.registerItem(none);

        ItemFlowTypeItem insert = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_INSERT",
                        new CustomItemStack(
                                Material.BLUE_STAINED_GLASS_PANE,
                                "&bItem Flow Type Placeholder",
                                "&eInput Slots"
                        )
                ),
                ItemFlowType.INSERT
        );
        SlimefunItemUtil.registerItem(insert);

        ItemFlowTypeItem withdraw = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_WITHDRAW",
                        new CustomItemStack(
                                Material.ORANGE_STAINED_GLASS_PANE,
                                "&bItem Flow Type Placeholder",
                                "&eOutput Slots"
                        )
                ),
                ItemFlowType.WITHDRAW
        );
        SlimefunItemUtil.registerItem(withdraw);

        ItemFlowTypeItem insert_and_withdraw = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_INSERT_AND_WITHDRAW",
                        new CustomItemStack(
                                Material.PURPLE_STAINED_GLASS_PANE,
                                "&bItem Flow Type Placeholder",
                                "&eInput and Output Slots"
                        )
                ),
                ItemFlowType.INSERT_AND_WITHDRAW
        );
        SlimefunItemUtil.registerItem(insert_and_withdraw);

        ItemFlowTypeItem free_output = new ItemFlowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ITEM_FLOW_TYPE_ITEM_FREE_OUTPUT",
                        new CustomItemStack(
                                Material.GREEN_STAINED_GLASS_PANE,
                                "&bItem Flow Type Placeholder",
                                "&eFreely Output"
                        )
                ),
                ItemFlowType.FREE_OUTPUT
        );
        SlimefunItemUtil.registerItem(free_output);

        MachineRecipeItem mri = new MachineRecipeItem(
                new SlimefunItemStack("RSC_EDITOR_MACHINE_RECIPE_ITEM",
                        new CustomItemStack(
                                Material.KNOWLEDGE_BOOK,
                                "&bMachine Recipe Placeholder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(mri);

        TemplateMachineRecipeItem tmri = new TemplateMachineRecipeItem(
                new SlimefunItemStack("RSC_EDITOR_TEMPLATE_MACHINE_RECIPE_ITEM",
                        new CustomItemStack(
                                Material.KNOWLEDGE_BOOK,
                                "&bTemplate Machine Recipe Placeholder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(tmri);

        LinkedMachineRecipeItem lmri = new LinkedMachineRecipeItem(
                new SlimefunItemStack("RSC_EDITOR_LINKED_MACHINE_RECIPE_ITEM",
                        new CustomItemStack(
                                Material.KNOWLEDGE_BOOK,
                                "&bLinked Machine Recipe Placeholder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(lmri);

        EnergyNetComponentTypeItem capacitor = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_CAPACITOR",
                        new CustomItemStack(
                                Material.IRON_INGOT,
                                "&bEnergy Component Type Placeholder",
                                "&eCapacitor"
                        )
                ),
                EnergyNetComponentType.CAPACITOR
        );
        SlimefunItemUtil.registerItem(capacitor);

        EnergyNetComponentTypeItem connector = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_CONNECTOR",
                        new CustomItemStack(
                                Material.OBSIDIAN,
                                "&bEnergy Component Type Placeholder",
                                "&eConnector"
                        )
                ),
                EnergyNetComponentType.CONNECTOR
        );
        SlimefunItemUtil.registerItem(connector);

        EnergyNetComponentTypeItem consumer = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_CONSUMER",
                        new CustomItemStack(
                                Material.REDSTONE,
                                "&bEnergy Component Type Placeholder",
                                "&eConsumer"
                        )
                ),
                EnergyNetComponentType.CONSUMER
        );
        SlimefunItemUtil.registerItem(consumer);

        EnergyNetComponentTypeItem generator = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_GENERATOR",
                        new CustomItemStack(
                                Material.DIAMOND,
                                "&bEnergy Component Type Placeholder",
                                "&eGenerator"
                        )
                ),
                EnergyNetComponentType.GENERATOR
        );
        SlimefunItemUtil.registerItem(generator);

        EnergyNetComponentTypeItem enct_none = new EnergyNetComponentTypeItem(
                new SlimefunItemStack("RSC_EDITOR_ENERGY_NET_COMPONENT_TYPE_ITEM_NONE",
                        new CustomItemStack(
                                Material.GRAY_STAINED_GLASS_PANE,
                                "&bEnergy Component Type Placeholder",
                                "&eNone"
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
                                    "&bSimple Machine Type Placeholder",
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
                                "&bItem Registration Placeholder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(registerItem);
    }
}
