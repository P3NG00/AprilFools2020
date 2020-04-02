package com.p3ng00.aprilfools;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class AprilFools extends JavaPlugin {

    public static JavaPlugin INSTANCE;
    public static boolean ENABLED;

    // Plugin purposely doesn't have a config to be less detectable

    @Override
    public void onEnable() {
        INSTANCE = this;
        ENABLED = false;
        getServer().getPluginManager().registerEvents(new AFListener(), INSTANCE);
        Objects.requireNonNull(getCommand("aprilfools")).setExecutor(new AFCommand());
    }
}
