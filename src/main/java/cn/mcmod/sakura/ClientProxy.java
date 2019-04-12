package cn.mcmod.sakura;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.client.SakuraParticleType;
import cn.mcmod.sakura.client.particle.ParticleMapleLeaf;
import cn.mcmod.sakura.entity.SakuraEntityRegister;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public static ResourceLocation leafTexture = new ResourceLocation(SakuraMain.MODID, "textures/particles/leaf.png");

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        BlockLoader.registerRenders();
        ItemLoader.registerRenders();
        SakuraEntityRegister.entityRender();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

    }

    @Override
    public World getClientWorld() {

        return FMLClientHandler.instance().getClient().world;

    }

    @Override
    public void spawnParticle(World world, SakuraParticleType particleType, double x, double y, double z, double velX, double velY, double velZ) {

        Minecraft mc = Minecraft.getMinecraft();
        Entity entity = mc.getRenderViewEntity();

        // ignore the passed-in world, since on SP we get the integrated server world, which is not really what we want
        world = this.getClientWorld();

        if (entity != null && mc.effectRenderer != null) {

            int i = mc.gameSettings.particleSetting;

            if (i == 1 && world.rand.nextInt(3) == 0) {

                i = 2;

            }

            double d0 = entity.posX - x;

            double d1 = entity.posY - y;

            double d2 = entity.posZ - z;

            if (d0 * d0 + d1 * d1 + d2 * d2 <= 1024D && i <= 1) {

                Particle particle = null;

                switch (particleType) {
                    case MAPLE:
                        particle = new ParticleMapleLeaf(world, x, y, z, velX, velY, velZ);
                        break;

                }

                if (particle != null) {
                    mc.effectRenderer.addEffect(particle);
                }
            }
        }
    }
}
