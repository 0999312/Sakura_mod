package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class GreenGrapeFluid extends Fluid {

    public static final String name = "green_grape_fluid";

    public GreenGrapeFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/green_grape_fluid_still"), new ResourceLocation(SakuraMain.MODID, "blocks/green_grape_fluid_flow"));
    }

}