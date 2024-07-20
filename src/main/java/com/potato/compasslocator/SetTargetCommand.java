package com.potato.compasslocator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetTargetCommand implements CommandExecutor {

    private final Main main;
    private String targetPlayerName;

    public SetTargetCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("playercompass.settarget")) {
            sender.sendMessage("You do not have sufficient permission to use this command");
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage("Usage: /settarget <playername>");
            return false;
        }

        targetPlayerName = args[0];
        sender.sendMessage("Compass target set to " + targetPlayerName);
        return true;
    }

    public String getTargetPlayerName() {
        return targetPlayerName;
    }
}