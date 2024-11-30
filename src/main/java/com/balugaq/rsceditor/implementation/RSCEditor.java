package com.balugaq.rsceditor.implementation;


import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class RSCEditor extends JavaPlugin implements SlimefunAddon {
    @Getter
    private static RSCEditor instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getLogger().info("RSCEditor has been enabled.");
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