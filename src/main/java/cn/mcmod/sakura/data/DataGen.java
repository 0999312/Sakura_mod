package cn.mcmod.sakura.data;

import cn.mcmod.sakura.SakuraMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void dataGen(GatherDataEvent event) {
        event.getGenerator().addProvider(new SakuraBlockStateProvider(event.getGenerator(), SakuraMod.MODID, event.getExistingFileHelper()));
        event.getGenerator().addProvider(new SakuraItemModelProvider(event.getGenerator(), SakuraMod.MODID, event.getExistingFileHelper()));
        SakuraBlockTagsProvider block_tag = new SakuraBlockTagsProvider(event.getGenerator(), SakuraMod.MODID, event.getExistingFileHelper());
        event.getGenerator().addProvider(block_tag);
        event.getGenerator().addProvider(new SakuraItemTagsProvider(event.getGenerator(), block_tag, SakuraMod.MODID, event.getExistingFileHelper()));
        
    }
}
