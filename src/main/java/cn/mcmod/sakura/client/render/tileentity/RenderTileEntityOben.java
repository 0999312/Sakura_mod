package cn.mcmod.sakura.client.render.tileentity;

import cn.mcmod.sakura.tileentity.TileEntityOben;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;

public class RenderTileEntityOben extends TileEntitySpecialRenderer<TileEntityOben> {

    @Override
    public void render(TileEntityOben te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
    	if(!te.getInventory().getStackInSlot(0).isEmpty()){
    		ItemStack stack = te.getInventory().getStackInSlot(0);
    	    GlStateManager.pushMatrix();
    	    GlStateManager.translate(x + 0.5D, y + 0.125D, z + 0.5D);
    	    GlStateManager.scale(0.5F, 0.5F, 0.5F);
    	    GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
    	    Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.FIXED);
    	    GlStateManager.popMatrix();
    	}
    }

}