package com.balugaq.rsceditor.implementation.groups;

import com.balugaq.rsceditor.implementation.RSCEditor;

public class GroupSetup {
    public static void register() {
        MyItemGroups.RSC_EDITOR_GROUP.register(RSCEditor.getInstance());
        MyItemGroups.MACHINE_GROUP.register(RSCEditor.getInstance());
        MyItemGroups.TYPE_GROUP.register(RSCEditor.getInstance());
        MyItemGroups.ITEM_GROUP_GROUP.register(RSCEditor.getInstance());
        MyItemGroups.RECIPE_TYPE_GROUP.register(RSCEditor.getInstance());
        MyItemGroups.BIOME_GROUP.register(RSCEditor.getInstance());
    }
}
