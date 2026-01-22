package net.electricbudgie.fabric.tacosdelight.block.entity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.electricbudgie.fabric.tacosdelight.block.FabricBlocks;
import net.electricbudgie.fabric.tacosdelight.block.entity.custom.CheesePressBlockEntityFabric;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;

public class FabricModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<CheesePressBlockEntityFabric>> CHEESE_PRESS_BE =
            BLOCK_ENTITIES.register("cheese_press",
                    ()-> BlockEntityType.Builder.create(CheesePressBlockEntityFabric::new,
                            FabricBlocks.CHEESE_PRESS_BLOCK.get()).build(null));

    public static void init() {
        BLOCK_ENTITIES.register();
    }
}
