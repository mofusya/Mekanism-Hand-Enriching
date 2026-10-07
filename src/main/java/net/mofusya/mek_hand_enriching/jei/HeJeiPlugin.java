package net.mofusya.mek_hand_enriching.jei;

import mekanism.client.jei.MekanismJEI;
import mekanism.client.jei.MekanismJEIRecipeType;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;
import net.mofusya.mek_hand_enriching.C;
import net.mofusya.mek_hand_enriching.items.HeItems;

@JeiPlugin
public class HeJeiPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(C.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        IModPlugin.super.registerRecipeCatalysts(registration);

        registration.addRecipeCatalysts(MekanismJEI.recipeType(MekanismJEIRecipeType.ENRICHING), VanillaTypes.ITEM_STACK, HeItems.R.getMainItems().stream().map(RegistryObject::get).map(ItemStack::new).toList());
    }
}
