package net.electricbudgie.neoforge.datagen;

import net.electricbudgie.TacosDelight;
import net.electricbudgie.neoforge.datagen.worldgen.ModBiomeModifiers;
import net.electricbudgie.tacosdelight.world.ModConfiguredFeatures;
import net.electricbudgie.tacosdelight.world.ModPlacedFeatures;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistryBuilder BUILDER = new RegistryBuilder()
            .addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .addRegistry(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModDatapackProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registries) {
        super(output, registries, BUILDER, Set.of(TacosDelight.MOD_ID));
    }
}
