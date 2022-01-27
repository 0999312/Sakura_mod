package cn.mcmod.sakura.block;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SakuraLeavesBlock extends LeavesBlock {
    private final Supplier<SimpleParticleType> leaf_particle;
    public SakuraLeavesBlock(Properties builder, Supplier<SimpleParticleType> particle) {
        super(builder);
        this.leaf_particle = particle;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        if (rand.nextInt(40) == 0) {
            int j = rand.nextInt(2) * 2 - 1;
            int k = rand.nextInt(2) * 2 - 1;

            double d0 = pos.getX() + 0.5D + 0.25D * j;
            double d1 = pos.getY() - 0.15D;
            double d2 = pos.getZ() + 0.5D + 0.25D * k;
            double d3 = rand.nextFloat() * j * 0.1D;
            double d4 = (rand.nextFloat() * 0.055D) + 0.015D;
            double d5 = rand.nextFloat() * k * 0.1D;
            worldIn.addParticle(this.leaf_particle.get(), d0, d1, d2, d3, -d4, d5);
        }
    }
}
