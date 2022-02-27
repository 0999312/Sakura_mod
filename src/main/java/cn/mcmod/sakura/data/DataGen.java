package cn.mcmod.sakura.data;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void dataGen(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        dataGenerator.addProvider(new SakuraBlockStateProvider(dataGenerator, SakuraMod.MODID, existingFileHelper));
        dataGenerator.addProvider(new SakuraItemModelProvider(dataGenerator, SakuraMod.MODID, existingFileHelper));
        SakuraBlockTagsProvider block_tag = new SakuraBlockTagsProvider(dataGenerator, SakuraMod.MODID,existingFileHelper);
        dataGenerator.addProvider(block_tag);
        dataGenerator.addProvider(new SakuraItemTagsProvider(dataGenerator, block_tag, SakuraMod.MODID, existingFileHelper));
        dataGenerator.addProvider(new SakuraRecipeProvider(dataGenerator));
        dataGenerator.addProvider(new SakuraLootTableProvider(dataGenerator));
    }
}
