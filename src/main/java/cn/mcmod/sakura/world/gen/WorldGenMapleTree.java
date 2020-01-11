package cn.mcmod.sakura.world.gen;

import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class WorldGenMapleTree extends WorldGenAbstractTree {
    private static final IBlockState DEFAULT_TRUNK = BlockLoader.MAPLE_LOG.getDefaultState();
    private static final IBlockState DEFAULT_LEAF = BlockLoader.MAPLE_LEAVE_RED.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    private static final IBlockState DEFAULT_FALLEN_LEAF = BlockLoader.FALLEN_LEAVES_MAPLE_RED.getDefaultState();

    private final int minTreeHeight;

    private final boolean generateSap;
    private final IBlockState metaWood;
    private final IBlockState metaLeaves;
    private final IBlockState metaFallenLeaves;

    public WorldGenMapleTree(boolean p_i2027_1_, boolean sap) {
        this(p_i2027_1_, 4, DEFAULT_TRUNK, DEFAULT_LEAF,DEFAULT_FALLEN_LEAF, sap);
    }

    public WorldGenMapleTree(boolean notify, int minTreeHeightIn, IBlockState woodMeta, IBlockState p_i46446_4_,IBlockState fallenMeta, boolean sap) {
        super(notify);
        this.minTreeHeight = minTreeHeightIn;
        this.metaWood = woodMeta;
        this.metaLeaves = p_i46446_4_;
        this.metaFallenLeaves = fallenMeta;
        this.generateSap = sap;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int i = rand.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getHeight()) {
            for (int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
                int k = 1;

                if (j == position.getY()) {
                    k = 0;
                }

                if (j >= position.getY() + 1 + i - 2) {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
                        if (j >= 0 && j < worldIn.getHeight()) {
                            if (!this.isReplaceable(worldIn, blockpos$mutableblockpos.setPos(l, j, i1))) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            }
			IBlockState state = worldIn.getBlockState(position.down());

			if (state.getBlock().canSustainPlant(state, worldIn, position.down(), net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling) Blocks.SAPLING) && position.getY() < worldIn.getHeight() - i - 1) {
			    state.getBlock().onPlantGrow(state, worldIn, position.down(), position);

			    for (int i3 = position.getY() - 3 + i; i3 <= position.getY() + i; ++i3) {
			        int i4 = i3 - (position.getY() + i);
			        int j1 = 1 - i4 / 2;

			        for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1) {
			            int l1 = k1 - position.getX();

			            for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2) {
			                int j2 = i2 - position.getZ();

			                if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0) {
			                    BlockPos blockpos = new BlockPos(k1, i3, i2);
			                    state = worldIn.getBlockState(blockpos);

			                    if (state.getBlock().isAir(state, worldIn, blockpos) || state.getBlock().isLeaves(state, worldIn, blockpos) || state.getMaterial() == Material.VINE) {
			                        this.setBlockAndNotifyAdequately(worldIn, blockpos, this.metaLeaves);
			                    }
			                }
			            }
			        }
			    }

			    for (int j3 = 0; j3 < i; ++j3) {
			        BlockPos upN = position.up(j3);
			        state = worldIn.getBlockState(upN);

			        if (state.getBlock().isAir(state, worldIn, upN) || state.getBlock().isLeaves(state, worldIn, upN) || state.getMaterial() == Material.VINE) {
			            this.setBlockAndNotifyAdequately(worldIn, position.up(j3), this.metaWood);

			            if (this.generateSap && j3 == 1) {
			                if (worldIn.getBlockState(position.add(0, j3, 0))==this.metaWood) {
			                    this.addSapLog(worldIn, position.add(0, j3, 0));
			                }

			            }
			        }
			    }
			    fallenLeaves(worldIn, position,4,2,4, this.metaFallenLeaves);
			    
			    return true;
			}
			return false;
        }
		return false;
    }

    /**
     * Fill the given area with the selected blocks
     */
    private void fallenLeaves(World worldIn,BlockPos pos, int xADD, int yADD, int zADD, IBlockState insideBlockState){
    	int xx = pos.getX();
        int yy = pos.getY();
        int zz = pos.getZ();
        
        boolean setFlg = false;
        int YEND = 4;
        for (int xx1 = xx - xADD; xx1 <= xx + xADD; xx1++) {
          for (int zz1 = zz - zADD; zz1 <= zz + zADD; zz1++) {
            if (((xx1 != xx - xADD) || (zz1 != zz - zADD)) && ((xx1 != xx + xADD) || (zz1 != zz - zADD)) && ((xx1 != xx - xADD) || (zz1 != zz + zADD)) && ((xx1 != xx + xADD) || (zz1 != zz + zADD)) && (((xx1 >= xx - xADD + 1) && (xx1 <= xx + xADD - 1) && (zz1 >= zz - zADD + 1) && (zz1 <= zz + zADD - 1)) || (worldIn.rand.nextInt(2) != 0)))
            {
              setFlg = false;
              int yy1 = yy + yADD;
              Block cBl = worldIn.getBlockState(new BlockPos(xx1, yy + yADD, zz1)).getBlock();
              
              if ((cBl == Blocks.AIR) || (cBl instanceof BlockLeaves) || (cBl == BlockLoader.CHESTNUTBURR)) {
                for (yy1 = yy + yADD; yy1 >= yy - YEND; yy1--)
                {
                  boolean cAir = worldIn.isAirBlock(new BlockPos(xx1, yy1, zz1));
                  cBl = worldIn.getBlockState(new BlockPos(xx1, yy1 - 1, zz1)).getBlock();
                  if ((cBl == Blocks.AIR) || ((cBl != Blocks.GRASS) && !(cBl instanceof BlockLeaves) && (!worldIn.getBlockState(new BlockPos(xx1, yy1 - 1, zz1)).isOpaqueCube())))
                  {
                    if (cBl != Blocks.AIR) {
                      break;
                    }
                  }
                  else if (cAir)
                  {
                    setFlg = true;
                    break;
                  }
                }
              }
              if (setFlg) {
                setBlockAndNotifyAdequately(worldIn, new BlockPos(xx1, yy1, zz1), insideBlockState);
              }
            }
          }
        }
    }
    
    private void addSapLog(World worldIn, BlockPos pos) {
        this.setBlockAndNotifyAdequately(worldIn, pos, BlockLoader.MAPLE_LOG_SAP.getDefaultState());
    }
}