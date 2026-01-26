package net.electricbudgie.fabric.tacosdelight.block.entity.renderer.client;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.fabric.tacosdelight.block.entity.custom.CheesePressBlockEntityFabric;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CheesePressModel extends GeoModel<CheesePressBlockEntityFabric> {

    @Override
    public Identifier getModelResource(CheesePressBlockEntityFabric cheesePressBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "geo/cheese_press_model.geo.json");
    }

    @Override
    public Identifier getTextureResource(CheesePressBlockEntityFabric cheesePressBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "textures/block/entity/cheese_press.png");
    }

    @Override
    public Identifier getAnimationResource(CheesePressBlockEntityFabric cheesePressBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "animations/cheese_press_model.animation.json");
    }

}