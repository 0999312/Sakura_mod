package cn.mcmod.sakura.data.builder;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import cn.mcmod.sakura.recipes.ChoppingRecipe;
import cn.mcmod.sakura.recipes.RecipeTypeRegistry;
import cn.mcmod_mmf.mmlib.recipe.ChanceResult;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class ChoppingBoardRecipeBuilder {
    private Ingredient item = Ingredient.EMPTY;
    private Ingredient tool = Ingredient.EMPTY;
    private final ItemStack result;
    private final NonNullList<ChanceResult> byproduces = NonNullList.create();
    private final float experience;
    private final int recipeTime;

    private ChoppingBoardRecipeBuilder(ItemLike resultItem, int count, float exp, int time) {
        this.result = new ItemStack(resultItem.asItem(), count);
        this.experience = exp;
        this.recipeTime = time;
    }

    public static ChoppingBoardRecipeBuilder chop(ItemLike resultItem) {
        return new ChoppingBoardRecipeBuilder(resultItem, 1, 1F, 1);
    }

    public static ChoppingBoardRecipeBuilder chop(ItemLike resultItem, int count) {
        return new ChoppingBoardRecipeBuilder(resultItem, count, 1F, 1);
    }

    public static ChoppingBoardRecipeBuilder chop(ItemLike resultItem, float exp, int time) {
        return new ChoppingBoardRecipeBuilder(resultItem, 1, exp, time);
    }

    public static ChoppingBoardRecipeBuilder chop(ItemLike resultItem, int count, float exp, int time) {
        return new ChoppingBoardRecipeBuilder(resultItem, count, exp, time);
    }

    public ChoppingBoardRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(Ingredient.of(tag));
    }

    public ChoppingBoardRecipeBuilder requires(ItemLike item) {
        return this.requires(Ingredient.of(item));
    }

    public ChoppingBoardRecipeBuilder requires(Ingredient ingre) {
        if(this.item.isEmpty())
            this.item = ingre;
        return this;
    }
    
    public ChoppingBoardRecipeBuilder requiresTool(TagKey<Item> tag) {
        return this.requiresTool(Ingredient.of(tag));
    }

    public ChoppingBoardRecipeBuilder requiresTool(ItemLike item) {
        return this.requiresTool(Ingredient.of(item));
    }

    public ChoppingBoardRecipeBuilder requiresTool(Ingredient ingre) {
        if(this.tool.isEmpty())
            this.tool = ingre;
        return this;
    }

    public ChoppingBoardRecipeBuilder addByproduce(ItemLike result) {
        return this.addByproduce(result, 1);
    }

    public ChoppingBoardRecipeBuilder addByproduce(ItemLike result, int count) {
        this.byproduces.add(new ChanceResult(new ItemStack(result.asItem(), count), 1));
        return this;
    }
    
    public ChoppingBoardRecipeBuilder addByproduceWithChance(ItemLike result, float chance) {
        return this.addByproduce(result, 1, chance);
    }

    public ChoppingBoardRecipeBuilder addByproduce(ItemLike result, int count, float chance) {
        this.byproduces.add(new ChanceResult(new ItemStack(result.asItem(), count), chance));
        return this;
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        consumer.accept(new ChoppingBoardRecipeBuilder.Result(id, this.item, this.tool, this.result, this.byproduces, this.experience,
                this.recipeTime));
    }

    public static class Result implements FinishedRecipe {

        private final ChoppingRecipe recipe = new ChoppingRecipe();

        public Result(ResourceLocation id, Ingredient input, Ingredient tool, ItemStack result, NonNullList<ChanceResult> byproduces, float exp, int time) {
            recipe.setId(id);
            recipe.input = input;
            recipe.tool = tool;
            recipe.output = result;
            recipe.extraOutput = byproduces;
            recipe.experience = exp;
            recipe.recipeTime = time;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonObject recipeJson = RecipeTypeRegistry.CHOPPING_RECIPE_SERIALIZER.get().toJson(recipe);
            json.add("ingredient", recipeJson.get("ingredient"));
            json.add("tool", recipeJson.get("tool"));
            json.add("result", recipeJson.get("result"));
            json.add("byproducts", recipeJson.get("byproducts"));
            json.add("experience", recipeJson.get("experience"));
            json.add("recipeTime", recipeJson.get("recipeTime"));
        }

        @Override
        public RecipeSerializer<?> getType() {
            return RecipeTypeRegistry.CHOPPING_RECIPE_SERIALIZER.get();
        }

        @Override
        public ResourceLocation getId() {
            return recipe.getId();
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }

}
