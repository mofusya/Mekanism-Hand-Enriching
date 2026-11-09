package net.mofusya.mek_hand_enriching.items.item;

import mekanism.api.recipes.ItemStackToItemStackRecipe;
import mekanism.common.recipe.MekanismRecipeType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;

import java.util.List;

public class PowerHammerItem extends Item {
    public PowerHammerItem(Properties build) {
        super(build);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide) return super.use(level, player, hand);

        ItemStack itemStack = player.getItemInHand(hand);
        ItemStack ingredientStack = player.getItemInHand(hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);

        var recipes = MekanismRecipeType.ENRICHING.getRecipes(level);
        for (RecipeHolder<ItemStackToItemStackRecipe> recipeHolder : recipes) {
            var recipe = recipeHolder.value();

            if (recipe.getInput().test(ingredientStack)) {
                ingredientStack.shrink((int) recipe.getInput().getNeededAmount(ingredientStack));
                player.addItem(recipe.getOutput(ingredientStack.copy()));
                itemStack.hurtAndBreak(1, player, hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                return InteractionResultHolder.success(itemStack);
            }
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(itemStack, context, tooltip, flag);

        tooltip.add(Component.translatable("item.mek_hand_enriching.power_hammer.desc").withStyle(ChatFormatting.DARK_GRAY));
    }
}
