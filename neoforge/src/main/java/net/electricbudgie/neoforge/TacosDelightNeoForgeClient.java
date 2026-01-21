package net.electricbudgie.neoforge;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.tacosdelight.client.ModClientTickEvents;
import net.electricbudgie.tacosdelight.particle.GassyParticle;
import net.electricbudgie.tacosdelight.particle.ModParticles;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@Mod(value = TacosDelight.MOD_ID, dist = Dist.CLIENT)
public class TacosDelightNeoForgeClient {
    public TacosDelightNeoForgeClient(IEventBus modBus) {
        modBus.addListener(this::onClientSetup);
        modBus.addListener(this::registerParticleFactories);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(ModClientTickEvents::registerClientTickEvents);
    }

    public void registerParticleFactories(RegisterParticleProvidersEvent event){
        event.registerSpriteSet(ModParticles.GASSY_PARTICLE.get(), GassyParticle.Factory::new);
    }
}
