package net.oakstheawesome.testmod.enchantment.effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record LightningEnchantmentEffect(EnchantmentLevelBasedValue amount) implements EnchantmentEntityEffect {

    public static final MapCodec<LightningEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(lightningEnchantmentEffectInstance ->
            lightningEnchantmentEffectInstance.group(
                    EnchantmentLevelBasedValue.CODEC.fieldOf("amount").forGetter(LightningEnchantmentEffect::amount)
            ).apply(lightningEnchantmentEffectInstance, LightningEnchantmentEffect::new)
    );

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (level == 1) {
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }
        if (level == 2) {
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }

        if (level == 3) {
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
