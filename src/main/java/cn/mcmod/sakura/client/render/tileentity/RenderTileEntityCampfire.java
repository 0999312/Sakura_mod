package cn.mcmod.sakura.client.render.tileentity;

import cn.mcmod.sakura.tileentity.TileEntityCampfire;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public class RenderTileEntityCampfire extends TileEntitySpecialRenderer<TileEntityCampfire> {

    @Override
    public void render(TileEntityCampfire te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y, (float) z + 0.5F);
        renderItem(te, x, y, z, partialTicks);
        GlStateManager.popMatrix();
    }

    protected ItemStack renderItemStack = ItemStack.EMPTY;
    protected EntityItem renderItemEntity = null;

    /**
     * Render the item.
     */
    protected void renderItem(TileEntityCampfire te, double posX, double posY, double posZ, float partialTicks) {

        if (te != null) {
            ItemStack itemstack = new ItemStack(te.getInventory().getStackInSlot(0).getItem(), te.getInventory().getStackInSlot(0).getCount(), te.getInventory().getStackInSlot(0).getMetadata());

            if (itemstack == ItemStack.EMPTY) {
                return;
            }
            if (itemstack != renderItemStack) {
                renderItemStack = itemstack;
                renderItemEntity = new EntityItem(te.getWorld());
                renderItemEntity.setItem(itemstack.copy());
                renderItemEntity.hoverStart = 0;
            }

            float scale = 1.0F;

            GlStateManager.scale(scale, scale, scale);


            GlStateManager.translate(0.0F, 0.4F, 0.0F);

            float rot = te.getWorld().getTotalWorldTime() % 360;
            rot = rot * 2;

            GlStateManager.rotate(rot, 0.0F, 1.0F, 0.0F);

            partialTicks = 0;

            Minecraft.getMinecraft().getRenderManager().renderEntity(renderItemEntity, 0.0D, 0.0D, 0.0D, 0.0F, partialTicks, false);
        }
    }
}