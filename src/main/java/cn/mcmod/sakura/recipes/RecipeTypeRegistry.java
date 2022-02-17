package cn.mcmod.sakura.recipes;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeTypeRegistry{
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SakuraMod.MODID);

    public static final RegistryObject<RecipeSerializer<StoneMortarRecipe>> STONE_MORTAR_RECIPE = RECIPES.register("stone_mortar", StoneMortarRecipe.MortarSerializer::new);
    public static final RegistryObject<RecipeSerializer<CookingPotRecipe>> COOKING_RECIPE = RECIPES.register("cooking", CookingPotRecipe.MortarSerializer::new);
}
