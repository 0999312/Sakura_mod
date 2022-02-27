package cn.mcmod.sakura.data.builder;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cn.mcmod.sakura.recipes.RecipeTypeRegistry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class StoneMortarRecipeBuilder {
    private final List<ItemStack> result = Lists.newArrayList();
    private final List<Ingredient> ingredients = Lists.newArrayList();
    @Nullable
    private String group;
    private final float experience;
    private final int recipeTime;

    public StoneMortarRecipeBuilder(ItemLike resultItem, int count, float exp, int time) {
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

    public StoneMortarRecipeBuilder requires(Tag<Item> tag) {
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

    public StoneMortarRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    public Item getResult() {
        return this.result.get(0).getItem();
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        consumer.accept(new StoneMortarRecipeBuilder.Result(id, this.result, this.group == null ? "" : this.group,
                this.ingredients, this.experience, this.recipeTime));
    }

    public int getRecipeTime() {
        return recipeTime;
    }

    public float getExperience() {
        return experience;
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final List<ItemStack> result;
        private final String group;
        private final List<Ingredient> ingredients;
        private final float experience;
        private final int recipeTime;

        public Result(ResourceLocation id, List<ItemStack> results, String group, List<Ingredient> ingredients,
                float exp, int time) {
            this.id = id;
            this.result = results;
            this.group = group;
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
            JsonArray arrayResults = new JsonArray();
            for (ItemStack result : this.result) {
                JsonObject jsonobject = new JsonObject();
                jsonobject.addProperty("item", ForgeRegistries.ITEMS.getKey(result.getItem()).toString());
                if (result.getCount() > 1) {
                    jsonobject.addProperty("count", result.getCount());
                }
                arrayResults.add(jsonobject);
            }
            json.add("results", arrayResults);
            if (this.experience > 0) {
                json.addProperty("experience", this.experience);
            }
            json.addProperty("recipeTime", this.recipeTime);
        }

        @Override
        public RecipeSerializer<?> getType() {
            return RecipeTypeRegistry.STONE_MORTAR_RECIPE.get();
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
