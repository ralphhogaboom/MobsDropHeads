package com.Oppzippy.MobsDropHeads;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton.SkeletonType;

public class Skeleton {
	/**
	 * Tests an entity for being a wither skeleton
	 * 
	 * @param e
	 *            Entity to test for being a wither skeleton
	 * @return Whether or not the entity is a wither skeleton
	 */
	public static boolean isWither(Entity e) {
		if (e.getType().equals(EntityType.SKELETON))
			return ((org.bukkit.entity.Skeleton) e).getSkeletonType().equals(
					SkeletonType.WITHER);
		return false;
	}
}
