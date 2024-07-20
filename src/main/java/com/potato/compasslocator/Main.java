package com.potato.compasslocator;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        SetTargetCommand setTargetCommand = new SetTargetCommand(this);
        Objects.requireNonNull(getCommand("settarget")).setExecutor(setTargetCommand);
        new CompassUpdater(this, setTargetCommand).runTaskTimer(this, 0, 20); // Update every second
        getServer().getPluginManager().registerEvents(new PlayerHitEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
