package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.implementation.items.machines.ArmorEditor;
import com.balugaq.rsceditor.implementation.items.machines.CapacitorEditor;
import com.balugaq.rsceditor.implementation.items.machines.FoodEditor;
import com.balugaq.rsceditor.implementation.items.machines.GEOResourceEditor;
import com.balugaq.rsceditor.implementation.items.machines.GeneratorEditor;
import com.balugaq.rsceditor.implementation.items.machines.ItemEditor;
import com.balugaq.rsceditor.implementation.items.machines.ItemGroupEditor;
import com.balugaq.rsceditor.implementation.items.machines.LinkedRecipeMachineEditor;
import com.balugaq.rsceditor.implementation.items.machines.MachineEditor;
import com.balugaq.rsceditor.implementation.items.machines.MaterialGeneratorEditor;
import com.balugaq.rsceditor.implementation.items.machines.MobDropEditor;
import com.balugaq.rsceditor.implementation.items.machines.MultiBlockEditor;
import com.balugaq.rsceditor.implementation.items.machines.RecipeMachineEditor;
import com.balugaq.rsceditor.implementation.items.machines.RecipeTypeEditor;
import com.balugaq.rsceditor.implementation.items.machines.ResearchEditor;
import com.balugaq.rsceditor.implementation.items.machines.SimpleMachineEditor;
import com.balugaq.rsceditor.implementation.items.machines.SolarGeneratorEditor;
import com.balugaq.rsceditor.implementation.items.machines.TemplateRecipeMachineEditor;
import com.balugaq.rsceditor.implementation.items.machines.WorkbenchEditor;
import com.balugaq.rsceditor.implementation.items.machines.builder.LinkedMachineRecipeBuilder;
import com.balugaq.rsceditor.implementation.items.machines.builder.MachineRecipeBuilder;
import com.balugaq.rsceditor.implementation.items.machines.builder.MultiBlockRecipeBuilder;
import com.balugaq.rsceditor.implementation.items.machines.builder.RegisterBuilder;
import com.balugaq.rsceditor.implementation.items.machines.builder.TemplateMachineRecipeBuilder;
import com.balugaq.rsceditor.implementation.items.machines.container.ArmorPieceContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.CustomRainbowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.EmptyContainer1x9;
import com.balugaq.rsceditor.implementation.items.machines.container.EmptyContainer2x9;
import com.balugaq.rsceditor.implementation.items.machines.container.EmptyContainer3x9;
import com.balugaq.rsceditor.implementation.items.machines.container.EmptyContainer4x9;
import com.balugaq.rsceditor.implementation.items.machines.container.EmptyContainer5x9;
import com.balugaq.rsceditor.implementation.items.machines.container.EmptyContainer6x9;
import com.balugaq.rsceditor.implementation.items.machines.container.ItemFlowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.MenuContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.SupplyContainer;
import com.balugaq.rsceditor.utils.SlimefunItemUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;

@UtilityClass
public class MachineSetup {
    public static void register() {
        // containers
        EmptyContainer1x9 emptyContainer1x9 = new EmptyContainer1x9(
                new SlimefunItemStack(
                        "RSC_EDITOR_EMPTY_CONTAINER_1X9",
                        new CustomItemStack(
                                Material.RED_STAINED_GLASS,
                                "&bEmpty Container 1x9"
                        )
                )
        );
        SlimefunItemUtil.registerItem(emptyContainer1x9);

        EmptyContainer2x9 emptyContainer2x9 = new EmptyContainer2x9(
                new SlimefunItemStack(
                        "RSC_EDITOR_EMPTY_CONTAINER_2X9",
                        new CustomItemStack(
                                Material.BLUE_STAINED_GLASS,
                                "&bEmpty Container 2x9"
                        )
                )
        );
        SlimefunItemUtil.registerItem(emptyContainer2x9);

        EmptyContainer3x9 emptyContainer3x9 = new EmptyContainer3x9(
                new SlimefunItemStack(
                        "RSC_EDITOR_EMPTY_CONTAINER_3X9",
                        new CustomItemStack(
                                Material.YELLOW_STAINED_GLASS,
                                "&bEmpty Container 3x9"
                        )
                )
        );
        SlimefunItemUtil.registerItem(emptyContainer3x9);

        EmptyContainer4x9 emptyContainer4x9 = new EmptyContainer4x9(
                new SlimefunItemStack(
                        "RSC_EDITOR_EMPTY_CONTAINER_4X9",
                        new CustomItemStack(
                                Material.PINK_STAINED_GLASS,
                                "&bEmpty Container 4x9"
                        )
                )
        );
        SlimefunItemUtil.registerItem(emptyContainer4x9);

        EmptyContainer5x9 emptyContainer5x9 = new EmptyContainer5x9(
                new SlimefunItemStack(
                        "RSC_EDITOR_EMPTY_CONTAINER_5X9",
                        new CustomItemStack(
                                Material.GREEN_STAINED_GLASS,
                                "&bEmpty Container 5x9"
                        )
                )
        );
        SlimefunItemUtil.registerItem(emptyContainer5x9);

        EmptyContainer6x9 emptyContainer6x9 = new EmptyContainer6x9(
                new SlimefunItemStack(
                        "RSC_EDITOR_EMPTY_CONTAINER_6X9",
                        new CustomItemStack(
                                Material.LIME_STAINED_GLASS,
                                "&bEmpty Container 6x9"
                        )
                )
        );
        SlimefunItemUtil.registerItem(emptyContainer6x9);

        ArmorPieceContainer armorPieceContainer = new ArmorPieceContainer(
                new SlimefunItemStack(
                        "RSC_EDITOR_ARMOR_PIECE_CONTAINER",
                        new CustomItemStack(
                                Material.IRON_BLOCK,
                                "&bArmor Piece Container"
                        )
                )
        );
        SlimefunItemUtil.registerItem(armorPieceContainer);

        CustomRainbowContainer customRainbowContainer = new CustomRainbowContainer(
                new SlimefunItemStack(
                        "RSC_EDITOR_CUSTOM_RAINBOW_CONTAINER",
                        new CustomItemStack(
                                Material.ORANGE_WOOL,
                                "&bCustom Rainbow Item Container"
                        )
                )
        );
        SlimefunItemUtil.registerItem(customRainbowContainer);

        SupplyContainer supplyContainer = new SupplyContainer(
                new SlimefunItemStack(
                        "RSC_EDITOR_SUPPLY_CONTAINER",
                        new CustomItemStack(
                                Material.MOSS_BLOCK,
                                "&bGEO Supply Container"
                        )
                )
        );
        SlimefunItemUtil.registerItem(supplyContainer);

        ItemFlowContainer itemFlowContainer = new ItemFlowContainer(
                new SlimefunItemStack(
                        "RSC_EDITOR_ITEM_FLOW_CONTAINER",
                        new CustomItemStack(
                                Material.LODESTONE,
                                "&bItem Flow Container"
                        )
                )
        );
        SlimefunItemUtil.registerItem(itemFlowContainer);

        MenuContainer menuContainer = new MenuContainer(
                new SlimefunItemStack(
                        "RSC_EDITOR_MENU_CONTAINER",
                        new CustomItemStack(
                                Material.BOOKSHELF,
                                "&bMenu Container"
                        )
                )
        );
        SlimefunItemUtil.registerItem(menuContainer);

        // builders
        MachineRecipeBuilder machineRecipeBuilder = new MachineRecipeBuilder(
                new SlimefunItemStack(
                        "RSC_EDITOR_MACHINE_RECIPE_BUILDER",
                        new CustomItemStack(
                                Material.SMITHING_TABLE,
                                "&bMachine Recipe Builder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(machineRecipeBuilder);

        TemplateMachineRecipeBuilder templateMachineRecipeBuilder = new TemplateMachineRecipeBuilder(
                new SlimefunItemStack(
                        "RSC_EDITOR_TEMPLATE_MACHINE_RECIPE_BUILDER",
                        new CustomItemStack(
                                Material.JUKEBOX,
                                "&bTemplate Machine Recipe Builder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(templateMachineRecipeBuilder);

        LinkedMachineRecipeBuilder linkedMachineRecipeBuilder = new LinkedMachineRecipeBuilder(
                new SlimefunItemStack(
                        "RSC_EDITOR_LINKED_MACHINE_RECIPE_BUILDER",
                        new CustomItemStack(
                                Material.LOOM,
                                "&bLinked Machine Recipe Builder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(linkedMachineRecipeBuilder);

        RegisterBuilder registerBuilder = new RegisterBuilder(
                new SlimefunItemStack(
                        "RSC_EDITOR_REGISTER_BUILDER",
                        new CustomItemStack(
                                Material.REDSTONE_LAMP,
                                "&bRegister Builder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(registerBuilder);

        MultiBlockRecipeBuilder multiBlockRecipeBuilder = new MultiBlockRecipeBuilder(
                new SlimefunItemStack(
                        "RSC_EDITOR_MULTI_BLOCK_RECIPE_BUILDER",
                        new CustomItemStack(
                                Material.LECTERN,
                                "&bMulti Block Recipe Builder"
                        )
                )
        );
        SlimefunItemUtil.registerItem(multiBlockRecipeBuilder);

        // editors
        ItemGroupEditor itemGroupEditor = new ItemGroupEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_ITEM_GROUP_EDITOR",
                        new CustomItemStack(
                                Material.FLETCHING_TABLE,
                                "&bItem Group Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(itemGroupEditor);

        RecipeTypeEditor recipeTypeEditor = new RecipeTypeEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_RECIPE_TYPE_EDITOR",
                        new CustomItemStack(
                                Material.CARTOGRAPHY_TABLE,
                                "&bRecipe Type Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(recipeTypeEditor);

        GEOResourceEditor geoResourceEditor = new GEOResourceEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_GEO_RESOURCE_EDITOR",
                        new CustomItemStack(
                                Material.GRASS_BLOCK,
                                "&bGEO Resource Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(geoResourceEditor);

        MobDropEditor mobDropEditor = new MobDropEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_MOB_DROP_EDITOR",
                        new CustomItemStack(
                                Material.SPAWNER,
                                "&bMob Drop Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(mobDropEditor);

        ItemEditor itemEditor = new ItemEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_ITEM_EDITOR",
                        new CustomItemStack(
                                Material.SLIME_BLOCK,
                                "&bItem Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(itemEditor);

        ArmorEditor armorEditor = new ArmorEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_ARMOR_EDITOR",
                        new CustomItemStack(
                                Material.GOLD_BLOCK,
                                "&bArmor Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(armorEditor);

        CapacitorEditor capacitorEditor = new CapacitorEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_CAPACITOR_EDITOR",
                        new CustomItemStack(
                                Material.REDSTONE_BLOCK,
                                "&bCapacitor Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(capacitorEditor);

        FoodEditor foodEditor = new FoodEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_FOOD_EDITOR",
                        new CustomItemStack(
                                Material.HAY_BLOCK,
                                "&bFood Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(foodEditor);

        MachineEditor machineEditor = new MachineEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_MACHINE_EDITOR",
                        new CustomItemStack(
                                Material.BLAST_FURNACE,
                                "&bMachine Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(machineEditor);

        GeneratorEditor generatorEditor = new GeneratorEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_GENERATOR_EDITOR",
                        new CustomItemStack(
                                Material.GLOWSTONE,
                                "&bGenerator Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(generatorEditor);

        SolarGeneratorEditor solarGeneratorEditor = new SolarGeneratorEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_SOLAR_GENERATOR_EDITOR",
                        new CustomItemStack(
                                Material.SHROOMLIGHT,
                                "&bSolar Generator Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(solarGeneratorEditor);

        MaterialGeneratorEditor materialGeneratorEditor = new MaterialGeneratorEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_MATERIAL_GENERATOR_EDITOR",
                        new CustomItemStack(
                                Material.DIAMOND_BLOCK,
                                "&bMaterial Generator Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(materialGeneratorEditor);

        RecipeMachineEditor recipeMachineEditor = new RecipeMachineEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_RECIPE_MACHINE_EDITOR",
                        new CustomItemStack(
                                Material.FURNACE,
                                "&bRecipe Machine Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(recipeMachineEditor);

        SimpleMachineEditor simpleMachineEditor = new SimpleMachineEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_SIMPLE_MACHINE_EDITOR",
                        new CustomItemStack(
                                Material.SMOKER,
                                "&bSimple Machine Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(simpleMachineEditor);

        MultiBlockEditor multiBlockEditor = new MultiBlockEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_MULTI_BLOCK_EDITOR",
                        new CustomItemStack(
                                Material.BRICKS,
                                "&bMulti Block Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(multiBlockEditor);

        TemplateRecipeMachineEditor templateRecipeMachineEditor = new TemplateRecipeMachineEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_TEMPLATE_RECIPE_MACHINE_EDITOR",
                        new CustomItemStack(
                                Material.EMERALD_BLOCK,
                                "&bTemplate Recipe Machine Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(templateRecipeMachineEditor);

        LinkedRecipeMachineEditor linkedRecipeMachineEditor = new LinkedRecipeMachineEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_LINKED_RECIPE_MACHINE_EDITOR",
                        new CustomItemStack(
                                Material.SEA_LANTERN,
                                "&bLinked Recipe Machine Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(linkedRecipeMachineEditor);

        WorkbenchEditor workbenchEditor = new WorkbenchEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_WORKBENCH_EDITOR",
                        new CustomItemStack(
                                Material.CRAFTING_TABLE,
                                "&bWorkbench Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(workbenchEditor);

        ResearchEditor researchEditor = new ResearchEditor(
                new SlimefunItemStack(
                        "RSC_EDITOR_RESEARCH_EDITOR",
                        new CustomItemStack(
                                Material.ENCHANTING_TABLE,
                                "&bResearch Editor"
                        )
                )
        );
        SlimefunItemUtil.registerItem(researchEditor);
    }
}
