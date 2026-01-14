package net.electricbudgie.tacosdelight.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItemSuppliers {
    private static final Map<ModFoodComponents.FoodType, Map<ModFoodComponents.FillingType, Supplier<Item>>> SUPPLIERS =
            new EnumMap<>(ModFoodComponents.FoodType.class);

    static {
        // --- TACOS ---
        Map<ModFoodComponents.FillingType, Supplier<Item>> tacos = new EnumMap<>(ModFoodComponents.FillingType.class);
        tacos.put(ModFoodComponents.FillingType.BEEF, () -> ModItems.BEEF_TACO.get());
        tacos.put(ModFoodComponents.FillingType.CHICKEN, () -> ModItems.CHICKEN_TACO.get());
        tacos.put(ModFoodComponents.FillingType.POTATO, () -> ModItems.POTATO_TACO.get());
        tacos.put(ModFoodComponents.FillingType.CHEESE, () -> ModItems.POTATO_TACO.get());
        SUPPLIERS.put(ModFoodComponents.FoodType.TACO, tacos);

        // --- BURRITOS ---
        Map<ModFoodComponents.FillingType, Supplier<Item>> burritos = new EnumMap<>(ModFoodComponents.FillingType.class);
        burritos.put(ModFoodComponents.FillingType.BEEF, () -> ModItems.BEEF_BURRITO.get());
        burritos.put(ModFoodComponents.FillingType.CHICKEN, () -> ModItems.CHICKEN_BURRITO.get());
        burritos.put(ModFoodComponents.FillingType.POTATO, () -> ModItems.POTATO_BURRITO.get());
        burritos.put(ModFoodComponents.FillingType.CHEESE, () -> ModItems.POTATO_BURRITO.get());
        SUPPLIERS.put(ModFoodComponents.FoodType.BURRITO, burritos);

        // --- QUESADILLAS ---
        Map<ModFoodComponents.FillingType, Supplier<Item>> quesadillas = new EnumMap<>(ModFoodComponents.FillingType.class);
        quesadillas.put(ModFoodComponents.FillingType.BEEF, () -> ModItems.BEEF_QUESADILLA.get());
        quesadillas.put(ModFoodComponents.FillingType.CHICKEN, () -> ModItems.CHICKEN_QUESADILLA.get());
        quesadillas.put(ModFoodComponents.FillingType.POTATO, () -> ModItems.POTATO_QUESADILLA.get());
        quesadillas.put(ModFoodComponents.FillingType.CHEESE, () -> ModItems.CHEESE_QUESADILLA.get());
        SUPPLIERS.put(ModFoodComponents.FoodType.QUESADILLA, quesadillas);

        // --- CRUNCHWRAPS ---
        Map<ModFoodComponents.FillingType, Supplier<Item>> crunchwraps = new EnumMap<>(ModFoodComponents.FillingType.class);
        crunchwraps.put(ModFoodComponents.FillingType.BEEF, () -> ModItems.BEEF_CRUNCHWRAP.get());
        crunchwraps.put(ModFoodComponents.FillingType.CHICKEN, () -> ModItems.CHICKEN_CRUNCHWRAP.get());
        crunchwraps.put(ModFoodComponents.FillingType.POTATO, () -> ModItems.POTATO_CRUNCHWRAP.get());
        SUPPLIERS.put(ModFoodComponents.FoodType.CRUNCHWRAP, crunchwraps);

        // --- NACHOS ---
        Map<ModFoodComponents.FillingType, Supplier<Item>> nachos = new EnumMap<>(ModFoodComponents.FillingType.class);
        // Uncomment when you add nacho items
        // nachos.put(ModFoodComponents.FillingType.BEEF, () -> ModItems.BEEF_NACHO_PLATTER_SERVING.get());
        // nachos.put(ModFoodComponents.FillingType.CHICKEN, () -> ModItems.CHICKEN_NACHO_PLATTER_SERVING.get());
        // nachos.put(ModFoodComponents.FillingType.POTATO, () -> ModItems.POTATO_NACHO_PLATTER_SERVING.get());
        // nachos.put(ModFoodComponents.FillingType.CHEESE, () -> ModItems.NACHO_PLATTER_SERVING.get());
        SUPPLIERS.put(ModFoodComponents.FoodType.NACHOS, nachos);
    }

    /**
     * Returns a Supplier<Item> for the given food and filling type.
     * If the type or filling is missing, returns a supplier of AIR.
     */
    public static Supplier<Item> get(ModFoodComponents.FoodType foodType, ModFoodComponents.FillingType fillingType){
        return SUPPLIERS
                .getOrDefault(foodType, Map.of())
                .getOrDefault(fillingType, () -> Items.AIR);
    }
}