package cn.mcmod.sakura.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import cn.mcmod_mmf.mmlib.fluid.FluidHelper;
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

public class FermenterRecipe implements Recipe<RecipeWrapper> {
    private final ResourceLocation id;
    private final NonNullList<Ingredient> inputItems;
    private final FluidIngredient inputFluid;

    private final NonNullList<ItemStack> outputItems;
    private final FluidStack outputFluid;

    private final float experience;
    private final int recipeTime;

    public FermenterRecipe(ResourceLocation id, NonNullList<Ingredient> inputItems, FluidIngredient fluidInput,
            NonNullList<ItemStack> output, FluidStack outputFluid, float experience, int recipeTime) {
        this.id = id;
        this.inputItems = inputItems;
        this.inputFluid = fluidInput;
        this.outputFluid = outputFluid;
        this.outputItems = output;
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
        return inputFluid;
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
        return this.outputItems.get(0).copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.getIngredients().size();
    }

    @Override
    public ItemStack getResultItem() {
        return this.outputItems.get(0);
    }
    
    public NonNullList<ItemStack> getResultItemList() {
        return this.outputItems;
    }
    
    public FluidStack getResultFluid() {
        return outputFluid;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public String getGroup() {
        return "fermenting";
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegistry.FERMENTER_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeTypeRegistry.FERMENTER_RECIPE_TYPE.get();
    }

    public float getExperience() {
        return experience;
    }

    public int getRecipeTime() {
        return recipeTime;
    }

    public static class FermenterSerializer extends ForgeRegistryEntry<RecipeSerializer<?>>
            implements RecipeSerializer<FermenterRecipe> {

        @Override
        public FermenterRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            NonNullList<Ingredient> nonnulllist = ingredientsFromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            if (nonnulllist.isEmpty()) {
                throw new JsonParseException("No ingredients for sakura cooking recipe");
            } else if (nonnulllist.size() > 3) {
                throw new JsonParseException("Too many ingredients for sakura cooking recipe. The maximum is 9");
            }
            final FluidIngredient fluidInputIn = json.has("fluid") 
                    ? FluidIngredient.deserialize(GsonHelper.getAsJsonObject(json, "fluid")) 
                    : FluidIngredient.EMPTY;
            NonNullList<ItemStack> nonnullResultList = itemsFromJson(GsonHelper.getAsJsonArray(json, "result_items"));
            if (nonnullResultList.isEmpty()) {
                throw new JsonParseException("No result item for sakura stone mortar recipe");
            } else if (nonnullResultList.size() > 3) {
                throw new JsonParseException("Too many result items for sakura stone mortar recipe. The maximum is 2");
            }
            final FluidStack outputFluid = FluidHelper.deserializeFluidStack(GsonHelper.getAsJsonObject(json, "result_fluid"));
            final float experienceIn = GsonHelper.getAsFloat(json, "experience", 0.0F);
            final int cookTimeIn = GsonHelper.getAsInt(json, "recipeTime", 200);
            
            return new FermenterRecipe(recipeId, nonnulllist, fluidInputIn, nonnullResultList, outputFluid, experienceIn, cookTimeIn);
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


        @Override
        public FermenterRecipe fromNetwork(ResourceLocation recipeID, FriendlyByteBuf buffer) {
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);
            for (int j = 0; j < inputItemsIn.size(); ++j) {
                inputItemsIn.set(j, Ingredient.fromNetwork(buffer));
            }
            FluidIngredient fluidInputIn = FluidIngredient.EMPTY;
            if(buffer.readBoolean())
                fluidInputIn = FluidIngredient.read(buffer);
            int i2 = buffer.readVarInt();
            NonNullList<ItemStack> outputItemsIn = NonNullList.withSize(i2, ItemStack.EMPTY);
            for (int j2 = 0; j2 < outputItemsIn.size(); ++j2) {
                outputItemsIn.set(j2, buffer.readItem());
            }
            FluidStack outputFluid = buffer.readFluidStack();
            float experienceIn = buffer.readFloat();
            int recipeTimeIn = buffer.readVarInt();
            return new FermenterRecipe(recipeID, inputItemsIn, fluidInputIn, outputItemsIn, outputFluid, experienceIn, recipeTimeIn);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, FermenterRecipe recipe) {
            buffer.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.inputItems) {
                ingredient.toNetwork(buffer);
            }
            buffer.writeBoolean(recipe.inputFluid != FluidIngredient.EMPTY);
            if(recipe.inputFluid != FluidIngredient.EMPTY)
                recipe.inputFluid.write(buffer);
            
            buffer.writeVarInt(recipe.outputItems.size());
            for (ItemStack outputItem : recipe.outputItems) {
                buffer.writeItem(outputItem);
            }
            buffer.writeFluidStack(recipe.outputFluid);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.recipeTime);
        }
    }

}
