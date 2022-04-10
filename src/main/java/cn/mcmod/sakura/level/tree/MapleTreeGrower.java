package cn.mcmod.sakura.level.tree;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class MapleTreeGrower extends AbstractTreeGrower {
    private final Supplier<ConfiguredFeature<?, ?>>  tree;
    private final Supplier<ConfiguredFeature<?, ?>> fancy_tree;

    public MapleTreeGrower(Supplier<ConfiguredFeature<?, ?>> tree, Supplier<ConfiguredFeature<?, ?>> fancy_tree) {
        this.tree = tree;
        this.fancy_tree = fancy_tree;
    }

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean hasBees) {
        if (random.nextInt(10) == 0) {
            return Holder.direct(this.fancy_tree.get());
        } else {
            return Holder.direct(this.tree.get());
        }
    }
    @Override
    public boolean growTree(ServerLevel p_60006_, ChunkGenerator p_60007_, BlockPos p_60008_, BlockState p_60009_,
            Random p_60010_) {
        // TODO Auto-generated method stub
        return super.growTree(p_60006_, p_60007_, p_60008_, p_60009_, p_60010_);
    }
}
