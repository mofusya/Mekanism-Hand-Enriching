package net.mofusya.mek_hand_enriching.data;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.mofusya.mek_hand_enriching.C;
import net.mofusya.mek_hand_enriching.items.HeItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    private static void engineRecipe(Ingredient baseIngredient, Item subBaseIngredient, Item result, Consumer<FinishedRecipe> writer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern(" #%")
                .pattern(" &#")
                .pattern("%  ")
                .define('#', baseIngredient)
                .define('%', Ingredient.of(ItemTags.LOGS_THAT_BURN))
                .define('&', Ingredient.of(subBaseIngredient))
                .unlockedBy(getHasName(subBaseIngredient), inventoryTrigger(ItemPredicate.Builder.item().of(subBaseIngredient).build()))
                .save(writer, C.MOD_ID + ":simple_" + getItemName(result));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, subBaseIngredient, 1)
                .requires(result)
                .unlockedBy(getHasName(result), inventoryTrigger(ItemPredicate.Builder.item().of(result).build()))
                .save(writer, C.MOD_ID + ":" + getItemName(subBaseIngredient) + "_from_separating");
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HeItems.WOODEN_POWER_HAMMER.get())
                .pattern(" #%")
                .pattern(" %#")
                .pattern("%  ")
                .define('#', Ingredient.of(ItemTags.PLANKS))
                .define('%', Ingredient.of(ItemTags.LOGS_THAT_BURN))
                .unlockedBy("has_any_log", inventoryTrigger(ItemPredicate.Builder.item().of(ItemTags.LOGS_THAT_BURN).build()))
                .save(writer, C.MOD_ID + ":simple_" + getItemName(HeItems.WOODEN_POWER_HAMMER.get()));

        engineRecipe(Ingredient.of(ItemTags.STONE_BRICKS), HeItems.WOODEN_POWER_HAMMER.get(), HeItems.STONE_POWER_HAMMER.get(), writer);
        engineRecipe(Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON), HeItems.STONE_POWER_HAMMER.get(), HeItems.IRON_POWER_HAMMER.get(), writer);
        engineRecipe(Ingredient.of(Tags.Items.STORAGE_BLOCKS_DIAMOND), HeItems.IRON_POWER_HAMMER.get(), HeItems.DIAMOND_POWER_HAMMER.get(), writer);
        engineRecipe(Ingredient.of(Tags.Items.STORAGE_BLOCKS_EMERALD), HeItems.DIAMOND_POWER_HAMMER.get(), HeItems.EMERALD_POWER_HAMMER.get(), writer);
        engineRecipe(Ingredient.of(Tags.Items.OBSIDIAN), HeItems.EMERALD_POWER_HAMMER.get(), HeItems.OBSIDIAN_POWER_HAMMER.get(), writer);
    }
}
