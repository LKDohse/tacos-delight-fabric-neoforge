package net.electricbudgie.tacosdelight.block.custom;

import net.electricbudgie.tacosdelight.item.ModFoodComponents;
import net.electricbudgie.tacosdelight.item.ModItemSuppliers;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.function.Supplier;

public class BurritoBoxBlock extends FoodTrayBlock {
    protected static final VoxelShape PLATE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape FOOD_SHAPE = VoxelShapes.union(
            PLATE_SHAPE,
            Block.createCuboidShape(2.0D, 2.0D, 2.0D, 14.0D, 4.0D, 14.0D)
    );

    private static Supplier<Item> burritoSupplier(ModFoodComponents.FillingType fillingType) {
        return ModItemSuppliers.get(ModFoodComponents.FoodType.BURRITO, fillingType);
    }

    public BurritoBoxBlock(AbstractBlock.Settings properties, ModFoodComponents.FillingType fillingType, boolean hasLeftovers) {
        super(properties, burritoSupplier(fillingType), 5, hasLeftovers);

    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(getServingsProperty()) == 0 ? PLATE_SHAPE : FOOD_SHAPE;
    }

}
