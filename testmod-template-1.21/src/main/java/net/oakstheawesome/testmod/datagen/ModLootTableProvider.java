package net.oakstheawesome.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.oakstheawesome.testmod.ModBlocks;
import net.oakstheawesome.testmod.ModItems;
import net.oakstheawesome.testmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CONDENSED_DIRT);
        addDrop(ModBlocks.CONDENSED_OAK_LOG);
        addDrop(ModBlocks.CONDENSED_DIRT_BUTTON);
        addDrop(ModBlocks.CONDENSED_DIRT_DOOR, doorDrops(ModBlocks.CONDENSED_DIRT_DOOR));
        addDrop(ModBlocks.CONDENSED_DIRT_FENCE);
        addDrop(ModBlocks.CONDENSED_DIRT_FENCE_GATE);
        addDrop(ModBlocks.CONDENSED_DIRT_SLAB, slabDrops(ModBlocks.CONDENSED_DIRT_SLAB));
        addDrop(ModBlocks.CONDENSED_DIRT_STAIRS);
        addDrop(ModBlocks.CONDENSED_DIRT_PRESSURE_PLATE);
        addDrop(ModBlocks.CONDENSED_DIRT_TRAPDOOR);
        addDrop(ModBlocks.CONDENSED_DIRT_WALL);
        //addDrop(Blocks.IRON_BLOCK, drops(ModItems.SUSPICIOUS_SUBSTANCE));
    }
}
