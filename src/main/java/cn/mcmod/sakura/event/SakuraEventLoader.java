package cn.mcmod.sakura.event;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.util.RecipesUtil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetMetadata;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class SakuraEventLoader {
    private static final Set<String> LOOT_LOCATIONS = ImmutableSet.<String>builder()
            .add(LootTableList.GAMEPLAY_FISHING_FISH.toString())
            .build();
    private final static Set<LootEntry> FishinglootPools = new HashSet<LootEntry>();
    @SubscribeEvent
	public static void OnRecipeRegister(RegistryEvent.Register<IRecipe> event) {
    	addFishingLoot(new ItemStack(ItemLoader.FOODSET,1,78),35);
    	addFishingLoot(new ItemStack(ItemLoader.MATERIAL,1,34),25);
    	RecipesUtil.addShapelessRecipe(new ItemStack(ItemLoader.FOODSET,1,60), new Object[]{
    			new ItemStack(ItemLoader.FOODSET,1,58),BlockLoader.SAKURA_LEAVES
    	});
    	RecipesUtil.addShapelessRecipe(new ItemStack(ItemLoader.FOODSET,1,61), new Object[]{
    			new ItemStack(ItemLoader.FOODSET,1,58),new ItemStack(ItemLoader.FOODSET,1,3)
    	});
    	RecipesUtil.addShapelessRecipe(new ItemStack(ItemLoader.FOODSET,1,69), new Object[]{
    			new ItemStack(ItemLoader.FOODSET,1,4),new ItemStack(ItemLoader.FOODSET,1,49),"foodKetchup"
    	});
    	RecipesUtil.addShapelessRecipe(new ItemStack(ItemLoader.FOODSET,1,70), new Object[]{
    			new ItemStack(ItemLoader.FOODSET,1,4),new ItemStack(ItemLoader.FOODSET,1,49),"foodKetchup","foodCheese"
    	});
    }
    
	@SubscribeEvent
	public static void onFishingLootLoaded(LootTableLoadEvent evt) {
        if (LOOT_LOCATIONS.contains(evt.getName().toString()))
        {
            for (LootEntry entry : FishinglootPools)
            {
            evt.getTable().getPool("main").addEntry(entry); 
            }

        }
	}
	
    public static void addFishingLoot(ItemStack stack,int weight)
    {
        LootCondition[] lootConditions = new LootCondition[0];
        LootFunction[] setMeta = new LootFunction[] { new SetMetadata(lootConditions, new RandomValueRange(stack.getMetadata())) };
        LootEntry entry = new LootEntryItem(stack.getItem(), weight, 0, setMeta, lootConditions, stack.getUnlocalizedName());

        FishinglootPools.add(entry);
    }
	
}
