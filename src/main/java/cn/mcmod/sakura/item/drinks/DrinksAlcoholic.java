package cn.mcmod.sakura.item.drinks;

import java.util.Random;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod_mmf.mmlib.item.food.ItemDrinkBase;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class DrinksAlcoholic extends ItemDrinkBase {

	public DrinksAlcoholic(String name, FoodInfo[] info, PotionEffect[][] effects) {
		super(SakuraMain.MODID,name, info, effects, new ItemStack(ItemLoader.cup,1,0));
	}
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		Random rand = worldIn.rand;
		if(rand.nextInt(10)<=7) 
			player.addPotionEffect(new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "nausea")), 600, 0));
		super.onFoodEaten(stack, worldIn, player);
	}
}
