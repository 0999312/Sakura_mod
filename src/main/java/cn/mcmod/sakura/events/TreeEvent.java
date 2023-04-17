package cn.mcmod.sakura.events;

import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.world.BlockEvent.BlockToolModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class TreeEvent {

    @SubscribeEvent
    public static void onAxeStrippingLog(BlockToolModificationEvent event) {
        if (ToolActions.AXE_STRIP.equals(event.getToolAction())) {
            stripLog(event, BlockRegistry.SAKURA_LOG.get(), BlockRegistry.STRIPPED_SAKURA_LOG.get());
            stripLog(event, BlockRegistry.MAPLE_LOG.get(), BlockRegistry.STRIPPED_MAPLE_LOG.get());
            stripLog(event, BlockRegistry.MAPLE_SAP_LOG.get(), BlockRegistry.STRIPPED_MAPLE_LOG.get());

            stripLog(event, BlockRegistry.SAKURA_WOOD.get(), BlockRegistry.STRIPPED_SAKURA_WOOD.get());
            stripLog(event, BlockRegistry.MAPLE_WOOD.get(), BlockRegistry.STRIPPED_MAPLE_WOOD.get());
        }
    }

    private static void stripLog(BlockToolModificationEvent event, Block log, Block stripped_log) {
        BlockState origin = event.getState();
        if (origin.is(log)) {
            event.getWorld().playSound(event.getPlayer(), event.getPos(), SoundEvents.AXE_STRIP, SoundSource.BLOCKS,
                    1.0F, 1.0F);
            event.setFinalState(stripped_log.withPropertiesOf(origin));
        }
    }
}
