package me.expentled.tutorial;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Tutorial extends JavaPlugin implements Listener {

    private static Tutorial instance;

    private File file;
    private FileConfiguration config;

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', "\n&aThe Tutorial Plugin has been Enabled&r\n")
        );

        setInstance(this);

        createConfig();

        config.set("message", "This is a message from a custom config file");
        save();

        getCommand("message").setExecutor(new Message());
        getCommand("tutorial").setExecutor(new Reload());
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', "\n&cThe Tutorial Plugin has been Disabled&r\n")
        );
    }

    private void createConfig() {
        try {
            File file = new File(this.getDataFolder(), "data.yml");
            if (!file.exists()) {
                if (!file.getParentFile().exists()) file.getParentFile().mkdir();
                file.createNewFile();
            }

            this.file = file;
            this.config = YamlConfiguration.loadConfiguration(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public FileConfiguration getConfig() {
        return config;
    }

    public void setConfig(FileConfiguration config) {
        this.config = config;
    }

    public static Tutorial getInstance() {
        return instance;
    }

    public static void setInstance(Tutorial instance) {
        Tutorial.instance = instance;
    }
}

