package net.electricbudgie.tacosdelight.registry;

import net.electricbudgie.TacosDelight;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageSources {
    public static final RegistryKey<DamageType> BLUE_RASPBERRY_BUSH =
            RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(TacosDelight.MOD_ID, "blue_raspberry"));

    public static final RegistryKey<DamageType> GAS_CLOUD =
            RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(TacosDelight.MOD_ID, "gas_cloud"));

}
