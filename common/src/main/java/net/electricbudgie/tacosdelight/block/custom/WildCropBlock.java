package net.electricbudgie.tacosdelight.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Iterator;


// Most of this absolutely comes from Farmer's Delight, just re-implemented here to live in 'Common' logic
// Though I pared it down to what I mostly needed-- a plant that can generate in sand on worldgen

public class WildCropBlock extends FlowerBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    public WildCropBlock(SuspiciousStewEffectsComponent stewEffects, Settings settings) {
        super(stewEffects, settings);
    }

    public boolean canPlantOnTop(BlockState state, BlockView level, BlockPos pos) {
        return state.isIn(BlockTags.DIRT) || state.isIn(BlockTags.SAND);
    }


}
