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

import com.Oppzippy.MobsDropHeads.lib.MobHead;
import com.Oppzippy.MobsDropHeads.lib.PlayerMobHead;

public class DeathDropChanger implements Listener {

	private Random rnd = new Random();

	// Non-player drops
	@EventHandler(priority = EventPriority.HIGHEST)
	public void DropHead(EntityDeathEvent event) {
		if (!event.getEntityType().isAlive()
				|| event.getEntityType().equals(EntityType.PLAYER))
			return;
		// Checks to be sure there was a killer
		if (event.getEntity().getKiller() != null) {
			Material itemInHand =
					event.getEntity().getKiller().getItemInHand().getType();
			// Heads require sword in hand
			if ((itemInHand == Material.STONE_SWORD
					|| itemInHand == Material.IRON_SWORD
					|| itemInHand == Material.DIAMOND_SWORD || itemInHand == Material.GOLD_SWORD)
					|| (MobsDropHeads.config.getBoolean("Heads Require Swords") == false)) {
				EntityType e = event.getEntity().getType();
				if (e.equals(EntityType.SKELETON)
						&& Skeleton.isWither(event.getEntity())
						&& MobsDropHeads.config.getBoolean("Wither Skeleton")) {
					for (int i = 0; i < event.getDrops().size(); i++) {
						if (event.getDrops().get(i).getType()
								.equals(Material.SKULL_ITEM)) {
							event.getDrops().remove(i);
							break;
						}
					}
					if (tryDrop(MobsDropHeads.config
							.getInt("Wither Skeleton Drop Chance")))
						event.getDrops().add(
								MobHead.WITHER_SKELETON.getItemStack());
					return;
				}
				int chance = 0;
				if (MobsDropHeads.dropChance.containsKey(e.toString())) {
					chance = MobsDropHeads.dropChance.get(e.toString());
					if (chance != 0 && tryDrop(chance)) {
						if (e.equals(EntityType.ZOMBIE)) {
							event.getDrops().add(MobHead.ZOMBIE.getItemStack());
							return;
						} else if (e.equals(EntityType.SKELETON)) {
							event.getDrops().add(
									MobHead.SKELETON.getItemStack());
							return;
						} else if (e.equals(EntityType.CREEPER)) {
							event.getDrops().add(
									MobHead.SKELETON.getItemStack());
							return;
						}
						PlayerMobHead pmHead =
								PlayerMobHead.valueOf(e.toString());
						if (pmHead != null)
							event.getDrops().add(pmHead.getItemStack());
					}
				}
			}
		}
	}

	// Player heads
	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerDropHead(PlayerDeathEvent event) {
		Player p = event.getEntity();
		Player killer = p.getKiller();
		// Checks to be sure there was a killer
		if (killer != null) {
			Material itemInHand = killer.getItemInHand().getType();
			// Heads require sword in hand
			if ((itemInHand == Material.STONE_SWORD
					|| itemInHand == Material.IRON_SWORD
					|| itemInHand == Material.DIAMOND_SWORD || itemInHand == Material.GOLD_SWORD)
					|| (MobsDropHeads.config.getBoolean("Heads Require Swords") == false)) {
				if (tryDrop((int)MobsDropHeads.config
						.getInt("Player Drop Chance"))
						&& (boolean)MobsDropHeads.config.getBoolean("Player")) {
					event.getDrops().add(PlayerHead.nameHead(p.getName()));
				}
			}
		}
	}

	/**
	 * Used for random chance of dropping heads
	 * 
	 * @param chance
	 *            Percentage chance of returning true
	 * @return Chance of being true, otherwise false
	 */
	private boolean tryDrop(int chance) {
		return rnd.nextInt(99) + 1 <= chance;
	}
}