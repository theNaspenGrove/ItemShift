package net.mov51.ItemShift;

import net.mov51.ItemShift.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

import static net.mov51.ItemShift.util.ConfigHelper.loadConfig;

public final class ItemShift extends JavaPlugin {
    public static Logger logger;
    public static ItemShift plugin;
    @Override
    public void onEnable() {
        plugin = getPlugin(ItemShift.class);
        //create default config file
        this.saveDefaultConfig();
        loadConfig();
        //create Aspen logger
        logger = this.getLogger();
        //register events
        getServer().getPluginManager().registerEvents(new ItemSpawn(), this);
        getServer().getPluginManager().registerEvents(new ItemDamage(), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new ItemPickup(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(), this);
        //send enable message
        logger.log(Level.INFO, "Items are being shifted!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
