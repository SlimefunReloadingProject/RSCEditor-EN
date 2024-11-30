package com.balugaq.rsceditor.implementation.groups;

import com.balugaq.rsceditor.implementation.RSCEditor;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class MyItemGroups {
    public static final ItemGroup RECIPE_TYPE_GROUP = new ItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "recipe_type_group"),
            new CustomItemStack(Material.KNOWLEDGE_BOOK, "&bRecipe Types")
    );

    public static final ItemGroup ITEM_GROUP_GROUP = new ItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "item_group_group"),
            new CustomItemStack(Material.BOOKSHELF, "&bItem Groups")
    );

    public static final ItemGroup TYPE_GROUP = new ItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "type_group"),
            new CustomItemStack(Material.ANVIL, "&bTypes")
    );
    public static final ItemGroup MACHINE_GROUP = new ItemGroup(
            new NamespacedKey(RSCEditor.getInstance(), "machine_group"),
            new CustomItemStack(Material.ANVIL, "&bMachines")
    );
}
