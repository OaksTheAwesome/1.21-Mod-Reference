package net.oakstheawesome.testmod;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMatierals {


//Static method that will register the armor material
    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(TestMod.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(TestMod.MOD_ID, id), material);

        return RegistryEntry.of(material);
    }




//Initializes the ModMaterials
    public static void initialize() {};




//Registering the armor matierial
    public static final RegistryEntry<ArmorMaterial> GUIDITE = registerMaterial("guidite",
            //Determines defense points
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3
            ),
        5,
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
        () -> Ingredient.ofItems(ModItems.SUSPICIOUS_SUBSTANCE),
        0.0F,
        0.0F,
        false);

//Armor multiplier for the material. Multiplies against base durabilities for armours.
    public static final int GUIDITE_DURABILITY_MULTIPLIER = 15;

}
