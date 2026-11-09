package net.mofusya.mek_hand_enriching;

import com.mojang.logging.LogUtils;
import net.mofusya.mek_hand_enriching.items.HeCreativeTabs;
import net.mofusya.mek_hand_enriching.items.HeItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

@Mod(HandEnriching.MOD_ID)
public class HandEnriching {
    public static final String MOD_ID = "mek_hand_enriching";
    private static final Logger LOGGER = LogUtils.getLogger();

    public HandEnriching(IEventBus modEventBus, ModContainer modContainer) {
        HeItems.R.register(modEventBus);
        HeCreativeTabs.R.register(modEventBus);
    }
}
