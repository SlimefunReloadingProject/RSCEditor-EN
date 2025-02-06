package com.balugaq.rsceditor.implementation.groups;

import com.balugaq.rsceditor.implementation.RSCEditor;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

@UtilityClass
public class RSCEItemGroups {
    public static final NestedItemGroup RSC_EDITOR_GROUP = new NestedItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "rsc_editor_group"),
            new CustomItemStack(Material.BOOK, "&bRSC Editor")
    );
    public static final SubItemGroup MACHINE_GROUP = new SubItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "machine_group"),
            RSC_EDITOR_GROUP,
            new CustomItemStack(Material.FURNACE, "&bBuilders")
    );
    public static final SubItemGroup TYPE_GROUP = new SubItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "type_group"),
            RSC_EDITOR_GROUP,
            new CustomItemStack(Material.NAME_TAG, "&bPlaceholders")
    );
    public static final SubItemGroup ITEM_GROUP_GROUP = new SubItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "item_group_group"),
            RSC_EDITOR_GROUP,
            new CustomItemStack(Material.BOOKSHELF, "&bItem Groups")
    );
    public static final SubItemGroup RECIPE_TYPE_GROUP = new SubItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "recipe_type_group"),
            RSC_EDITOR_GROUP,
            new CustomItemStack(Material.KNOWLEDGE_BOOK, "&bRecipe Types")
    );
    public static final SubItemGroup BIOME_GROUP = new SubItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "biome_group"),
            RSC_EDITOR_GROUP,
            new CustomItemStack(Material.MOSS_BLOCK, "&bBiome Placeholders")
    );
    public static final SubItemGroup SOUND_TYPE_GROUP = new SubItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "sound_type_group"),
            RSC_EDITOR_GROUP,
            new CustomItemStack(Material.NOTE_BLOCK, "&bSound Placeholders")
    );
    public static final SubItemGroup TOOL_GROUP = new SubItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "tool_group"),
            RSC_EDITOR_GROUP,
            new CustomItemStack(Material.DIAMOND_PICKAXE, "&bTools")
    );
}
