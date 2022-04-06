package cn.mcmod.sakura.data;

import cn.mcmod.sakura.fluid.FluidRegistry;
import cn.mcmod.sakura.tags.SakuraFluidTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraFluidTagsProvider extends FluidTagsProvider {

    public SakuraFluidTagsProvider(DataGenerator datagen, String modId, ExistingFileHelper existingFileHelper) {
        super(datagen, modId, existingFileHelper);
    }
    @Override
    protected void addTags() {
        tag(FluidTags.WATER).add(FluidRegistry.FOOD_OIL.get(),FluidRegistry.FOOD_OIL_FLOWING.get());
        tag(SakuraFluidTags.WATER_WATER).add(Fluids.WATER, Fluids.FLOWING_WATER);
        tag(SakuraFluidTags.FOOD_OIL).addTag(SakuraFluidTags.PLANTOIL);
        tag(SakuraFluidTags.PLANTOIL).add(FluidRegistry.FOOD_OIL.get(),FluidRegistry.FOOD_OIL_FLOWING.get());
    }
}
