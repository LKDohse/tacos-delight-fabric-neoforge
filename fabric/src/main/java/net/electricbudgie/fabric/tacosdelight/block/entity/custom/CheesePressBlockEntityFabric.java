package net.electricbudgie.fabric.tacosdelight.block.entity.custom;

import net.electricbudgie.fabric.tacosdelight.block.CheesePressBlock;
import net.electricbudgie.fabric.tacosdelight.block.entity.FabricModBlockEntities;
import net.electricbudgie.tacosdelight.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CheesePressBlockEntityFabric extends BlockEntity implements GeoBlockEntity, GeoAnimatable {
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 12000;
    protected boolean pressing;

    public CheesePressBlockEntityFabric(BlockPos pos, BlockState state) {
        super(FabricModBlockEntities.CHEESE_PRESS_BE.get(), pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CheesePressBlockEntityFabric.this.progress;
                    case 1 -> CheesePressBlockEntityFabric.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        CheesePressBlockEntityFabric.this.progress = value;
                    case 1:
                        CheesePressBlockEntityFabric.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    public void startPressing(BlockPos pos, BlockState state){
        pressing = true;
        world.setBlockState(pos, state.with(CheesePressBlock.PRESSING, true), CheesePressBlock.NOTIFY_ALL);
    }

    public void stopPressing(BlockPos pos, BlockState state){
        pressing = false;
        world.setBlockState(pos, state.with(CheesePressBlock.PRESSING, false), CheesePressBlock.NOTIFY_ALL);
    }

    public void tick(World world, BlockPos pos, BlockState state){
        if (!pressing) return;
        if (progress == maxProgress){
            ItemStack cheeseStack = new ItemStack(ModBlocks.CHEESE_WHEEL_BLOCK.get().asItem(), 1);
            ItemEntity cheeseEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), cheeseStack);
            world.spawnEntity(cheeseEntity);
            progress = 0;
            stopPressing(pos, state);
        }
        else progress++;
        markDirty(world, pos, state);
    }

    // Animation

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,
                "baseController",
                0,
                state -> {
                    if (getCachedState().get(CheesePressBlock.PRESSING)){
                        return state.setAndContinue(RawAnimation.begin().thenPlayAndHold("press_down"));
                    }
                    else {
                        return state.setAndContinue(RawAnimation.begin().thenPlayAndHold("press_up"));
                    }
                }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    // NBT reading/writing and network packets
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);

        nbt.putInt("cheese_press.progress", progress);
        nbt.putInt("cheese_press.max_progress", maxProgress);
        nbt.putBoolean("cheese_press.is_pressing", pressing);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        progress = nbt.getInt("cheese_press.progress");
        maxProgress = nbt.getInt("cheese_press.max_progress");
        pressing = nbt.getBoolean("cheese_press.is_pressing");
        super.readNbt(nbt, registryLookup);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}