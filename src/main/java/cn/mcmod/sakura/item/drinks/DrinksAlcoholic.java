package cn.mcmod.sakura.item.drinks;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class DrinksAlcoholic extends DrinkBasic {

	public DrinksAlcoholic(String name, String[] subNames, PotionEffect[][] effects) {
		super(name, subNames, effects);
	}
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		Random rand = worldIn.rand;
		if(rand.nextInt(10)<=7) 
			player.addPotionEffect(new PotionEffect(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "nausea")), 600, 0));
		super.onFoodEaten(stack, worldIn, player);
	}
}
