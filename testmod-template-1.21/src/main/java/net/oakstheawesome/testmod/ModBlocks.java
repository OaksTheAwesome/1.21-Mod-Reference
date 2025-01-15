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

    public static final Block CONDENSED_DIRT_STAIRS = register("condensed_dirt_stairs",
            new StairsBlock(ModBlocks.CONDENSED_DIRT.getDefaultState(), AbstractBlock.Settings.create().strength(0.5f, 2)));

    public static final Block CONDENSED_DIRT_SLAB = register("condensed_dirt_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(0.5f, 2)));

    public static final Block CONDENSED_DIRT_BUTTON = register("condensed_dirt_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.create().strength(0.5f, 2).noCollision()));

    public static final Block CONDENSED_DIRT_PRESSURE_PLATE = register("condensed_dirt_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(0.5f, 2)));

    public static final Block CONDENSED_DIRT_FENCE = register("condensed_dirt_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(0.5f, 2)));

    public static final Block CONDENSED_DIRT_FENCE_GATE = register("condensed_dirt_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(0.5f, 2)));

    public static final Block CONDENSED_DIRT_WALL = register("condensed_dirt_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(0.5f, 2).requiresTool()));

    public static final Block CONDENSED_DIRT_DOOR = register("condensed_dirt_door",
            new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(0.5f, 2).nonOpaque()));

    public static final Block CONDENSED_DIRT_TRAPDOOR = register("condensed_dirt_trapdoor",
            new TrapdoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(0.5f, 2).nonOpaque()));

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
