package net.mofusya.mek_hand_enriching.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;
import net.mofusya.mek_hand_enriching.C;
import net.mofusya.ornatelib.registries.OrnateCreativeTabRegister;
import net.mofusya.ornatelib.util.ItemHelpers;

public class HeCreativeTabs {

    public static final OrnateCreativeTabRegister R = new OrnateCreativeTabRegister(C.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN = R.register("main", () -> new ItemStack(HeItems.DIAMOND_POWER_HAMMER.get()), (parameters, output) -> {
        output.acceptAll(ItemHelpers.itemRegistries2ItemStacks(HeItems.R.getMainItems()));
    });
}
