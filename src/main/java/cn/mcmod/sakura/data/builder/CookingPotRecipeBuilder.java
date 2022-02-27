package cn.mcmod.sakura.data.builder;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cn.mcmod.sakura.recipes.RecipeTypeRegistry;
import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class CookingPotRecipeBuilder {
    private final ItemStack result;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final FluidIngredient fluid;
    @Nullable
    private String group;
    private final float experience;
    private final int recipeTime;

    public CookingPotRecipeBuilder(FluidIngredient fluid, ItemLike resultItem, int count, float exp, int time) {
        this.result = new ItemStack(resultItem.asItem(), count);
        this.fluid = fluid;
        this.experience = exp;
        this.recipeTime = time;
    }

    public static CookingPotRecipeBuilder cooking(FluidIngredient fluid, ItemLike resultItem) {
        return new CookingPotRecipeBuilder(fluid, resultItem, 1, 0F, 200);
    }

    public static CookingPotRecipeBuilder cooking(FluidIngredient fluid, ItemLike resultItem, int count) {
        return new CookingPotRecipeBuilder(fluid, resultItem, count, 0F, 200);
    }

    public static CookingPotRecipeBuilder cooking(FluidIngredient fluid, ItemLike resultItem, float exp, int time) {
        return new CookingPotRecipeBuilder(fluid, resultItem, 1, exp, time);
    }

    public static CookingPotRecipeBuilder cooking(FluidIngredient fluid, ItemLike resultItem, int count, float exp,
            int time) {
        return new CookingPotRecipeBuilder(fluid, resultItem, count, exp, time);
    }

    public CookingPotRecipeBuilder requires(Tag<Item> tag) {
        return this.requires(Ingredient.of(tag));
    }

    public CookingPotRecipeBuilder requires(ItemLike item) {
        return this.requires(item, 1);
    }

    public CookingPotRecipeBuilder requires(ItemLike item, int count) {
        for (int i = 0; i < count; ++i) {
            this.requires(Ingredient.of(item));
        }
        return this;
    }

    public CookingPotRecipeBuilder requires(Ingredient ingre) {
        return this.requires(ingre, 1);
    }

    public CookingPotRecipeBuilder requires(Ingredient ingre, int count) {
        for (int i = 0; i < count; ++i) {
            this.ingredients.add(ingre);
        }
        return this;
    }

    public CookingPotRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    public Item getResult() {
        return this.result.getItem();
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        consumer.accept(new CookingPotRecipeBuilder.Result(id, this.fluid, this.result,
                this.group == null ? "" : this.group, this.ingredients, this.experience, this.recipeTime));
    }

    public int getRecipeTime() {
        return recipeTime;
    }

    public float getExperience() {
        return experience;
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final ItemStack result;
        private final String group;
        private final List<Ingredient> ingredients;
        private final float experience;
        private final int recipeTime;
        private final FluidIngredient fluid;

        public Result(ResourceLocation id, FluidIngredient fluid, ItemStack result, String group,
                List<Ingredient> ingredients, float exp, int time) {
            this.id = id;
            this.result = result;
            this.group = group;
            this.fluid = fluid;
            this.ingredients = ingredients;
            this.experience = exp;
            this.recipeTime = time;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            JsonArray jsonarray = new JsonArray();

            for (Ingredient ingredient : this.ingredients) {
                jsonarray.add(ingredient.toJson());
            }

            json.add("ingredients", jsonarray);
            json.add("fluid", this.fluid.serialize());
            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result.getItem()).toString());
            if (this.result.getCount() > 1) {
                objectResult.addProperty("count", this.result.getCount());
            }
            json.add("result", objectResult);

            if (this.experience > 0) {
                json.addProperty("experience", this.experience);
            }
            json.addProperty("recipeTime", this.recipeTime);
        }

        @Override
        public RecipeSerializer<?> getType() {
            return RecipeTypeRegistry.COOKING_RECIPE.get();
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
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
