package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class WhiteWineFluid extends Fluid {

    public static final String name = "white_wine";

    public WhiteWineFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/white_wine_still"), new ResourceLocation(SakuraMain.MODID, "blocks/white_wine_flow"));
    }

}