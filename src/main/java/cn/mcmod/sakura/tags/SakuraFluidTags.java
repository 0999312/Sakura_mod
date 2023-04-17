package cn.mcmod.sakura.tags;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod_mmf.mmlib.utils.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class SakuraFluidTags {
    public static final TagKey<Fluid> WATER_WATER = TagUtils.forgeFluidTag("water/water");
    public static final TagKey<Fluid> FOOD_OIL = TagUtils.forgeFluidTag("food_oil");
    public static final TagKey<Fluid> PLANTOIL = TagUtils.forgeFluidTag("plantoil");
    public static final TagKey<Fluid> SOYSAUCE = TagUtils.forgeFluidTag("soysauce");
    
    public static final TagKey<Fluid> BREWERS_ALCOHOL = TagUtils.modFluidTag(SakuraMod.MODID, "brewers_alcohol");
}
