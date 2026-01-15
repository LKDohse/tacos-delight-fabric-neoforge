package net.electricbudgie.tacosdelight.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.electricbudgie.tacosdelight.block.custom.*;
import net.electricbudgie.tacosdelight.item.ModFoodComponents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.registry.RegistryKeys;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.BLOCK);

    //Ores
    public static final RegistrySupplier<Block> HALITE = registerBlock("halite", new PillarBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR)));

    //Wild Crops
    //public static final RegistrySupplier<Block> WILD_HOT_PEPPERS = registerBlock("wild_hot_pepper", new WildCropBlock(StatusEffects.WEAKNESS,6, AbstractBlock.Settings.copy(Blocks.TALL_GRASS)));

    //Crops
    public static final RegistrySupplier<Block> BLUE_RASPBERRY_BUSH = registerBlock("blue_raspberry_bush", new BlueRaspberryBushBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final RegistrySupplier<Block> LIME_TREE = registerBlock("lime_tree", new LimeTreeBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final RegistrySupplier<Block> HOT_PEPPER_CROP = registerBlock("hot_pepper_plant", new HotPepperCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    //Feast Blocks
    public static final RegistrySupplier<Block> BEEF_TACO_BOX_BLOCK = registerBlock("beef_taco_box", new TacoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.BEEF, true));
    public static final RegistrySupplier<Block> CHICKEN_TACO_BOX_BLOCK = registerBlock("chicken_taco_box", new TacoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.CHICKEN, true));
    public static final RegistrySupplier<Block> POTATO_TACO_BOX_BLOCK = registerBlock("potato_taco_box", new TacoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.POTATO, true));

    public static final RegistrySupplier<Block> BEEF_BURRITO_BOX_BLOCK = registerBlock("beef_burrito_box", new BurritoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.BEEF, true));
    public static final RegistrySupplier<Block> CHICKEN_BURRITO_BOX_BLOCK = registerBlock("chicken_burrito_box", new BurritoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.CHICKEN, true));
    public static final RegistrySupplier<Block> POTATO_BURRITO_BOX_BLOCK = registerBlock("potato_burrito_box", new BurritoBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.POTATO, true));

    public static final RegistrySupplier<Block> BEEF_CRAVINGS_BOX_BLOCK = registerBlock("beef_cravings_box", new CravingsBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.BEEF, true));
    public static final RegistrySupplier<Block> CHICKEN_CRAVINGS_BOX_BLOCK = registerBlock("chicken_cravings_box", new CravingsBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.CHICKEN, true));
    public static final RegistrySupplier<Block> POTATO_CRAVINGS_BOX_BLOCK = registerBlock("potato_cravings_box", new CravingsBoxBlock(AbstractBlock.Settings.copy(Blocks.CAKE), ModFoodComponents.FillingType.POTATO, true));

    //Entities
    public static final RegistrySupplier<Block> CHEESE_WHEEL_BLOCK = registerBlock("cheese_wheel",
            new CheeseWheelBlock((AbstractBlock.Settings.create().nonOpaque())));
    public static final RegistrySupplier<Block> CHEESE_PRESS_BLOCK = registerBlock("cheese_press",
            new CheesePressBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));

    public static final RegistrySupplier<Block> DEEP_FRYER = registerBlock("deep_fryer", new DeepFryerBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));

    public static void initialize() {
        BLOCKS.register();
    }

    public static RegistrySupplier<Block> registerBlock(String name, Block block) {
        var registeredBlock = BLOCKS.register(name, () -> block);
        return registeredBlock;
    }
}
