package cn.mcmod.sakura.entity;

import cn.mcmod.sakura.SakuraMain;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SakuraEntityRegister {
    public static void entityRegister() {
        //EntityRegistry.registerModEntity(new ResourceLocation(SakuraMain.MODID, "deer"), EntityDeer.class, prefix("Deer"), 1, SakuraMain.instance, 90, 2, false, 0xe8a96d, 0xdcdcdc);
    }

    private static String prefix(String path) {
        return SakuraMain.MODID + "." + path;
    }

    @SideOnly(Side.CLIENT)
    public static void entityRender() {
        //RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, RenderDeer::new);
    }

    public static void entitySpawn() {

    }
}
