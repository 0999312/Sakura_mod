package cn.mcmod.sakura.entity.villager;

import java.util.List;
import java.util.Random;

import cn.mcmod.sakura.block.BlockFacing;
import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.registries.ForgeRegistry;

public class WAVillagerHouse extends StructureVillagePieces.Village {
    public WAVillagerHouse()
    {
    }

    public WAVillagerHouse(StructureVillagePieces.Start start, int type, Random rand, StructureBoundingBox p_i45571_4_, EnumFacing facing)
    {
        super(start, type);
        this.setCoordBaseMode(facing);
        this.boundingBox = p_i45571_4_;
    }

	public static WAVillagerHouse createPiece(StructureVillagePieces.Start start,
			List<StructureComponent> list, Random rand, int minX, int minY, int minZ, EnumFacing facing, int type) {
		StructureBoundingBox box = StructureBoundingBox
				.getComponentToAddBoundingBox(minX, minY, minZ, 0, 0, 0, 9, 9, 6, facing);
		return StructureComponent.findIntersecting(list, box) != null ? null : new WAVillagerHouse(start,
				type, rand, box, facing);
	}

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
     * Mineshafts at the end, it adds Fences...
     */
    public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn)
    {
        if (this.averageGroundLvl < 0)
        {
            this.averageGroundLvl = this.getAverageGroundLevel(worldIn, structureBoundingBoxIn);

            if (this.averageGroundLvl < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 9 - 1, 0);
        }

        IBlockState iblockstate = Blocks.STONE.getDefaultState();
        IBlockState iblockstate1 = BlockLoader.STRAW_BLOCK_STAIR.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH);
        IBlockState iblockstate2 = BlockLoader.STRAW_BLOCK_STAIR.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH);
        IBlockState iblockstate000 = BlockLoader.BAMBOO_PLANK_STAIR.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH);
        IBlockState iblockstate3 = BlockLoader.BAMBOO_PLANK_STAIR.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST);
        IBlockState iblockstate4 = BlockLoader.BAMBOO_PLANK.getDefaultState();
        IBlockState iblockstate5 = BlockLoader.MAPLE_PLANK_STAIR.getDefaultState().withProperty(BlockFacing.FACING, EnumFacing.NORTH);
        IBlockState iblockstate6 = BlockLoader.BAMBOO_FENCE.getDefaultState();
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, 1, 7, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 8, 0, 5, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 5, 0, 8, 5, 5, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 6, 1, 8, 6, 4, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 7, 2, 8, 7, 3, iblockstate, iblockstate, false);
        for (int i = -1; i <= 2; ++i)
        {
            for (int j = 0; j <= 8; ++j)
            {
                this.setBlockState(worldIn, iblockstate1, j, 6 + i, i, structureBoundingBoxIn);
                this.setBlockState(worldIn, iblockstate2, j, 6 + i, 5 - i, structureBoundingBoxIn);
            }
        }
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 0, 0, 1, 5, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 1, 5, 8, 1, 5, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 1, 0, 8, 1, 4, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 2, 1, 0, 7, 1, 0, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 0, 0, 4, 0, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 5, 0, 4, 5, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 2, 5, 8, 4, 5, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 2, 0, 8, 4, 0, iblockstate, iblockstate, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 2, 1, 0, 4, 4, iblockstate4, iblockstate4, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 5, 7, 4, 5, iblockstate4, iblockstate4, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 8, 2, 1, 8, 4, 4, iblockstate4, iblockstate4, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 2, 0, 7, 4, 0, iblockstate4, iblockstate4, false);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 0, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 0, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 0, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 4, 3, 0, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 5, 3, 0, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 6, 3, 0, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 3, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 2, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 3, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 2, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 8, 3, 2, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 8, 3, 3, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 5, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 3, 2, 5, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 5, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 5, structureBoundingBoxIn);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 4, 1, 7, 4, 1, iblockstate4, iblockstate4, false);
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 4, 4, 7, 4, 4, iblockstate4, iblockstate4, false);
        this.setBlockState(worldIn, iblockstate4, 7, 1, 4, structureBoundingBoxIn);
        this.setBlockState(worldIn, iblockstate3, 7, 1, 3, structureBoundingBoxIn);
        this.setBlockState(worldIn, iblockstate000, 6, 1, 4, structureBoundingBoxIn);
        this.setBlockState(worldIn, iblockstate000, 5, 1, 4, structureBoundingBoxIn);
        this.setBlockState(worldIn, iblockstate000, 4, 1, 4, structureBoundingBoxIn);
        this.setBlockState(worldIn, iblockstate000, 3, 1, 4, structureBoundingBoxIn);
        this.setBlockState(worldIn, iblockstate6, 6, 1, 3, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 6, 2, 3, structureBoundingBoxIn);
        this.setBlockState(worldIn, iblockstate6, 4, 1, 3, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 4, 2, 3, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.CRAFTING_TABLE.getDefaultState(), 7, 1, 1, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.AIR.getDefaultState(), 1, 1, 0, structureBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.AIR.getDefaultState(), 1, 2, 0, structureBoundingBoxIn);
        this.createVillageDoor(worldIn, structureBoundingBoxIn, randomIn, 1, 1, 0, EnumFacing.NORTH);

        if (this.getBlockStateFromPos(worldIn, 1, 0, -1, structureBoundingBoxIn).getMaterial() == Material.AIR && this.getBlockStateFromPos(worldIn, 1, -1, -1, structureBoundingBoxIn).getMaterial() != Material.AIR)
        {
            this.setBlockState(worldIn, iblockstate5, 1, 0, -1, structureBoundingBoxIn);

            if (this.getBlockStateFromPos(worldIn, 1, -1, -1, structureBoundingBoxIn).getBlock() == Blocks.GRASS_PATH)
            {
                this.setBlockState(worldIn, Blocks.GRASS.getDefaultState(), 1, -1, -1, structureBoundingBoxIn);
            }
        }

        for (int l = 0; l < 6; ++l)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.clearCurrentPositionBlocksUpwards(worldIn, k, 9, l, structureBoundingBoxIn);
                this.replaceAirAndLiquidDownwards(worldIn, iblockstate, k, -1, l, structureBoundingBoxIn);
            }
        }

        this.spawnVillagers(worldIn, structureBoundingBoxIn, 2, 1, 2, 1);
        return true;
    }

    protected int chooseProfession(int villagersSpawnedIn, int currentVillagerProfession)
    {
		ForgeRegistry<VillagerRegistry.VillagerProfession> registry = (ForgeRegistry<VillagerProfession>) ForgeRegistries.VILLAGER_PROFESSIONS;
		int id = registry.getID(VillagerLoader.wa_villager);
		return id < 0 ? currentVillagerProfession : id;
    }
}