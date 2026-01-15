package net.electricbudgie.tacosdelight.recipe;

import dev.architectury.registry.registries.DeferredRegister;
import net.electricbudgie.TacosDelight;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.RECIPE_SERIALIZER);

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.RECIPE_TYPE);

    public static final RegistryEntry<RecipeSerializer<DeepFryerRecipe>> DEEP_FRYER_SERIALIZER = RECIPE_SERIALIZERS.register(
            Identifier.of(TacosDelight.MOD_ID, "deepfrying"),
            DeepFryerRecipe.Serializer::new);

    public static final RegistryEntry<RecipeType<DeepFryerRecipe>> DEEP_FRYER_RECIPE_TYPE = RECIPE_TYPES.register(
            Identifier.of(TacosDelight.MOD_ID, "deepfrying"),
            () -> new RecipeType<DeepFryerRecipe>() {
                @Override
                public String toString(){
                    return "tacosdelight:deepfrying";
                }
            });

    public static void initialize(){
        RECIPE_SERIALIZERS.register();
        RECIPE_TYPES.register();
        TacosDelight.LOGGER.info("Registering custom recipe types for {}", TacosDelight.MOD_ID);
    }
}
