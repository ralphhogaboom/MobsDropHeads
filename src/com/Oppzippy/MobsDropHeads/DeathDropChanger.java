package com.Oppzippy.MobsDropHeads;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathDropChanger extends MobsDropHeads implements Listener {
	Random rnd = new Random();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void DropHead(EntityDeathEvent event) {
		if (event.getEntity().getKiller() != null) {
			Material itemInHand = event.getEntity().getKiller().getItemInHand()
					.getType();
			if ((itemInHand == Material.STONE_SWORD
					|| itemInHand == Material.IRON_SWORD
					|| itemInHand == Material.DIAMOND_SWORD || itemInHand == Material.GOLD_SWORD)
					|| (MobsDropHeads.config.getBoolean("Heads Require Swords") == false)) {
				EntityType e = event.getEntity().getType();
				if (e.equals(EntityType.ZOMBIE)
						&& MobsDropHeads.config.getBoolean("Zombie")
						&& rnd.nextInt(MobsDropHeads.config
								.getInt("Zombie Drop Chance")) + 1 == 1) {
					event.getDrops().add(MobHead.ZOMBIE.getItemStack());
				} else if (e.equals(EntityType.SKELETON)
						&& !Skeleton.isWither(event.getEntity())
						&& MobsDropHeads.config.getBoolean("Skeleton")
						&& rnd.nextInt(MobsDropHeads.config
								.getInt("Skeleton Drop Chance")) + 1 == 1) {
					event.getDrops().add(MobHead.SKELETON.getItemStack());
				} else if (e.equals(EntityType.CREEPER)
						&& MobsDropHeads.config.getBoolean("Creeper")
						&& rnd.nextInt(MobsDropHeads.config
								.getInt("Creeper Drop Chance")) + 1 == 1) {
					event.getDrops().add(MobHead.CREEPER.getItemStack());

				} else if (e.equals(EntityType.SKELETON)) {
					if (Skeleton.isWither(event.getEntity())
							&& MobsDropHeads.config
									.getBoolean("Wither Skeleton")) {
						if (event.getDrops().contains(
								MobHead.WITHER_SKELETON.getItemStack()))
							event.getDrops().remove(
									MobHead.WITHER_SKELETON.getItemStack());
						if (rnd.nextInt(MobsDropHeads.config
								.getInt("Wither Skeleton Drop Chance")) + 1 == 1)
							event.getDrops().add(
									MobHead.WITHER_SKELETON.getItemStack());
					}
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerDropHead(PlayerDeathEvent event) {
		Player p = event.getEntity();
		Player killer = p.getKiller();
		if (killer != null) {
			Material itemInHand = killer.getItemInHand().getType();
			if ((itemInHand == Material.STONE_SWORD
					|| itemInHand == Material.IRON_SWORD
					|| itemInHand == Material.DIAMOND_SWORD || itemInHand == Material.GOLD_SWORD)
					|| (MobsDropHeads.config.getBoolean("Heads Require Swords") == false)) {
				if (rnd.nextInt((int) MobsDropHeads.config
						.getInt("Player Drop Chance")) + 1 == 1
						&& (boolean) MobsDropHeads.config.getBoolean("Player")) {
					event.getDrops().add(PlayerHead.NameHead(p.getName()));
				}
			}
		}
	}
}
