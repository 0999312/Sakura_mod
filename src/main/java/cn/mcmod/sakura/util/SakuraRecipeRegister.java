package cn.mcmod.sakura.util;

import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import net.minecraft.item.ItemStack;

public class SakuraRecipeRegister {
    public static void mortarRegister() {
        TileEntityStoneMortar.MortarRecipes recipes = new TileEntityStoneMortar.MortarRecipes(
                new ItemStack(ItemLoader.RICE)
                , new ItemStack(ItemLoader.RICE_SEEDS));
        TileEntityStoneMortar.MortarRecipes.addMortarRecipe(recipes);
    }
}
