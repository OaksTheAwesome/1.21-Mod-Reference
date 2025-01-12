package net.oakstheawesome.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.oakstheawesome.testmod.ModEnchantmentEffects;
import net.oakstheawesome.testmod.ModItems;
import net.oakstheawesome.testmod.enchantment.effect.LightningEnchantmentEffect;
import net.oakstheawesome.testmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class EnchantmentGenerator extends FabricDynamicRegistryProvider {
    public EnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
        System.out.println("REGISTERING ENCHANTS");
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        register(entries, ModEnchantmentEffects.THUNDERING, Enchantment.builder(
                Enchantment.definition(
                        registries.getWrapperOrThrow(RegistryKeys.ITEM).getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        registries.getWrapperOrThrow(RegistryKeys.ITEM).getOrThrow(ModTags.Items.MOD_ENCHANTABLE_ITEMS_SWORD),
                        10,
                        3,
                        Enchantment.leveledCost(1, 10),
                        Enchantment.leveledCost(1, 15),
                        5,
                        AttributeModifierSlot.MAINHAND
                )
        )
                .addEffect(
                        EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM,
                        new LightningEnchantmentEffect(EnchantmentLevelBasedValue.linear(0.4f, 0.2f))
                )
        );


    }

    private void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.getValue()), resourceConditions);
    }

    @Override
    public String getName() {
        return "TestModEnchantmentGenerator";
    }
}
