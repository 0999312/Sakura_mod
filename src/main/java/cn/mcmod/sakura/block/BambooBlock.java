package cn.mcmod.sakura.block;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

@SuppressWarnings("deprecation")
public class BambooBlock extends RotatedPillarBlock {

    public BambooBlock() {
        super(Properties.of(Material.BAMBOO,state -> (state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.SAND : MaterialColor.PLANT)).strength(2.0F).sound(SoundType.BAMBOO));
    }
    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        super.randomTick(state, worldIn, pos, rand);
        if(worldIn.isDay()) {
            if(worldIn.canSeeSky(pos)||worldIn.getBlockState(pos.above()).is(this)||worldIn.getBlockState(pos.above()).is(BlockRegistry.BAMBOO_BLOCK_SUNBURNT.get())) {
                worldIn.setBlockAndUpdate(pos, BlockRegistry.BAMBOO_BLOCK_SUNBURNT.get().withPropertiesOf(state));
            }
        }
    }
}
