package com.Oppzippy.MobsDropHeads;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MobsDropHeads extends JavaPlugin {

	private final Logger logger = Bukkit.getLogger();

	public static MemoryConfiguration config;

	public static HashMap<String, Integer> dropChance =
			new HashMap<String, Integer>();

	public void onDisable() {}

	public void onEnable() {
		reloadConfiguration();
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new DeathDropChanger(), this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String command,
			String[] args) {
		if (command.equalsIgnoreCase("mobsdropheads")
				|| command.equalsIgnoreCase("mdh")
				|| command.equalsIgnoreCase("heads")) {
			if (!sender.getName().equalsIgnoreCase("Console")) {
				if (args.length == 0) {
					((Player)sender).sendMessage("Mobs Drop Heads commands:");
					((Player)sender).sendMessage("/" + command
							+ " reload - Reloads config file");
				}
				if (args.length >= 1 && sender.isOp()
						&& args[0].equalsIgnoreCase("reload")) {
					reloadConfiguration();
					((Player)sender)
							.sendMessage("Reloading Mobs Drop Heads config file.");
				}
			} else {
				if (args.length == 0) {
					logger.info(sender.getName());
					logger.info("Mobs Drop Heads commands:");
					logger.info(command + " reload - Reloads config file");
				}
				if (args.length >= 1 && sender.isOp()
						&& args[0].equalsIgnoreCase("reload")) {
					reloadConfiguration();
				}
			}
		}
		return true;
	}

	private void reloadConfiguration() {
		logger.info("Reloading Mobs Drop Heads configuration file.");
		saveDefaultConfig();
		reloadConfig();
		config = getConfig();
		if (config.getBoolean("Skeleton"))
			dropChance.put("SKELETON", config.getInt("Skeleton Drop Chance"));
		if (config.getBoolean("Zombie"))
			dropChance.put("ZOMBIE", config.getInt("Zombie Drop Chance"));
		if (config.getBoolean("Creeper"))
			dropChance.put("CREEPER", config.getInt("Creeper Drop Chance"));
		if (config.getBoolean("Blaze"))
			dropChance.put("BLAZE", config.getInt("Blaze Drop Chance"));
		if (config.getBoolean("Cave Spider"))
			dropChance.put("CAVE_SPIDER",
					config.getInt("Cave Spider Drop Chance"));
		if (config.getBoolean("Chicken"))
			dropChance.put("CHICKEN", config.getInt("Chicken Drop Chance"));
		if (config.getBoolean("Cow"))
			dropChance.put("COW", config.getInt("Cow Drop Chance"));
		if (config.getBoolean("Enderman"))
			dropChance.put("ENDERMAN", config.getInt("Enderman Drop Chance"));
		if (config.getBoolean("Ghast"))
			dropChance.put("GHAST", config.getInt("Ghast Drop Chance"));
		if (config.getBoolean("Magma Cube"))
			dropChance.put("MAGMA_CUBE",
					config.getInt("Magma Cube Drop Chance"));
		if (config.getBoolean("Mooshroom"))
			dropChance.put("MUSHROOM_COW",
					config.getInt("Mooshroom Drop Chance"));
		if (config.getBoolean("Pig"))
			dropChance.put("PIG", config.getInt("Pig Drop Chance"));
		if (config.getBoolean("Zombie Pigman"))
			dropChance.put("PIG_ZOMBIE",
					config.getInt("Zombie Pigman Drop Chance"));
		if (config.getBoolean("Sheep"))
			dropChance.put("SHEEP", config.getInt("Sheep Drop Chance"));
		if (config.getBoolean("Slime"))
			dropChance.put("SLIME", config.getInt("Slime Drop Chance"));
		if (config.getBoolean("Spider"))
			dropChance.put("SPIDER", config.getInt("Spider Drop Chance"));
		if (config.getBoolean("Squid"))
			dropChance.put("SQUID", config.getInt("Squid Drop Chance"));
		if (config.getBoolean("Villager"))
			dropChance.put("VILLAGER", config.getInt("Villager Drop Chance"));
		if (config.getBoolean("Iron Golem"))
			dropChance.put("IRON_GOLEM",
					config.getInt("Iron Golem Drop Chance"));
		if (config.getBoolean("Player"))
			dropChance.put("PLAYER", config.getInt("Player Drop Chance"));
		logger.info("Reloaded Mobs Drop Heads configuration file.");
	}
}
