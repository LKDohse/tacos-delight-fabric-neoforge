package net.electricbudgie;

import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.block.entity.ModBlockEntities;
import net.electricbudgie.tacosdelight.components.ModComponents;
import net.electricbudgie.tacosdelight.effect.ModEffects;
import net.electricbudgie.tacosdelight.item.ModItems;
import net.electricbudgie.tacosdelight.registry.ModCreativeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TacosDelight {
    public static final String MOD_ID = "tacosdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static void init() {
        ModComponents.initialize();
        ModCreativeTabs.initTabs();
        ModEffects.registerEffects();
        ModBlocks.initialize();
        ModBlockEntities.initialize();
        ModItems.initialize();
        // Write common init code here.
    }
}
