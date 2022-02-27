package cn.mcmod.sakura.events;

import java.util.function.Supplier;

import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class BurnTimeEvent {
    @SubscribeEvent
    public static void registerBurnTime(FurnaceFuelBurnTimeEvent event) {
        register(event, ItemRegistry.MATERIALS.get(""), 4000);
        register(event, BlockItemRegistry.BAMBOO_BLOCK, 4000);
    }
    
    private static void register(FurnaceFuelBurnTimeEvent event, Supplier<? extends Item> item, int burnTime) {
        register(event, item.get(), burnTime);
    }
    
    private static void register(FurnaceFuelBurnTimeEvent event, Item item, int burnTime) {
        register(event, new ItemStack(item), burnTime);
    }
    
    private static void register(FurnaceFuelBurnTimeEvent event, ItemStack item, int burnTime) {
        if(item.equals(event.getItemStack(), false)) 
            event.setBurnTime(burnTime);
    }
}
