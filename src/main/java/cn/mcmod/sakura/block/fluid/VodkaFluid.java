package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class VodkaFluid extends Fluid {

    public static final String name = "vodka";

    public VodkaFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/vodka_still"), new ResourceLocation(SakuraMain.MODID, "blocks/vodka_flow"));
    }

}