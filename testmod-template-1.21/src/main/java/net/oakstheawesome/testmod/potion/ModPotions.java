package net.oakstheawesome.testmod.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.oakstheawesome.testmod.TestMod;

public class ModPotions {

    //Makes a potion using the tater effect established in effects/TaterEffect.java
    public static final Potion TATER_POTION =
            Registry.register(
                    Registries.POTION,
                    Identifier.of("testmod","tater"),
                    new Potion(
                            new StatusEffectInstance(
                                    TestMod.TATER,
                                    3600,
                                    0)));


    //Registers the potion and makes a potion recipe for the tater potion, then initializes it
    public static void initialize() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.WATER,
                    Items.POTATO,
                    Registries.POTION.getEntry(TATER_POTION)
            );
        });
    }
}
