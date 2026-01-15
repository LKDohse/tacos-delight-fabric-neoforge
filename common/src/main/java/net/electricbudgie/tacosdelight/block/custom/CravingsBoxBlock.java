package net.electricbudgie.tacosdelight.block.custom;

import net.electricbudgie.tacosdelight.item.ModFoodComponents;
import net.electricbudgie.tacosdelight.item.ModItemSuppliers;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.function.Supplier;

public class CravingsBoxBlock extends FoodTrayBlock{
    public static final IntProperty SERVINGS;

    protected static final VoxelShape PLATE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape FOOD_SHAPE = VoxelShapes.union(
            PLATE_SHAPE,
            Block.createCuboidShape(2.0D, 2.0D, 2.0D, 14.0D, 4.0D, 14.0D)
    );

    public CravingsBoxBlock(AbstractBlock.Settings properties, ModFoodComponents.FillingType fillingType, boolean hasLeftovers){
        super(properties, hasLeftovers);
        this.servings = new ArrayList<>();
        servings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.QUESADILLA, fillingType));
        servings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.TACO, fillingType));
        servings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.BURRITO, fillingType));
        servings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.CRUNCHWRAP, fillingType));
        servings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.QUESADILLA, fillingType));
        servings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.TACO, fillingType));
        servings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.BURRITO, fillingType));
        servings.add(ModItemSuppliers.get(ModFoodComponents.FoodType.CRUNCHWRAP, fillingType));

        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(SERVINGS, 8));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(getServingsProperty()) == 0 ? PLATE_SHAPE : FOOD_SHAPE;
    }

    @Override
    public IntProperty getServingsProperty() {
        return SERVINGS;
    }

    @Override
    public void setServingsProperty(int amount, World world, BlockPos pos){
        var state = world.getBlockState(pos).with(SERVINGS, amount);
        world.setBlockState(pos, state, Block.NOTIFY_ALL);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    static {
        SERVINGS = IntProperty.of("servings", 0, 8);
    }

}
