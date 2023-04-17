package cn.mcmod.sakura.fluid;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidBlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SakuraMod.MODID);
    public static final RegistryObject<LiquidBlock> FOOD_OIL_BLOCK = BLOCKS.register("food_oil", () ->
        new LiquidBlock(FluidRegistry.FOOD_OIL, Block.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> DOBUROKU_BLOCK = BLOCKS.register("doburoku", () ->
        new LiquidBlock(FluidRegistry.DOBUROKU, Block.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<LiquidBlock> SAKE_BLOCK = BLOCKS.register("sake", () ->
        new LiquidBlock(FluidRegistry.SAKE, Block.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<LiquidBlock> SHOUCHU_BLOCK = BLOCKS.register("shouchu", () ->
        new LiquidBlock(FluidRegistry.SHOUCHU, Block.Properties.copy(Blocks.WATER)));
    
    public static final RegistryObject<LiquidBlock> BEER_BLOCK = BLOCKS.register("beer", () ->
        new LiquidBlock(FluidRegistry.BEER, Block.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<LiquidBlock> WHISKEY_BLOCK = BLOCKS.register("whiskey", () ->
        new LiquidBlock(FluidRegistry.WHISKEY, Block.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<LiquidBlock> RED_WINE_BLOCK = BLOCKS.register("red_wine", () ->
        new LiquidBlock(FluidRegistry.RED_WINE, Block.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<LiquidBlock> WHITE_WINE_BLOCK = BLOCKS.register("white_wine", () ->
        new LiquidBlock(FluidRegistry.WHITE_WINE, Block.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<LiquidBlock> BRANDY_BLOCK = BLOCKS.register("brandy", () ->
        new LiquidBlock(FluidRegistry.BRANDY, Block.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<LiquidBlock> RUM_BLOCK = BLOCKS.register("rum", () ->
        new LiquidBlock(FluidRegistry.RUM, Block.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<LiquidBlock> CHAMPAGNE_BLOCK = BLOCKS.register("champagne", () ->
        new LiquidBlock(FluidRegistry.CHAMPAGNE, Block.Properties.copy(Blocks.WATER)));

}
