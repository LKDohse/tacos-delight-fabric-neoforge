package net.electricbudgie.fabric.tacosdelight.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.electricbudgie.fabric.tacosdelight.block.custom.CheesePressBlock;
import net.electricbudgie.fabric.tacosdelight.block.custom.DeepFryerBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public class FabricModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.BLOCK);

    public static final RegistrySupplier<Block> CHEESE_PRESS_BLOCK = registerBlock("cheese_press", () ->
            new CheesePressBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));

    public static final RegistrySupplier<Block> DEEP_FRYER_BLOCK = registerBlock("deep_fryer", () ->
            new DeepFryerBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));

    public static RegistrySupplier<Block> registerBlock(String name, Supplier<Block> supplier) {
        var registeredBlock = BLOCKS.register(name, supplier);
        return registeredBlock;
    }

    public static void initialize() {
        BLOCKS.register();
    }
}
