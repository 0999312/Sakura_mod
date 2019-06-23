package cn.mcmod.sakura.util;

import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.tileentity.TileEntityCampfirePot;
import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class SakuraRecipeRegister {
    public static void mortarRegister() {
        TileEntityStoneMortar.MortarRecipes.addMortarRecipe(new TileEntityStoneMortar.MortarRecipes(
                new ItemStack(ItemLoader.MATERIAL, 1, 1), new ItemStack(ItemLoader.RICE_SEEDS)));
    }

    public static void potRegister() {
        TileEntityCampfirePot.PotRecipes.addPotRecipe(new TileEntityCampfirePot.PotRecipes(new ItemStack(ItemLoader.FOODSET, 1, 1), new ItemStack(ItemLoader.MATERIAL, 1, 1), new FluidStack(FluidRegistry.WATER, 200)));
    }
}
