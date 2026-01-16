package net.electricbudgie.neoforge;

import net.electricbudgie.neoforge.datagen.DataGenerators;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod("tacosdelight")
public final class TacosDelightNeoForge {

    public TacosDelightNeoForge(IEventBus modBus) {
        modBus.addListener(this::gatherData);
        // Run our common setup.

        net.electricbudgie.TacosDelight.init();

       // ModParticlesNeoForge.register();
        //ModParticles.initialize();


    }
    private void gatherData(final GatherDataEvent event) {
        DataGenerators.gatherData(event);
    }
}
