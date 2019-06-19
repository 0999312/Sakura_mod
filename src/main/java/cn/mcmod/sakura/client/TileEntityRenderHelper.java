package cn.mcmod.sakura.client;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityRenderHelper extends TileEntityItemStackRenderer {

    private TileEntityStoneMortar mortarRender = new TileEntityStoneMortar();

    @Override
    public void renderByItem(ItemStack itemStack) {

        Block block = Block.getBlockFromItem(itemStack.getItem());
        Item item = itemStack.getItem();
        if (block == BlockLoader.STONEMORTAR) {
            TileEntityRendererDispatcher.instance.render(this.mortarRender, 0.0D, 0.0D, 0.0D, 0.0F);
        } else {
            super.renderByItem(itemStack);
        }

    }

}