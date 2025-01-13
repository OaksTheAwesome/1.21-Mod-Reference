package net.oakstheawesome.testmod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.oakstheawesome.testmod.effects.TaterEffect;
import net.oakstheawesome.testmod.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";

	//Registers effect
	public static final RegistryEntry<StatusEffect> TATER;
	static {
		TATER = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("testmod", "tater"), new TaterEffect());
	}

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModArmorMatierals.initialize();
		ModItems.initialize();
		ModBlocks.initialize();
        ModEnchantmentEffects.registerModEnchantmentEffects();
		ModPotions.initialize();

		LOGGER.info("Oak's Test Mod!");
	}
}