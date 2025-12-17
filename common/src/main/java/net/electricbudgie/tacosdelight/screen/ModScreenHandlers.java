package net.electricbudgie.tacosdelight.screen;

import dev.architectury.registry.menu.MenuRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final DeferredRegister<ScreenHandlerType<?>> SCREEN_HANDLERS =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.SCREEN_HANDLER);

    public static final RegistrySupplier<ScreenHandlerType<DeepFryerScreenHandler>> DEEP_FRYER_SCREEN_HANDLER =
            SCREEN_HANDLERS.register(Identifier.of(TacosDelight.MOD_ID, "deep_fryer_screen_handler"),
                    () -> MenuRegistry.ofExtended(DeepFryerScreenHandler::new));

    public static void registerScreenHandlers() {
        TacosDelight.LOGGER.info("Registering screen handlers for " + TacosDelight.MOD_ID);
        SCREEN_HANDLERS.register();
    }
}
