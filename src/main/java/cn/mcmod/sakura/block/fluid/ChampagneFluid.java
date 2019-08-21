package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class ChampagneFluid extends Fluid {

    public static final String name = "champagne";

    public ChampagneFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/champagne_still"), new ResourceLocation(SakuraMain.MODID, "blocks/champagne_flow"));
    }

}