package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class BeerFluid extends Fluid {

    public static final String name = "beer";

    public BeerFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/beer_still"), new ResourceLocation(SakuraMain.MODID, "blocks/beer_flow"));
    }

}