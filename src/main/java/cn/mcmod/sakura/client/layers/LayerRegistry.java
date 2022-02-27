package cn.mcmod.sakura.client.layers;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.client.render.StoneMortarRenderer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = SakuraMod.MODID, value = Dist.CLIENT)
public class LayerRegistry {
    public static final ModelLayerLocation STONE_MORTAR = register("stone_mortar");

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(STONE_MORTAR, StoneMortarRenderer::createLayer);
    }

    private static ModelLayerLocation register(String path) {
        return register(path, "main");
    }

    private static ModelLayerLocation register(String path, String part) {
        return new ModelLayerLocation(new ResourceLocation(SakuraMod.MODID, path), part);
    }
}
