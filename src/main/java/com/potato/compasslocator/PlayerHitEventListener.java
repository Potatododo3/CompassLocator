package com.potato.compasslocator;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerHitEventListener implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        Player damager = (Player) e.getDamager();
        Player victim = (Player) e.getEntity(); // corrected from e.getDamager() to e.getEntity()

        if (victim.hasPermission("rehanm.victim")) {
            return;
        }
        if (damager.hasPermission("rehanm.damager")) {
            return;
        } else {
            e.setCancelled(true);
        }
    }

}