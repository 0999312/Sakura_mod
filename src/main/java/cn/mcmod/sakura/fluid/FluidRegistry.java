package cn.mcmod.sakura.fluid;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidRegistry {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, SakuraMod.MODID);

    public static final RegistryObject<FlowingFluid> FOOD_OIL = FLUIDS.register("food_oil", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.FOOD_OIL_PROP));
    public static final RegistryObject<FlowingFluid> FOOD_OIL_FLOWING = FLUIDS.register("food_oil_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.FOOD_OIL_PROP));

    private static final ForgeFlowingFluid.Properties FOOD_OIL_PROP =  new ForgeFlowingFluid.Properties(FOOD_OIL, FOOD_OIL_FLOWING,
            FluidAttributes.builder(new ResourceLocation("block/water_still"), 
                    new ResourceLocation("block/water_flow"))
            
            .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY)
            .color(0xFFFFF050).density(3000).viscosity(1000))
            .block(FluidBlockRegistry.FOOD_OIL_BLOCK)
            .bucket(BucketItemRegistry.FOOD_OIL_BUCKET)
            .slopeFindDistance(3)
            .explosionResistance(100F);

}
