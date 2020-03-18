package cn.mcmod.sakura.compat.ie;

import blusunrize.immersiveengineering.api.crafting.BlastFurnaceRecipe;
import blusunrize.immersiveengineering.api.crafting.CokeOvenRecipe;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Optional.Method;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class IEcompat {
	@SubscribeEvent
	@Method(modid = "immersiveengineering")
	public static void registerRecipe(RegistryEvent.Register<IRecipe> event) {
		CokeOvenRecipe.addRecipe(new ItemStack(BlockLoader.BAMBOO_CHARCOAL_BLOCK), new ItemStack(BlockLoader.BAMBOO_BLOCK), 3200, 2000);
		CokeOvenRecipe.addRecipe(new ItemStack(ItemLoader.MATERIAL, 1,51), new ItemStack(BlockLoader.BAMBOO, 1), 800, 500);
		BlastFurnaceRecipe.addBlastFuel(new ItemStack(ItemLoader.MATERIAL, 1,51), 500);
		BlastFurnaceRecipe.addBlastFuel(new ItemStack(BlockLoader.BAMBOO_CHARCOAL_BLOCK), 2500);
	}
}
