package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class SakeFluid extends Fluid {

    public static final String name = "sake";

    public SakeFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/sake_still"), new ResourceLocation(SakuraMain.MODID, "blocks/sake_flow"));
    }

}