package net.electricbudgie.tacosdelight.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

import java.util.function.Supplier;

public abstract class FoodTrayBlock extends Block {
    public static final DirectionProperty FACING;
    public static final IntProperty SERVINGS;
    public final Supplier<Item> servingItem;
    public final boolean hasLeftovers;
    public static final int MAX_SERVINGS = 6;

    public FoodTrayBlock(AbstractBlock.Settings properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties);
        this.servingItem = servingItem;
        this.hasLeftovers = hasLeftovers;
    }

    public IntProperty getServingsProperty() {
        return SERVINGS;
    }

    public int getMaxServings() {
        return MAX_SERVINGS;
    }

    public ItemStack getServingItem(BlockState state) {
        return new ItemStack(this.servingItem.get());
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
        SERVINGS = IntProperty.of("servings", 0, 4);
    }
}