package me.expentled.tutorial;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Events implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("You broke a block!");
        event.setCancelled(true);
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        Entity target = event.getEntity(), attacker = event.getDamager();
        if(attacker instanceof Player) {
            Player player = (Player) attacker;
            player.sendMessage("Don't attack the wildlife!");
            event.setCancelled(true);
        }
    }

}
