package net.electricbudgie.fabric;

import net.electricbudgie.fabric.tacosdelight.ModParticlesFabric;
import net.electricbudgie.fabric.tacosdelight.datagen.worldgen.ModWorldGeneration;
import net.electricbudgie.tacosdelight.particle.ModParticles;
import net.fabricmc.api.ModInitializer;

import net.electricbudgie.TacosDelight;

public final class TacosDelightFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        TacosDelight.init();

        ModParticlesFabric.register();
        ModParticles.initialize();
        ModWorldGeneration.generateModWorldGeneration();
        TacosDelight.LOGGER.info("Initializing Fabric implementation of Tacos Delight!");
    }
}
