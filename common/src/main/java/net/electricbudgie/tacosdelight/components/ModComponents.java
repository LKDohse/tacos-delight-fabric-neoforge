package net.electricbudgie.tacosdelight.components;

import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModComponents {
    public static final DeferredRegister<ComponentType<?>> COMPONENTS =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.DATA_COMPONENT_TYPE);


    public static final RegistrySupplier<ComponentType<Integer>> AGE_COMPONENT =
            COMPONENTS.register(Identifier.of(TacosDelight.MOD_ID, "age"),
                    () -> ComponentType.<Integer>builder()
                            .codec(Codec.INT)
                            .build()
            );

    public static void initialize(){
        COMPONENTS.register();
        TacosDelight.LOGGER.info("Registering components for ", TacosDelight.MOD_ID);
    }
}
