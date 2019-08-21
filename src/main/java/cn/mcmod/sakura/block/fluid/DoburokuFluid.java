package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class DoburokuFluid extends Fluid {

    public static final String name = "doburoku";

    public DoburokuFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/doburoku_still"), new ResourceLocation(SakuraMain.MODID, "blocks/doburoku_flow"));
    }

}