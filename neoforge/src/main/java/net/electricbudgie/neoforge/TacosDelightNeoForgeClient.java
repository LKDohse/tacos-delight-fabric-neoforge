package net.electricbudgie.neoforge;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.neoforge.block.entity.NeoForgeModBlockEntities;
import net.electricbudgie.neoforge.block.entity.renderer.CheesePressEntityRenderer;
import net.electricbudgie.neoforge.block.entity.renderer.DeepFryerRenderer;
import net.electricbudgie.neoforge.menu.NeoForgeModScreenHandlers;
import net.electricbudgie.neoforge.menu.custom.DeepFryerScreen;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.client.ModClientTickEvents;
import net.electricbudgie.tacosdelight.components.ModComponents;
import net.electricbudgie.tacosdelight.particle.GassyParticle;
import net.electricbudgie.tacosdelight.particle.ModParticles;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@Mod(value = TacosDelight.MOD_ID, dist = Dist.CLIENT)
public class TacosDelightNeoForgeClient {
    public TacosDelightNeoForgeClient(IEventBus modBus) {
        modBus.addListener(this::onClientSetup);
        modBus.addListener(this::registerParticleFactories);
        modBus.addListener(this::registerRenderers);
        modBus.addListener(this::registerScreens);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(ModClientTickEvents::registerClientTickEvents);
        event.enqueueWork(TacosDelightNeoForgeClient::registerModelPredicateProviders);
    }

    public void registerParticleFactories(RegisterParticleProvidersEvent event){
        event.registerSpriteSet(ModParticles.GASSY_PARTICLE.get(), GassyParticle.Factory::new);
    }

    public static void registerModelPredicateProviders() {
        TacosDelight.LOGGER.info("Registering model predicates for cheese wheel!");
        ModelPredicateProviderRegistry.register(
                ModBlocks.CHEESE_WHEEL_BLOCK.get().asItem(),
                Identifier.of(TacosDelight.MOD_ID, "age"),
                (itemStack, clientWorld, livingEntity, seed) -> {
                    Integer age = itemStack.get(ModComponents.AGE_COMPONENT.get());
                    if (age == null) return 0.0f;
                    return switch (age) {
                        case 0 -> 0.0f;
                        case 1 -> 0.5f;
                        case 2 -> 1.0f;
                        default -> 0.0f;
                    };
                }
        );
    }

    public void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(
                NeoForgeModBlockEntities.CHEESE_PRESS_BE.get(),
                CheesePressEntityRenderer::new
        );

        event.registerBlockEntityRenderer(
                NeoForgeModBlockEntities.DEEP_FRYER_BE.get(),
                DeepFryerRenderer::new
        );
    }

    public void registerScreens(RegisterMenuScreensEvent event){
        event.register(NeoForgeModScreenHandlers.DEEP_FRYER_HANDLER.get(), DeepFryerScreen::new);
    }
}
