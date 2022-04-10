package cn.mcmod.sakura.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
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
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class CookingPotRecipe implements Recipe<RecipeWrapper> {
    private final ResourceLocation id;
    private final NonNullList<Ingredient> inputItems;
    private final FluidIngredient fluidInput;

    private final ItemStack output;
    private final float experience;
    private final int recipeTime;

    public CookingPotRecipe(ResourceLocation id, NonNullList<Ingredient> inputItems, FluidIngredient fluidInput,
            ItemStack output, float experience, int recipeTime) {
        this.id = id;
        this.inputItems = inputItems;
        this.fluidInput = fluidInput;
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

    public FluidIngredient getRequiredFluid() {
        return fluidInput;
    }

    public boolean matchesWithFluid(FluidStack fluid, RecipeWrapper inv, Level worldIn) {
        if(this.getRequiredFluid() == FluidIngredient.EMPTY)
            return matches(inv, worldIn);
        return this.getRequiredFluid().test(fluid) && matches(inv, worldIn);
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level worldIn) {
        List<ItemStack> inputs = new ArrayList<>();
        int i = 0;

        for (int j = 0; j < 9; ++j) {
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
        return this.output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.getIngredients().size();
    }

    @Override
    public ItemStack getResultItem() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public String getGroup() {
        return "cooking";
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegistry.COOKING_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeTypeRegistry.COOKING_RECIPE_TYPE.get();
    }

    public float getExperience() {
        return experience;
    }

    public int getRecipeTime() {
        return recipeTime;
    }

    public static class CookingSerializer extends ForgeRegistryEntry<RecipeSerializer<?>>
            implements RecipeSerializer<CookingPotRecipe> {

        @Override
        public CookingPotRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            NonNullList<Ingredient> nonnulllist = ingredientsFromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            if (nonnulllist.isEmpty()) {
                throw new JsonParseException("No ingredients for sakura cooking recipe");
            } else if (nonnulllist.size() > 9) {
                throw new JsonParseException("Too many ingredients for sakura cooking recipe. The maximum is 9");
            }
            final FluidIngredient fluidInputIn = json.has("fluid") 
                    ? FluidIngredient.deserialize(GsonHelper.getAsJsonObject(json, "fluid")) 
                    : FluidIngredient.EMPTY;
            final ItemStack outputIn = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "result"), true);
            final float experienceIn = GsonHelper.getAsFloat(json, "experience", 0.0F);
            final int cookTimeIn = GsonHelper.getAsInt(json, "recipeTime", 200);
            return new CookingPotRecipe(recipeId, nonnulllist, fluidInputIn, outputIn, experienceIn, cookTimeIn);
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
        public CookingPotRecipe fromNetwork(ResourceLocation recipeID, FriendlyByteBuf buffer) {
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);
            for (int j = 0; j < inputItemsIn.size(); ++j) {
                inputItemsIn.set(j, Ingredient.fromNetwork(buffer));
            }
            FluidIngredient fluidInputIn = FluidIngredient.EMPTY;
            if(buffer.readBoolean())
                fluidInputIn = FluidIngredient.read(buffer);
            ItemStack outputItem = buffer.readItem();
            float experienceIn = buffer.readFloat();
            int recipeTimeIn = buffer.readVarInt();
            return new CookingPotRecipe(recipeID, inputItemsIn, fluidInputIn, outputItem, experienceIn, recipeTimeIn);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, CookingPotRecipe recipe) {
            buffer.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.inputItems) {
                ingredient.toNetwork(buffer);
            }
            buffer.writeBoolean(recipe.fluidInput != FluidIngredient.EMPTY);
            if(recipe.fluidInput != FluidIngredient.EMPTY)
                recipe.fluidInput.write(buffer);
            
            buffer.writeItem(recipe.output);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.recipeTime);
        }
    }

}
