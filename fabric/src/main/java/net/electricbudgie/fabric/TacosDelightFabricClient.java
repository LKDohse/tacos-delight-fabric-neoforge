package net.electricbudgie.fabric;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.fabric.tacosdelight.block.entity.FabricModBlockEntities;
import net.electricbudgie.fabric.tacosdelight.block.entity.renderer.CheesePressEntityRenderer;
import net.electricbudgie.fabric.tacosdelight.block.entity.renderer.DeepFryerBlockEntityRenderer;
import net.electricbudgie.fabric.tacosdelight.screen.FabricModScreenHandlers;
import net.electricbudgie.fabric.tacosdelight.screen.custom.DeepFryerScreen;
import net.electricbudgie.tacosdelight.client.ModClientTickEvents;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.components.ModComponents;
import net.electricbudgie.tacosdelight.particle.GassyParticle;
import net.electricbudgie.tacosdelight.particle.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;

public final class TacosDelightFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.

        registerModelPredicateProviders();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_RASPBERRY_BUSH.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIME_TREE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_HOT_PEPPERS.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOT_PEPPER_CROP.get(), RenderLayer.getCutout());
        BlockEntityRendererFactories.register(FabricModBlockEntities.DEEP_FRYER_BE.get(), DeepFryerBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(FabricModBlockEntities.CHEESE_PRESS_BE.get(), CheesePressEntityRenderer::new);
            ModClientTickEvents.registerClientTickEvents();
            ParticleFactoryRegistry.getInstance().register(ModParticles.GASSY_PARTICLE.get(), GassyParticle.Factory::new);
       HandledScreens.register(FabricModScreenHandlers.DEEP_FRYER_HANDLER, DeepFryerScreen::new);


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
}
