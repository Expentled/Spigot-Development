package me.expentled.tutorial;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tutorial extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', "\n&aThe Tutorial Plugin has been Enabled&r\n")
        );

        getCommand("test").setExecutor(new CustomInventory());
        getServer().getPluginManager().registerEvents(new CustomInventory(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', "\n&cThe Tutorial Plugin has been Disabled&r\n")
        );
    }

}
