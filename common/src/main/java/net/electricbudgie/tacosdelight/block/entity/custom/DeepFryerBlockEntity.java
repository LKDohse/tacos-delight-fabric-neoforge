package net.electricbudgie.tacosdelight.block.entity.custom;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import net.electricbudgie.tacosdelight.block.custom.DeepFryerBlock;
import net.electricbudgie.tacosdelight.block.entity.ImplementedInventory;
import net.electricbudgie.tacosdelight.block.entity.ModBlockEntities;
import net.electricbudgie.tacosdelight.recipe.DeepFryerRecipe;
import net.electricbudgie.tacosdelight.recipe.DeepFryerRecipeInput;
import net.electricbudgie.tacosdelight.recipe.ModRecipes;
import net.electricbudgie.tacosdelight.screen.DeepFryerScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class DeepFryerBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedMenuProvider {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public static final int INPUT_SLOT = 0;
    public static final int OUTPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private final int DEFAULT_MAX_PROGRESS = 72;

    protected boolean cooking;

    public DeepFryerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DEEP_FRYER_BE.get(), pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> DeepFryerBlockEntity.this.progress;
                    case 1 -> DeepFryerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        DeepFryerBlockEntity.this.progress = value;
                    case 1:
                        DeepFryerBlockEntity.this.maxProgress = value;
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

    @Override
    public void saveExtraData(PacketByteBuf packetByteBuf) {
        packetByteBuf.writeBlockPos(getPos());
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Deep Fryer");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new DeepFryerScreenHandler(syncId, playerInventory, getPos());
    }
}
