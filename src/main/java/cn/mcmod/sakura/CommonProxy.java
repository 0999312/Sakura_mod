package cn.mcmod.sakura;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.client.SakuraParticleType;
import cn.mcmod.sakura.entity.SakuraEntityRegister;
import cn.mcmod.sakura.event.SakuraEventLoader;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.item.drinks.DrinksLoader;
import cn.mcmod.sakura.tileentity.TileEntityRegistry;
import cn.mcmod.sakura.util.SakuraRecipeRegister;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@EventBusSubscriber
public class CommonProxy {
    public static CreativeTabs tab;


    public void preInit(FMLPreInitializationEvent event) {
        tab = new CreativeTabsSakura();
        new BlockLoader(event);
        new ItemLoader(event);
        new DrinksLoader();
        SakuraEntityRegister.entityRegister();

        MinecraftForge.EVENT_BUS.register(new SakuraEventLoader());
        new SakuraOreDictLoader();

    }

    public void init(FMLInitializationEvent event) {
        TileEntityRegistry.init();
        SakuraRecipeRegister.mortarRegister();
        SakuraRecipeRegister.potRegister();
        SakuraRecipeRegister.furnaceRegister();
        SakuraRecipeRegister.barrelRegister();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerFluidBlockRendering(Block block, String name) {

    }

    public World getClientWorld() {
        return null;
    }

    public void spawnParticle(SakuraParticleType particleType, double x, double y, double z, double velX, double velY, double velZ) {

    }

}
