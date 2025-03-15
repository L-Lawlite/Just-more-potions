package net.lawliet.jm_potions.entity.effects;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class DenationMobEffect extends MobEffect {
    protected final float explosionRadius = 2.0F;
    private static final ParticleOptions effectParticle = ParticleTypes.SMOKE;

    public DenationMobEffect(MobEffectCategory category, int color) {
        super(category, color, effectParticle);
    }

    @Override
    public void onMobRemoved(ServerLevel level, LivingEntity entity, int amplifier, Entity.RemovalReason removalReason) {
        if (removalReason == Entity.RemovalReason.KILLED) {
            level.explode(entity,entity.getX(),entity.getY(),entity.getZ(), this.explosionRadius * (amplifier + 1), Level.ExplosionInteraction.NONE);
        }
    }
}
