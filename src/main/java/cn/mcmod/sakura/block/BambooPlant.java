package cn.mcmod.sakura.block;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;

@SuppressWarnings("deprecation")
public class BambooPlant extends Block implements BonemealableBlock {
    private static final VoxelShape SHAPE = Block.box(6D, 0.0D, 6D, 10D, 16.0D, 10D);
    public static final EnumProperty<BambooLeaves> LEAVES = BlockStateProperties.BAMBOO_LEAVES;
    public static final int MAX_HEIGHT = 16;
    public static final int STAGE_GROWING = 0;
    public static final int STAGE_DONE_GROWING = 1;
    public static final int AGE_THIN_BAMBOO = 0;
    public static final int AGE_THICK_BAMBOO = 1;

    public BambooPlant() {
        super(Properties.copy(Blocks.BAMBOO));
        this.registerDefaultState(this.stateDefinition.any().setValue(LEAVES, BambooLeaves.NONE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48928_) {
        p_48928_.add(LEAVES);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState p_48941_, BlockGetter p_48942_, BlockPos p_48943_) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState p_48945_, BlockGetter p_48946_, BlockPos p_48947_,
            CollisionContext p_48948_) {
        return SHAPE;
    }

    @Override
    public boolean isPathfindable(BlockState p_48906_, BlockGetter p_48907_, BlockPos p_48908_,
            PathComputationType p_48909_) {
        return false;
    }

    @Override
    public boolean isCollisionShapeFullBlock(BlockState p_181159_, BlockGetter p_181160_, BlockPos p_181161_) {
        return false;
    }

    @Override
    public void tick(BlockState p_48896_, ServerLevel p_48897_, BlockPos p_48898_, Random p_48899_) {
        if (!p_48896_.canSurvive(p_48897_, p_48898_)) {
            p_48897_.destroyBlock(p_48898_, true);
        }

    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel levelIn, BlockPos pos, Random random) {
        if (levelIn.getRawBrightness(pos.above(), 0) >= 6) {
            int i = this.getHeightBelowUpToMax(levelIn, pos) + 1;
            if (i < 16 && levelIn.isEmptyBlock(pos.above())
                    && ForgeHooks.onCropsGrowPre(levelIn, pos, state, random.nextInt(3) == 0)) {
                this.growBamboo(state, levelIn, pos, random, i);
                ForgeHooks.onCropsGrowPost(levelIn, pos, state);
            } else {
                if (levelIn.isRaining() || random.nextFloat() < 0.15) {
                    growBambooShoot(levelIn, pos, random);
                }
            }
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockState ground = worldIn.getBlockState(pos.below());
        return (ground.is(BlockTags.BAMBOO_PLANTABLE_ON) || ground.is(this)) && !(ground.is(Blocks.BAMBOO))
                && !(ground.is(Blocks.BAMBOO_SAPLING));
    }

    @Override
    public BlockState updateShape(BlockState p_48921_, Direction p_48922_, BlockState p_48923_, LevelAccessor p_48924_,
            BlockPos p_48925_, BlockPos p_48926_) {
        if (!p_48921_.canSurvive(p_48924_, p_48925_)) {
            p_48924_.scheduleTick(p_48925_, this, 1);
        }
        return super.updateShape(p_48921_, p_48922_, p_48923_, p_48924_, p_48925_, p_48926_);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter p_48886_, BlockPos p_48887_, BlockState p_48888_,
            boolean p_48889_) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level p_48891_, Random p_48892_, BlockPos p_48893_, BlockState p_48894_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel p_48876_, Random p_48877_, BlockPos p_48878_, BlockState p_48879_) {
        int i = this.getHeightAboveUpToMax(p_48876_, p_48878_);
        int j = this.getHeightBelowUpToMax(p_48876_, p_48878_);
        int k = i + j + 1;
        int l = 1 + p_48877_.nextInt(2);

        for (int i1 = 0; i1 < l; ++i1) {
            BlockPos blockpos = p_48878_.above(i);
            BlockState blockstate = p_48876_.getBlockState(blockpos);
            if (k >= 16 || !p_48876_.isEmptyBlock(blockpos.above())) {
                this.growBambooShoot(p_48876_, p_48878_, p_48877_);
                return;
            }

            this.growBamboo(blockstate, p_48876_, blockpos, p_48877_, k);

            ++i;
            ++k;
        }

    }

    @Override
    public float getDestroyProgress(BlockState p_48901_, Player p_48902_, BlockGetter p_48903_, BlockPos p_48904_) {
        return p_48902_.getMainHandItem().canPerformAction(net.minecraftforge.common.ToolActions.AXE_DIG) ? 1.0F
                : super.getDestroyProgress(p_48901_, p_48902_, p_48903_, p_48904_);
    }

    public void growBamboo(BlockState p_48911_, Level p_48912_, BlockPos p_48913_, Random p_48914_, int p_48915_) {
        BlockState blockstate = p_48912_.getBlockState(p_48913_.below());
        BlockPos blockpos = p_48913_.below(2);
        BlockState blockstate1 = p_48912_.getBlockState(blockpos);
        BambooLeaves bambooleaves = BambooLeaves.NONE;
        if (p_48915_ >= 1) {
            if (blockstate.is(this) && blockstate.getValue(LEAVES) != BambooLeaves.NONE) {
                if (blockstate.is(this) && blockstate.getValue(LEAVES) != BambooLeaves.NONE) {
                    bambooleaves = BambooLeaves.LARGE;
                    if (blockstate1.is(this)) {
                        p_48912_.setBlock(p_48913_.below(), blockstate.setValue(LEAVES, BambooLeaves.SMALL), 3);
                        p_48912_.setBlock(blockpos, blockstate1.setValue(LEAVES, BambooLeaves.NONE), 3);
                    }
                }
            } else {
                bambooleaves = BambooLeaves.SMALL;
            }
        }

        p_48912_.setBlock(p_48913_.above(), this.defaultBlockState().setValue(LEAVES, bambooleaves), 3);
    }

    public void growBambooShoot(ServerLevel levelIn, BlockPos pos, Random random) {
        BlockPos blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2),
                random.nextInt(3) - 1);
        if (BlockRegistry.BAMBOOSHOOT.get().defaultBlockState().canSurvive(levelIn, blockpos1)
                && levelIn.isEmptyBlock(blockpos1.above()) && levelIn.isEmptyBlock(blockpos1)) {
            levelIn.setBlockAndUpdate(blockpos1, BlockRegistry.BAMBOOSHOOT.get().defaultBlockState());
        }
    }

    protected int getHeightAboveUpToMax(BlockGetter p_48883_, BlockPos p_48884_) {
        int i;
        for (i = 0; i < 16 && p_48883_.getBlockState(p_48884_.above(i + 1)).is(this); ++i) {
        }

        return i;
    }

    protected int getHeightBelowUpToMax(BlockGetter p_48933_, BlockPos p_48934_) {
        int i;
        for (i = 0; i < 16 && p_48933_.getBlockState(p_48934_.below(i + 1)).is(this); ++i) {
        }

        return i;
    }

}
