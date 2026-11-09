package net.mofusya.mek_hand_enriching.items;

import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.mofusya.mek_hand_enriching.C;
import net.mofusya.mek_hand_enriching.items.item.PowerHammerItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HeItems {
    public static final DeferredRegister<Item> R = DeferredRegister.create(Registries.ITEM, C.MOD_ID);

    public static final DeferredHolder<Item, PowerHammerItem> WOODEN_POWER_HAMMER = createPowerHammer("wooden", 4);
    public static final DeferredHolder<Item, PowerHammerItem> STONE_POWER_HAMMER = createPowerHammer("stone", 8);
    public static final DeferredHolder<Item, PowerHammerItem> IRON_POWER_HAMMER = createPowerHammer("iron", 16);
    public static final DeferredHolder<Item, PowerHammerItem> DIAMOND_POWER_HAMMER = createPowerHammer("diamond", 64);
    public static final DeferredHolder<Item, PowerHammerItem> EMERALD_POWER_HAMMER = createPowerHammer("emerald", 128);
    public static final DeferredHolder<Item, PowerHammerItem> OBSIDIAN_POWER_HAMMER = createPowerHammer("obsidian", 1024);


    private static DeferredHolder<Item, PowerHammerItem> createPowerHammer(String name, int durability) {
        return createPowerHammer(name, durability, new Item.Properties());
    }

    private static DeferredHolder<Item, PowerHammerItem> createPowerHammer(String name, int durability, Item.Properties build){
        return R.register(name + "_power_hammer", () -> new PowerHammerItem(build.durability(durability)));
    }
}
