package net.electricbudgie.fabric.tacosdelight.datagen;

import net.electricbudgie.fabric.tacosdelight.block.FabricModBlocks;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.electricbudgie.tacosdelight.block.custom.HotPepperCropBlock;
import net.electricbudgie.tacosdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LIME_TREE.get(), Items.STICK);
        addDrop(ModBlocks.BLUE_RASPBERRY_BUSH.get(), Items.STICK);
        addDrop(ModBlocks.HALITE.get(), multipleOreDrops(ModBlocks.HALITE.get(), ModItems.ROCK_SALT_CRYSTALS.get(), 4f, 6f));
        addDrop(FabricModBlocks.DEEP_FRYER_BLOCK.get());
        addDrop(FabricModBlocks.CHEESE_PRESS_BLOCK.get());

        BlockStatePropertyLootCondition.Builder hotPepperLootConditionBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.HOT_PEPPER_CROP.get())
                .properties(StatePredicate.Builder.create().exactMatch(HotPepperCropBlock.AGE, 5));
        this.addDrop(ModBlocks.HOT_PEPPER_CROP.get(), this.cropDrops(ModBlocks.HOT_PEPPER_CROP.get(), ModItems.HOT_PEPPER.get(), ModItems.HOT_PEPPER_SEEDS.get(), hotPepperLootConditionBuilder));
        this.addDrop(ModBlocks.WILD_HOT_PEPPERS.get(), wildCropDrops(ModItems.HOT_PEPPER.get(), ModItems.HOT_PEPPER_SEEDS.get()));
    }

    public LootTable.Builder wildCropDrops(Item fruit, Item seeds){
        return LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .with(ItemEntry.builder(fruit))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)))
                )
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(RandomChanceLootCondition.builder(0.50f))
                        .with(ItemEntry.builder(seeds))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0f, 2f)))
                );
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops){
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder) ItemEntry.builder(item).apply(
                                SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}

