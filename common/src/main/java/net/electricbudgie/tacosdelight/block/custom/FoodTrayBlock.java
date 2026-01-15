package net.electricbudgie.tacosdelight.block.custom;

import net.electricbudgie.tacosdelight.block.custom.logic.FoodTrayBlockLogic;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

//All inspiration goes to Farmer's Delight: https://github.com/vectorwing/FarmersDelight
//Some logic reimplemented in order to put in a mod-platform-agnostic context

public abstract class FoodTrayBlock extends Block {
    public static final DirectionProperty FACING;

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
        this.servings = servings;
        this.hasLeftovers = hasLeftovers;
    }

    public FoodTrayBlock(AbstractBlock.Settings properties, Supplier<Item> servingItem, int maxServings, boolean hasLeftovers) {
        super(properties);
        this.servings = IntStream.range(0, maxServings)
                .mapToObj(i -> servingItem)
                .toList();
        this.hasLeftovers = hasLeftovers;
    }

    protected static void giveOrDropItem(PlayerEntity player, ItemStack stack) {
        if (!player.getInventory().insertStack(stack)) {
            player.dropItem(stack, false);
        }
    }

    public ItemStack getServingItem(int servingIndex) {
        return new ItemStack(servings.get(servingIndex - 1).get());
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        int currentServingsRemaining = state.get(getServingsProperty());
        if (FoodTrayBlockLogic.canServe(currentServingsRemaining)) {
            giveOrDropItem(player, getServingItem(currentServingsRemaining));
            world.playSound(pos.getX(), pos.getY(), pos.getZ(), (SoundEvent) SoundEvents.ITEM_ARMOR_EQUIP_GENERIC.value(), SoundCategory.BLOCKS, 1f, 1f, true);
            setServingsProperty(FoodTrayBlockLogic.getRemainingServings(currentServingsRemaining), world, pos);
        } else {
            world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 1f, 1f, true);
            world.breakBlock(pos, false);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return (BlockState) this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing());
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canPlaceAt(level, currentPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        return level.getBlockState(pos.down()).isSolidBlock(level, pos.down());
    }

    abstract IntProperty getServingsProperty();

    abstract void setServingsProperty(int amount, World world, BlockPos pos);

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