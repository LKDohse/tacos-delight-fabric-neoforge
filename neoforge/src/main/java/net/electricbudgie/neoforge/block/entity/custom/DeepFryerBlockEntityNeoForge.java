package net.electricbudgie.neoforge.block.entity.custom;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import net.electricbudgie.neoforge.block.custom.DeepFryerBlock;
import net.electricbudgie.neoforge.block.entity.NeoForgeModBlockEntities;
import net.electricbudgie.neoforge.menu.custom.DeepFryerScreenHandler;
import net.electricbudgie.tacosdelight.block.entity.ImplementedInventory;
import net.electricbudgie.tacosdelight.recipe.DeepFryerRecipe;
import net.electricbudgie.tacosdelight.recipe.DeepFryerRecipeInput;
import net.electricbudgie.tacosdelight.recipe.ModRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
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

import java.util.Optional;

public class DeepFryerBlockEntityNeoForge extends BlockEntity implements ExtendedMenuProvider, ImplementedInventory, GeoBlockEntity, GeoAnimatable {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final int INPUT_SLOT = 0;
    public static final int OUTPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private final int DEFAULT_MAX_PROGRESS = 72;

    protected boolean cooking;

    public DeepFryerBlockEntityNeoForge(BlockPos pos, BlockState state) {
        super(NeoForgeModBlockEntities.DEEP_FRYER_BE.get(), pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> DeepFryerBlockEntityNeoForge.this.progress;
                    case 1 -> DeepFryerBlockEntityNeoForge.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        DeepFryerBlockEntityNeoForge.this.progress = value;
                    case 1:
                        DeepFryerBlockEntityNeoForge.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        //20 ticks per second
        if (isCrafting()) {
            if (progress == 1) sizzle(world, pos);
            startCooking();
            increaseCraftingProgress();
            markDirty(world, pos, state);

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
                if (!hasMoreItemsToCook())
                    stopCooking();
            }
        } else {
            resetProgress();
        }
    }

    private void sizzle(World world, BlockPos pos){
        if (!world.isClient)
            world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.3f, 1f);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    //Crafting Stuff
    public boolean isCrafting() {
        return hasRecipe() && canInsertIntoOutputSlot();
    }

    public boolean hasMoreItemsToCook(){
        var items = inventory.get(INPUT_SLOT);
        return (items.getCount() > 0) && hasRecipe();
    }

    public void startCooking() {
        if (!world.isClient) {
            world.setBlockState(pos, getCachedState().with(DeepFryerBlock.COOKING, true), Block.NOTIFY_ALL);
        }
    }

    public void stopCooking() {
        if (!world.isClient) {
            world.setBlockState(pos, getCachedState().with(DeepFryerBlock.COOKING, false), Block.NOTIFY_ALL);
        }
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = DEFAULT_MAX_PROGRESS;
    }

    private void craftItem() {
        Optional<RecipeEntry<DeepFryerRecipe>> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().output().getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + recipe.get().value().output().getCount()));
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean canInsertIntoOutputSlot() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<DeepFryerRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) return false;

        ItemStack output = recipe.get().value().getResult(null);
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeEntry<DeepFryerRecipe>> getCurrentRecipe() {
        return this.getWorld().getRecipeManager()
                .getFirstMatch(ModRecipes.DEEP_FRYER_RECIPE_TYPE.value(), new DeepFryerRecipeInput((inventory.get(INPUT_SLOT))), this.getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
        int currentCount = this.getStack(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    //Animation BULLSHIT

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);



    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,
                "baseController",
                5,
                state -> {
                    if (getCachedState().get(DeepFryerBlock.COOKING)){
                        return state.setAndContinue(RawAnimation.begin().thenPlayAndHold("start_frying"));
                    }
                    else {
                        return state.setAndContinue(RawAnimation.begin().thenPlayAndHold("stop_frying"));
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
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("deep_fryer.progress", progress);
        nbt.putInt("deep_fryer.max_progress", maxProgress);
        nbt.putBoolean("deep_fryer.is_frying", cooking);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("deep_fryer.progress");
        maxProgress = nbt.getInt("deep_fryer.max_progress");
        cooking = nbt.getBoolean("deep_fryer.is_frying");
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

    ///GUI stuff


    @Override
    public Text getDisplayName() {
        return Text.literal("Deep Fryer");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
       //return new DeepFryerMenu(syncId, playerInventory, player);
        return new DeepFryerScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public void saveExtraData(PacketByteBuf packetByteBuf) {

    }
}

