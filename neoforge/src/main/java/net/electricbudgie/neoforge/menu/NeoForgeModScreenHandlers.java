package net.electricbudgie.neoforge.menu;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.electricbudgie.TacosDelight;
import net.electricbudgie.neoforge.menu.custom.DeepFryerScreenHandler;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;

public class NeoForgeModScreenHandlers {
    public static final DeferredRegister<ScreenHandlerType<?>> MENUS =
            DeferredRegister.create(RegistryKeys.SCREEN_HANDLER, TacosDelight.MOD_ID);

    public static final DeferredHolder<ScreenHandlerType<?>, ScreenHandlerType<DeepFryerScreenHandler>> DEEP_FRYER_HANDLER =
        registerMenuType("deep_fryer_menu", DeepFryerScreenHandler::new);

    private static <T extends ScreenHandler>
    DeferredHolder<ScreenHandlerType<?>, ScreenHandlerType<T>>
    registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
        TacosDelight.LOGGER.info("Registering screen handlers for " + TacosDelight.MOD_ID);
    }

}
