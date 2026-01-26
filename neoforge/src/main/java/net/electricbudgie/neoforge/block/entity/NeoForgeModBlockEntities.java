package net.electricbudgie.neoforge.block.entity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.electricbudgie.neoforge.block.NeoForgeModBlocks;
import net.electricbudgie.neoforge.block.entity.custom.CheesePressBlockEntityNeoForge;
import net.electricbudgie.neoforge.block.entity.custom.DeepFryerBlockEntityNeoForge;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;

public class NeoForgeModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<CheesePressBlockEntityNeoForge>> CHEESE_PRESS_BE =
            BLOCK_ENTITIES.register("cheese_press",
                    ()-> BlockEntityType.Builder.create(CheesePressBlockEntityNeoForge::new,
                            NeoForgeModBlocks.CHEESE_PRESS_BLOCK.get()).build(null));

    public static final RegistrySupplier<BlockEntityType<DeepFryerBlockEntityNeoForge>> DEEP_FRYER_BE =
            BLOCK_ENTITIES.register("deep_fryer",
                    ()-> BlockEntityType.Builder.create(DeepFryerBlockEntityNeoForge::new,
                            NeoForgeModBlocks.DEEP_FRYER_BLOCK.get()).build(null));

    public static void init() {
        BLOCK_ENTITIES.register();
    }
}
