package cn.mcmod.sakura.block;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SakuraMod.MODID);
    
//    public static final RegistryObject<Block> SAKURA_LEAVES = BLOCKS.register("sakuraleaves", ()->new LeavesBlock(null));
}
