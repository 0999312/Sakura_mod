package cn.mcmod.sakura.entity.villager;

import java.util.Random;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.api.kimono.KimonoLoader;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.item.drinks.DrinksLoader;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.entity.passive.EntityVillager.PriceInfo;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

@EventBusSubscriber
public class VillagerLoader {
	public static VillagerProfession wa_villager = new VillagerRegistry.VillagerProfession(SakuraMain.MODID+":wa_profession", 
			SakuraMain.MODID+":textures/entity/villager/wa_farmer.png", 
			SakuraMain.MODID+":textures/entity/villager/wa_zombie_farmer.png");
	public static VillagerProfession wa_kimono_villager = new VillagerRegistry.VillagerProfession(SakuraMain.MODID+":wa_silk", 
			SakuraMain.MODID+":textures/entity/villager/wa_silk.png", 
			SakuraMain.MODID+":textures/entity/villager/wa_zombie_silk.png");
	@SubscribeEvent
	public static void onVillagerProfessionRegistration(RegistryEvent.Register<VillagerRegistry.VillagerProfession> event) {
		event.getRegistry().registerAll(wa_villager,wa_kimono_villager);
		VillagerRegistry.VillagerCareer silk = new VillagerRegistry.VillagerCareer(wa_kimono_villager, "wa_silk");
		silk.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.MATERIAL,2,59),new PriceInfo(1, 3)));
		silk.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.MATERIAL,4,59),new PriceInfo(2, 5)));
		silk.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.KIMONO),new PriceInfo(10, 14)));
		silk.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.HAORI),new PriceInfo(10, 14)));
		
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("kimono_1"),new PriceInfo(10, 14)));
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("kimono_2"),new PriceInfo(10, 14)));
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("kimono_3"),new PriceInfo(10, 14)));
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("kimono_4"),new PriceInfo(10, 14)));
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("kimono_5"),new PriceInfo(10, 14)));
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("kimono_6"),new PriceInfo(10, 14)));
		
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("haori_1"),new PriceInfo(10, 14)));
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("haori_2"),new PriceInfo(10, 14)));
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("haori_3"),new PriceInfo(10, 14)));
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("haori_4"),new PriceInfo(10, 14)));
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("haori_5"),new PriceInfo(10, 14)));
		silk.addTrade(2, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("haori_6"),new PriceInfo(10, 14)));
		
		silk.addTrade(3, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("kimono_miko"),new PriceInfo(15, 18)));
		silk.addTrade(3, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("yukata_0"),new PriceInfo(15, 18)));
		silk.addTrade(3, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("yukata_1"),new PriceInfo(15, 18)));
		silk.addTrade(3, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("yukata_2"),new PriceInfo(15, 18)));
		silk.addTrade(3, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("yukata_3"),new PriceInfo(15, 18)));
		silk.addTrade(3, new SimpleSell(KimonoLoader.getInstance().getCustomKimono("yukata_4"),new PriceInfo(15, 18)));

	    VillagerRegistry.VillagerCareer farmer = new VillagerRegistry.VillagerCareer(wa_villager, "wa_farmer");
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.CABBAGE,8),new PriceInfo(2, 4)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.EGGPLANT,8),new PriceInfo(2, 4)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.BUCKWHEAT,8),new PriceInfo(2, 4)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.RED_BEAN,8),new PriceInfo(2, 4)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.ONION,8),new PriceInfo(2, 4)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.TOMATO,8),new PriceInfo(2, 4)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.RAPESEED,8),new PriceInfo(2, 4)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.RICE_SEEDS,8),new PriceInfo(2, 4)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.RED_BEAN,1),new PriceInfo(5, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.BUCKWHEAT,1),new PriceInfo(5, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.CABBAGE_SEEDS,1),new PriceInfo(5, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.EGGPLANT_SEEDS,1),new PriceInfo(5, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.ONION_SEEDS,1),new PriceInfo(5, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.RADISH_SEEDS,1),new PriceInfo(5, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.RAPESEED,1),new PriceInfo(5, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.RICE_SEEDS,1),new PriceInfo(4, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.TOMATO_SEEDS,1),new PriceInfo(5, 7)));
	    farmer.addTrade(2, new SimpleBuy(new ItemStack(ItemLoader.MATERIAL,8,37),new PriceInfo(3, 5)));
		
		VillagerRegistry.VillagerCareer fisher = new VillagerRegistry.VillagerCareer(wa_villager, "wa_fisher");
		fisher.addTrade(1, new SimpleSell(new ItemStack(Items.FISH,16),new PriceInfo(1, 3)));
		fisher.addTrade(1, new SimpleBuy(new ItemStack(Items.FISH,8),new PriceInfo(2, 4)));
		fisher.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.FOODSET,16,78),new PriceInfo(2, 4)));
		fisher.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.FOODSET,8,78),new PriceInfo(4, 6)));

		VillagerCareer trader = new VillagerCareer(wa_villager, "wa_trader");
		trader.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.MATERIAL,8,3),new PriceInfo(2, 7)));
		trader.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.MATERIAL,8,29),new PriceInfo(3, 6)));
		trader.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.MATERIAL,8,33),new PriceInfo(3, 7)));
		trader.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.MATERIAL,8,45),new PriceInfo(3, 5)));
		trader.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.MATERIAL,8,31),new PriceInfo(2, 5)));
		trader.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.FOODSET,8,63),new PriceInfo(4, 7)));
		trader.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.FOODSET,8,81),new PriceInfo(3, 5)));
		
		trader.addTrade(3, new SimpleBuy(new ItemStack(ItemLoader.SAKURA_DIAMOND,1),new PriceInfo(12, 23)));
		trader.addTrade(3, new SimpleSell(new ItemStack(ItemLoader.SAKURA_DIAMOND,1),new PriceInfo(8, 10)));
		
		VillagerRegistry.VillagerCareer wine_trader = new VillagerRegistry.VillagerCareer(wa_villager, "wine_trader");
		wine_trader.addTrade(1, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,0),new PriceInfo(20, 30)));
		wine_trader.addTrade(1, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,0),new PriceInfo(10, 20)));
		wine_trader.addTrade(1, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,1),new PriceInfo(20, 30)));
		wine_trader.addTrade(1, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,1),new PriceInfo(10, 20)));
		wine_trader.addTrade(1, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,4),new PriceInfo(20, 30)));
		wine_trader.addTrade(1, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,4),new PriceInfo(10, 20)));
		wine_trader.addTrade(1, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,5),new PriceInfo(20, 30)));
		wine_trader.addTrade(1, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,5),new PriceInfo(10, 20)));
	
		wine_trader.addTrade(2, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,2),new PriceInfo(40, 60)));
		wine_trader.addTrade(2, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,2),new PriceInfo(20, 35)));
		wine_trader.addTrade(2, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,6),new PriceInfo(40, 60)));
		wine_trader.addTrade(2, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,6),new PriceInfo(20, 35)));
		
		wine_trader.addTrade(3, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,3),new PriceInfo(60, 80)));
		wine_trader.addTrade(3, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,3),new PriceInfo(30, 45)));
		wine_trader.addTrade(3, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,7),new PriceInfo(60, 80)));
		wine_trader.addTrade(3, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,7),new PriceInfo(30, 45)));
		wine_trader.addTrade(3, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,8),new PriceInfo(60, 80)));
		wine_trader.addTrade(3, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,8),new PriceInfo(30, 45)));
		wine_trader.addTrade(3, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,9),new PriceInfo(60, 80)));
		wine_trader.addTrade(3, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,9),new PriceInfo(30, 45)));
		wine_trader.addTrade(3, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,10),new PriceInfo(60, 80)));
		wine_trader.addTrade(3, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,10),new PriceInfo(30, 45)));
		
		wine_trader.addTrade(4, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,11),new PriceInfo(50, 100)));
		wine_trader.addTrade(4, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,11),new PriceInfo(40, 70)));
		wine_trader.addTrade(4, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,12),new PriceInfo(50, 100)));
		wine_trader.addTrade(4, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,12),new PriceInfo(40, 70)));
		wine_trader.addTrade(4, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,13),new PriceInfo(75, 120)));
		wine_trader.addTrade(4, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,13),new PriceInfo(40, 70)));
		wine_trader.addTrade(4, new SimpleBuy(new ItemStack(DrinksLoader.bottle_alcoholic,1,14),new PriceInfo(75, 120)));
		wine_trader.addTrade(4, new SimpleSell(new ItemStack(DrinksLoader.bottle_alcoholic,1,14),new PriceInfo(40, 70)));
	
	}
	private static class SimpleBuy implements ITradeList{
		private ItemStack item;
		private PriceInfo price;

		public SimpleBuy(ItemStack item, PriceInfo price){
			this.item = item;
			this.price = price;
		}

		public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
		{
			int i = price != null ? price.getPrice(random) : 1;
			recipeList.add(new MerchantRecipe(new ItemStack(ItemLoader.MATERIAL, i, 50),item.copy()));
        }
	}
    private static class SimpleSell implements ITradeList{
		private ItemStack item;
		private PriceInfo price;

		public SimpleSell(ItemStack item, PriceInfo price){
			this.item = item;
			this.price = price;
		}

		public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
		{
			int i = price != null ? price.getPrice(random) : 1;
			recipeList.add(new MerchantRecipe(item.copy(),new ItemStack(ItemLoader.MATERIAL, i, 50)));
        }
	}
}
