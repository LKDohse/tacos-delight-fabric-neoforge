package net.electricbudgie.tacosdelight.tags;

import net.electricbudgie.TacosDelight;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModTags {
    public static final TagKey<Biome> IS_TROPICAL = createBiomeTag("is_tropical");
    public static final TagKey<Biome> IS_SNOWY = createBiomeTag("is_snowy");
    public static final TagKey<Biome> IS_WARM = createBiomeTag("is_warm");
    public static final TagKey<Biome> IS_COOL = createBiomeTag("is_cool");

    public static final TagKey<Item> FD_KNIVES = createItemTag("fd_knives");

    private static TagKey<Biome> createBiomeTag(String name){
        return TagKey.of(RegistryKeys.BIOME, Identifier.of(TacosDelight.MOD_ID, name));
    }

    private static TagKey<Item> createItemTag(String name){
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(TacosDelight.MOD_ID, name));
    }

}
