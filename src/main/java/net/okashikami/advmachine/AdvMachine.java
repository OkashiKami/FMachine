package net.okashikami.advmachine;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.okashikami.advmachine.block.ModBlocks;
import net.okashikami.advmachine.event.PlayerTickHandler;
import net.okashikami.advmachine.item.ModItems;
import net.okashikami.advmachine.networking.ModMessages;
import net.okashikami.advmachine.painting.ModPaintings;
import net.okashikami.advmachine.util.ModLootTableModifiers;
import net.okashikami.advmachine.villager.ModVillagers;
import net.okashikami.advmachine.world.feature.ModConfiguredFeatures;
import net.okashikami.advmachine.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class AdvMachine implements ModInitializer {
	public static final String MOD_ID = "advmachine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();
		ModOreGeneration.generateOres();

		ModLootTableModifiers.modifyLootTables();
		ModMessages.registerC2SPackets();

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}
