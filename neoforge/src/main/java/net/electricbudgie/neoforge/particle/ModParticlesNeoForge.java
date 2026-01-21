package net.electricbudgie.neoforge.particle;


import net.electricbudgie.tacosdelight.particle.ModParticles;
import net.minecraft.particle.SimpleParticleType;

public class ModParticlesNeoForge {
    public static void register() {
        ModParticles.GASSY_PARTICLE = ModParticles.PARTICLE_TYPES.register(
                "gassy", () -> new SimpleParticleType(false) // works in NeoForge
        );
    }
}