package net.electricbudgie.fabric.tacosdelight.block.entity.renderer.client;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.fabric.tacosdelight.block.entity.custom.DeepFryerBlockEntityFabric;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class DeepFryerModel extends GeoModel<DeepFryerBlockEntityFabric> {


    @Override
    public Identifier getModelResource(DeepFryerBlockEntityFabric deepFryerBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "geo/deep_fryer_model.geo.json");
    }

    @Override
    public Identifier getTextureResource(DeepFryerBlockEntityFabric deepFryerBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "textures/block/entity/deep_fryer.png");
    }

    @Override
    public Identifier getAnimationResource(DeepFryerBlockEntityFabric deepFryerBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "animations/deep_fryer_model.animation.json");
    }
}