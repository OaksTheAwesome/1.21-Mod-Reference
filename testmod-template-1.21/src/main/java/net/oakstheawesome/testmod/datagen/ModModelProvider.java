package net.oakstheawesome.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.oakstheawesome.testmod.ModBlocks;
import net.oakstheawesome.testmod.ModItems;
import net.oakstheawesome.testmod.custom_blocks.PrismarineLampBlock;

//This is the most important datagen, creates .json for all items and blocks
public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool condensedDirtPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CONDENSED_DIRT);
        blockStateModelGenerator.registerLog(ModBlocks.CONDENSED_OAK_LOG).log(ModBlocks.CONDENSED_OAK_LOG);

        condensedDirtPool.stairs(ModBlocks.CONDENSED_DIRT_STAIRS);
        condensedDirtPool.slab(ModBlocks.CONDENSED_DIRT_SLAB);
        condensedDirtPool.button(ModBlocks.CONDENSED_DIRT_BUTTON);
        condensedDirtPool.pressurePlate(ModBlocks.CONDENSED_DIRT_PRESSURE_PLATE);
        condensedDirtPool.fence(ModBlocks.CONDENSED_DIRT_FENCE);
        condensedDirtPool.fenceGate(ModBlocks.CONDENSED_DIRT_FENCE_GATE);
        condensedDirtPool.wall(ModBlocks.CONDENSED_DIRT_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.CONDENSED_DIRT_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CONDENSED_DIRT_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PRISMARINE_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.PRISMARINE_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PRISMARINE_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PrismarineLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));


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
