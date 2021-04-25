package cn.mcmod.sakura.event;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import cn.mcmod.sakura.ClientProxy;
import cn.mcmod.sakura.SakuraConfig;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.api.armor.ArmorLoader;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.packet.PacketKeyMessage;
import cn.mcmod_mmf.mmlib.recipe.UniversalFluid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetMetadata;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;

@EventBusSubscriber
public class SakuraEventLoader {
    private static final Set<String> LOOT_LOCATIONS = ImmutableSet.<String>builder()
            .add(LootTableList.GAMEPLAY_FISHING_FISH.toString())
            .build();
    private final static Set<LootEntry> FishinglootPools = new HashSet<LootEntry>();
    @SubscribeEvent
    public static void onFuelRegister(FurnaceFuelBurnTimeEvent event) {
    	if(ItemStack.areItemsEqual(event.getItemStack(), new ItemStack(BlockLoader.BAMBOO)))
    		event.setBurnTime(400);
    	if(ItemStack.areItemsEqual(event.getItemStack(), new ItemStack(ItemLoader.MATERIAL, 1,51)))
    		event.setBurnTime(1600);
    	if(ItemStack.areItemsEqual(event.getItemStack(), new ItemStack(BlockLoader.BAMBOO_CHARCOAL_BLOCK)))
    		event.setBurnTime(8000);
	}
    
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void RegisterUniverFluid(RegistryEvent.Register<UniversalFluid> event){
    	event.getRegistry().register(new UniversalFluid(BlockLoader.VODKA_FLUID,BlockLoader.RUM_FLUID,BlockLoader.BRANDY_FLUID,BlockLoader.WHISKEY_FLUID).setRegistryName(new ResourceLocation("sakura", "alcohol_liqueur")));

    }
    
    @SubscribeEvent
	public static void OnRecipeRegister(RegistryEvent.Register<IRecipe> event) {
    	addFishingLoot(new ItemStack(ItemLoader.FOODSET,1,78),45);
    	addFishingLoot(new ItemStack(ItemLoader.FOODSET,1,141),45);
    	addFishingLoot(new ItemStack(ItemLoader.SEAWEED_RAW),15);
    }
    
	@SubscribeEvent
	public static void onFishingLootLoaded(LootTableLoadEvent evt) {
        if (LOOT_LOCATIONS.contains(evt.getName().toString()))
            for (LootEntry entry : FishinglootPools)
            	evt.getTable().getPool("main").addEntry(entry); 
	}
	
    public static void addFishingLoot(ItemStack stack,int weight){
        LootCondition[] lootConditions = new LootCondition[0];
        LootFunction[] setMeta = new LootFunction[] { new SetMetadata(lootConditions, new RandomValueRange(stack.getMetadata())) };
        LootEntry entry = new LootEntryItem(stack.getItem(), weight, 0, setMeta, lootConditions, stack.getUnlocalizedName());

        FishinglootPools.add(entry);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
	public static void KeyInput(InputEvent.KeyInputEvent event) {
		if(ClientProxy.ChangeMode.isPressed()){
			ClientProxy.getNetwork().sendToServer(new PacketKeyMessage(SakuraMain.MODID));
		 }
	}
    @SubscribeEvent
	public static void onPlayerLoggin(PlayerLoggedInEvent event) {
    	if(SakuraConfig.harder_iron_recipe)
		event.player.sendMessage(new TextComponentTranslation("sakura.warning.harder_iron_recipe_enabled", new Object()));
	}
    
    @SubscribeEvent
    public static void onPlayerLogginGiveItem(PlayerLoggedInEvent event) {
    	if(event.player instanceof EntityPlayerMP) {
    		//Thanks ENE
    		if(event.player.getName().equalsIgnoreCase("ENE"))
    			giveItem((EntityPlayerMP) event.player,
    					ArmorLoader.getInstance().getCustomArmor("kimono_ene", ItemLoader.KIMONO));
    	}
    }
    private static void giveItem(EntityPlayerMP player,ItemStack item) {
		NBTTagCompound playerData = player.getEntityData();
		NBTTagCompound data = getTagSafe(playerData, EntityPlayer.PERSISTED_NBT_TAG);
		StringBuilder builder =new StringBuilder(item.getUnlocalizedName().substring(5)).append("_has");
		if (!data.getBoolean(builder.toString())) {
			ItemHandlerHelper.giveItemToPlayer(player, item);
			data.setBoolean(builder.toString(), true);
			playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
		}
    }
    private static NBTTagCompound getTagSafe(NBTTagCompound tag, String key) {
        if(tag == null) {
          return new NBTTagCompound();
        }

        return tag.getCompoundTag(key);
    }
}
