package net.electricbudgie.tacosdelight.effect;

import dev.architectury.registry.registries.DeferredRegister;
import net.electricbudgie.TacosDelight;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final DeferredRegister<StatusEffect> EFFECTS =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.STATUS_EFFECT);

    public static final RegistryEntry<StatusEffect> DISAPPOINTED = EFFECTS.register("disappointed",
            () -> new DisappointedEffect(StatusEffectCategory.HARMFUL, 0xbbbfbf)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(TacosDelight.MOD_ID, "disappointed"), -0.20f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> GAS_CLOUD_DAMAGE = EFFECTS.register("gas_cloud_damage",
            () -> new GasCloudDamageEffect(StatusEffectCategory.HARMFUL, 0x7d5011));

    public static final RegistryEntry<StatusEffect> GASSY = EFFECTS.register("gassy",
            () -> new GassyEffect(StatusEffectCategory.HARMFUL, 0x7d5011));

    public static final RegistryEntry<StatusEffect> SPICY = EFFECTS.register("spicy",
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