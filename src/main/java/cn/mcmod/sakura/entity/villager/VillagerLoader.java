package cn.mcmod.sakura.entity.villager;

import java.util.Random;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.entity.passive.EntityVillager.PriceInfo;
import net.minecraft.init.Blocks;
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
	
	@SubscribeEvent
	public static void onVillagerProfessionRegistration(RegistryEvent.Register<VillagerRegistry.VillagerProfession> event) {
		event.getRegistry().registerAll(wa_villager);

	    VillagerRegistry.VillagerCareer farmer = new VillagerRegistry.VillagerCareer(wa_villager, "wa_farmer");
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.CABBAGE,8),new PriceInfo(1, 1)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.EGGPLANT,8),new PriceInfo(1, 1)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.BUCKWHEAT,8),new PriceInfo(1, 1)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.RED_BEAN,8),new PriceInfo(1, 1)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.ONION,8),new PriceInfo(1, 1)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.TOMATO,8),new PriceInfo(1, 1)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.RAPESEED,8),new PriceInfo(1, 1)));
	    farmer.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.RICE_SEEDS,8),new PriceInfo(1, 1)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.RED_BEAN,1),new PriceInfo(2, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.BUCKWHEAT,1),new PriceInfo(2, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.CABBAGE_SEEDS,1),new PriceInfo(2, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.EGGPLANT_SEEDS,1),new PriceInfo(2, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.ONION_SEEDS,1),new PriceInfo(2, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.RADISH_SEEDS,1),new PriceInfo(2, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.RAPESEED,1),new PriceInfo(2, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.RICE_SEEDS,1),new PriceInfo(2, 7)));
	    farmer.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.TOMATO_SEEDS,1),new PriceInfo(2, 7)));

		VillagerRegistry.VillagerCareer fisher = new VillagerRegistry.VillagerCareer(wa_villager, "wa_fisher");
		fisher.addTrade(1, new SimpleSell(new ItemStack(ItemLoader.FOODSET,16,78),new PriceInfo(2, 4)));
		fisher.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.FOODSET,2,78),new PriceInfo(2, 4)));
		VillagerCareer trader = new VillagerCareer(wa_villager, "wa_trader");
		trader.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.MATERIAL,1,3),new PriceInfo(2, 7)));
		trader.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.MATERIAL,1,29),new PriceInfo(4, 7)));
		trader.addTrade(1, new SimpleBuy(new ItemStack(ItemLoader.MATERIAL,1,33),new PriceInfo(4, 7)));
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
			recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD, i, 0),item.copy()));
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
			recipeList.add(new MerchantRecipe(item.copy(),new ItemStack(Items.EMERALD, i, 0)));
        }
	}
}
