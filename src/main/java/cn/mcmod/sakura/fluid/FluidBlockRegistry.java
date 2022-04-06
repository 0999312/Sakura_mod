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
}
