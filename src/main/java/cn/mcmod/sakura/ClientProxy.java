package cn.mcmod.sakura;

import org.lwjgl.input.Keyboard;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.client.SakuraParticleType;
import cn.mcmod.sakura.client.particle.ParticleMapleGreenLeaf;
import cn.mcmod.sakura.client.particle.ParticleMapleOrangeLeaf;
import cn.mcmod.sakura.client.particle.ParticleMapleRedLeaf;
import cn.mcmod.sakura.client.particle.ParticleMapleYellowLeaf;
import cn.mcmod.sakura.client.particle.ParticleSakuraLeaf;
import cn.mcmod.sakura.entity.SakuraEntityRegister;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.item.drinks.DrinksLoader;
import cn.mcmod.sakura.tileentity.TileEntityRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public static ResourceLocation leafTexture = new ResourceLocation(SakuraMain.MODID, "textures/particles/leaf.png");
    public static KeyBinding ChangeMode;
    
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        BlockLoader.registerRenders();
        ItemLoader.registerRenders();
        DrinksLoader.registerRender();
        SakuraEntityRegister.entityRender();

        TileEntityRegistry.render();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        ChangeMode = new KeyBinding("key.sakura.sheath_in", Keyboard.KEY_V, "key.categories.sakura");
        ClientRegistry.registerKeyBinding(ChangeMode); 
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

    }

    @Override
    public void spawnParticle(SakuraParticleType particleType, double x, double y, double z, double velX, double velY, double velZ) {
        Minecraft mc = Minecraft.getMinecraft();
        World world = mc.world;
        if (world == null) return;
        
        if (mc.effectRenderer != null) {
            int i = mc.gameSettings.particleSetting;
            if (i == 1 && world.rand.nextInt(3) == 0) i = 2;

            Particle particle = null;

            switch (particleType) {
            case MAPLERED:
                particle = new ParticleMapleRedLeaf(world, x, y, z, velX, velY, velZ);
                break;
			case MAPLEGREEN:
				particle = new ParticleMapleGreenLeaf(world, x, y, z, velX, velY, velZ);
				break;
			case MAPLEORANGE:
				particle = new ParticleMapleOrangeLeaf(world, x, y, z, velX, velY, velZ);
				break;
			case MAPLEYELLOW:
				particle = new ParticleMapleYellowLeaf(world, x, y, z, velX, velY, velZ);
				break;
			case LEAVESSAKURA:
				particle = new ParticleSakuraLeaf(world, x, y, z, velX, velY, velZ);
				break;
			default:
				break;

            }

            if (particle != null) {
                mc.effectRenderer.addEffect(particle);
            }

        }
    }

}
