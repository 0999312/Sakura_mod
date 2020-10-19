package cn.mcmod.sakura;

import cn.mcmod.sakura.api.armor.ArmorLoader;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.client.SakuraParticleType;
import cn.mcmod.sakura.compat.tfc.TFCCompat;
import cn.mcmod.sakura.entity.SakuraEntityRegister;
import cn.mcmod.sakura.entity.villager.VillagerCreationWA;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.item.drinks.DrinksLoader;
import cn.mcmod.sakura.packet.PacketKeyMessage;
import cn.mcmod.sakura.packet.PacketKeyMessageHandler;
import cn.mcmod.sakura.potion.PotionLoader;
import cn.mcmod.sakura.tileentity.TileEntityRegistry;
import cn.mcmod.sakura.util.SakuraRecipeRegister;
import cn.mcmod.sakura.world.gen.WorldGenLoader;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber
public class CommonProxy {
	public static final SoundEvent TAIKO = new SoundEvent(new ResourceLocation(SakuraMain.MODID, "taiko"));
    public static CreativeTabs tab = new CreativeTabsSakura();
    private static SimpleNetworkWrapper network;
    public static SimpleNetworkWrapper getNetwork() {
        return network;
    }
    public void preInit(FMLPreInitializationEvent event) {
    	
        new PotionLoader(event);
        BlockLoader.getInstance().registerBlock();
        ItemLoader.getInstance().registerItem();
        DrinksLoader.getInstance().registerItems();
        SakuraEntityRegister.entityRegister();
        SakuraEntityRegister.entitySpawn();
        SakuraOreDictLoader.getInstance().registerOre();
        ArmorLoader.getInstance().Init();
        VillagerCreationWA.registerComponents();
		VillagerCreationWA villageHandler = new VillagerCreationWA();
		VillagerRegistry.instance().registerVillageCreationHandler(villageHandler);
    }

    public void init(FMLInitializationEvent event) {
    	MinecraftForge.ORE_GEN_BUS.register(WorldGenLoader.getInstance());
    	MinecraftForge.TERRAIN_GEN_BUS.register(WorldGenLoader.getInstance());
    	WorldGenLoader.getInstance().WorldGenRegister();
        TileEntityRegistry.getInstance().init();

        SakuraRecipeRegister.getInstance().Init();
        if(Loader.isModLoaded("tfc")){
        	TFCCompat.registerTFCFuel();
        }
        if (Loader.isModLoaded("waila")){
            FMLInterModComms.sendMessage("waila", "register", "cn.mcmod.sakura.compat.waila.CampfirePlugin.register");
            FMLInterModComms.sendMessage("waila", "register", "cn.mcmod.sakura.compat.waila.CampfirePotPlugin.register");
        }
        network = NetworkRegistry.INSTANCE.newSimpleChannel(SakuraMain.MODID);
    	network.registerMessage(new PacketKeyMessageHandler(),PacketKeyMessage.class,0,Side.SERVER);
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerFluidBlockRendering(Block block, String name) {

    }

    public void spawnParticle(SakuraParticleType particleType, double x, double y, double z, double velX, double velY, double velZ) {

    }
    @SubscribeEvent
    public static void onSoundEvenrRegistration(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().register(TAIKO.setRegistryName(new ResourceLocation(SakuraMain.MODID, "taiko")));
    }
}
