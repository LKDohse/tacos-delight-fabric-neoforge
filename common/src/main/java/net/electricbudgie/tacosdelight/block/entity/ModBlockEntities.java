package net.electricbudgie.tacosdelight.block.entity;

import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.block.entity.custom.CheesePressBlockEntity;
import net.electricbudgie.tacosdelight.block.entity.custom.CheeseWheelBlockEntity;
import net.electricbudgie.tacosdelight.block.entity.custom.DeepFryerBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
    DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<DeepFryerBlockEntity>> DEEP_FRYER_BE =
            BLOCK_ENTITIES.register("deep_fryer",
                    ()-> BlockEntityType.Builder.create(DeepFryerBlockEntity::new,
                            ModBlocks.DEEP_FRYER.get()).build(null));

    public static final RegistrySupplier<BlockEntityType<CheesePressBlockEntity>> CHEESE_PRESS_BE =
            BLOCK_ENTITIES.register("cheese_press",
                    ()-> BlockEntityType.Builder.create(CheesePressBlockEntity::new,
        ModBlocks.CHEESE_PRESS_BLOCK.get()).build(null));

    public static final RegistrySupplier<BlockEntityType<CheeseWheelBlockEntity>> CHEESE_WHEEL_BE =
            BLOCK_ENTITIES.register("cheese_wheel",
                    () -> BlockEntityType.Builder.create(CheeseWheelBlockEntity::new,
                            ModBlocks.CHEESE_WHEEL_BLOCK.get()).build(null));

    public static void initialize(){
        BLOCK_ENTITIES.register();
    }
}
