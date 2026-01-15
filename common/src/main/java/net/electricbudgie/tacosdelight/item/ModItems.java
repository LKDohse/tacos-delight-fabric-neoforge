package net.electricbudgie.tacosdelight.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.registry.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.ITEM);

    //Block Items
    //public static final RegistrySupplier<Item> DEEP_FRYER_ITEM = registerItem("deep_fryer", new BlockItem(ModBlocks.DEEP_FRYER.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));
    //public static final RegistrySupplier<Item> CHEESE_PRESS_ITEM = registerItem("cheese_press", new BlockItem(ModBlocks.CHEESE_PRESS_BLOCK.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));
    //public static final RegistrySupplier<Item> CHEESE_WHEEL_ITEM = registerItem("cheese_wheel", new BlockItem(ModBlocks.CHEESE_WHEEL_BLOCK.get(), new Item.Settings().component(ModComponents.AGE_COMPONENT.get(), 0).arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));

    public static final RegistrySupplier<Item> HALITE_BLOCK_ITEM = registerItem("halite", new BlockItem(ModBlocks.HALITE.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));

    public static final RegistrySupplier<Item> BEEF_BURRITO_BOX_BLOCK_ITEM = registerItem("beef_burrito_box", new BlockItem(ModBlocks.BEEF_BURRITO_BOX_BLOCK.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));
    public static final RegistrySupplier<Item> CHICKEN_BURRITO_BOX_BLOCK_ITEM = registerItem("chicken_burrito_box", new BlockItem(ModBlocks.CHICKEN_BURRITO_BOX_BLOCK.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));
    public static final RegistrySupplier<Item> POTATO_BURRITO_BOX_BLOCK_ITEM = registerItem("potato_burrito_box", new BlockItem(ModBlocks.POTATO_BURRITO_BOX_BLOCK.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));

    public static final RegistrySupplier<Item> BEEF_TACO_BOX_BLOCK_ITEM = registerItem("beef_taco_box", new BlockItem(ModBlocks.BEEF_TACO_BOX_BLOCK.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));
    public static final RegistrySupplier<Item> CHICKEN_TACO_BOX_BLOCK_ITEM = registerItem("chicken_taco_box", new BlockItem(ModBlocks.CHICKEN_TACO_BOX_BLOCK.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));
    public static final RegistrySupplier<Item> POTATO_TACO_BOX_BLOCK_ITEM = registerItem("potato_taco_box", new BlockItem(ModBlocks.POTATO_TACO_BOX_BLOCK.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));

    public static final RegistrySupplier<Item> BEEF_CRAVINGS_BOX_BLOCK_ITEM = registerItem("beef_cravings_box", new BlockItem(ModBlocks.BEEF_CRAVINGS_BOX_BLOCK.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));
    public static final RegistrySupplier<Item> CHICKEN_CRAVINGS_BOX_BLOCK_ITEM = registerItem("chicken_cravings_box", new BlockItem(ModBlocks.CHICKEN_CRAVINGS_BOX_BLOCK.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));
    public static final RegistrySupplier<Item> POTATO_CRAVINGS_BOX_BLOCK_ITEM = registerItem("potato_cravings_box", new BlockItem(ModBlocks.POTATO_CRAVINGS_BOX_BLOCK.get(), new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));

    //Ores and Ore-related Items
    public static final RegistrySupplier<Item> SALT = registerItemViaSettings("salt", ModFoodComponents.SALT);
    public static final RegistrySupplier<Item> ROCK_SALT_CRYSTALS = registerSimpleItem("rock_salt_crystals");

    //Basic Ingredients
    public static final RegistrySupplier<Item> DICED_TOMATOES = registerItemViaSettings("diced_tomatoes", ModFoodComponents.DICED_TOMATOES_SETTINGS);
    public static final RegistrySupplier<Item> DRIED_CHILI = registerItemViaSettings("dried_chili", ModFoodComponents.DRIED_CHILI_SETTINGS);
    public static final RegistrySupplier<Item> DRIED_ONION = registerItemViaSettings("dried_onion", ModFoodComponents.DRIED_ONION_SETTINGS);
    public static final RegistrySupplier<Item> FLOUR_TORTILLA = registerItemViaSettings("flour_tortilla", ModFoodComponents.FLOUR_TORTILLA_SETTINGS);
    public static final RegistrySupplier<Item> NACHO_CHEESE = registerItemViaSettings("nacho_cheese", ModFoodComponents.NACHO_CHEESE_SETTINGS);
    public static final RegistrySupplier<Item> SHREDDED_CHEESE = registerItemViaSettings("shredded_cheese", ModFoodComponents.SHREDDED_CHEESE_SETTINGS);
    public static final RegistrySupplier<Item> DICED_POTATO = registerItemViaSettings("diced_potato", ModFoodComponents.DICED_POTATO_SETTINGS);
    public static final RegistrySupplier<Item> SOUR_CREAM = registerItemViaSettings("sour_cream", ModFoodComponents.SOUR_CREAM_SETTINGS);
    public static final RegistrySupplier<Item> RAW_TORTILLA_CHIPS = registerItemViaSettings("raw_tortilla_chips", ModFoodComponents.RAW_TORTILLA_CHIPS_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_FIESTA_POTATOES = registerItemViaSettings("uncooked_fiesta_potatoes", ModFoodComponents.UNCOOKED_FIESTA_POTATOES_SETTINGS);
    public static final RegistrySupplier<Item> FRIED_FIESTA_POTATOES = registerItemViaSettings("fried_fiesta_potatoes", ModFoodComponents.FRIED_FIESTA_POTATOES_SETTINGS);
    public static final RegistrySupplier<Item> TACO_SEASONING = registerItemViaSettings("taco_seasoning", ModFoodComponents.TACO_SEASONING_SETTINGS);
    public static final RegistrySupplier<Item> TORTILLA_CHIPS = registerItemViaSettings("tortilla_chips", ModFoodComponents.TORTILLA_CHIPS);
    public static final RegistrySupplier<Item> FLOUR_TOSTADA = registerItemViaSettings("flour_tostada", ModFoodComponents.FLOUR_TOSTADA);
    public static final RegistrySupplier<Item> CHEESE_WEDGE = registerItemViaSettings("cheese_wedge", ModFoodComponents.CHEESE_WEDGE);
    public static final RegistrySupplier<Item> HAND_PIE_CRUST = registerItemViaSettings("hand_pie_crust", ModFoodComponents.HAND_PIE_CRUST_SETTINGS);
    public static final RegistrySupplier<Item> APPLE_SLICES = registerItemViaSettings("apple_slices", ModFoodComponents.APPLE_SLICES_SETTINGS);

    //Raw Ingredients
    public static final RegistrySupplier<Item> RAW_TACO_BEEF = registerItemViaSettings("raw_taco_beef", ModFoodComponents.RAW_TACO_BEEF_SETTINGS);
    public static final RegistrySupplier<Item> RAW_TACO_CHICKEN = registerItemViaSettings("raw_taco_chicken", ModFoodComponents.RAW_TACO_CHICKEN_SETTINGS);
    public static final RegistrySupplier<Item> TORTILLA_DOUGH = registerItemViaSettings("tortilla_dough", ModFoodComponents.TORTILLA_DOUGH_SETTINGS);
    public static final RegistrySupplier<Item> CURDS_AND_WHEY = registerItemViaSettings("curds_and_whey", ModFoodComponents.CURDS_AND_WHEY_SETTINGS);

    //Cooked Ingredients
    public static final RegistrySupplier<Item> TACO_BEEF = registerItemViaSettings("taco_beef", ModFoodComponents.TACO_BEEF_SETTINGS);
    public static final RegistrySupplier<Item> TACO_CHICKEN = registerItemViaSettings("taco_chicken", ModFoodComponents.TACO_CHICKEN_SETTINGS);

    //Unfinished Foods
    public static final RegistrySupplier<Item> UNCOOKED_CHEESE_QUESADILLA = registerItemViaSettings("uncooked_cheese_quesadilla", ModFoodComponents.UNCOOKED_CHEESE_QUESADILLA_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_CHICKEN_QUESADILLA = registerItemViaSettings("uncooked_chicken_quesadilla", ModFoodComponents.UNCOOKED_CHICKEN_QUESADILLA_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_BEEF_QUESADILLA = registerItemViaSettings("uncooked_beef_quesadilla", ModFoodComponents.UNCOOKED_BEEF_QUESADILLA_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_POTATO_QUESADILLA = registerItemViaSettings("uncooked_potato_quesadilla", ModFoodComponents.UNCOOKED_POTATO_QUESADILLA_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_CHICKEN_CRUNCHWRAP = registerItemViaSettings("uncooked_chicken_crunchwrap", ModFoodComponents.UNCOOKED_CHICKEN_CRUNCHWRAP_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_BEEF_CRUNCHWRAP = registerItemViaSettings("uncooked_beef_crunchwrap", ModFoodComponents.UNCOOKED_BEEF_CRUNCHWRAP_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_POTATO_CRUNCHWRAP = registerItemViaSettings("uncooked_potato_crunchwrap", ModFoodComponents.UNCOOKED_POTATO_CRUNCHWRAP_SETTINGS);
    public static final RegistrySupplier<Item> TORTILLA_WITH_CHEESE= registerItemViaSettings("tortilla_with_cheese", ModFoodComponents.TORTILLA_WITH_CHEESE_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_CHEESY_POTATO_GRILLER= registerItemViaSettings("uncooked_cheesy_potato_griller", ModFoodComponents.UNCOOKED_CHEESY_POTATO_GRILLER_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_CHICKEN_TAQUITO = registerItemViaSettings("uncooked_chicken_taquito", ModFoodComponents.UNCOOKED_CHICKEN_TAQUITO_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_STEAK_TAQUITO = registerItemViaSettings("uncooked_steak_taquito", ModFoodComponents.UNCOOKED_STEAK_TAQUITO_SETTINGS);
    public static final RegistrySupplier<Item> UNCOOKED_CARAMEL_APPLE_EMPANADA = registerItemViaSettings("uncooked_caramel_apple_empanada", ModFoodComponents.UNCOOKED_CARAMEL_APPLE_EMPANADA);

    //Sides
    public static final RegistrySupplier<Item> NACHOS = registerItemViaSettings("nachos", ModFoodComponents.NACHOS_SETTINGS);
    public static final RegistrySupplier<Item> CHEESY_FIESTA_POTATOES = registerItemViaSettings("cheesy_fiesta_potatoes", ModFoodComponents.CHEESY_FIESTA_POTATOES_SETTINGS);
    public static final RegistrySupplier<Item> CARAMEL_APPLE_EMPANADA = registerItemViaSettings("caramel_apple_empanada", ModFoodComponents.CARAMEL_APPLE_EMPANADA_SETTINGS);

    //Roll-Ups
    public static final RegistrySupplier<Item> CHEESY_ROLL_UP = registerItemViaSettings("cheesy_roll_up", ModFoodComponents.CHEESY_ROLL_UP_SETTINGS);
    public static final RegistrySupplier<Item> CHEESY_POTATO_GRILLER = registerItemViaSettings("cheesy_potato_griller", ModFoodComponents.CHEESY_POTATO_GRILLER_SETTINGS);
    public static final RegistrySupplier<Item> CHICKEN_TAQUITO = registerItemViaSettings("chicken_taquito", ModFoodComponents.CHICKEN_TAQUITO_SETTINGS);
    public static final RegistrySupplier<Item> STEAK_TAQUITO = registerItemViaSettings("steak_taquito", ModFoodComponents.STEAK_TAQUITO_SETTINGS);

    //Tacos
    public static final RegistrySupplier<Item> POTATO_TACO = registerItemViaSettings("potato_taco", ModFoodComponents.POTATO_TACO_SETTINGS);
    public static final RegistrySupplier<Item> CHICKEN_TACO = registerItemViaSettings("chicken_taco", ModFoodComponents.CHICKEN_TACO_SETTINGS);
    public static final RegistrySupplier<Item> BEEF_TACO = registerItemViaSettings("beef_taco", ModFoodComponents.BEEF_TACO_SETTINGS);

    //Burritos
    public static final RegistrySupplier<Item> POTATO_BURRITO = registerItemViaSettings("potato_burrito", ModFoodComponents.POTATO_BURRITO_SETTINGS);
    public static final RegistrySupplier<Item> CHICKEN_BURRITO = registerItemViaSettings("chicken_burrito", ModFoodComponents.CHICKEN_BURRITO_SETTINGS);
    public static final RegistrySupplier<Item> BEEF_BURRITO = registerItemViaSettings("beef_burrito", ModFoodComponents.BEEF_BURRITO_SETTINGS);

    //Quesadillas
    public static final RegistrySupplier<Item> CHEESE_QUESADILLA = registerItemViaSettings("cheese_quesadilla", ModFoodComponents.CHEESE_QUESADILLA_SETTINGS);
    public static final RegistrySupplier<Item> CHICKEN_QUESADILLA = registerItemViaSettings("chicken_quesadilla", ModFoodComponents.CHICKEN_QUESADILLA_SETTINGS);
    public static final RegistrySupplier<Item> BEEF_QUESADILLA = registerItemViaSettings("beef_quesadilla", ModFoodComponents.BEEF_QUESADILLA_SETTINGS);
    public static final RegistrySupplier<Item> POTATO_QUESADILLA = registerItemViaSettings("potato_quesadilla", ModFoodComponents.POTATO_QUESADILLA_SETTINGS);

    //Crunchwraps
    public static final RegistrySupplier<Item> CHICKEN_CRUNCHWRAP = registerItemViaSettings("chicken_crunchwrap", ModFoodComponents.CHICKEN_CRUNCHWRAP_SETTINGS);
    public static final RegistrySupplier<Item> BEEF_CRUNCHWRAP = registerItemViaSettings("beef_crunchwrap", ModFoodComponents.BEEF_CRUNCHWRAP_SETTINGS);
    public static final RegistrySupplier<Item> POTATO_CRUNCHWRAP = registerItemViaSettings("potato_crunchwrap", ModFoodComponents.POTATO_CRUNCHWRAP_SETTINGS);

    //Crops
    public static final RegistrySupplier<AliasedBlockItem> LIME = registerAliasedBlockItem("lime", ModBlocks.LIME_TREE.get(), ModFoodComponents.LIME_SETTINGS);
    public static final RegistrySupplier<AliasedBlockItem> BLUE_RASPBERRY =  registerAliasedBlockItem("blue_raspberry", ModBlocks.BLUE_RASPBERRY_BUSH.get(), ModFoodComponents.BLUE_RASPBERRY_SETTINGS);
    public static final RegistrySupplier<AliasedBlockItem> HOT_PEPPER_SEEDS =   registerAliasedBlockItem("hot_pepper_seeds", ModBlocks.HOT_PEPPER_CROP.get(), new Item.Settings());
    public static final RegistrySupplier<Item> HOT_PEPPER = registerItemViaSettings("hot_pepper", ModFoodComponents.HOT_PEPPER_SETTINGS);

    //Drinks
    //public static final RegistrySupplier<Item> BAJA_BLAST_SYRUP = registerItem("baja_blast_syrup", new DrinkableItem(ModFoodComponents.BAJA_BLAST_SYRUP_SETTINGS));
    //public static final RegistrySupplier<Item> BAJA_BLAST = registerItem("baja_blast", new DrinkableItem(ModFoodComponents.BAJA_BLAST_SETTINGS));

    //Uncategorized
    public static final RegistrySupplier<Item> CARDBOARD_TRAY = registerSimpleItem("cardboard_tray");

    public static RegistrySupplier<Item> registerItemViaSettings(String name, Item.Settings settings){
        var item = ITEMS.register(name, () -> new Item(settings.arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));
        return item;
    }

    public static RegistrySupplier<Item> registerSimpleItem(String name) {
        var item = ITEMS.register(name, ()-> new Item(new Item.Settings().arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)));
        return item;
    }

    public static RegistrySupplier<Item> registerItem(String name, Item item){
        var registeredItem = ITEMS.register(name, ()-> item);
        return registeredItem;
    }

    public static RegistrySupplier<AliasedBlockItem> registerAliasedBlockItem(String name, Block block, Item.Settings settings){
        var registeredItem = ITEMS.register(name,
                () -> new AliasedBlockItem(
                        block,
                        settings.arch$tab(ModCreativeTabs.TACOS_DELIGHT_TAB)
                ));
        return registeredItem;
    }


    public static void initialize() {
        ITEMS.register();
        TacosDelight.LOGGER.info("Registering Mod Items for " + TacosDelight.MOD_ID);
    }
}
