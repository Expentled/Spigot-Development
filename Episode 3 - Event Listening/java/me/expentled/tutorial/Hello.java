package me.expentled.tutorial;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Hello implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {
                if (label.equalsIgnoreCase("test")) player.sendMessage("Hello, good sir!");
                else player.sendMessage("Hello.");
            } else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("world")) {
                    player.sendMessage("Hello World!");
                }
            }
        } else if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Hello, Mr. Console");
        } else if(sender instanceof BlockCommandSender) {
            System.out.println("Hello from a command block!");
        }

        return false;
    }

}
