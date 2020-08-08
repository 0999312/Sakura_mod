package cn.mcmod.sakura.compat.jei;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.gui.GuiBarrel;
import cn.mcmod.sakura.gui.GuiCampfirePot;
import cn.mcmod.sakura.gui.GuiDistillation;
import cn.mcmod.sakura.gui.GuiStoneMortar;
import cn.mcmod.sakura.inventory.ContainerBarrel;
import cn.mcmod.sakura.inventory.ContainerCampfirePot;
import cn.mcmod.sakura.inventory.ContainerDistillation;
import cn.mcmod.sakura.inventory.ContainerStoneMortar;
import cn.mcmod.sakura.item.ItemLoader;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEICompat implements IModPlugin {
	@Override
	public void register(IModRegistry registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();
		
		registry.addRecipes(PotRecipeMaker.getRecipes(jeiHelpers),"sakura.cooking_pot");
		registry.addRecipes(MortarRecipeMaker.getRecipes(jeiHelpers),"sakura.mortar");
		registry.addRecipes(BarrelRecipeMaker.getRecipes(jeiHelpers),"sakura.barrel");
		registry.addRecipes(DistillationRecipeMaker.getRecipes(jeiHelpers),"sakura.distillation");
		registry.addRecipes(L2ISRecipeMaker.getRecipes(jeiHelpers),"sakura.liquid_item");
		
		registry.addRecipes(WebRecipeMaker.getRecipes(jeiHelpers),"sakura.straw_web");

		registry.addRecipeClickArea(GuiCampfirePot.class, 91, 41, 28, 23,"sakura.cooking_pot");
		registry.addRecipeClickArea(GuiStoneMortar.class, 77, 32, 28, 23,"sakura.mortar");
		registry.addRecipeClickArea(GuiBarrel.class, 62, 33, 24, 21,"sakura.barrel");
		registry.addRecipeClickArea(GuiDistillation.class, 62, 33, 24, 21,"sakura.distillation");
		registry.addRecipeClickArea(GuiBarrel.class, 130, 29, 18, 21,"sakura.liquid_item");
		registry.addRecipeClickArea(GuiDistillation.class, 130, 29, 18, 21,"sakura.liquid_item");
		
		recipeTransferRegistry.addRecipeTransferHandler(ContainerCampfirePot.class,"sakura.cooking_pot", 0, 9, 10, 36);
		recipeTransferRegistry.addRecipeTransferHandler(ContainerStoneMortar.class,"sakura.mortar", 0, 4, 6, 36);
		recipeTransferRegistry.addRecipeTransferHandler(ContainerBarrel.class,"sakura.barrel", 0, 3, 5, 36);
		recipeTransferRegistry.addRecipeTransferHandler(ContainerDistillation.class,"sakura.distillation", 0, 3, 5, 36);

		registry.addRecipeCatalyst(new ItemStack(ItemLoader.POT),"sakura.cooking_pot");
		registry.addRecipeCatalyst(new ItemStack(BlockLoader.STONEMORTAR),"sakura.mortar");
		registry.addRecipeCatalyst(new ItemStack(BlockLoader.BARREL),"sakura.barrel");
		registry.addRecipeCatalyst(new ItemStack(BlockLoader.BARREL_DISTILLATION),"sakura.distillation");
		registry.addRecipeCatalyst(new ItemStack(BlockLoader.STRAW_WEB),"sakura.straw_web");
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new IRecipeCategory[]{
				new CategoryPot(registry.getJeiHelpers().getGuiHelper()),
				new CategoryMortar(registry.getJeiHelpers().getGuiHelper()),
				new CategoryBarrel(registry.getJeiHelpers().getGuiHelper()),
				new CategoryDistillation(registry.getJeiHelpers().getGuiHelper()),
				new CategoryL2IS(registry.getJeiHelpers().getGuiHelper()),
				new CategoryWeb(registry.getJeiHelpers().getGuiHelper()),
			}
		);
	}
	
}
