package net.mcreator.enchiridionbook.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.enchiridionbook.EnchiridionbookModElements;
import net.mcreator.enchiridionbook.EnchiridionbookMod;

import java.util.Map;

@EnchiridionbookModElements.ModElement.Tag
public class EnchiridionLivingEntityIsHitWithItemProcedure extends EnchiridionbookModElements.ModElement {
	public EnchiridionLivingEntityIsHitWithItemProcedure(EnchiridionbookModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EnchiridionbookMod.LOGGER.warn("Failed to load dependency entity for procedure EnchiridionLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 20000);
	}
}
