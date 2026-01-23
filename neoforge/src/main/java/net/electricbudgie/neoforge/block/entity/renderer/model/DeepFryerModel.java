package net.electricbudgie.neoforge.block.entity.renderer.model;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.neoforge.block.entity.custom.DeepFryerBlockEntityNeoForge;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class DeepFryerModel extends GeoModel<DeepFryerBlockEntityNeoForge> {

    @Override
    public Identifier getModelResource(DeepFryerBlockEntityNeoForge deepFryerBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "geo/deep_fryer_model.geo.json");
    }

    @Override
    public Identifier getTextureResource(DeepFryerBlockEntityNeoForge deepFryerBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "textures/block/entity/deep_fryer.png");
    }

    @Override
    public Identifier getAnimationResource(DeepFryerBlockEntityNeoForge deepFryerBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "animations/deep_fryer_model.animation.json");
    }
}
