package net.electricbudgie.neoforge;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.tacosdelight.client.ModClientTickEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = TacosDelight.MOD_ID, dist = Dist.CLIENT)
public class TacosDelightNeoForgeClient {
    public TacosDelightNeoForgeClient(IEventBus modBus) {
        modBus.addListener(this::onClientSetup);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(ModClientTickEvents::registerClientTickEvents);
    }
}
