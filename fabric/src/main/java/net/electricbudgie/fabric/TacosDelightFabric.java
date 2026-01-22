package net.electricbudgie.fabric;

import net.electricbudgie.fabric.tacosdelight.ModParticlesFabric;
import net.electricbudgie.fabric.tacosdelight.block.FabricBlocks;
import net.electricbudgie.fabric.tacosdelight.block.entity.FabricModBlockEntities;
import net.electricbudgie.fabric.tacosdelight.item.FabricModItems;
import net.electricbudgie.fabric.tacosdelight.world.gen.ModWorldGeneration;
import net.electricbudgie.tacosdelight.particle.ModParticles;
import net.electricbudgie.tacosdelight.registry.ModCreativeTabs;
import net.fabricmc.api.ModInitializer;

import net.electricbudgie.TacosDelight;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public final class TacosDelightFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        TacosDelight.init();

        // Fabric-specific Setup
        FabricBlocks.initialize();
        FabricModBlockEntities.init();
        FabricModItems.initialize();

        addCreativeTabEntries();
        ModParticlesFabric.register();
        ModParticles.initialize();
        ModWorldGeneration.generateModWorldGeneration();
        TacosDelight.LOGGER.info("Initializing Fabric implementation of Tacos Delight!");
    }

    public void addCreativeTabEntries(){
        ItemGroupEvents.modifyEntriesEvent(ModCreativeTabs.TACOS_DELIGHT_TAB_KEY)
                .register(entries -> {
                   entries.add(FabricModItems.CHEESE_PRESS_ITEM.get());
                });
    }
}
