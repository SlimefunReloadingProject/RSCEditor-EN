package com.balugaq.rsceditor.implementation;


import com.balugaq.rsceditor.core.command.RSCECommands;
import com.balugaq.rsceditor.implementation.groups.GroupSetup;
import com.balugaq.rsceditor.implementation.items.BiomeItems;
import com.balugaq.rsceditor.implementation.items.ItemGroupItems;
import com.balugaq.rsceditor.implementation.items.MachineSetup;
import com.balugaq.rsceditor.implementation.items.RecipeTypeItems;
import com.balugaq.rsceditor.implementation.items.SoundTypeItems;
import com.balugaq.rsceditor.implementation.items.ToolSetup;
import com.balugaq.rsceditor.implementation.items.TypeItems;
import com.balugaq.rsceditor.utils.SlimefunItemUtil;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class RSCEditor extends JavaPlugin implements SlimefunAddon {
    private static RSCEditor instance;

    public static RSCEditor getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        GroupSetup.register();

        TypeItems.register();
        MachineSetup.register();
        RecipeTypeItems.register();
        ItemGroupItems.register();
        BiomeItems.register();
        SoundTypeItems.register();
        ToolSetup.register();

        PluginCommand command = this.getCommand("rsceditor");
        if (command != null) {
            command.setExecutor(new RSCECommands());
        } else {
            getLogger().warning("Failed to register command 'rsceditor'.");
        }

        getLogger().info("RSCEditor has been enabled.");
    }

    public void reload() {
        SlimefunItemUtil.unregisterAllItems();
        onDisable();
        onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().info("RSCEditor has been disabled.");
    }

    @Override
    @NotNull
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/balugaq/RSCEditor/issues";
    }
}