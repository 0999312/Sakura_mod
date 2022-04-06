package cn.mcmod.sakura.tags;

import cn.mcmod_mmf.mmlib.utils.TagUtils;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class SakuraFluidTags {
    public static final IOptionalNamedTag<Fluid> WATER_WATER = TagUtils.forgeFluidTag("water/water");
    public static final IOptionalNamedTag<Fluid> FOOD_OIL = TagUtils.forgeFluidTag("food_oil");
    public static final IOptionalNamedTag<Fluid> PLANTOIL = TagUtils.forgeFluidTag("plantoil");
}
