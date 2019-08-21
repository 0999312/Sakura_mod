package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class RedWineFluid extends Fluid {

    public static final String name = "red_wine";

    public RedWineFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/red_wine_still"), new ResourceLocation(SakuraMain.MODID, "blocks/red_wine_flow"));
    }

}