package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class GrapeFluid extends Fluid {

    public static final String name = "grape_fluid";

    public GrapeFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/grape_fluid_still"), new ResourceLocation(SakuraMain.MODID, "blocks/grape_fluid_flow"));
    }

}