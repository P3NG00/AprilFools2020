package com.p3ng00.aprilfools;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

import static com.p3ng00.aprilfools.AprilFools.ENABLED;

public class AFListener implements Listener {

    @EventHandler
    public void onChestOpen(PlayerInteractEvent event) {
        if (ENABLED && event.getAction() == Action.RIGHT_CLICK_BLOCK && (event.getClickedBlock().getType() == Material.CHEST || event.getClickedBlock().getType() == Material.SHULKER_BOX)) {
            if (Math.random() <= 0.1) {
                class ExplodeRunnable extends BukkitRunnable {
                    @Override
                    public void run() {
                        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);
                    }
                }
                int delay = 20 * (new Random().nextInt(3) + 2);
                if (Math.random() < 0.5) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0f, 1.0f);
                            new ExplodeRunnable().runTaskLater(AprilFools.INSTANCE, 30);
                        }
                    }.runTaskLater(AprilFools.INSTANCE, delay);
                } else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_HOSTILE_BIG_FALL, 1.0f, 1.0f);
                            new ExplodeRunnable().runTaskLater(AprilFools.INSTANCE, 5 + new Random().nextInt(6));
                        }
                    }.runTaskLater(AprilFools.INSTANCE, delay);
                }
            }
        }
    }
}
