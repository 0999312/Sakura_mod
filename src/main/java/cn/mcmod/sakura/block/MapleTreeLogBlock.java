package cn.mcmod.sakura.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

@SuppressWarnings("deprecation")
public class MapleTreeLogBlock extends RotatedPillarBlock {

    public MapleTreeLogBlock() {
        super(Properties.of(Material.WOOD, state -> (state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.PODZOL)) .strength(2.0F).sound(SoundType.WOOD));
    }
    
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitresult) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.canPerformAction(net.minecraftforge.common.ToolActions.SHEARS_CARVE)) {
           if (!level.isClientSide) {
              level.playSound((Player)null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
              level.setBlock(pos, BlockRegistry.MAPLE_SAP_LOG.get().withPropertiesOf(state).setValue(MapleTreeSapLogBlock.EXHAUSTION, false), 11);
              itemstack.hurtAndBreak(1, player, (tool) -> {
                 tool.broadcastBreakEvent(hand);
              });
              level.gameEvent(player, GameEvent.SHEAR, pos);
              player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
           }
           return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
           return super.use(state, level, pos, player, hand, hitresult);
        }
     }

    @Override
    public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack,
            ToolAction toolAction) {
        if (stack.canPerformAction(ToolActions.SHEARS_CARVE)) {
            return BlockRegistry.MAPLE_SAP_LOG.get().withPropertiesOf(state).setValue(MapleTreeSapLogBlock.EXHAUSTION, false);
        }
        return super.getToolModifiedState(state, world, pos, player, stack, toolAction);
    }
}
