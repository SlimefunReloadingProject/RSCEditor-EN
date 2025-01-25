package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.implementation.items.tools.MenuCopier;
import com.balugaq.rsceditor.utils.SlimefunItemUtil;
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
                        "&aMenu Copier",
                        "",
                        "&aRigth click on a machine to paste the menu.",
                        "&aShift + Right-click to copy the menu."
                )
        );
        SlimefunItemUtil.registerItem(menuCopier);
    }
}
