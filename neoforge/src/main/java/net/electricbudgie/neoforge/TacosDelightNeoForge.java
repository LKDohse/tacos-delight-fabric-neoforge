package net.electricbudgie.neoforge;

import net.neoforged.fml.common.Mod;

@Mod("tacosdelight")
public final class TacosDelightNeoForge {

    public TacosDelightNeoForge() {
        // Run our common setup.
        net.electricbudgie.TacosDelight.init();

       // ModParticlesNeoForge.register();
        //ModParticles.initialize();
    }
}
