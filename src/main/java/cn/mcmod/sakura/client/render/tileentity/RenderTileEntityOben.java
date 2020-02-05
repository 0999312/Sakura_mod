package cn.mcmod.sakura.client.render.tileentity;

import cn.mcmod.sakura.tileentity.TileEntityOben;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;

public class RenderTileEntityOben extends TileEntitySpecialRenderer<TileEntityOben> {

    @Override
    public void render(TileEntityOben te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
    	if(!te.getInventory().getStackInSlot(0).isEmpty()){
    	GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y-0.25F, (float) z + 0.5F);
        renderItem(te, x, y, z, partialTicks);
        GlStateManager.popMatrix();
    	}
    }
    
    public RenderTileEntityOben() {
	}

    /**
     * Render the item.
     */
    protected void renderItem(TileEntityOben te, double posX, double posY, double posZ, float partialTicks) {
        	EntityItem renderItemEntity = null;
            renderItemEntity = new EntityItem(te.getWorld());
            renderItemEntity.setItem(te.getInventory().getStackInSlot(0).copy());
            renderItemEntity.hoverStart = 0;
            GlStateManager.scale(1.0F, 1.0F, 1.0F);
            GlStateManager.translate(0.0F, 0.8F, 0.0F);
            Minecraft.getMinecraft().getRenderManager().renderEntity(renderItemEntity, 0.0D, 0.0D, 0.0D, 0F, partialTicks, false);

    }
}