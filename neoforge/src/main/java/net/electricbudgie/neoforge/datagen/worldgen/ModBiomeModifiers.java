package net.electricbudgie.neoforge.datagen.worldgen;

import net.electricbudgie.TacosDelight;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {

    public static void bootstrap(Registerable<BiomeModifier> context) {
        var placedFeatures = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        var biomes = context.getRegistryLookup(RegistryKeys.BIOME);

    }

    public static RegistryKey<BiomeModifier> registerKey(String name) {
        return RegistryKey.of(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.of(TacosDelight.MOD_ID, name));
    }
}
