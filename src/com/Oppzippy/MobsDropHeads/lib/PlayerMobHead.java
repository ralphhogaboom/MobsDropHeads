package com.Oppzippy.MobsDropHeads.lib;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Oppzippy.MobsDropHeads.PlayerHead;


public enum PlayerMobHead {
	BLAZE("Blaze Head", "MHF_Blaze"),
	CAVE_SPIDER("Cave Spider Head", "MHF_CaveSpider"),
	CHICKEN("Chicken Head", "MHF_Chicken"),
	COW("Cow Head", "MHF_Cow"),
	ENDERMAN("Enderman Head", "MHF_Enderman"),
	GHAST("Ghast Head", "MHF_Ghast"),
	IRON_GOLEM("Iron Golem Head", "MHF_Golem"),
	MAGMA_CUBE("Magma Cube Head", "MHF_LavaSlime"),
	MUSHROOM_COW("Mooshroom Head", "MHF_MushroomCow"),
	OCELOT("Ocelot Head", "MHF_Ocelot"),
	PIG("Pig Head", "MHF_Pig"),
	PIG_ZOMBIE("Zombie Pigman Head", "MHF_PigZombie"),
	SHEEP("Sheep Head", "MHF_Sheep"),
	SLIME("Slime Head", "MHF_Slime"),
	SPIDER("Spider Head", "MHF_Spider"),
	SQUID("Squid Head", "MHF_Squid"),
	VILLAGER("Villager Head", "MHF_Villager");
	String displayName;
	String playerName;
	private PlayerMobHead(String displayName, String playerName){
		this.displayName = displayName;
		this.playerName = playerName;
	}
	
	/**
	 * Creates an ItemStack for the head.
	 * @return The created ItemStack for this head
	 */
	
	public ItemStack getItemStack(){
		ItemStack head = PlayerHead.nameHead(playerName);
		ItemMeta headMeta = head.getItemMeta();
		headMeta.setDisplayName(ChatColor.RESET + displayName);
		head.setItemMeta(headMeta);
		return head;
	}
	
	/**
	 * The display name is the name shown in-game upon mousing over the item.
	 * @return Display name of the head
	 */
	
	public String getDisplayName(){
		return displayName;
	}
	
	/**
	 * Returns the player's name who owns the skin that is being used.
	 * @return SkullOwner
	 */
	
	public String getMHFName(){
		return playerName;
	}
}
