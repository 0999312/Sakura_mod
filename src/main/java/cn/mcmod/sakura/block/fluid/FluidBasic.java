package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidBasic extends Fluid {
    public FluidBasic(String name) {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/"+name+"_still"), new ResourceLocation(SakuraMain.MODID, "blocks/"+name+"_flow"));
    }

}