package net.electricbudgie.neoforge.block.entity.renderer.model;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.neoforge.block.entity.custom.CheesePressBlockEntityNeoForge;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CheesePressModel extends GeoModel<CheesePressBlockEntityNeoForge> {

    @Override
    public Identifier getModelResource(CheesePressBlockEntityNeoForge cheesePressBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "geo/cheese_press_model.geo.json");
    }

    @Override
    public Identifier getTextureResource(CheesePressBlockEntityNeoForge cheesePressBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "textures/block/entity/cheese_press.png");
    }

    @Override
    public Identifier getAnimationResource(CheesePressBlockEntityNeoForge cheesePressBlockEntity) {
        return Identifier.of(TacosDelight.MOD_ID, "animations/cheese_press_model.animation.json");
    }

}