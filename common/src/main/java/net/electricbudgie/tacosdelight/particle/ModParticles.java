package net.electricbudgie.tacosdelight.particle;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.RegistryKeys;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.PARTICLE_TYPE);

    public static RegistrySupplier<ParticleType<?>> GASSY_PARTICLE;

    public static void initialize(){
        PARTICLE_TYPES.register();
        TacosDelight.LOGGER.info("Registering particles for {}", TacosDelight.MOD_ID);

    }
}
