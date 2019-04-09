package cn.mcmod.sakura.entity;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SakuraEntityRegister {
	   public static void entityRegister() {
	    }

	    private static String prefix(String path) {
	        return SakuraMain.MODID + "." + path;
	    }

	    @SideOnly(Side.CLIENT)
	    public static void entityRender() {
	    
	    }
	    public static void entitySpawn() {

	    }
}
