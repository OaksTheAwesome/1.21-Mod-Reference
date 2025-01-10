package net.oakstheawesome.testmod;

import net.minecraft.item.Item;
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


}
