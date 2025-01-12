package net.oakstheawesome.testmod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.oakstheawesome.testmod.items.LightningStick;

import java.util.List;

//---------------------------------------------------------------------------------------------------------------------



//Registration method
public class ModItems {
    public static Item register(String id, Item item) {
        Identifier itemID = Identifier.of(TestMod.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return  registeredItem;
    }



//---------------------------------------------------------------------------------------------------------------------



//Add Mod Items here
public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", new Item(new Item.Settings()
    .rarity(Rarity.UNCOMMON)) {
    //Adds a tooltip to the item
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.testmod.suspicious_substance.tooltip").formatted(Formatting.LIGHT_PURPLE));
        super.appendTooltip(stack, context, tooltip, type);
    }});

//Registers custom item Lightning Stick, handled in items/LightningStick
public static final Item LIGHTNING_STICK = register("lightning_stick", new LightningStick(new Item.Settings()));


//Example of a food item
public static final Item PEAR = register("pear", new Item(new Item.Settings()
        .food(new FoodComponent.Builder()
                .nutrition(4)
                .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 60 * 20, 1), 0.8f)
                .saturationModifier(3)
                .build())));


//Example of a tool/weapon, values relative to material's stats (In this case, GuiditeMaterial stats. Ex attack dmg base is 8.0F=9 + 4 = 13 attack dmg total
public static final Item GUIDITE_SWORD = register("guidite_sword", new SwordItem(GuiditeMaterial.INSTANCE, new Item.Settings()
        .attributeModifiers(SwordItem.createAttributeModifiers(GuiditeMaterial.INSTANCE, 4, -2.4f))));


//Armor item additions, pulls from ModArmorMaterials
public static final Item GUIDITE_HELMET = register("guidite_helmet", new ArmorItem(ModArmorMatierals.GUIDITE, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(ModArmorMatierals.GUIDITE_DURABILITY_MULTIPLIER))));
public static final Item GUIDITE_CHESTPLATE = register("guidite_chestplate", new ArmorItem(ModArmorMatierals.GUIDITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(ModArmorMatierals.GUIDITE_DURABILITY_MULTIPLIER))));
public static final Item GUIDITE_LEGGINGS = register("guidite_leggings", new ArmorItem(ModArmorMatierals.GUIDITE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(ModArmorMatierals.GUIDITE_DURABILITY_MULTIPLIER))));
public static final Item GUIDITE_BOOTS = register("guidite_boots", new ArmorItem(ModArmorMatierals.GUIDITE, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(ModArmorMatierals.GUIDITE_DURABILITY_MULTIPLIER))));



//---------------------------------------------------------------------------------------------------------------------


//Custom Mod Items Group
public static final ItemGroup OAKS_MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(TestMod.MOD_ID, "oaks_mod_items"),
        FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.SUSPICIOUS_SUBSTANCE))
                .displayName(Text.translatable("itemgroup.testmod"))
                .entries(((displayContext, entries) -> {
                    entries.add(ModItems.GUIDITE_BOOTS);
                    entries.add(ModItems.GUIDITE_LEGGINGS);
                    entries.add(ModItems.GUIDITE_CHESTPLATE);
                    entries.add(ModItems.GUIDITE_HELMET);
                    entries.add(ModItems.GUIDITE_SWORD);
                    entries.add(ModItems.LIGHTNING_STICK);
                    entries.add(ModItems.SUSPICIOUS_SUBSTANCE);
                    entries.add(ModItems.PEAR);

                }))
                .build());



//---------------------------------------------------------------------------------------------------------------------



//Initialize Mod Items and register items to vanilla groups
public static void initialize(){
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
        fabricItemGroupEntries.add(SUSPICIOUS_SUBSTANCE);
    });


    ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
        fabricItemGroupEntries.add(PEAR);
    });


    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
        fabricItemGroupEntries.add(GUIDITE_BOOTS);
        fabricItemGroupEntries.add(GUIDITE_LEGGINGS);
        fabricItemGroupEntries.add(GUIDITE_CHESTPLATE);
        fabricItemGroupEntries.add(GUIDITE_HELMET);

        fabricItemGroupEntries.add(GUIDITE_SWORD);
    });


    FuelRegistry.INSTANCE
            .add(ModItems.SUSPICIOUS_SUBSTANCE, 30 * 20);

    CompostingChanceRegistry.INSTANCE
            .add(ModItems.SUSPICIOUS_SUBSTANCE, 0.3f);
    }

}


