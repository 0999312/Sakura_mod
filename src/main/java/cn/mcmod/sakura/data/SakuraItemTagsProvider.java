package cn.mcmod.sakura.data;

import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.tags.SakuraItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SakuraItemTagsProvider extends ItemTagsProvider {

    public SakuraItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTags, String modId,
            ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(SakuraItemTags.SEEDS_RICE).add(ItemRegistry.RICE_SEEDS.get());
    }

    @Override
    public String getName() {
        return "Sakura Items' Tags";
    }
}
