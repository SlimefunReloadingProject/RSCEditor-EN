package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.implementation.RSCEditor;
import com.balugaq.rsceditor.implementation.items.tools.MenuCopier;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;

@UtilityClass
public class ToolSetup {
    public static void register() {
        MenuCopier menuCopier = new MenuCopier(
                new SlimefunItemStack(
                        "RSC_EDITOR_TOOL_MENU_COPIER",
                        Material.LIME_DYE,
                        "&a菜单复制器",
                        "",
                        "&a对粘液机器 右键 以复制菜单。",
                        "&a对粘液机器 Shift+右键 以粘贴菜单。"
                )
        );
        menuCopier.register(RSCEditor.getInstance());
    }
}
