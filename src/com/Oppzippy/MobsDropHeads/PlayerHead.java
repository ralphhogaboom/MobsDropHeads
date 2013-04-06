package com.Oppzippy.MobsDropHeads;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerHead {
	public static ItemStack NameHead(String pName) {
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta meta = ((SkullMeta)skull.getItemMeta());
		meta.setOwner(pName);
		skull.setItemMeta(meta);
		return skull;
		/* Some old code
		net.minecraft.server.v1_5_R2.ItemStack itemStack = CraftItemStack
				.asNMSCopy(skull);
		NBTTagCompound tag = itemStack.tag;
		tag = new NBTTagCompound();
		tag.setString("SkullOwner", pName);
		itemStack.tag = tag;
		return CraftItemStack.asBukkitCopy(itemStack);
		*/
	}
}
