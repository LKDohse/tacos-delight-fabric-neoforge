package net.electricbudgie.fabric.tacosdelight.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.electricbudgie.fabric.tacosdelight.block.FabricBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public class FabricModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(TacosDelight.MOD_ID, RegistryKeys.ITEM);

    //Block Items
    public static final RegistrySupplier<Item> CHEESE_PRESS_ITEM = registerItemSupplier("cheese_press", ()-> new BlockItem(FabricBlocks.CHEESE_PRESS_BLOCK.get(), new Item.Settings()));

    public static RegistrySupplier<Item> registerItemSupplier(String name, Supplier<Item> supplier){
        var registeredItem = ITEMS.register(name, supplier);
        return registeredItem;
    }

    public static void initialize() {
        ITEMS.register();
        TacosDelight.LOGGER.info("Registering Mod Items for " + TacosDelight.MOD_ID);
    }
}
