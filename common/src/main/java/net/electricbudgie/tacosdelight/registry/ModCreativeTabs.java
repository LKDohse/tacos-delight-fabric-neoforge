package net.electricbudgie.tacosdelight.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.electricbudgie.TacosDelight;
import net.electricbudgie.tacosdelight.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class ModCreativeTabs {
        public static final DeferredRegister<ItemGroup> TABS =
                DeferredRegister.create(TacosDelight.MOD_ID,
                        RegistryKeys.ITEM_GROUP);

        public static RegistrySupplier<ItemGroup> TACOS_DELIGHT_TAB;

        public static void initTabs(){
            TACOS_DELIGHT_TAB = TABS.register("tacos_delight_tab", ()->
                    CreativeTabRegistry.create(Text.translatable("category.tacos_delight_tab"), () -> new ItemStack(ModItems.BEEF_TACO)));

            TABS.register();
        }
}
