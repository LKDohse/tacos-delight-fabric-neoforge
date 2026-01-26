package net.electricbudgie.fabric.tacosdelight.block.entity.renderer;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.fabric.tacosdelight.block.entity.custom.DeepFryerBlockEntityFabric;
import net.electricbudgie.fabric.tacosdelight.block.entity.renderer.client.DeepFryerModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DeepFryerBlockEntityRenderer extends GeoBlockRenderer<DeepFryerBlockEntityFabric> {
    public DeepFryerBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        super(new DeepFryerModel());
    }

    @Override
    public @Nullable RenderLayer getRenderType(DeepFryerBlockEntityFabric animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {
        return RenderLayer.getEntityTranslucentCull(Identifier.of(TacosDelight.MOD_ID, "textures/block/entity/deep_fryer.png"));
    }
}

