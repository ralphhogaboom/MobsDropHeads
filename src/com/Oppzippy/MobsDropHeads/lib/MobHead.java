package com.Oppzippy.MobsDropHeads.lib;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum MobHead {
	CREEPER("Creeper Head", (byte)4), SKELETON("Skeleton Skull", (byte)0),
	WITHER_SKELETON("Wither Skeleton Skull", (byte)1), ZOMBIE("Zombie Head",
			(byte)2);

	String SkullName;

	byte SkullData;

	ItemStack item;

	private MobHead(String name, Byte data) {
		SkullName = name;
		SkullData = data;
	}

	/**
	 * Gets the damage value of the skull.
	 * 
	 * @return Damage value of a skull
	 **/
	public byte getData() {
		return SkullData;
	}

	/**
	 * Creates an ItemStack containing a mob's head.
	 * 
	 * @return ItemStack containing a mob's head
	 */
	public ItemStack getItemStack() {
		return new ItemStack(Material.SKULL_ITEM, 1, SkullData);
	}

	/**
	 * Returns the name of the head. Ex. Creeper Head, Skeleton Skull, etc.
	 * 
	 * @return Name of the head
	 */
	public String getName() {
		return SkullName;
	}
}
