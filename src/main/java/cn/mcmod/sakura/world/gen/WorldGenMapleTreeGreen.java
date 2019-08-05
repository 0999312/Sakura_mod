package cn.mcmod.sakura.world.gen;

import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class WorldGenMapleTreeGreen extends WorldGenAbstractTree {
    private static final IBlockState DEFAULT_TRUNK = BlockLoader.MAPLE_LOG.getDefaultState();
    private static final IBlockState DEFAULT_LEAF = BlockLoader.MAPLE_LEAVE_GREEN.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    /**
     * The minimum height of a generated tree.
     */
    private final int minTreeHeight;
    /**
     * True if this tree should grow Vines.
     */
    private final boolean generateSap;
    /**
     * The metadata value of the wood to use in tree generation.
     */
    private final IBlockState metaWood;
    /**
     * The metadata value of the leaves to use in tree generation.
     */
    private final IBlockState metaLeaves;

    public WorldGenMapleTreeGreen(boolean p_i2027_1_, boolean sap) {
        this(p_i2027_1_, 4, DEFAULT_TRUNK, DEFAULT_LEAF, sap);
    }

    public WorldGenMapleTreeGreen(boolean notify, int minTreeHeightIn, IBlockState woodMeta, IBlockState p_i46446_4_, boolean sap) {
        super(notify);
        this.minTreeHeight = minTreeHeightIn;
        this.metaWood = woodMeta;
        this.metaLeaves = p_i46446_4_;
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
            } else {
                IBlockState state = worldIn.getBlockState(position.down());

                if (state.getBlock().canSustainPlant(state, worldIn, position.down(), net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling) Blocks.SAPLING) && position.getY() < worldIn.getHeight() - i - 1) {
                    state.getBlock().onPlantGrow(state, worldIn, position.down(), position);
                    int k2 = 3;
                    int l2 = 0;

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
                                      BlockPos fruitBlockPos = new BlockPos(k1, i3 - 1, i2);
                                      BlockPos blockBelowFruitPos = new BlockPos(k1, i3 - 2, i2);
                                      if (worldIn.isAirBlock(fruitBlockPos)) 
                                          if (worldIn.isAirBlock(blockBelowFruitPos) && i3 > 2) 
                                              if (rand.nextInt(4) == 0) 
                                                  this.setBlockAndNotifyAdequately(worldIn,fruitBlockPos, BlockLoader.CHESTNUTBURR.getDefaultState());
                                    }
                                }
                            }
                        }
                    }

                    for (int j3 = 0; j3 < i; ++j3) {
                        BlockPos upN = position.up(j3);
                        state = worldIn.getBlockState(upN);

                        if (state.getBlock().isAir(state, worldIn, upN) || this.isBurr(state, worldIn, upN) || state.getBlock().isLeaves(state, worldIn, upN) || state.getMaterial() == Material.VINE) {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(j3), this.metaWood);

                            if (this.generateSap && j3 == 1) {
                                if (worldIn.getBlockState(position.add(0, j3, 0))==this.metaWood) {
                                    this.addSapLog(worldIn, position.add(0, j3, 0));
                                }

                            }
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public boolean isBurr(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.getBlock() == BlockLoader.CHESTNUTBURR;
    }

    private void addSapLog(World worldIn, BlockPos pos) {
        this.setBlockAndNotifyAdequately(worldIn, pos, BlockLoader.MAPLE_LOG_SAP.getDefaultState());
    }
}