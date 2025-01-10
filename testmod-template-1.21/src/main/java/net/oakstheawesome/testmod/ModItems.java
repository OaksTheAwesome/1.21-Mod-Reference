package net.oakstheawesome.testmod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;


//Registration method
public class ModItems {
    public static Item register(String id, Item item) {
        Identifier itemID = Identifier.of(TestMod.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return  registeredItem;
    }


//Add Mod Items here
public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", new Item(new Item.Settings()
    .rarity(Rarity.UNCOMMON)) {
    //Adds a tooltip to the item
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.testmod.suspicious_substance.tooltip").formatted(Formatting.LIGHT_PURPLE));
        super.appendTooltip(stack, context, tooltip, type);
    }}); //Add next item beyond this point

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



//Initialize Mod Items and register items to groups
public static void initialize(){
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                    .register(fabricItemGroupEntries -> fabricItemGroupEntries
                            .add(ModItems.SUSPICIOUS_SUBSTANCE));

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                    .register(fabricItemGroupEntries -> fabricItemGroupEntries
                            .add(ModItems.PEAR));

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                    .register(fabricItemGroupEntries -> fabricItemGroupEntries
                            .add(ModItems.GUIDITE_SWORD));

    FuelRegistry.INSTANCE
            .add(ModItems.SUSPICIOUS_SUBSTANCE, 30 * 20);

    CompostingChanceRegistry.INSTANCE
            .add(ModItems.SUSPICIOUS_SUBSTANCE, 0.3f);
    }

}


