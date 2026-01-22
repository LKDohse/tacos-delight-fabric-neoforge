package net.electricbudgie.tacosdelight.block.entity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.block.entity.custom.CheeseWheelBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
    DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<CheeseWheelBlockEntity>> CHEESE_WHEEL_BE =
            BLOCK_ENTITIES.register("cheese_wheel",
                    () -> BlockEntityType.Builder.create(CheeseWheelBlockEntity::new,
                            ModBlocks.CHEESE_WHEEL_BLOCK.get()).build(null));

    public static void initialize(){
        BLOCK_ENTITIES.register();
        TacosDelight.LOGGER.info("Registering block entities for {}", TacosDelight.MOD_ID);
    }
}
