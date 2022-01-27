package cn.mcmod.sakura.data;

import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraItemModelProvider extends AbstractItemModelProvider {

    public SakuraItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        BlockItemRegistry.ITEMS.getEntries().forEach((item) -> {
            if (item.get() instanceof BlockItem)
                itemBlock(((BlockItem) item.get())::getBlock);
            else
                normalItem(item);
        });
//        FoodRegistry.ITEMS.getEntries().forEach((item)->{
//            normalItem(item);
//        });
//        ItemRegistry.ITEMS.getEntries().forEach((item)->{
//            normalItem(item);
//        });
    }

}
