package com.balugaq.rsceditor.utils;

import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@Getter
public class YamlWriter {
    private File file;
    private FileConfiguration outputTo;
    private BlockMenu blockMenu;
    public YamlWriter() {
        outputTo = new YamlConfiguration();
    }

    public YamlWriter setFile(File file) {
        this.file = file;
        this.outputTo = YamlConfiguration.loadConfiguration(file);
        return this;
    }

    public YamlWriter set(String key, Object value) {
        outputTo.set(key, value);
        return this;
    }

    public YamlWriter setBlockMenu(BlockMenu blockMenu) {
        this.blockMenu = blockMenu;
        return this;
    }

    public String toString() {
        return outputTo.saveToString();
    }

    public void save() {
        try {
            outputTo.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
