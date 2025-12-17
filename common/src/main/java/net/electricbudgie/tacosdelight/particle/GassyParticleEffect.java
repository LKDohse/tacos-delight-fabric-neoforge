package net.electricbudgie.tacosdelight.particle;

import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;

public class GassyParticleEffect implements ParticleEffect {
    @Override
    public ParticleType<?> getType() {
        return ModParticles.GASSY_PARTICLE.get();
    }
}
