package cn.mcmod.sakura.util;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.tileentity.TileEntityCampfirePot;
import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class SakuraRecipeRegister {
	public static void furnaceRegister() {
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 17), new ItemStack(ItemLoader.FOODSET, 1, 5), 0.1F);
	}

    public static void mortarRegister() {
        TileEntityStoneMortar.MortarRecipes.addMortarRecipe(new TileEntityStoneMortar.MortarRecipes(
                new ItemStack(ItemLoader.MATERIAL, 1, 1), new ItemStack(ItemLoader.RICE_SEEDS)));
		TileEntityStoneMortar.MortarRecipes.addMortarRecipe(new TileEntityStoneMortar.MortarRecipes(
				new ItemStack(ItemLoader.MATERIAL, 2, 4), new ItemStack(Items.WHEAT)));
		TileEntityStoneMortar.MortarRecipes.addMortarRecipe(new TileEntityStoneMortar.MortarRecipes(
				new ItemStack(ItemLoader.MATERIAL, 1, 16), new ItemStack(ItemLoader.MATERIAL, 1, 1)));
    }

    public static void potRegister() {
//        TileEntityCampfirePot.PotRecipes.addPotRecipe(
//        		new TileEntityCampfirePot.PotRecipes(
//						new ItemStack(ItemLoader.FOODSET, 1, 3),
//        		"cropRice",
//        		new Object[]{
//						"listAllfishfresh"
//        		},
//        		new FluidStack(FluidRegistry.WATER, 200)));
//		TileEntityCampfirePot.PotRecipes.addPotRecipe(
//				new TileEntityCampfirePot.PotRecipes(
//						new ItemStack(ItemLoader.FOODSET, 1, 3),
//						"cropRice",
//						new Object[]{
//								"listAllfishraw"
//						},
//						new FluidStack(FluidRegistry.WATER, 200)));
//
//        TileEntityCampfirePot.PotRecipes.addPotRecipe(
//                new TileEntityCampfirePot.PotRecipes(new ItemStack(ItemLoader.FOODSET, 1, 1),
//                        "cropRice",
//                        new FluidStack(FluidRegistry.WATER, 200)));
//		TileEntityCampfirePot.PotRecipes.addPotRecipe(
//				new TileEntityCampfirePot.PotRecipes(new ItemStack(ItemLoader.FOODSET, 1, 1),
//						"cropRice",
//						new ItemStack[]{
//								new ItemStack(Item.getItemFromBlock(BlockLoader.BAMBOOSHOOT))
//						},
//						new FluidStack(FluidRegistry.WATER, 200)));
    }
}
