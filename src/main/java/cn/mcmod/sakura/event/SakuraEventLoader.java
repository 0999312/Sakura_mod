package cn.mcmod.sakura.event;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.util.RecipesUtil;
import net.minecraft.init.Blocks;
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
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class SakuraEventLoader {
    private static final Set<String> LOOT_LOCATIONS = ImmutableSet.<String>builder()
            .add(LootTableList.GAMEPLAY_FISHING_FISH.toString())
            .build();
    private final static Set<LootPool> FishinglootPools = new HashSet<LootPool>();
    @SubscribeEvent
	public static void OnRecipeRegister(RegistryEvent.Register<IRecipe> event) {
    	addFishingLoot(new ItemStack(ItemLoader.FOODSET,1,78), 5);
    	addFishingLoot(new ItemStack(ItemLoader.MATERIAL,1,34), 8);
    	
    }
    
	@SubscribeEvent
	public static void onFishingLootLoaded(LootTableLoadEvent evt) {
        if (LOOT_LOCATIONS.contains(evt.getName().toString()))
        {
            for (LootPool pool : FishinglootPools)
            {
                evt.getTable().addPool(pool);
            }
        }
	}
	
    public static void addFishingLoot(ItemStack stack,int chanceint)
    {
        LootCondition[] lootConditions = new LootCondition[0];
        LootFunction[] setMeta = new LootFunction[] { new SetMetadata(lootConditions, new RandomValueRange(stack.getMetadata())) };
        LootEntry entry = new LootEntryItem(stack.getItem(), 1, 1, setMeta, lootConditions, stack.getUnlocalizedName());
        LootCondition chance = new RandomChance(1 * 0.75f * ((float)chanceint / 10.0f));

        FishinglootPools.add(new LootPool(new LootEntry[] { entry }, new LootCondition[] { chance }, new RandomValueRange(1), new RandomValueRange(0), stack.getUnlocalizedName()));
    }
	
}
