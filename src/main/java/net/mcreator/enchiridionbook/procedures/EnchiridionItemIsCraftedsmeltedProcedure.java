package net.mcreator.enchiridionbook.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.enchiridionbook.EnchiridionbookModElements;
import net.mcreator.enchiridionbook.EnchiridionbookMod;

import java.util.Map;
import java.util.Iterator;

@EnchiridionbookModElements.ModElement.Tag
public class EnchiridionItemIsCraftedsmeltedProcedure extends EnchiridionbookModElements.ModElement {
	public EnchiridionItemIsCraftedsmeltedProcedure(EnchiridionbookModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EnchiridionbookMod.LOGGER.warn("Failed to load dependency entity for procedure EnchiridionItemIsCraftedsmelted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("enchiridionbook:enchiridion_book"));
			AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
	}
}
