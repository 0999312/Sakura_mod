package cn.mcmod.sakura.world.gen;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGenLoader {
	public WorldGenLoader() {
		GameRegistry.registerWorldGenerator(new WorldGenBambooShot(), 1);
		GameRegistry.registerWorldGenerator(new WorldGenPepper(), 1);
		GameRegistry.registerWorldGenerator(new WorldGenVanilla(), 1);
	}

}
