package me.expentled.tutorial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            if(args[0].equalsIgnoreCase("reload")) {
                Tutorial.getInstance().setConfig(YamlConfiguration.loadConfiguration(Tutorial.getInstance().getFile()));
                sender.sendMessage("The plugin has been reloaded");
            }
        } else sender.sendMessage("This is a tutorial plugin");
        return false;
    }
}
