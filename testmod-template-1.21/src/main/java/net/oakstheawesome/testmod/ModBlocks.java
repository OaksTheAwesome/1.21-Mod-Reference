package net.oakstheawesome.testmod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.oakstheawesome.testmod.custom_blocks.PrismarineLampBlock;


public class ModBlocks {

    //Add mod blocks here
    public static final Block CONDENSED_DIRT = register("condensed_dirt",
            new Block(AbstractBlock.Settings.create().strength(0.5f, 2).requiresTool().sounds(BlockSoundGroup.GRASS)));

    public static final Block CONDENSED_OAK_LOG = register("condensed_oak_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block PRISMARINE_LAMP = register("prismarine_lamp",
            new PrismarineLampBlock(AbstractBlock.Settings.create().strength(1f).requiresTool().luminance(PrismarineLampBlock::getLuminance)));


//Register function
    private static Block register(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TestMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }



    //Initialize statement
    public static void initialize() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.CONDENSED_DIRT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.CONDENSED_OAK_LOG);
        });


    }

}
