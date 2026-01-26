package net.electricbudgie.fabric.tacosdelight.datagen;

import net.electricbudgie.fabric.tacosdelight.block.FabricModBlocks;
import net.electricbudgie.fabric.tacosdelight.datagen.custom.recipe.CustomFabricRecipeProvider;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModRecipeProvider extends CustomFabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        Map<Item, Item> fillingWithRollup = Map.of(
                Items.COOKED_BEEF, ModItems.UNCOOKED_STEAK_TAQUITO.get(),
                ModItems.TACO_CHICKEN.get(), ModItems.UNCOOKED_CHICKEN_TAQUITO.get(),
                ModItems.FRIED_FIESTA_POTATOES.get(), ModItems.UNCOOKED_CHEESY_POTATO_GRILLER.get()
        );

        Map<Item, Item> fillingWithTaco = Map.of(
                ModItems.TACO_BEEF.get(), ModItems.BEEF_TACO.get(),
                ModItems.TACO_CHICKEN.get(), ModItems.CHICKEN_TACO.get(),
                ModItems.FRIED_FIESTA_POTATOES.get(), ModItems.POTATO_TACO.get()
        );

        Map<Item, Item> fillingWithBurrito = Map.of(
                ModItems.TACO_BEEF.get(), ModItems.BEEF_BURRITO.get(),
                ModItems.TACO_CHICKEN.get(), ModItems.CHICKEN_BURRITO.get(),
                ModItems.FRIED_FIESTA_POTATOES.get(), ModItems.POTATO_BURRITO.get()
        );

        Map<Item, Item> fillingWithQuesadilla = Map.of(
                ModItems.TACO_BEEF.get(), ModItems.UNCOOKED_BEEF_QUESADILLA.get(),
                ModItems.TACO_CHICKEN.get(), ModItems.UNCOOKED_CHICKEN_QUESADILLA.get(),
                ModItems.FRIED_FIESTA_POTATOES.get(), ModItems.UNCOOKED_POTATO_QUESADILLA.get(),
                ModItems.SHREDDED_CHEESE.get(), ModItems.UNCOOKED_CHEESE_QUESADILLA.get()
        );

        Map<Item, Item> fillingWithCrunchwrap = Map.of(
                ModItems.TACO_BEEF.get(), ModItems.UNCOOKED_BEEF_CRUNCHWRAP.get(),
                ModItems.TACO_CHICKEN.get(), ModItems.UNCOOKED_CHICKEN_CRUNCHWRAP.get(),
                ModItems.FRIED_FIESTA_POTATOES.get(), ModItems.UNCOOKED_POTATO_CRUNCHWRAP.get()
        );

        generateRecipes(fillingWithRollup,
                (filling, result) -> generateRollupRecipe(filling, result).offerTo(recipeExporter));

        generateRecipes(fillingWithTaco,
                (filling, result) -> generateTacoRecipe(filling, result).offerTo(recipeExporter));

        generateRecipes(fillingWithBurrito,
                (filling, result) -> generateBurritoRecipe(filling, result).offerTo(recipeExporter));

        generateRecipes(fillingWithQuesadilla,
                (filling, result) -> generateQuesadillaRecipe(filling, result).offerTo(recipeExporter));

        generateRecipes(fillingWithCrunchwrap,
                (filling, result) -> generateCrunchwrapRecipe(filling, result).offerTo(recipeExporter));


        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 400, ModItems.TORTILLA_DOUGH.get(), ModItems.FLOUR_TORTILLA.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 400, ModItems.UNCOOKED_CHEESE_QUESADILLA.get(), ModItems.CHEESE_QUESADILLA.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 400, ModItems.UNCOOKED_POTATO_QUESADILLA.get(), ModItems.POTATO_QUESADILLA.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 400, ModItems.UNCOOKED_CHICKEN_QUESADILLA.get(), ModItems.CHICKEN_QUESADILLA.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 400, ModItems.UNCOOKED_BEEF_QUESADILLA.get(), ModItems.BEEF_QUESADILLA.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 400, ModItems.UNCOOKED_POTATO_CRUNCHWRAP.get(), ModItems.POTATO_CRUNCHWRAP.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 400, ModItems.UNCOOKED_BEEF_CRUNCHWRAP.get(), ModItems.BEEF_CRUNCHWRAP.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 400, ModItems.UNCOOKED_CHICKEN_CRUNCHWRAP.get(), ModItems.CHICKEN_CRUNCHWRAP.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 600, ModItems.RAW_TACO_BEEF.get(), ModItems.TACO_BEEF.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 600, ModItems.RAW_TACO_CHICKEN.get(), ModItems.TACO_CHICKEN.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 600, ModItems.TORTILLA_WITH_CHEESE.get(), ModItems.CHEESY_ROLL_UP.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 600, ModItems.UNCOOKED_CHEESY_POTATO_GRILLER.get(), ModItems.CHEESY_POTATO_GRILLER.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 600, ModItems.UNCOOKED_CHICKEN_TAQUITO.get(), ModItems.CHICKEN_TAQUITO.get(), 0.35f);
        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 600, ModItems.UNCOOKED_STEAK_TAQUITO.get(), ModItems.STEAK_TAQUITO.get(), 0.35f);

        FabricRecipeProvider.offerFoodCookingRecipe(recipeExporter, "smoker", RecipeSerializer.SMOKING, SmokingRecipe::new, 200, ModItems.HOT_PEPPER.get(), ModItems.DRIED_CHILI.get(), 1f);

        generateHomogenousFoodBox(ModItems.BEEF_BURRITO.get(), ModBlocks.BEEF_BURRITO_BOX_BLOCK.get(), 5).offerTo(recipeExporter);
        generateHomogenousFoodBox(ModItems.CHICKEN_BURRITO.get(), ModBlocks.CHICKEN_BURRITO_BOX_BLOCK.get(), 5).offerTo(recipeExporter);
        generateHomogenousFoodBox(ModItems.POTATO_BURRITO.get(), ModBlocks.POTATO_BURRITO_BOX_BLOCK.get(), 5).offerTo(recipeExporter);
        generateHomogenousFoodBox(ModItems.BEEF_TACO.get(), ModBlocks.BEEF_TACO_BOX_BLOCK.get(), 6).offerTo(recipeExporter);
        generateHomogenousFoodBox(ModItems.CHICKEN_TACO.get(), ModBlocks.CHICKEN_TACO_BOX_BLOCK.get(), 6).offerTo(recipeExporter);
        generateHomogenousFoodBox(ModItems.POTATO_TACO.get(), ModBlocks.POTATO_TACO_BOX_BLOCK.get(), 6).offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TORTILLA_WITH_CHEESE.get())
                .input(ModItems.FLOUR_TORTILLA.get())
                .input(ModItems.SHREDDED_CHEESE.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA.get()), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TORTILLA.get()))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_TACO_BEEF.get())
                .input(ModItemTagProvider.GROUND_BEEF)
                .input(ModItems.TACO_SEASONING.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.TACO_SEASONING.get()), FabricRecipeProvider.conditionsFromItem(ModItems.TACO_SEASONING.get()))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_TACO_CHICKEN.get())
                .input(ModItemTagProvider.CUT_CHICKEN)
                .input(ModItems.TACO_SEASONING.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.TACO_SEASONING.get()), FabricRecipeProvider.conditionsFromItem(ModItems.TACO_SEASONING.get()))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.UNCOOKED_FIESTA_POTATOES.get())
                .input(ModItems.DICED_POTATO.get())
                .input(ModItems.TACO_SEASONING.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.TACO_SEASONING.get()), FabricRecipeProvider.conditionsFromItem(ModItems.TACO_SEASONING.get()))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.BEEF_CRAVINGS_BOX_BLOCK.get().asItem())
                .input(ModItems.BEEF_TACO.get(), 2)
                .input(ModItems.BEEF_BURRITO.get(), 2)
                .input(ModItems.BEEF_CRUNCHWRAP.get(), 2)
                .input(ModItems.BEEF_QUESADILLA.get(), 2)
                .input(ModItems.CARDBOARD_TRAY.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.BEEF_CRUNCHWRAP.get()), FabricRecipeProvider.conditionsFromItem(ModItems.BEEF_CRUNCHWRAP.get()))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.CHICKEN_CRAVINGS_BOX_BLOCK.get().asItem())
                .input(ModItems.CHICKEN_TACO.get(), 2)
                .input(ModItems.CHICKEN_BURRITO.get(), 2)
                .input(ModItems.CHICKEN_CRUNCHWRAP.get(), 2)
                .input(ModItems.CHICKEN_QUESADILLA.get(), 2)
                .input(ModItems.CARDBOARD_TRAY.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.CHICKEN_CRUNCHWRAP.get()), FabricRecipeProvider.conditionsFromItem(ModItems.CHICKEN_CRUNCHWRAP.get()))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.POTATO_CRAVINGS_BOX_BLOCK.get().asItem())
                .input(ModItems.POTATO_TACO.get(), 2)
                .input(ModItems.POTATO_BURRITO.get(), 2)
                .input(ModItems.POTATO_CRUNCHWRAP.get(), 2)
                .input(ModItems.POTATO_QUESADILLA.get(), 2)
                .criterion(FabricRecipeProvider.hasItem(ModItems.POTATO_CRUNCHWRAP.get()), FabricRecipeProvider.conditionsFromItem(ModItems.POTATO_CRUNCHWRAP.get()))
                .input(ModItems.CARDBOARD_TRAY.get())
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CARDBOARD_TRAY.get())
                .pattern("# #")
                .pattern("###")
                .input('#', Items.PAPER)
                .criterion(FabricRecipeProvider.hasItem(Items.PAPER), FabricRecipeProvider.conditionsFromItem(Items.PAPER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, FabricModBlocks.CHEESE_PRESS_BLOCK.get())
                .pattern(" i ")
                .pattern("#D#")
                .pattern("###")
                .input('i', Items.LEVER)
                .input('#', ItemTags.SLABS)
                .input('D', Items.IRON_TRAPDOOR)
                .criterion(FabricRecipeProvider.hasItem(Items.LEVER), FabricRecipeProvider.conditionsFromItem(Items.LEVER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, FabricModBlocks.DEEP_FRYER_BLOCK.get())
                .pattern("III")
                .pattern("iDi")
                .pattern("i#i")
                .input('I', Items.IRON_BARS)
                .input('i', Items.IRON_INGOT)
                .input('D', Items.CAMPFIRE)
                .input('#', Blocks.IRON_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT), FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SALT.get(), 4)
                .input(ModItems.ROCK_SALT_CRYSTALS.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.ROCK_SALT_CRYSTALS.get()), FabricRecipeProvider.conditionsFromItem((ModItems.ROCK_SALT_CRYSTALS.get())))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TACO_SEASONING.get(), 4)
                .input(ModItems.SALT.get())
                .input(ModItems.DRIED_CHILI.get())
                .input(ModItems.DRIED_ONION.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.SALT.get()), FabricRecipeProvider.conditionsFromItem(ModItems.SALT.get()))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.NACHOS.get(), 1)
                .input(ModItems.NACHO_CHEESE.get())
                .input(ModItems.TORTILLA_CHIPS.get())
                .input(Items.BOWL)
                .criterion(FabricRecipeProvider.hasItem(ModItems.NACHO_CHEESE.get()), FabricRecipeProvider.conditionsFromItem(ModItems.NACHO_CHEESE.get()))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHEESY_FIESTA_POTATOES.get(), 1)
                .input(ModItems.NACHO_CHEESE.get())
                .input(ModItems.FRIED_FIESTA_POTATOES.get())
                .input(ModItems.SOUR_CREAM.get())
                .input(Items.BOWL)
                .criterion(FabricRecipeProvider.hasItem(ModItems.NACHO_CHEESE.get()), FabricRecipeProvider.conditionsFromItem(ModItems.NACHO_CHEESE.get()))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAJA_BLAST.get(), 4)
                .input(ModItems.BAJA_BLAST_SYRUP.get())
                .input(Items.WATER_BUCKET)
                .input(Items.GLASS_BOTTLE, 4)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BAJA_BLAST_SYRUP.get()), FabricRecipeProvider.conditionsFromItem(ModItems.BAJA_BLAST_SYRUP.get()))
                .offerTo(recipeExporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TORTILLA_DOUGH.get(), 4)
                .input(Items.WATER_BUCKET)
                .input(Items.WHEAT)
                .input(ModItems.SALT.get())
                .criterion(FabricRecipeProvider.hasItem(Items.WHEAT), FabricRecipeProvider.conditionsFromItem(Items.WHEAT))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.UNCOOKED_CARAMEL_APPLE_EMPANADA.get(), 1)
                .input(ModItems.APPLE_SLICES.get())
                .input(Items.SUGAR)
                .input(ModItems.HAND_PIE_CRUST.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.APPLE_SLICES.get()), FabricRecipeProvider.conditionsFromItem(ModItems.APPLE_SLICES.get()))
                .criterion(FabricRecipeProvider.hasItem(ModItems.HAND_PIE_CRUST.get()), FabricRecipeProvider.conditionsFromItem(ModItems.HAND_PIE_CRUST.get()))
                .offerTo(recipeExporter);

        try {
            offerDeepFrying(recipeExporter, ModItems.RAW_TORTILLA_CHIPS.get(), ModItems.TORTILLA_CHIPS.get(), 0.2f, 200, 1);
            offerDeepFrying(recipeExporter, ModItems.UNCOOKED_FIESTA_POTATOES.get(), ModItems.FRIED_FIESTA_POTATOES.get(), 0.2f, 200, 1);
            offerDeepFrying(recipeExporter, ModItems.FLOUR_TORTILLA.get(), ModItems.FLOUR_TOSTADA.get(), 0.2f, 200, 1);
            offerDeepFrying(recipeExporter, ModItems.UNCOOKED_CARAMEL_APPLE_EMPANADA.get(), ModItems.CARAMEL_APPLE_EMPANADA.get(), 0.2f, 200, 1);
            offerCutting(recipeExporter, ModItemTagProvider.TOMATOES, ModItems.DICED_TOMATOES.get(), 1);
            offerCutting(recipeExporter, ModItems.FLOUR_TORTILLA.get(), ModItems.RAW_TORTILLA_CHIPS.get(), 2);
            offerCutting(recipeExporter, Items.POTATO, ModItems.DICED_POTATO.get(), 4);
            offerCutting(recipeExporter, ModItems.CHEESE_WEDGE.get(), ModItems.SHREDDED_CHEESE.get(), 4);
            offerCutting(recipeExporter, Items.APPLE, ModItems.APPLE_SLICES.get(), 4);
            offerCutting(recipeExporter, vectorwing.farmersdelight.common.registry.ModItems.PIE_CRUST.get(), ModItems.HAND_PIE_CRUST.get(), 4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateRecipes(Map<Item, Item> fillings, BiConsumer<Item, Item> generator) {
        fillings.forEach(generator);
    }

    private static ShapelessRecipeJsonBuilder generateRollupRecipe(Item filling, Item result) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, result)
                .input(ModItems.FLOUR_TORTILLA.get())
                .input(filling)
                .input(ModItemTagProvider.SHREDDED_CHEESE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA.get()), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TORTILLA.get()));
    }

    private static ShapelessRecipeJsonBuilder generateTacoRecipe(Item filling, Item result) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, result)
                .input(ModItems.FLOUR_TORTILLA.get())
                .input(filling)
                .input(ModItemTagProvider.SHREDDED_CHEESE)
                .input(ModItems.SOUR_CREAM.get())
                .input(ModItems.DICED_TOMATOES.get())
                .input(ModItemTagProvider.LEAFY_GREENS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA.get()), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TORTILLA.get()));
    }

    private static ShapelessRecipeJsonBuilder generateBurritoRecipe(Item filling, Item result) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, result)
                .input(ModItems.FLOUR_TORTILLA.get())
                .input(filling)
                .input(ModItemTagProvider.SHREDDED_CHEESE)
                .input(ModItems.SOUR_CREAM.get())
                .input(ModItems.DICED_TOMATOES.get())
                .input(ModItemTagProvider.LEAFY_GREENS)
                .input(ModItemTagProvider.RICE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA.get()), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TORTILLA.get()));
    }

    private static ShapelessRecipeJsonBuilder generateQuesadillaRecipe(Item filling, Item result) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, result)
                .input(ModItems.FLOUR_TORTILLA.get())
                .input(filling)
                .input(ModItemTagProvider.SHREDDED_CHEESE)
                .input(ModItems.SOUR_CREAM.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA.get()), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TORTILLA.get()));
    }

    private static ShapelessRecipeJsonBuilder generateCrunchwrapRecipe(Item filling, Item result) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, result)
                .input(ModItems.FLOUR_TORTILLA.get())
                .input(filling)
                .input(ModItemTagProvider.SHREDDED_CHEESE)
                .input(ModItems.SOUR_CREAM.get())
                .input(ModItems.DICED_TOMATOES.get())
                .input(ModItemTagProvider.LEAFY_GREENS)
                .input(ModItems.FLOUR_TOSTADA.get())
                .criterion(FabricRecipeProvider.hasItem(ModItems.FLOUR_TORTILLA.get()), FabricRecipeProvider.conditionsFromItem(ModItems.FLOUR_TOSTADA.get()));
    }

    private static ShapelessRecipeJsonBuilder generateHomogenousFoodBox(Item food, Block box, int count) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, box.asItem())
                .input(food, count)
                .input(ModItems.CARDBOARD_TRAY.get())
                .criterion(FabricRecipeProvider.hasItem(food), FabricRecipeProvider.conditionsFromItem(food));
    }
}
