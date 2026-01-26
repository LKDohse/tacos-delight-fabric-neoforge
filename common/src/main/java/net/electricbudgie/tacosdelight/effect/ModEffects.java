package net.electricbudgie.tacosdelight.effect;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryKey<StatusEffect> DISAPPOINTED_KEY =
            RegistryKey.of(RegistryKeys.STATUS_EFFECT,
                    Identifier.of(TacosDelight.MOD_ID, "disappointed"));

    public static final RegistryKey<StatusEffect> GAS_CLOUD_DAMAGE_KEY =
            RegistryKey.of(RegistryKeys.STATUS_EFFECT,
                    Identifier.of(TacosDelight.MOD_ID, "gas_cloud_damage"));

    public static final RegistryKey<StatusEffect> GASSY_KEY =
            RegistryKey.of(RegistryKeys.STATUS_EFFECT,
                    Identifier.of(TacosDelight.MOD_ID, "gassy"));

    public static final RegistryKey<StatusEffect> SPICY_KEY =
            RegistryKey.of(RegistryKeys.STATUS_EFFECT,
                    Identifier.of(TacosDelight.MOD_ID, "spicy"));

    public static final DeferredRegister<StatusEffect> EFFECTS =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.STATUS_EFFECT);

    public static final RegistrySupplier<StatusEffect> DISAPPOINTED = EFFECTS.register(DISAPPOINTED_KEY.getValue().getPath(),
            ()-> new DisappointedEffect(StatusEffectCategory.HARMFUL, 0xbbbfbf)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(TacosDelight.MOD_ID, "disappointed"), -0.20f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistrySupplier<StatusEffect> GAS_CLOUD_DAMAGE = EFFECTS.register(GAS_CLOUD_DAMAGE_KEY.getValue().getPath(),
            () -> new GasCloudDamageEffect(StatusEffectCategory.HARMFUL, 0x7d5011));

    public static final RegistrySupplier<StatusEffect> GASSY = EFFECTS.register(GASSY_KEY.getValue().getPath(),
            () -> new GassyEffect(StatusEffectCategory.HARMFUL, 0x7d5011));

    public static final RegistrySupplier<StatusEffect> SPICY = EFFECTS.register(SPICY_KEY.getValue().getPath(),
            () -> new SpicyEffect(StatusEffectCategory.NEUTRAL, 0x850900)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            Identifier.of(TacosDelight.MOD_ID, "spicy"),
                            2.0f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(TacosDelight.MOD_ID, "spicy"),
                            0.5f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    public static void registerEffects() {
        EFFECTS.register();
        TacosDelight.LOGGER.info("Registering Mod Effects for " + TacosDelight.MOD_ID);
    }
}