package cn.mcmod.sakura.entity.villager;

import java.util.List;
import java.util.Random;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class VillagerCreationWA implements IVillageCreationHandler{
	public static void registerComponents() {
		MapGenStructureIO.registerStructureComponent(WAVillagerHouse.class,
				SakuraMain.MODID+":wa_house");
	
	}
	@Override
	public PieceWeight getVillagePieceWeight(Random random, int i) {
		return new PieceWeight(WAVillagerHouse.class, 20, MathHelper.getInt(random, i, 1 + i));
	}

	@Override
	public Class<?> getComponentClass() {
		return WAVillagerHouse.class;
	}

	@Override
	public Village buildComponent(PieceWeight villagePiece, Start startPiece, List<StructureComponent> pieces,
			Random random, int p1, int p2, int p3, EnumFacing facing, int p5) {
		return WAVillagerHouse.createPiece(startPiece, pieces, random, p1, p2, p3, facing, p5);
	}

}
