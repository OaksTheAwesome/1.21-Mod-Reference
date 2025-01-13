package net.oakstheawesome.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.oakstheawesome.testmod.ModBlocks;
import net.oakstheawesome.testmod.ModItems;

//This is the most important datagen, creates .json for all items and blocks
public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_DIRT);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SUSPICIOUS_SUBSTANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUIDITE_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUIDITE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUIDITE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUIDITE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUIDITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHTNING_STICK, Models.GENERATED);


    }
}
