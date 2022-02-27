package cn.mcmod.sakura.item;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.vertex.PoseStack;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.entity.BlockEntityRegistry;
import cn.mcmod.sakura.block.entity.StoneMortarBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;

public class StoneMortarItem extends BlockItem {

    public StoneMortarItem() {
        super(BlockRegistry.STONE_MORTAR.get(), SakuraMod.defaultItemProperties());
    }

    @Override
    public void initializeClient(@Nonnull Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            BlockEntityWithoutLevelRenderer myRenderer;

            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                if (Minecraft.getInstance().getEntityRenderDispatcher() != null && myRenderer == null) {
                    myRenderer = new BlockEntityWithoutLevelRenderer(
                            Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                            Minecraft.getInstance().getEntityModels()) {
                        private StoneMortarBlockEntity blockEntity;

                        @Override
                        public void renderByItem(@Nonnull ItemStack stack,
                                @Nonnull ItemTransforms.TransformType transformType, @Nonnull PoseStack matrix,
                                @Nonnull MultiBufferSource buffer, int x, int y) {
                            if (blockEntity == null) {
                                blockEntity = BlockEntityRegistry.STONE_MORTAR.get().create(BlockPos.ZERO,
                                        BlockRegistry.STONE_MORTAR.get().defaultBlockState());
                            }
                            Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(blockEntity, matrix,
                                    buffer, x, y);
                        }
                    };
                }

                return myRenderer;
            }
        });
    }

}
