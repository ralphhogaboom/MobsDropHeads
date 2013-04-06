package com.Oppzippy.MobsDropHeads;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum MobHead {
	CREEPER("Creeper Head", (byte) 4),SKELETON(
			"Skeleton Skull", (byte) 0), WITHER_SKELETON(
			"Wither Skeleton Skull", (byte) 1), ZOMBIE("Zombie Head", (byte) 2);
	String SkullName;
	byte SkullData;
	ItemStack item;

	private MobHead(String name, Byte data) {
		SkullName = name;
		SkullData = data;
	}

	public byte getData() {
		return SkullData;
	}

	public ItemStack getItemStack() {
		return new ItemStack(Material.SKULL_ITEM, 1, SkullData);
	}

	public String getName() {
		return SkullName;
	}
}
