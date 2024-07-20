package com.potato.compasslocator;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CompassUpdater extends BukkitRunnable {

    private final Main main;
    private final SetTargetCommand setTargetCommand;
    public CompassUpdater(Main main, SetTargetCommand setTargetCommand) {
        this.main = main;
        this.setTargetCommand = setTargetCommand;
    }

    @Override
    public void run() {
        String targetPlayerName = setTargetCommand.getTargetPlayerName();
        if (targetPlayerName == null) {
            return; // No target player set
        }

        Player target = Bukkit.getPlayer(targetPlayerName);
        if (target == null || !target.isOnline()) {
            return; // Target player is not online
        }

        Location targetLocation = target.getLocation();

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setCompassTarget(targetLocation);

            double distance = player.getLocation().distance(targetLocation);
            String distanceMessage = String.format("Distance to %s: %.2f blocks", target.getName(), distance);

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(distanceMessage));
        }
    }
}