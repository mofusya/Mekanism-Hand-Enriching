package net.mofusya.mek_hand_enriching.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.mofusya.mek_hand_enriching.C;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HeCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> R = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, C.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = R.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.mek_hand_enriching.main"))
            .icon(() -> new ItemStack(HeItems.DIAMOND_POWER_HAMMER))
            .displayItems(HeItems.R.getEntries())
            .build());
}
