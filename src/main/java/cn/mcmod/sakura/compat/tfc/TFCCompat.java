package cn.mcmod.sakura.compat.tfc;

import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.block.BlockLoader;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.util.fuel.Fuel;
import net.dries007.tfc.util.fuel.FuelManager;
import net.minecraft.item.ItemStack;

public class TFCCompat {
	private static final Fuel bamboo = new Fuel(IIngredient.of(new ItemStack(BlockLoader.BAMBOO)), 400, 800f, false, true);
	private static final Fuel bamboo_charcoal = new Fuel(IIngredient.of(new ItemStack(ItemLoader.MATERIAL,1,51)), 1600, 1450f, true, true);
	private static final Fuel bamboo_charcoal_block = new Fuel(IIngredient.of(new ItemStack(BlockLoader.BAMBOO_CHARCOAL_BLOCK)), 8000, 160f, true, false);
	public static void registerTFCFuel() {
		FuelManager.addFuel(bamboo);
		FuelManager.addFuel(bamboo_charcoal);
		FuelManager.addFuel(bamboo_charcoal_block);
	}
}
