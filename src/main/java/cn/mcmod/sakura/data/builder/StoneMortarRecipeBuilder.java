package cn.mcmod.sakura.data.builder;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import cn.mcmod.sakura.recipes.RecipeTypeRegistry;
import cn.mcmod.sakura.recipes.StoneMortarRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class StoneMortarRecipeBuilder {
    private final NonNullList<ItemStack> result = NonNullList.create();
    private final NonNullList<Ingredient> ingredients = NonNullList.create();
    private final float experience;
    private final int recipeTime;

    private StoneMortarRecipeBuilder(ItemLike resultItem, int count, float exp, int time) {
        this.result.add(new ItemStack(resultItem.asItem(), count));
        this.experience = exp;
        this.recipeTime = time;
    }

    public static StoneMortarRecipeBuilder mortar(ItemLike resultItem) {
        return new StoneMortarRecipeBuilder(resultItem, 1, 0F, 200);
    }

    public static StoneMortarRecipeBuilder mortar(ItemLike resultItem, int count) {
        return new StoneMortarRecipeBuilder(resultItem, count, 0F, 200);
    }

    public static StoneMortarRecipeBuilder mortar(ItemLike resultItem, float exp, int time) {
        return new StoneMortarRecipeBuilder(resultItem, 1, exp, time);
    }

    public static StoneMortarRecipeBuilder mortar(ItemLike resultItem, int count, float exp, int time) {
        return new StoneMortarRecipeBuilder(resultItem, count, exp, time);
    }

    public StoneMortarRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(Ingredient.of(tag));
    }

    public StoneMortarRecipeBuilder requires(ItemLike item) {
        return this.requires(item, 1);
    }

    public StoneMortarRecipeBuilder requires(ItemLike item, int count) {
        for (int i = 0; i < count; ++i) {
            this.requires(Ingredient.of(item));
        }
        return this;
    }

    public StoneMortarRecipeBuilder requires(Ingredient ingre) {
        return this.requires(ingre, 1);
    }

    public StoneMortarRecipeBuilder requires(Ingredient ingre, int count) {
        for (int i = 0; i < count; ++i) {
            this.ingredients.add(ingre);
        }
        return this;
    }

    public StoneMortarRecipeBuilder addResult(ItemLike result) {
        return this.addResult(result, 1);
    }

    public StoneMortarRecipeBuilder addResult(ItemLike result, int count) {
        this.result.add(new ItemStack(result.asItem(), count));
        return this;
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        consumer.accept(new StoneMortarRecipeBuilder.Result(id, this.result, this.ingredients, this.experience,
                this.recipeTime));
    }

    public static class Result implements FinishedRecipe {

        private final StoneMortarRecipe recipe = new StoneMortarRecipe();

        public Result(ResourceLocation id, NonNullList<ItemStack> results, NonNullList<Ingredient> ingredients, float exp, int time) {
            recipe.setId(id);
            recipe.output = results;
            recipe.inputItems = ingredients;
            recipe.experience = exp;
            recipe.recipeTime = time;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonObject recipeJson = RecipeTypeRegistry.STONE_MORTAR_RECIPE_SERIALIZER.get().toJson(recipe);
            json.add("ingredients", recipeJson.get("ingredients"));
            json.add("results", recipeJson.get("results"));
            json.add("experience", recipeJson.get("experience"));
            json.add("recipeTime", recipeJson.get("recipeTime"));
        }

        @Override
        public RecipeSerializer<?> getType() {
            return RecipeTypeRegistry.STONE_MORTAR_RECIPE_SERIALIZER.get();
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
