package cn.mcmod.sakura.recipes;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod_mmf.mmlib.recipe.AbstractRecipeSerializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeTypeRegistry {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister
            .create(Registry.RECIPE_TYPE_REGISTRY, SakuraMod.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister
            .create(ForgeRegistries.RECIPE_SERIALIZERS, SakuraMod.MODID);

    public static final RegistryObject<RecipeType<CookingPotRecipe>> COOKING_RECIPE_TYPE = RECIPE_TYPES
            .register("cooking", () -> recipeType("cooking"));
    public static final RegistryObject<RecipeType<StoneMortarRecipe>> STONE_MORTAR_RECIPE_TYPE = RECIPE_TYPES
            .register("stone_mortar", () -> recipeType("stone_mortar"));
    public static final RegistryObject<RecipeType<FermenterRecipe>> FERMENTER_RECIPE_TYPE = RECIPE_TYPES
            .register("fermenting", () -> recipeType("fermenting"));
    public static final RegistryObject<RecipeType<DistillerRecipe>> DISTILLER_RECIPE_TYPE = RECIPE_TYPES
            .register("distillation", () -> recipeType("distillation"));
    public static final RegistryObject<RecipeType<ChoppingRecipe>> CHOPPING_RECIPE_TYPE = RECIPE_TYPES
            .register("chopping", () -> recipeType("chopping"));


    public static final RegistryObject<AbstractRecipeSerializer<StoneMortarRecipe>> STONE_MORTAR_RECIPE_SERIALIZER = RECIPE_SERIALIZERS
            .register("stone_mortar", () -> new AbstractRecipeSerializer<StoneMortarRecipe>(StoneMortarRecipe.class));
    public static final RegistryObject<AbstractRecipeSerializer<CookingPotRecipe>> COOKING_RECIPE_SERIALIZER = RECIPE_SERIALIZERS
            .register("cooking", () -> new AbstractRecipeSerializer<CookingPotRecipe>(CookingPotRecipe.class));
    public static final RegistryObject<AbstractRecipeSerializer<FermenterRecipe>> FERMENTER_RECIPE_SERIALIZER = RECIPE_SERIALIZERS
            .register("fermenting", () -> new AbstractRecipeSerializer<FermenterRecipe>(FermenterRecipe.class));
    public static final RegistryObject<AbstractRecipeSerializer<DistillerRecipe>> DISTILLER_RECIPE_SERIALIZER = RECIPE_SERIALIZERS
            .register("distillation", () -> new AbstractRecipeSerializer<DistillerRecipe>(DistillerRecipe.class));
    
    public static final RegistryObject<AbstractRecipeSerializer<ChoppingRecipe>> CHOPPING_RECIPE_SERIALIZER = RECIPE_SERIALIZERS
            .register("chopping", () -> new AbstractRecipeSerializer<ChoppingRecipe>(ChoppingRecipe.class));

    private static <T extends Recipe<?>> RecipeType<T> recipeType(String name) {
        return new RecipeType<T>() {
            public String toString() {
                return new ResourceLocation(SakuraMod.MODID, name).toString();
            }
        };
    }
}
