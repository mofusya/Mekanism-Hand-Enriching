package net.mofusya.mek_hand_enriching.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.mofusya.mek_hand_enriching.C;
import net.mofusya.mek_hand_enriching.items.item.PowerHammerItem;
import net.mofusya.ornatelib.registries.OrnateItemRegister;

public class HeItems {
    public static final OrnateItemRegister R = new OrnateItemRegister(C.MOD_ID);

    public static final RegistryObject<Item> WOODEN_POWER_HAMMER = createPowerHammer("wooden", 4);
    public static final RegistryObject<Item> STONE_POWER_HAMMER = createPowerHammer("stone", 8);
    public static final RegistryObject<Item> IRON_POWER_HAMMER = createPowerHammer("iron", 16);
    public static final RegistryObject<Item> DIAMOND_POWER_HAMMER = createPowerHammer("diamond", 64);
    public static final RegistryObject<Item> EMERALD_POWER_HAMMER = createPowerHammer("emerald", 128);
    public static final RegistryObject<Item> OBSIDIAN_POWER_HAMMER = createPowerHammer("obsidian", 1024);


    private static RegistryObject<Item> createPowerHammer(String name, int durability) {
        return createPowerHammer(name, durability, new Item.Properties());
    }

    private static RegistryObject<Item> createPowerHammer(String name, int durability, Item.Properties build){
        return R.register(name + "_power_hammer", PowerHammerItem::new, build.defaultDurability(durability));
    }
}
