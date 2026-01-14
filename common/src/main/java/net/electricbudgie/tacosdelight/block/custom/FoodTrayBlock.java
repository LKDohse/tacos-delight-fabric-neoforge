package net.electricbudgie.tacosdelight.block.custom;

import net.electricbudgie.tacosdelight.block.custom.logic.FoodTrayBlockLogic;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

//All inspiration goes to Farmer's Delight: https://github.com/vectorwing/FarmersDelight
//Some logic reimplemented in order to put in a mod-platform-agnostic context

public abstract class FoodTrayBlock extends Block {
    public static final DirectionProperty FACING;
    public static IntProperty SERVINGS;
    protected int MAX_SERVINGS;

    protected static final VoxelShape[] SHAPES;
    protected static final VoxelShape PLATE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape FOOD_SHAPE = VoxelShapes.union(
            PLATE_SHAPE,
            Block.createCuboidShape(2.0D, 2.0D, 2.0D, 14.0D, 4.0D, 14.0D)
    );

    protected List<Supplier<Item>> servings;
    public final boolean hasLeftovers;

    public FoodTrayBlock(AbstractBlock.Settings properties, List<Supplier<Item>> servings, boolean hasLeftovers) {
        super(properties);
        MAX_SERVINGS = servings.size();
        SERVINGS = IntProperty.of("servings", 0, MAX_SERVINGS);
        this.servings = servings;
        this.hasLeftovers = hasLeftovers;
    }

    public FoodTrayBlock(AbstractBlock.Settings properties, Supplier<Item> servingItem, int maxServings, boolean hasLeftovers) {
        super(properties);
        this.MAX_SERVINGS = maxServings;
        SERVINGS = IntProperty.of("servings", 0, MAX_SERVINGS);
        this.servings = IntStream.range(0, maxServings)
                .mapToObj(i -> servingItem)
                .toList();
        this.hasLeftovers = hasLeftovers;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        int currentServingsRemaining = state.get(SERVINGS);
        if (FoodTrayBlockLogic.canServe(currentServingsRemaining)) {
            giveOrDropItem(player, getServingItem(currentServingsRemaining));
            world.setBlockState(pos, state.with(SERVINGS, FoodTrayBlockLogic.getRemainingServings(currentServingsRemaining)));
        } else {
            world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 1f, 1f, true);
            world.breakBlock(pos, false);
        }
        return ActionResult.SUCCESS;
    }

    protected static void giveOrDropItem(PlayerEntity player, ItemStack stack) {
        if (!player.getInventory().insertStack(stack)) {
            player.dropItem(stack, false);
        }
    }

    public ItemStack getServingItem(int servingIndex) {
        return new ItemStack((ItemConvertible) servings.get(servingIndex));
    }

    public IntProperty getServingsProperty() {
        return SERVINGS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return SHAPES[(Integer) state.get(SERVINGS)];
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return (BlockState) this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canPlaceAt(level, currentPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        return level.getBlockState(pos.down()).isSolidBlock(level, pos.down());
    }

    @Override
    public int getComparatorOutput(BlockState blockState, World level, BlockPos pos) {
        return (Integer) blockState.get(this.getServingsProperty());
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
        SHAPES = new VoxelShape[]{PLATE_SHAPE, FOOD_SHAPE};
    }
}