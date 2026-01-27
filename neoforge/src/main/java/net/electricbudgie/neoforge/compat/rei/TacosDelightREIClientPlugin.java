package net.electricbudgie.neoforge.compat.rei;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
import net.electricbudgie.neoforge.block.NeoForgeModBlocks;
import net.electricbudgie.neoforge.menu.custom.DeepFryerScreen;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.item.ModItems;
import net.electricbudgie.tacosdelight.recipe.DeepFryerRecipe;
import net.electricbudgie.tacosdelight.recipe.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;


@REIPluginClient
public class TacosDelightREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new DeepFryerCategory());
        registry.add(new CheesePressCategory());

        registry.addWorkstations(DeepFryerCategory.DEEP_FRYER, EntryStacks.of(NeoForgeModBlocks.DEEP_FRYER_BLOCK.get()));
        registry.addWorkstations(CheesePressCategory.ID, EntryStacks.of(NeoForgeModBlocks.CHEESE_PRESS_BLOCK.get()));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(ModItems.BLUE_RASPBERRY.get().asItem()), Text.translatable("item.tacosdelight.blue_raspberry")).lines(Text.translatable("tacosdelight.rei.info.blue_raspberry")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(ModItems.HOT_PEPPER.get().asItem()), Text.translatable("item.tacosdelight.hot_pepper")).lines(Text.translatable("tacosdelight.rei.info.hot_pepper")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(ModItems.LIME.get().asItem()), Text.translatable("item.tacosdelight.lime")).lines(Text.translatable("tacosdelight.rei.info.lime")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(ModBlocks.CHEESE_WHEEL_BLOCK.get().asItem()), Text.translatable("block.tacosdelight.cheese_wheel")).lines(Text.translatable("tacosdelight.rei.info.cheese_wheel")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(ModItems.CHEESE_WEDGE.get().asItem()), Text.translatable("item.tacosdelight.cheese_wedge")).lines(Text.translatable("tacosdelight.rei.info.cheese_wedge")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(ModItems.TORTILLA_DOUGH.get().asItem()), Text.translatable("item.tacosdelight.tortilla_dough")).lines(Text.translatable("tacosdelight.rei.info.flour_tortilla_dough")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(ModItems.SALT.get().asItem()), Text.translatable("item.tacosdelight.salt")).lines(Text.translatable("tacosdelight.rei.info.salt")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(ModItems.HALITE_BLOCK_ITEM.get().asItem()), Text.translatable("block.tacosdelight.halite")).lines(Text.translatable("tacosdelight.rei.info.halite")));
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
