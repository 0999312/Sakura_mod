package cn.mcmod.sakura.potion;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionLoader {
	public static final ResourceLocation res = new ResourceLocation("sakura:textures/gui/potion.png");
	public static Potion exp_up = new PotionExp();
	public static Potion cannon = new PotionCannon();
	public static Potion fire_blade = new PotionFire();
	public static Potion golden_heart = new PotionGoldenHeart();
	public static Potion poisom = new PotionAttackPotion(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "poison")), "poisom",1,0x2eb025, 0, 18, 18, 18);
	public static Potion poisom_big = new PotionAttackPotion(ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "poison")),"scorpion",3,0x2D123D,18,18,18,18);
	
	public PotionLoader(FMLPreInitializationEvent event) {
		 ForgeRegistries.POTIONS.register(exp_up);
		 ForgeRegistries.POTIONS.register(cannon);
		 ForgeRegistries.POTIONS.register(golden_heart);
		 ForgeRegistries.POTIONS.register(poisom);
		 ForgeRegistries.POTIONS.register(poisom_big);
		 ForgeRegistries.POTIONS.register(fire_blade);
		 registerPotionEvent();
	}
	private static void registerPotionEvent() {
		MinecraftForge.EVENT_BUS.register(exp_up);
		MinecraftForge.EVENT_BUS.register(cannon);
		MinecraftForge.EVENT_BUS.register(poisom);
		MinecraftForge.EVENT_BUS.register(fire_blade);
		MinecraftForge.EVENT_BUS.register(poisom_big);
	}
}
