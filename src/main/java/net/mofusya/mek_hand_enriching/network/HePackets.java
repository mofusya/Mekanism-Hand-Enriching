package net.mofusya.mek_hand_enriching.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundEvents;
import net.mofusya.mek_hand_enriching.C;
import net.mofusya.ornatelib.registries.network.PacketRegister;
import net.mofusya.ornatelib.registries.network.packet.ClientPacket;
import net.mofusya.ornatelib.registries.network.packet.SimpleClientPacket;

public class HePackets {
    public static final PacketRegister R = new PacketRegister(C.MOD_ID);

    public static final ClientPacket ON_USE_POWER_HAMMER = R.register(new SimpleClientPacket("on_use_power_hammer", () -> {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        if (player == null) return;

        player.playSound(SoundEvents.AXE_WAX_OFF);
    }));

}
