package net.electricbudgie.neoforge;

import net.electricbudgie.neoforge.block.NeoForgeModBlocks;
import net.electricbudgie.neoforge.block.entity.NeoForgeModBlockEntities;
import net.electricbudgie.neoforge.data.DataGenerators;
import net.electricbudgie.neoforge.item.NeoForgeModItems;
import net.electricbudgie.neoforge.menu.NeoForgeModScreenHandlers;
import net.electricbudgie.neoforge.particle.ModParticlesNeoForge;
import net.electricbudgie.tacosdelight.particle.ModParticles;
import net.electricbudgie.tacosdelight.registry.ModCreativeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod("tacosdelight")
public final class TacosDelightNeoForge {

    public TacosDelightNeoForge(IEventBus modBus) {
        modBus.addListener(this::gatherData);
        // Run our common setup.
        net.electricbudgie.TacosDelight.init();

        NeoForgeModBlocks.initialize();
        NeoForgeModBlockEntities.init();
        NeoForgeModItems.initialize();
        ModParticlesNeoForge.register();
        ModParticles.initialize();
        NeoForgeModScreenHandlers.register(modBus);

        modBus.addListener(this::addCreativeTabEntries);

    }
    private void gatherData(final GatherDataEvent event) {
        DataGenerators.gatherData(event);
    }

    public void addCreativeTabEntries(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey() == ModCreativeTabs.TACOS_DELIGHT_TAB_KEY) {
            event.add(NeoForgeModItems.CHEESE_PRESS_ITEM.get());
            event.add(NeoForgeModItems.DEEP_FRYER_ITEM.get());
        }
    }
}
