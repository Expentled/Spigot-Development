package me.expentled.tutorial;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tutorial extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', "\n&aThe Tutorial Plugin has been Enabled&r\n")
        );

        this.saveDefaultConfig();

        FileConfiguration config = this.getConfig();
        System.out.println(config.getConfigurationSection("heading").toString());
        System.out.println(config.getString("heading.name"));
        System.out.println(config.getInt("heading.value") + "");
        System.out.println(config.getBoolean("heading.enabled") + "");
        System.out.println(config.getStringList("heading.list"));
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', "\n&cThe Tutorial Plugin has been Disabled&r\n")
        );
    }

}
