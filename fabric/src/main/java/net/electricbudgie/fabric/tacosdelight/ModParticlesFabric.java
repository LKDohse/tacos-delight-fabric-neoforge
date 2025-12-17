package net.electricbudgie.fabric.tacosdelight;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.tacosdelight.particle.ModParticles;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.util.Identifier;

public class ModParticlesFabric {
    public static void register() {
        ModParticles.GASSY_PARTICLE = ModParticles.PARTICLE_TYPES.register(
                Identifier.of(TacosDelight.MOD_ID, "gassy"),
                FabricParticleTypes::simple
        );

    }
}