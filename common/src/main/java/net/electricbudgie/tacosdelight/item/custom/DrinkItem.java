package net.electricbudgie.tacosdelight.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

//From part of a class (Drinkable Item) from Farmer's Delight; can't directly depend on this due to using architectury

public class DrinkItem extends Item {
    public DrinkItem(Item.Settings properties) {
        super(properties);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public int getMaxUseTime(ItemStack stack, LivingEntity entity) {
        return 32;
    }

    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack heldStack = player.getStackInHand(hand);
        if (heldStack.contains(DataComponentTypes.FOOD)) {
            if (player.canConsume(((FoodComponent)heldStack.get(DataComponentTypes.FOOD)).canAlwaysEat())) {
                player.setCurrentHand(hand);
                return TypedActionResult.consume(heldStack);
            } else {
                return TypedActionResult.fail(heldStack);
            }
        } else {
            return ItemUsage.consumeHeldItem(level, player, hand);
        }
    }
}