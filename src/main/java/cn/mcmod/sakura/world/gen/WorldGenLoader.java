package cn.mcmod.sakura.world.gen;

import cn.mcmod.sakura.SakuraConfig;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.world.biome.SakuraBiomes;
import cn.mcmod_mmf.mmlib.util.WorldUtil;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGenLoader {
	private static final WorldGenLoader instance = new WorldGenLoader();
	private WorldGenLoader() {
	}
	public void WorldGenRegister() {
		GameRegistry.registerWorldGenerator(new WorldGenBambooShot(), 1);
		GameRegistry.registerWorldGenerator(new WorldGenPepper(), 1);
		GameRegistry.registerWorldGenerator(new WorldGenVanilla(), 1);
		GameRegistry.registerWorldGenerator(new WorldGenIronSand(SakuraConfig.iron_sand_amount), 1);
	}
	@SubscribeEvent
	public void onOreGen(OreGenEvent.Post event) {
		World worldIn = event.getWorld();
        int genY = 10 + event.getRand().nextInt(24);
		if (SakuraConfig.every_where_sakura_diamond||(worldIn.getBiome(new BlockPos(event.getPos().getX(), 0, event.getPos().getZ())) == SakuraBiomes.BAMBOOFOREST ||
			worldIn.getBiome(new BlockPos(event.getPos().getX(), 0, event.getPos().getZ())) == SakuraBiomes.MAPLEFOREST)) {
			BlockPos pos=new BlockPos(event.getPos().getX(),genY, event.getPos().getZ());
                for (int i = 0; i < 2; i++) {
                    new WorldGenMinable(BlockLoader.SAKURA_DIAMOND_ORE.getDefaultState(),3 + event.getRand().nextInt(5)).generate(worldIn, event.getRand(), pos);
                }
        }
	}
    @SubscribeEvent
    public void HotSpringGen(Decorate event) {
    	if(Loader.isModLoaded("tfc"))
    		return;
    	BlockPos pos = event.getChunkPos().getBlock(event.getRand().nextInt(16) + 8, 0, event.getRand().nextInt(16) + 8);
    	BlockPos newPos = WorldUtil.getInstance().findGround(event.getWorld(),pos, true, false, true);
    	Biome biome = event.getWorld().getBiome(pos);
        
    	if (newPos != null&&event.getWorld().provider instanceof WorldProviderSurface&&biome != Biomes.DESERT && biome != Biomes.DESERT_HILLS && event.getRand().nextFloat() < SakuraConfig.hotspring_weight / 10000.0F) {
            new WorldGenHotSpring().generate(event.getWorld(), event.getRand(), newPos);
        }
	}
	public static WorldGenLoader getInstance() {
		return instance;
	}

}
