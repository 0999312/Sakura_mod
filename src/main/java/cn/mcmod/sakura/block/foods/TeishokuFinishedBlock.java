package cn.mcmod.sakura.block.foods;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

public class TeishokuFinishedBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public TeishokuFinishedBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
            BlockHitResult hit) {
        if (worldIn.isClientSide) {
            if (this.takePlates(worldIn, pos, state, player, handIn).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
        }
        return this.takePlates(worldIn, pos, state, player, handIn);
    }

    private InteractionResult takePlates(Level worldIn, BlockPos pos, BlockState state, Player player,
            InteractionHand handIn) {
        worldIn.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
        worldIn.destroyBlock(pos, true);
        return InteractionResult.SUCCESS;
    }

}
