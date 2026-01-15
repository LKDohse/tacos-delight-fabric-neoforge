package net.electricbudgie;

import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.components.ModComponents;
import net.electricbudgie.tacosdelight.item.ModItems;
import net.electricbudgie.tacosdelight.registry.ModCreativeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TacosDelight {
    public static final String MOD_ID = "tacos-delight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static void init() {
        ModCreativeTabs.initTabs();
        ModComponents.initialize();
        //ModEffects.registerEffects();
        ModBlocks.initialize();
        ModItems.initialize();
        // Write common init code here.
    }
}
