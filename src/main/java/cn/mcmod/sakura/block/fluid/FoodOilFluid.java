package cn.mcmod.sakura.block.fluid;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FoodOilFluid extends Fluid {

    public static final String name = "foodoil";

    public FoodOilFluid() {
        super(name, new ResourceLocation(SakuraMain.MODID, "blocks/food_oil_still"), new ResourceLocation(SakuraMain.MODID, "blocks/food_oil_flow"));
    }

}