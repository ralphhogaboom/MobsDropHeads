package com.Oppzippy.MobsDropHeads;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MobsDropHeads extends JavaPlugin {
	private final Logger logger = Logger.getLogger("Minecraft");
	public static MemoryConfiguration config;

	public void onDisable() {
		config = null;
		System.gc();
	}

	public void onEnable() {
		saveDefaultConfig();
		if (!configIsOk(getConfig())) {
			configNotOK();
		}
		config = getConfig();
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
					((Player) sender).sendMessage("Mobs Drop Heads commands:");
					((Player) sender).sendMessage("/" + command
							+ " reload - Reloads config file");
				}
				if (args.length >= 1 && sender.isOp()
						&& args[0].equalsIgnoreCase("reload")) {
					saveDefaultConfig();
					if (!configIsOk(getConfig())) {
						configNotOK();
					}
					reloadConfig();
					config = getConfig();
					logger.info("Reloading Mobs Drop Heads config file.");
					((Player) sender)
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
					saveDefaultConfig();
					if (!configIsOk(getConfig())) {
						configNotOK();
					}
					reloadConfig();
					config = getConfig();
					logger.info("Reloading Mobs Drop Heads config file.");
				}
			}
		}
		return true;
	}

	private boolean configIsOk(MemoryConfiguration c) {
		if (c.isSet("Skeleton") && c.isSet("Zombie") && c.isSet("Creeper")
				&& c.isSet("Player") && c.isSet("Skeleton Drop Chance")
				&& c.isSet("Zombie Drop Chance")
				&& c.isSet("Creeper Drop Chance")
				&& c.isSet("Player Drop Chance") && c.isSet("Wither Skeleton")
				&& c.isSet("Wither Skeleton Drop Chance")
				&& c.isSet("Heads Require Swords")) {
			return true;
		}
		return false;
	}

	private void configNotOK() {
		logger.severe(getDescription().getName()
				+ " config file is missing values!  The plugin will not run correctly and will cause errors.  Please delete your config file and type the command mobsdropheads reload.");
	}
}
