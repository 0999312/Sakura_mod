package cn.mcmod.sakura.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class StoneMortarRecipe implements Recipe<RecipeWrapper> {
    private final ResourceLocation id;
    private final NonNullList<Ingredient> inputItems;
    private final NonNullList<ItemStack> output;
    private final float experience;
    private final int recipeTime;

    public StoneMortarRecipe(ResourceLocation id, NonNullList<Ingredient> inputItems, NonNullList<ItemStack> output,
            float experience, int recipeTime) {
        this.id = id;
        this.inputItems = inputItems;
        this.output = output;
        this.experience = experience;
        this.recipeTime = recipeTime;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level worldIn) {
        List<ItemStack> inputs = new ArrayList<>();
        int i = 0;

        for (int j = 0; j < 4; ++j) {
            ItemStack itemstack = inv.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                inputs.add(itemstack);
            }
        }
        return i == this.getIngredients().size() && RecipeMatcher.findMatches(inputs, this.getIngredients()) != null;
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv) {
        return this.output.get(0).copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.getIngredients().size();
    }

    @Override
    public ItemStack getResultItem() {
        return this.output.get(0);
    }

    public NonNullList<ItemStack> getResultItemList() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public String getGroup() {
        return "stone_mortar";
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegistry.STONE_MORTAR_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeTypeRegistry.STONE_MORTAR_RECIPE_TYPE.get();
    }

    public float getExperience() {
        return experience;
    }

    public int getRecipeTime() {
        return recipeTime;
    }

    public static class MortarSerializer extends ForgeRegistryEntry<RecipeSerializer<?>>
            implements RecipeSerializer<StoneMortarRecipe> {

        @Override
        public StoneMortarRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            NonNullList<Ingredient> nonnulllist = ingredientsFromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            if (nonnulllist.isEmpty()) {
                throw new JsonParseException("No ingredients for sakura stone mortar recipe");
            } else if (nonnulllist.size() > 4) {
                throw new JsonParseException("Too many ingredients for sakura stone mortar recipe. The maximum is 4");
            }
            NonNullList<ItemStack> nonnullResultList = itemsFromJson(GsonHelper.getAsJsonArray(json, "results"));
            if (nonnullResultList.isEmpty()) {
                throw new JsonParseException("No result item for sakura stone mortar recipe");
            } else if (nonnullResultList.size() > 2) {
                throw new JsonParseException("Too many result items for sakura stone mortar recipe. The maximum is 2");
            }
            final float experienceIn = GsonHelper.getAsFloat(json, "experience", 0.0F);
            final int cookTimeIn = GsonHelper.getAsInt(json, "recipeTime", 200);
            return new StoneMortarRecipe(recipeId, nonnulllist, nonnullResultList, experienceIn, cookTimeIn);
        }

        private static NonNullList<ItemStack> itemsFromJson(JsonArray items) {
            NonNullList<ItemStack> nonnulllist = NonNullList.create();

            for (int i = 0; i < items.size(); ++i) {
                ItemStack ingredient = CraftingHelper.getItemStack(items.get(i).getAsJsonObject(), true, true);
                if (!ingredient.isEmpty()) {
                    nonnulllist.add(ingredient);
                }
            }

            return nonnulllist;
        }

        private static NonNullList<Ingredient> ingredientsFromJson(JsonArray ingredients) {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();

            for (int i = 0; i < ingredients.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredients.get(i));
                if (!ingredient.isEmpty()) {
                    nonnulllist.add(ingredient);
                }
            }

            return nonnulllist;
        }

        @Override
        public StoneMortarRecipe fromNetwork(ResourceLocation recipeID, FriendlyByteBuf buffer) {
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);
            for (int j = 0; j < inputItemsIn.size(); ++j) {
                inputItemsIn.set(j, Ingredient.fromNetwork(buffer));
            }
            int i2 = buffer.readVarInt();
            NonNullList<ItemStack> outputItemsIn = NonNullList.withSize(i2, ItemStack.EMPTY);
            for (int j2 = 0; j2 < outputItemsIn.size(); ++j2) {
                outputItemsIn.set(j2, buffer.readItem());
            }
            float experienceIn = buffer.readFloat();
            int recipeTimeIn = buffer.readVarInt();
            return new StoneMortarRecipe(recipeID, inputItemsIn, outputItemsIn, experienceIn, recipeTimeIn);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, StoneMortarRecipe recipe) {
            buffer.writeVarInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.inputItems) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeVarInt(recipe.output.size());

            for (ItemStack outputItem : recipe.output) {
                buffer.writeItem(outputItem);
            }

            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.recipeTime);
        }
    }

}
