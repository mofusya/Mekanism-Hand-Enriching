package net.mofusya.mek_hand_enriching;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mofusya.mek_hand_enriching.items.HeCreativeTabs;
import net.mofusya.mek_hand_enriching.items.HeItems;
import net.mofusya.mek_hand_enriching.network.HePackets;
import org.slf4j.Logger;

@Mod(HandEnriching.MOD_ID)
public class HandEnriching
{
    public static final String MOD_ID = "mek_hand_enriching";
    private static final Logger LOGGER = LogUtils.getLogger();

    public HandEnriching()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        HeItems.R.register(modEventBus);
        HePackets.R.register();
        HeCreativeTabs.R.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        /*
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(EXAMPLE_BLOCK_ITEM);
         */
    }
}
