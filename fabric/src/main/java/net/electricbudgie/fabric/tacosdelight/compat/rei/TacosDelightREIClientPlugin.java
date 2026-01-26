package net.electricbudgie.fabric.tacosdelight.compat.rei;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.electricbudgie.fabric.tacosdelight.block.FabricModBlocks;
import net.electricbudgie.fabric.tacosdelight.screen.custom.DeepFryerScreen;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.item.ModItems;
import net.electricbudgie.tacosdelight.recipe.DeepFryerRecipe;
import net.electricbudgie.tacosdelight.recipe.ModRecipes;
import net.minecraft.item.ItemStack;

public class TacosDelightREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new DeepFryerCategory());
        registry.add(new CheesePressCategory());

        registry.addWorkstations(DeepFryerCategory.DEEP_FRYER, EntryStacks.of(FabricModBlocks.DEEP_FRYER_BLOCK.get()));
        registry.addWorkstations(DeepFryerCategory.DEEP_FRYER, EntryStacks.of(FabricModBlocks.CHEESE_PRESS_BLOCK.get()));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(DeepFryerRecipe.class, ModRecipes.DEEP_FRYER_RECIPE_TYPE.value(), DeepFryerDisplay::new);
        registerCheesePressRecipes(registry);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176)/2) + 78, ((screen.height - 166)/2)+30, 20, 25),
                DeepFryerScreen.class, DeepFryerCategory.DEEP_FRYER);
    }

    private void registerCheesePressRecipes(DisplayRegistry registry){
        registry.add(new CheesePressDisplay(
                new ItemStack(ModItems.CURDS_AND_WHEY),
                new ItemStack(ModBlocks.CHEESE_WHEEL_BLOCK.get().asItem())
        ));
    }
}
