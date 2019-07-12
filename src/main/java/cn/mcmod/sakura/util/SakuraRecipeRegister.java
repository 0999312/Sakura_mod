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
//		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 17), new ItemStack(ItemLoader.FOODSET, 1, 5), 0.1F);
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
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
		new TileEntityCampfirePot.PotRecipes(
				new ItemStack(ItemLoader.FOODSET, 2, 90),
				"listAllbeefraw",
				new Object[]{
						"bamboo"
				},
				new FluidStack(FluidRegistry.WATER, 0)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
		new TileEntityCampfirePot.PotRecipes(
				new ItemStack(ItemLoader.FOODSET, 2, 10),
				"cropRice",
				new Object[]{
						"listAllbeefraw"
				},
				new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 8),
						"cropRice",
						new Object[]{
								"cropBambooshoot"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 9),
						"cropRice",
						new Object[]{
								"listAllfishraw"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 11),
						"cropRice",
						new Object[]{
						"listAllporkraw"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 12),
						"cropRice",
						new Object[]{
								"listAllmushroom"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 13),
						"cropRice",
						new Object[]{
								"listAllegg"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 14),
						"cropRice",
						new Object[]{
								"listAllbeefraw",
								"listAllegg"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 15),
						"cropRice",
						new Object[]{
								"listAllbeefraw",
								"listAllegg"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 16),
						"cropRice",
						new Object[]{
								new ItemStack(ItemLoader.FOODSET, 1, 6),
								"listAllegg"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 17),
						"cropRice",
						new Object[]{
								"listAllchickenraw",
								"listAllegg"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 18),
						"cropRice",
						new Object[]{
								"listAllfishraw",
								"listAllegg"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 1, 19),
						new ItemStack(ItemLoader.MATERIAL, 1, 8),
						new Object[]{
						new ItemStack(ItemLoader.MATERIAL, 1,32)
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 1, 26),
						new ItemStack(ItemLoader.MATERIAL, 1, 9),
						new Object[]{
						new ItemStack(ItemLoader.MATERIAL, 1,32)
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 1, 34),
						new ItemStack(ItemLoader.MATERIAL, 1, 10),
						new Object[]{
						new ItemStack(ItemLoader.MATERIAL, 1,32)
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
				new TileEntityCampfirePot.PotRecipes(
						new ItemStack(ItemLoader.FOODSET, 2, 3),
						new ItemStack(ItemLoader.RED_BEAN,1),
						new Object[]{
								"listAllsugar",
								"listAllsugar"
						},
						new FluidStack(FluidRegistry.WATER, 200)));
		TileEntityCampfirePot.PotRecipes.addPotRecipe(
		new TileEntityCampfirePot.PotRecipes(
				new ItemStack(ItemLoader.FOODSET, 2, 6),
				"listAllporkraw",
				new Object[]{
						"foodFlour",
						"listAllegg",
						"foodBreadcrumbs",
						"dustSalt",
						"foodBlackpepper"
				},
				new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));

    }
}
