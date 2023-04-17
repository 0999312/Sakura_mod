package cn.mcmod.sakura.data.client;

import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.block.machines.StoneMortarBlock;
import cn.mcmod.sakura.fluid.BucketItemRegistry;
import cn.mcmod_mmf.mmlib.data.AbstractItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.BushBlock;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraItemModelProvider extends AbstractItemModelProvider {

    public SakuraItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        BlockItemRegistry.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof BlockItem) {
                BlockItem blockItem = (BlockItem) item.get();
                if (blockItem.getBlock() instanceof StoneMortarBlock)
                    return;
                if (blockItem.getBlock() instanceof BushBlock)
                    bushItem(item);
                else
                    itemBlock(blockItem::getBlock);
            } else {
                normalItem(item);
            }
        });
        
        BucketItemRegistry.ITEMS.getEntries().forEach((item)->{
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
