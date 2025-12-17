package net.electricbudgie.neoforge;

import net.electricbudgie.tacosdelight.particle.ModParticles;
import net.neoforged.fml.common.Mod;

import net.electricbudgie.TacosDelight;

@Mod(TacosDelight.MOD_ID)
public final class TacosDelightNeoForge {
    public TacosDelightNeoForge() {
        // Run our common setup.
        TacosDelight.init();

        ModParticlesNeoForge.register();
        ModParticles.initialize();
    }
}
