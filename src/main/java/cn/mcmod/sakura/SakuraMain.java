package cn.mcmod.sakura;

import org.apache.logging.log4j.Logger;

import cn.mcmod.sakura.gui.SakuraGuiHandler;
import cn.mcmod.sakura.world.biome.SakuraBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.registries.IForgeRegistry;
// 
@Mod(modid = SakuraMain.MODID, name = SakuraMain.NAME, version = SakuraMain.VERSION,dependencies = "required-after:mm_lib@[2.2.0,) ;")
public class SakuraMain {
    public static final String MODID = "sakura";
    public static final String NAME = "Sakura";
    public static final String VERSION = "@version@";

    @Instance(SakuraMain.MODID)
    public static SakuraMain instance;

    public static Logger logger;
    
    @SidedProxy(clientSide = "cn.mcmod.sakura.ClientProxy", serverSide = "cn.mcmod.sakura.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);

        FluidRegistry.enableUniversalBucket();
    }

    @SubscribeEvent
    public void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();
        SakuraBiomes.register(registry);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        logger = event.getModLog();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new SakuraGuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
