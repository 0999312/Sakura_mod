package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class ShouchuFluid extends Fluid {

    public static final String name = "shouchu";

    public ShouchuFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/shouchu_still"), new ResourceLocation(SakuraMain.MODID, "blocks/shouchu_flow"));
    }

}