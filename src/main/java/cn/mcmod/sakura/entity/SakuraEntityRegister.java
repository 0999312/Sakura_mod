package cn.mcmod.sakura.entity;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.client.render.RenderDeer;
import cn.mcmod.sakura.client.render.RenderSamuraiIllager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SakuraEntityRegister {
    public static void entityRegister() {
        EntityRegistry.registerModEntity(new ResourceLocation(SakuraMain.MODID, "deer"), EntityDeer.class, prefix("Deer"), 1, SakuraMain.instance, 90, 2, false, 0xe8a96d, 0xdcdcdc);
        EntityRegistry.registerModEntity(new ResourceLocation(SakuraMain.MODID, "samuraiillger"), EntitySamuraiIllager.class, prefix("SamuraiIllager"), 2, SakuraMain.instance, 90, 2, true, 9804699, 2580065);
    }

    private static String prefix(String path) {
        return SakuraMain.MODID + "." + path;
    }

    @SideOnly(Side.CLIENT)
    public static void entityRender() {
        RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, RenderDeer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySamuraiIllager.class, RenderSamuraiIllager::new);
    }

    public static void entitySpawn() {

    }
}
