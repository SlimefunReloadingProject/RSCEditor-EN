package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.implementation.RSCEditor;
import com.balugaq.rsceditor.implementation.items.machines.ArmorEditor;
import com.balugaq.rsceditor.implementation.items.machines.CapacitorEditor;
import com.balugaq.rsceditor.implementation.items.machines.FoodEditor;
import com.balugaq.rsceditor.implementation.items.machines.GEOResourceEditor;
import com.balugaq.rsceditor.implementation.items.machines.GeneratorEditor;
import com.balugaq.rsceditor.implementation.items.machines.ItemEditor;
import com.balugaq.rsceditor.implementation.items.machines.ItemGroupEditor;
import com.balugaq.rsceditor.implementation.items.machines.MachineEditor;
import com.balugaq.rsceditor.implementation.items.machines.MaterialGeneratorEditor;
import com.balugaq.rsceditor.implementation.items.machines.MobDropEditor;
import com.balugaq.rsceditor.implementation.items.machines.RecipeMachineEditor;
import com.balugaq.rsceditor.implementation.items.machines.RecipeTypeEditor;
import com.balugaq.rsceditor.implementation.items.machines.SimpleMachineEditor;
import com.balugaq.rsceditor.implementation.items.machines.SolarGeneratorEditor;
import com.balugaq.rsceditor.implementation.items.machines.builder.LinkedMachineRecipeBuilder;
import com.balugaq.rsceditor.implementation.items.machines.builder.MachineRecipeBuilder;
import com.balugaq.rsceditor.implementation.items.machines.container.ArmorPieceContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.CustomRainbowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.ItemFlowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.MenuContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.SupplyContainer;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;

public class MachineSetup {
    public static void register() {
        // containers
        ArmorPieceContainer armorPieceContainer = new ArmorPieceContainer(
                new SlimefunItemStack(
                        "RSC_EDITOR_ARMOR_PIECE_CONTAINER",
                        new CustomItemStack(
                                Material.IRON_BLOCK,
                                "§b装备部分容器"
                        )
                )
        );
        armorPieceContainer.register(RSCEditor.getInstance());

        CustomRainbowContainer customRainbowContainer = new CustomRainbowContainer(
                new SlimefunItemStack(
                        "RSC_EDITOR_CUSTOM_RAINBOW_CONTAINER",
                        new CustomItemStack(
                                Material.ORANGE_WOOL,
                                "§b自定义彩虹物品容器"
                        )
                )
        );
        customRainbowContainer.register(RSCEditor.getInstance());

        SupplyContainer supplyContainer = new SupplyContainer(
                new SlimefunItemStack(
                        "RSC_EDITOR_SUPPLY_CONTAINER",
                        new CustomItemStack(
                                Material.MOSS_BLOCK,
                                "§bGEO供应容器"
                        )
                )
        );
        supplyContainer.register(RSCEditor.getInstance());

        ItemFlowContainer itemFlowContainer = new ItemFlowContainer(
                new SlimefunItemStack(
                        "RSC_EDITOR_ITEM_FLOW_CONTAINER",
                        new CustomItemStack(
                                Material.IRON_BARS,
                                "§b物品流容器"
                        )
                )
        );
        itemFlowContainer.register(RSCEditor.getInstance());

        MenuContainer menuContainer = new MenuContainer(
                new SlimefunItemStack(
                        "RSC_EDITOR_MENU_CONTAINER",
                        new CustomItemStack(
                                Material.BOOKSHELF,
                                "§b菜单容器"
                        )
                )
        );
        menuContainer.register(RSCEditor.getInstance());

        // builders
        MachineRecipeBuilder machineRecipeBuilder = new MachineRecipeBuilder(
                new SlimefunItemStack(
                        "RSC_EDITOR_MACHINE_RECIPE_BUILDER",
                        new CustomItemStack(
                                Material.LOOM,
                                "§b机器配方构造器"
                        )
                )
        );
        machineRecipeBuilder.register(RSCEditor.getInstance());

        LinkedMachineRecipeBuilder linkedMachineRecipeBuilder = new LinkedMachineRecipeBuilder(
                new SlimefunItemStack(
                        "RSC_EDITOR_LINKED_MACHINE_RECIPE_BUILDER",
                        new CustomItemStack(
                                Material.LOOM,
                                "§b链接机器配方构造器"
                        )
                )
        );
        linkedMachineRecipeBuilder.register(RSCEditor.getInstance());

        // editors
        ItemGroupEditor itemGroupEditor = new ItemGroupEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_ITEM_GROUP_EDITOR",
                        new CustomItemStack(
                                Material.FLETCHING_TABLE,
                                "§b物品组构造器"
                        )
                )
        );
        itemGroupEditor.register(RSCEditor.getInstance());

        RecipeTypeEditor recipeTypeEditor = new RecipeTypeEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_RECIPE_TYPE_EDITOR",
                        new CustomItemStack(
                                Material.CARTOGRAPHY_TABLE,
                                "§b配方类型构造器"
                        )
                )
        );
        recipeTypeEditor.register(RSCEditor.getInstance());

        GEOResourceEditor geoResourceEditor = new GEOResourceEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_GEO_RESOURCE_EDITOR",
                        new CustomItemStack(
                                Material.SHROOMLIGHT,
                                "§b自然资源构造器"
                        )
                )
        );
        geoResourceEditor.register(RSCEditor.getInstance());

        MobDropEditor mobDropEditor = new MobDropEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_MOB_DROP_EDITOR",
                        new CustomItemStack(
                                Material.SPAWNER,
                                "§b生物掉落构造器"
                        )
                )
        );
        mobDropEditor.register(RSCEditor.getInstance());

        ItemEditor itemEditor = new ItemEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_ITEM_EDITOR",
                        new CustomItemStack(
                                Material.SLIME_BLOCK,
                                "§b物品构造器"
                        )
                )
        );
        itemEditor.register(RSCEditor.getInstance());

        ArmorEditor armorEditor = new ArmorEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_ARMOR_EDITOR",
                        new CustomItemStack(
                                Material.GOLD_BLOCK,
                                "§b装备构造器"
                        )
                )
        );
        armorEditor.register(RSCEditor.getInstance());

        CapacitorEditor capacitorEditor = new CapacitorEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_CAPACITOR_EDITOR",
                        new CustomItemStack(
                                Material.REDSTONE_BLOCK,
                                "§b电容构造器"
                        )
                )
        );
        capacitorEditor.register(RSCEditor.getInstance());

        FoodEditor foodEditor = new FoodEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_FOOD_EDITOR",
                        new CustomItemStack(
                                Material.HAY_BLOCK,
                                "§b食物构造器"
                        )
                )
        );
        foodEditor.register(RSCEditor.getInstance());

        MachineEditor machineEditor = new MachineEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_MACHINE_EDITOR",
                        new CustomItemStack(
                                Material.BLAST_FURNACE,
                                "§b机器构造器"
                        )
                )
        );
        machineEditor.register(RSCEditor.getInstance());

        GeneratorEditor generatorEditor = new GeneratorEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_GENERATOR_EDITOR",
                        new CustomItemStack(
                                Material.GLOWSTONE,
                                "§b发电机构造器"
                        )
                )
        );
        generatorEditor.register(RSCEditor.getInstance());

        SolarGeneratorEditor solarGeneratorEditor = new SolarGeneratorEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_SOLAR_GENERATOR_EDITOR",
                        new CustomItemStack(
                                Material.SHROOMLIGHT,
                                "§b太阳能发电机构造器"
                        )
                )
        );
        solarGeneratorEditor.register(RSCEditor.getInstance());

        MaterialGeneratorEditor materialGeneratorEditor = new MaterialGeneratorEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_MATERIAL_GENERATOR_EDITOR",
                        new CustomItemStack(
                                Material.DIAMOND_BLOCK,
                                "§b材料生成器构造器"
                        )
                )
        );
        materialGeneratorEditor.register(RSCEditor.getInstance());

        RecipeMachineEditor recipeMachineEditor = new RecipeMachineEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_RECIPE_MACHINE_EDITOR",
                        new CustomItemStack(
                                Material.FURNACE,
                                "§b配方机器构造器"
                        )
                )
        );
        recipeMachineEditor.register(RSCEditor.getInstance());

        SimpleMachineEditor simpleMachineEditor = new SimpleMachineEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_SIMPLE_MACHINE_EDITOR",
                        new CustomItemStack(
                                Material.SMOKER,
                                "§b简单机器构造器"
                        )
                )
        );
        simpleMachineEditor.register(RSCEditor.getInstance());
    }
}
