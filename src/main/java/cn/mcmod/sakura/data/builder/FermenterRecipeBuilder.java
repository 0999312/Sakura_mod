package cn.mcmod.sakura.data.builder;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import cn.mcmod.sakura.recipes.FermenterRecipe;
import cn.mcmod.sakura.recipes.RecipeTypeRegistry;
import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fluids.FluidStack;

public class FermenterRecipeBuilder {
    private final NonNullList<Ingredient> ingredients = NonNullList.create();
    private final NonNullList<ItemStack> result = NonNullList.create();
    private final FluidIngredient fluid;
    private final FluidStack result_fluid;
    private final float experience;
    private final int recipeTime;

    private FermenterRecipeBuilder(FluidIngredient fluid, ItemLike resultItem, int count, FluidStack result_fluid, float exp, int time) {
        this.result.add(new ItemStack(resultItem.asItem(), count));
        this.fluid = fluid;
        this.result_fluid = result_fluid;
        this.experience = exp;
        this.recipeTime = time;
    }
    
    private FermenterRecipeBuilder(FluidIngredient fluid, FluidStack result_fluid, float exp, int time) {
        this.fluid = fluid;
        this.result_fluid = result_fluid;
        this.experience = exp;
        this.recipeTime = time;
    }
    
    public static FermenterRecipeBuilder fermenting(FluidIngredient fluid, FluidStack result_fluid, float exp, int time) {
        return new FermenterRecipeBuilder(fluid, result_fluid, exp, time);
    }
    
    public static FermenterRecipeBuilder fermenting(FluidIngredient fluid, FluidStack result_fluid) {
        return new FermenterRecipeBuilder(fluid, result_fluid, 0F, 800);
    }

    public static FermenterRecipeBuilder fermenting(FluidIngredient fluid, ItemLike resultItem, FluidStack result_fluid) {
        return new FermenterRecipeBuilder(fluid, resultItem, 1, result_fluid, 0F, 800);
    }

    public static FermenterRecipeBuilder fermenting(FluidIngredient fluid, ItemLike resultItem, int count, FluidStack result_fluid) {
        return new FermenterRecipeBuilder(fluid, resultItem, count, result_fluid, 0F, 800);
    }

    public static FermenterRecipeBuilder fermenting(FluidIngredient fluid, ItemLike resultItem, FluidStack result_fluid, float exp, int time) {
        return new FermenterRecipeBuilder(fluid, resultItem, 1, result_fluid, exp, time);
    }

    public static FermenterRecipeBuilder fermenting(FluidIngredient fluid, ItemLike resultItem, int count, FluidStack result_fluid, float exp,
            int time) {
        return new FermenterRecipeBuilder(fluid, resultItem, count, result_fluid, exp, time);
    }

    public FermenterRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(Ingredient.of(tag));
    }

    public FermenterRecipeBuilder requires(ItemLike item) {
        return this.requires(item, 1);
    }

    public FermenterRecipeBuilder requires(ItemLike item, int count) {
        for (int i = 0; i < count; ++i) {
            this.requires(Ingredient.of(item));
        }
        return this;
    }

    public FermenterRecipeBuilder requires(Ingredient ingre) {
        return this.requires(ingre, 1);
    }

    public FermenterRecipeBuilder requires(Ingredient ingre, int count) {
        for (int i = 0; i < count; ++i) {
            this.ingredients.add(ingre);
        }
        return this;
    }
    
    public FermenterRecipeBuilder addResult(ItemLike result) {
        return this.addResult(result, 1);
    }

    public FermenterRecipeBuilder addResult(ItemLike result, int count) {
        this.result.add(new ItemStack(result.asItem(), count));
        return this;
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        consumer.accept(new FermenterRecipeBuilder.Result(id, this.fluid, this.result, this.ingredients,
                result_fluid, this.experience, this.recipeTime));
    }


    public static class Result implements FinishedRecipe {
        private final FermenterRecipe recipe = new FermenterRecipe();

        public Result(ResourceLocation id, FluidIngredient fluid, NonNullList<ItemStack> result, NonNullList<Ingredient> ingredients
                , FluidStack result_fluid, float exp, int time) {
            recipe.setId(id);
            recipe.outputItems = result;
            recipe.inputFluid = fluid;
            recipe.inputItems = ingredients;
            recipe.outputFluid = result_fluid;
            recipe.experience = exp;
            recipe.recipeTime = time;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonObject recipeJson = RecipeTypeRegistry.FERMENTER_RECIPE_SERIALIZER.get().toJson(recipe);
            json.add("ingredients", recipeJson.get("ingredients"));
            json.add("fluid", recipeJson.get("fluid"));
            json.add("results", recipeJson.get("results"));
            json.add("result_fluid", recipeJson.get("result_fluid"));
            json.add("experience", recipeJson.get("experience"));
            json.add("recipeTime", recipeJson.get("recipeTime"));
        }

        @Override
        public RecipeSerializer<?> getType() {
            return RecipeTypeRegistry.FERMENTER_RECIPE_SERIALIZER.get();
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
