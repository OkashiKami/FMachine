package net.okashikami.fmachine;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.okashikami.fmachine.block.ModBlocks;
import net.okashikami.fmachine.event.PlayerTickHandler;
import net.okashikami.fmachine.item.ModItems;
import net.okashikami.fmachine.networking.ModMessages;
import net.okashikami.fmachine.painting.ModPaintings;
import net.okashikami.fmachine.util.ModLootTableModifiers;
import net.okashikami.fmachine.villager.ModVillagers;
import net.okashikami.fmachine.world.feature.ModConfiguredFeatures;
import net.okashikami.fmachine.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FMachine implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "fmachine";
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
