package net.mofusya.mek_hand_enriching.items.item;

import mekanism.api.recipes.ItemStackToItemStackRecipe;
import mekanism.common.recipe.MekanismRecipeType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;
import net.mofusya.mek_hand_enriching.network.HePackets;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class PowerHammerItem extends Item implements Vanishable {
    public PowerHammerItem(Properties build) {
        super(build);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide) return super.use(level, player, hand);

        ItemStack itemStack = player.getItemInHand(hand);
        ItemStack ingredientStack = player.getItemInHand(hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);

        var recipes = MekanismRecipeType.ENRICHING.getRecipes(level);
        for (ItemStackToItemStackRecipe recipe : recipes) {
            if (recipe.getInput().test(ingredientStack)) {
                ingredientStack.shrink((int) recipe.getInput().getNeededAmount(ingredientStack));
                player.addItem(recipe.getOutput(ingredientStack.copy()));
                itemStack.hurtAndBreak(1, player, pPLayer -> {
                    pPLayer.broadcastBreakEvent(hand);
                });
                HePackets.ON_USE_POWER_HAMMER.send2Player((ServerPlayer) player);
                return InteractionResultHolder.success(itemStack);
            }
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(itemStack, level, tooltip, flag);

        tooltip.add(Component.translatable("item.mek_hand_enriching.power_hammer.desc").withStyle(ChatFormatting.DARK_GRAY));
    }
}
