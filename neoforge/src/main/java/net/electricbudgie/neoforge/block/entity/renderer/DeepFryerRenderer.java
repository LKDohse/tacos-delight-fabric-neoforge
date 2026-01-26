package net.electricbudgie.neoforge.block.entity.renderer;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.neoforge.block.entity.custom.DeepFryerBlockEntityNeoForge;
import net.electricbudgie.neoforge.block.entity.renderer.model.DeepFryerModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DeepFryerRenderer extends GeoBlockRenderer<DeepFryerBlockEntityNeoForge> {
    public DeepFryerRenderer(BlockEntityRendererFactory.Context context) {
        super(new DeepFryerModel());
    }

    @Override
    public @Nullable RenderLayer getRenderType(DeepFryerBlockEntityNeoForge animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {
        return RenderLayer.getEntityTranslucentCull(Identifier.of(TacosDelight.MOD_ID, "textures/block/entity/deep_fryer.png"));
    }
}
