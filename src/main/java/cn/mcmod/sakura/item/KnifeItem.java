package cn.mcmod.sakura.item;

import cn.mcmod.sakura.tags.SakuraBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class KnifeItem extends DiggerItem {

    public KnifeItem(Tier tier, float attackDamageIn, float attackSpeedIn, Properties properties) {
        super(attackDamageIn, attackSpeedIn, tier, SakuraBlockTags.MINEABLE_WITH_KNIFE, properties);
    }
    
    @Override
    public boolean canAttackBlock(BlockState state, Level worldIn, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (user) -> user.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

}
