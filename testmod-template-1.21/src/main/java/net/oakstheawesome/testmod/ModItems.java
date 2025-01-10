package net.oakstheawesome.testmod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


//Registration method
public class ModItems {
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(TestMod.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return  registeredItem;
    }


//Add Mod Items here
public static final Item SUSPICIOUS_SUBSTANCE = register(
        new Item(new Item.Settings()),
        "suspicious_substance");



//Initialize Mod Items and register items to groups
public static void initialize(){
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
            .register(fabricItemGroupEntries -> fabricItemGroupEntries
                    .add(ModItems.SUSPICIOUS_SUBSTANCE));
    }


}


