package me.expentled.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CustomInventory implements CommandExecutor, Listener {

    public void createInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 27, ChatColor.translateAlternateColorCodes('&', "&c&lInventory"));
        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        for(int x = 0; x < inventory.getSize(); x++) {
            inventory.setItem(x, glass);
        }
        ItemStack apple = new ItemStack(Material.APPLE, 1);
        inventory.setItem(13, apple);

        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();
        if(inventory instanceof PlayerInventory) return;

        String name = ChatColor.stripColor(event.getView().getTitle());
        if(!name.equalsIgnoreCase("Inventory")) return;

        ItemStack item = event.getCurrentItem();
        if(item == null || item.getType() == Material.AIR) return;

        event.setCancelled(true);
        if(item.getType() == Material.APPLE) {
            Player player = (Player) event.getWhoClicked();
            player.sendMessage("You clicked the apple!");
            player.setHealth(10);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            createInventory(player);
        }
        return false;
    }
}
