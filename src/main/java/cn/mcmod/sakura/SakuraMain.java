package cn.mcmod.sakura;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = SakuraMain.MODID, name = SakuraMain.NAME, version = SakuraMain.VERSION)
public class SakuraMain {
    public static final String MODID = "sakura";
    public static final String NAME = "Sakura";
    public static final String VERSION = "@version@";

    @Instance(SakuraMain.MODID)
    public static SakuraMain instance;

    @SidedProxy(clientSide = "cn.mcmod.sakura.ClientProxy", serverSide = "cn.mcmod.sakura.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
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
