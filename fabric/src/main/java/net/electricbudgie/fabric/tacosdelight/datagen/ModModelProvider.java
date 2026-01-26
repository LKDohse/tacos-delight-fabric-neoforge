package net.electricbudgie.fabric.tacosdelight.datagen;

import net.electricbudgie.fabric.tacosdelight.block.FabricModBlocks;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;

import java.util.Map;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Blocks
        blockStateModelGenerator.registerLog(ModBlocks.HALITE.get()).log(ModBlocks.HALITE.get());

        //Crops
        //Have to manually write this at the moment, due to needing a cutout property for neoforge support :/
//        blockStateModelGenerator.registerTintableCross(ModBlocks.WILD_HOT_PEPPERS.get(), BlockStateModelGenerator.TintType.NOT_TINTED);
//        blockStateModelGenerator.registerCrop(ModBlocks.BLUE_RASPBERRY_BUSH.get(), BlueRaspberryBushBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
//        blockStateModelGenerator.registerCrop(ModBlocks.HOT_PEPPER_CROP.get(), HotPepperCropBlock.AGE, 0,1,2,3,4,5);
//        registerTallPlant(blockStateModelGenerator, ModBlocks.LIME_TREE.get(), LimeTreeBlock.AGE);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        registerFoodModels(itemModelGenerator);
        itemModelGenerator.register(ModItems.CARDBOARD_TRAY.get(), Models.GENERATED);
        itemModelGenerator.register(FabricModBlocks.CHEESE_PRESS_BLOCK.get().asItem(), Models.GENERATED);
        itemModelGenerator.register(FabricModBlocks.DEEP_FRYER_BLOCK.get().asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BEEF_BURRITO_BOX_BLOCK.get().asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CHICKEN_BURRITO_BOX_BLOCK.get().asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.POTATO_BURRITO_BOX_BLOCK.get().asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BEEF_TACO_BOX_BLOCK.get().asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CHICKEN_TACO_BOX_BLOCK.get().asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.POTATO_TACO_BOX_BLOCK.get().asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BEEF_CRAVINGS_BOX_BLOCK.get().asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CHICKEN_CRAVINGS_BOX_BLOCK.get().asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.POTATO_CRAVINGS_BOX_BLOCK.get().asItem(), Models.GENERATED);
    }

    private static void registerFoodModels(ItemModelGenerator itemModelGenerator) {

        // Basic Ingredients
        itemModelGenerator.register(ModItems.HOT_PEPPER.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.HOT_PEPPER_SEEDS.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_RASPBERRY.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.LIME.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.DICED_TOMATOES.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.DRIED_CHILI.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.DRIED_ONION.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOUR_TORTILLA.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.NACHO_CHEESE.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.SHREDDED_CHEESE.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.DICED_POTATO.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUR_CREAM.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TORTILLA_CHIPS.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_FIESTA_POTATOES.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIED_FIESTA_POTATOES.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.TACO_SEASONING.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCK_SALT_CRYSTALS.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.TORTILLA_CHIPS.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOUR_TOSTADA.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_WEDGE.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.HAND_PIE_CRUST.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.APPLE_SLICES.get(), Models.GENERATED);

        // Raw Ingredients
        itemModelGenerator.register(ModItems.RAW_TACO_BEEF.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TACO_CHICKEN.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.TORTILLA_DOUGH.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CURDS_AND_WHEY.get(), Models.GENERATED);

        //Cooked Ingredients
        itemModelGenerator.register(ModItems.TACO_BEEF.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.TACO_CHICKEN.get(), Models.GENERATED);

        //Unfinished Foods
        itemModelGenerator.register(ModItems.UNCOOKED_CHEESE_QUESADILLA.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_CHICKEN_QUESADILLA.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_BEEF_QUESADILLA.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_POTATO_QUESADILLA.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_CHICKEN_CRUNCHWRAP.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_BEEF_CRUNCHWRAP.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_POTATO_CRUNCHWRAP.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.TORTILLA_WITH_CHEESE.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_CHEESY_POTATO_GRILLER.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_CHICKEN_TAQUITO.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_STEAK_TAQUITO.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOOKED_CARAMEL_APPLE_EMPANADA.get(), Models.GENERATED);

        //Sides
        itemModelGenerator.register(ModItems.NACHOS.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESY_FIESTA_POTATOES.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CARAMEL_APPLE_EMPANADA.get(), Models.GENERATED);

        //Roll-Ups
        itemModelGenerator.register(ModItems.CHEESY_ROLL_UP.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESY_POTATO_GRILLER.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_TAQUITO.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.STEAK_TAQUITO.get(), Models.GENERATED);

        //Tacos
        itemModelGenerator.register(ModItems.POTATO_TACO.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_TACO.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_TACO.get(), Models.GENERATED);

        //Burritos
        itemModelGenerator.register(ModItems.POTATO_BURRITO.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_BURRITO.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_BURRITO.get(), Models.GENERATED);

        //Quesadillas
        itemModelGenerator.register(ModItems.CHEESE_QUESADILLA.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_QUESADILLA.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_QUESADILLA.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.POTATO_QUESADILLA.get(), Models.GENERATED);

        //Crunchwraps
        itemModelGenerator.register(ModItems.CHICKEN_CRUNCHWRAP.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.BEEF_CRUNCHWRAP.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.POTATO_CRUNCHWRAP.get(), Models.GENERATED);

        //Drinks and Drink Errata
        itemModelGenerator.register(ModItems.BAJA_BLAST_SYRUP.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.BAJA_BLAST.get(), Models.GENERATED);
    }

    public final void registerTallPlant(BlockStateModelGenerator generator, Block plant, Property<Integer> ageProperty) {
        generator.registerItemModel(plant.asItem());
        BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(ageProperty, Properties.DOUBLE_BLOCK_HALF).register((age, half) -> {
            return switch (half) {
                case UPPER ->
                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(plant, "_age" + age + "_upper"));
                case LOWER ->
                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(plant, "_age" + age + "_lower"));
            };
        });
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(plant).coordinate(blockStateVariantMap));
        ageProperty.getValues().stream()
                .flatMap(age -> Properties.DOUBLE_BLOCK_HALF.getValues().stream()
                        .map(half -> Map.entry(age, half)))
                .forEach(entry -> {
                    Integer age = entry.getKey();
                    DoubleBlockHalf half = entry.getValue();
                    generator.createSubModel(
                            plant,
                            "_age" + age + "_" + half.name().toLowerCase(),
                            Models.CROSS,
                            TextureMap::cross
                    );
                });
    }


}
