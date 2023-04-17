package cn.mcmod.sakura.data;

import cn.mcmod.sakura.fluid.FluidRegistry;
import cn.mcmod.sakura.tags.SakuraFluidTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
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
        tag(FluidTags.WATER).add(FluidRegistry.DOBUROKU.get(),FluidRegistry.DOBUROKU_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.SAKE.get(),FluidRegistry.SAKE_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.SHOUCHU.get(),FluidRegistry.SHOUCHU_FLOWING.get());
        
        tag(FluidTags.WATER).add(FluidRegistry.RED_WINE.get(),FluidRegistry.RED_WINE_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.WHITE_WINE.get(),FluidRegistry.WHITE_WINE_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.WHISKEY.get(),FluidRegistry.WHISKEY_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.BEER.get(),FluidRegistry.BEER_FLOWING.get());
        
        tag(FluidTags.WATER).add(FluidRegistry.RUM.get(),FluidRegistry.RUM.get());
        tag(FluidTags.WATER).add(FluidRegistry.CHAMPAGNE.get(),FluidRegistry.CHAMPAGNE_FLOWING.get());
        tag(FluidTags.WATER).add(FluidRegistry.BRANDY.get(),FluidRegistry.BRANDY.get());
        
        tag(SakuraFluidTags.WATER_WATER).add(Fluids.WATER, Fluids.FLOWING_WATER).addOptional(new ResourceLocation("tfc:river_water"));
        tag(SakuraFluidTags.BREWERS_ALCOHOL)
            .add(FluidRegistry.RUM.get(),FluidRegistry.RUM_FLOWING.get())
            .add(FluidRegistry.WHISKEY.get(),FluidRegistry.WHISKEY_FLOWING.get())
            .add(FluidRegistry.SHOUCHU.get(),FluidRegistry.SHOUCHU_FLOWING.get());
        tag(SakuraFluidTags.FOOD_OIL).addTag(SakuraFluidTags.PLANTOIL);
        tag(SakuraFluidTags.PLANTOIL).add(FluidRegistry.FOOD_OIL.get(),FluidRegistry.FOOD_OIL_FLOWING.get()).addOptional(new ResourceLocation("tfc:flowing_olive_oil")).addOptional(new ResourceLocation("tfc:olive_oil"));
    }
}
