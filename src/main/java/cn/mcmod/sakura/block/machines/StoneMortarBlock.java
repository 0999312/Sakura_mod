package cn.mcmod.sakura.block.machines;

import cn.mcmod.sakura.block.entity.StoneMortarBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StoneMortarBlock extends Block implements EntityBlock {

    public StoneMortarBlock() {
        super(Properties.copy(Blocks.STONE));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StoneMortarBlockEntity(pos, state);
    }

}
