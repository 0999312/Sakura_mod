package cn.mcmod.sakura.client;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.entity.BlockEntityRegistry;
import cn.mcmod.sakura.client.particle.FallenLeafParticle;
import cn.mcmod.sakura.client.particle.ParticleRegistry;
import cn.mcmod.sakura.client.render.StoneMortarRenderer;
import cn.mcmod.sakura.fluid.FluidRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.BushBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = SakuraMod.MODID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void clientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SAKURA_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RICE_CROP_ROOT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BAMBOO_PLANT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BAMBOOSHOOT.get(), RenderType.cutout());
            
            BlockRegistry.BLOCKS.getEntries().forEach(block -> {
                if (block.get() instanceof BushBlock) {
                    ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.cutout());
                }
            });
            FluidRegistry.FLUIDS.getEntries().forEach(fluid -> {
                ItemBlockRenderTypes.setRenderLayer(fluid.get(), RenderType.translucent());
            });
            
            BlockEntityRenderers.register(BlockEntityRegistry.STONE_MORTAR.get(), StoneMortarRenderer::new);
        });
    }

    @SuppressWarnings("resource")
    @SubscribeEvent
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SAKURA_LEAF.get(),
                FallenLeafParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.RED_MAPLE_LEAF.get(),
                FallenLeafParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.YELLOW_MAPLE_LEAF.get(),
                FallenLeafParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.GREEN_MAPLE_LEAF.get(),
                FallenLeafParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.ORANGE_MAPLE_LEAF.get(),
                FallenLeafParticle.Factory::new);
    }

}
