package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.implementation.RSCEditor;
import com.balugaq.rsceditor.implementation.items.machines.GEOResourceEditor;
import com.balugaq.rsceditor.implementation.items.machines.ItemEditor;
import com.balugaq.rsceditor.implementation.items.machines.ItemGroupEditor;
import com.balugaq.rsceditor.implementation.items.machines.MobDropEditor;
import com.balugaq.rsceditor.implementation.items.machines.RecipeTypeEditor;
import com.balugaq.rsceditor.implementation.items.machines.container.CustomRainbowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.SupplyContainer;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;

public class MachineSetup {
    public static void register() {
        // containers
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
    }
}
