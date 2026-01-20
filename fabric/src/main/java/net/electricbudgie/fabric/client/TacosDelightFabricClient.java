package net.electricbudgie.fabric.client;

//import net.electricbudgie.fabric.tacosdelight.ModModelPredicateProvider;
import net.electricbudgie.tacosdelight.client.ModClientTickEvents;
import net.electricbudgie.tacosdelight.block.ModBlocks;
        import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
        import net.minecraft.client.render.RenderLayer;

public final class TacosDelightFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_RASPBERRY_BUSH.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIME_TREE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_HOT_PEPPERS.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOT_PEPPER_CROP.get(), RenderLayer.getCutout());
//        BlockEntityRendererFactories.register(ModBlockEntities.DEEP_FRYER_BE, DeepFryerBlockEntityRenderer::new);
//        BlockEntityRendererFactories.register(ModBlockEntities.CHEESE_PRESS_BE, CheesePressEntityRenderer::new);
        ModClientTickEvents.registerClientTickEvents();
//        ModModelPredicateProvider.registerModelPredicateProviders();
//        ParticleFactoryRegistry.getInstance().register(ModParticles.GASSY_PARTICLE.get(), GassyParticle.Factory::new);
//        HandledScreens.register(ModScreenHandlers.DEEP_FRYER_HANDLER, DeepFryerScreen::new);
    }
}
