package cn.mcmod.sakura.fluid;

import java.util.function.Supplier;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
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
    
    public static final RegistryObject<FlowingFluid> DOBUROKU = FLUIDS.register("doburoku", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.DOBUROKU_PROP));
    public static final RegistryObject<FlowingFluid> DOBUROKU_FLOWING = FLUIDS.register("doburoku_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.DOBUROKU_PROP));
    
    public static final RegistryObject<FlowingFluid> SAKE = FLUIDS.register("sake", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.SAKE_PROP));
    public static final RegistryObject<FlowingFluid> SAKE_FLOWING = FLUIDS.register("sake_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.SAKE_PROP));
    
    public static final RegistryObject<FlowingFluid> SHOUCHU = FLUIDS.register("shouchu", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.SHOUCHU_PROP));
    public static final RegistryObject<FlowingFluid> SHOUCHU_FLOWING = FLUIDS.register("shouchu_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.SHOUCHU_PROP));
    
    public static final RegistryObject<FlowingFluid> BEER = FLUIDS.register("beer", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.BEER_PROP));
    public static final RegistryObject<FlowingFluid> BEER_FLOWING = FLUIDS.register("beer_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.BEER_PROP));
    
    public static final RegistryObject<FlowingFluid> WHISKEY = FLUIDS.register("whiskey", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.WHISKEY_PROP));
    public static final RegistryObject<FlowingFluid> WHISKEY_FLOWING = FLUIDS.register("whiskey_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.WHISKEY_PROP));
    
    public static final RegistryObject<FlowingFluid> RUM = FLUIDS.register("rum", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.RUM_PROP));
    public static final RegistryObject<FlowingFluid> RUM_FLOWING = FLUIDS.register("rum_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.RUM_PROP));
    
    public static final RegistryObject<FlowingFluid> RED_WINE = FLUIDS.register("red_wine", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.RED_WINE_PROP));
    public static final RegistryObject<FlowingFluid> RED_WINE_FLOWING = FLUIDS.register("red_wine_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.RED_WINE_PROP));
    
    public static final RegistryObject<FlowingFluid> WHITE_WINE = FLUIDS.register("white_wine", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.WHITE_WINE_PROP));
    public static final RegistryObject<FlowingFluid> WHITE_WINE_FLOWING = FLUIDS.register("white_wine_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.WHITE_WINE_PROP));
    
    public static final RegistryObject<FlowingFluid> CHAMPAGNE = FLUIDS.register("champagne", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.CHAMPAGNE_PROP));
    public static final RegistryObject<FlowingFluid> CHAMPAGNE_FLOWING = FLUIDS.register("champagne_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.CHAMPAGNE_PROP));
    
    public static final RegistryObject<FlowingFluid> BRANDY = FLUIDS.register("brandy", 
            () -> new ForgeFlowingFluid.Source(FluidRegistry.BRANDY_PROP));
    public static final RegistryObject<FlowingFluid> BRANDY_FLOWING = FLUIDS.register("brandy_flowing", 
            () -> new ForgeFlowingFluid.Flowing(FluidRegistry.BRANDY_PROP));
    

    private static final ForgeFlowingFluid.Properties FOOD_OIL_PROP = 
            createProp(FOOD_OIL, FOOD_OIL_FLOWING, 0xFFFFF050, BucketItemRegistry.FOOD_OIL_BUCKET, FluidBlockRegistry.FOOD_OIL_BLOCK);

    private static final ForgeFlowingFluid.Properties DOBUROKU_PROP = 
            createProp(DOBUROKU, DOBUROKU_FLOWING, 0xFFCCC299, BucketItemRegistry.DOBUROKU_BUCKET, FluidBlockRegistry.DOBUROKU_BLOCK);
    
    private static final ForgeFlowingFluid.Properties SAKE_PROP = 
            createProp(SAKE, SAKE_FLOWING, 0xDDFFF8CC, BucketItemRegistry.SAKE_BUCKET, FluidBlockRegistry.SAKE_BLOCK);
    
    private static final ForgeFlowingFluid.Properties SHOUCHU_PROP = 
            createProp(SHOUCHU, SHOUCHU_FLOWING, 0xBBFFFCF2,BucketItemRegistry.SHOUCHU_BUCKET, FluidBlockRegistry.SHOUCHU_BLOCK);
    
    private static final ForgeFlowingFluid.Properties BEER_PROP = 
            createProp(BEER, BEER_FLOWING, 0xFFF2A918,BucketItemRegistry.BEER_BUCKET, FluidBlockRegistry.BEER_BLOCK);
    
    private static final ForgeFlowingFluid.Properties BRANDY_PROP = 
            createProp(BRANDY, BRANDY_FLOWING, 0xFFBF2F00,BucketItemRegistry.BRANDY_BUCKET, FluidBlockRegistry.BRANDY_BLOCK);
    
    private static final ForgeFlowingFluid.Properties WHISKEY_PROP = 
            createProp(WHISKEY, WHISKEY_FLOWING, 0xFFA52121,BucketItemRegistry.WHISKEY_BUCKET, FluidBlockRegistry.WHISKEY_BLOCK);
    
    private static final ForgeFlowingFluid.Properties RUM_PROP = 
            createProp(RUM, RUM_FLOWING, 0xFFFFAA32,BucketItemRegistry.RUM_BUCKET, FluidBlockRegistry.RUM_BLOCK);
    
    private static final ForgeFlowingFluid.Properties RED_WINE_PROP = 
            createProp(RED_WINE, RED_WINE_FLOWING, 0xFFA71844, BucketItemRegistry.RED_WINE_BUCKET, FluidBlockRegistry.RED_WINE_BLOCK);
    
    private static final ForgeFlowingFluid.Properties WHITE_WINE_PROP = 
            createProp(WHITE_WINE, WHITE_WINE_FLOWING, 0xFFFFF8B2, BucketItemRegistry.WHITE_WINE_BUCKET, FluidBlockRegistry.WHITE_WINE_BLOCK);
    
    private static final ForgeFlowingFluid.Properties CHAMPAGNE_PROP = 
            createProp(CHAMPAGNE, CHAMPAGNE_FLOWING, 0xFFFFE772, BucketItemRegistry.CHAMPAGNE_BUCKET, FluidBlockRegistry.CHAMPAGNE_BLOCK);
    
    private static ForgeFlowingFluid.Properties createProp(
            Supplier<? extends Fluid> still, 
            Supplier<? extends Fluid> flowing, 
            int color, 
            Supplier<? extends Item> bucket, 
            Supplier<? extends LiquidBlock> block){
        return new ForgeFlowingFluid.Properties(still, flowing,
                FluidAttributes.builder(new ResourceLocation("block/water_still"), 
                        new ResourceLocation("block/water_flow"))
                .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY)
                .color(color).density(3000).viscosity(1000))
                .block(block)
                .bucket(bucket)
                .slopeFindDistance(3)
                .explosionResistance(100F);
    }
}
