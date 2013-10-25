package com.Oppzippy.MobsDropHeads;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerHead {
	/**
	 * Creates a skull item and sets the skull owner to the specified player's
	 * name.
	 * 
	 * @param pName
	 *            The name of the SkullOwner
	 * @return ItemStack containing the player's skull.
	 * 
	 * 
	 **/

	public static ItemStack nameHead(String pName) {
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = ((SkullMeta) skull.getItemMeta());
		meta.setOwner(pName);
		skull.setItemMeta(meta);
		return skull;
	}
}
