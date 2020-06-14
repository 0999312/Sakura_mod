package cn.mcmod.sakura.client.render.tileentity;

import cn.mcmod.sakura.block.BlockOben;
import cn.mcmod.sakura.tileentity.TileEntityOben;
import cn.mcmod_mmf.mmlib.block.BlockFacing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RenderTileEntityOben extends TileEntitySpecialRenderer<TileEntityOben> {

    @Override
    public void render(TileEntityOben te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
    	
    	if(!te.getInventory().getStackInSlot(0).isEmpty()){
    		ItemStack stack = te.getInventory().getStackInSlot(0);
    	    GlStateManager.pushMatrix();
    	    GlStateManager.translate(x + 0.5D, y + 0.4D, z + 0.5D);
    	    GlStateManager.scale(0.75F, 0.75F, 0.75F);
    	    GlStateManager.rotate(getFacingRotate(te), 0.0F, 1.0F, 0.0F);
    	    Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.FIXED);
    	    GlStateManager.popMatrix();
    	}
    }
    private float getFacingRotate(TileEntityOben te){
    	World world = te.getWorld();
    	if(world.getBlockState(te.getPos()).getBlock() instanceof BlockOben){
    		switch (world.getBlockState(te.getPos()).getValue(BlockFacing.FACING).getHorizontalIndex()) {
			case 0://S
				return 180F;
			case 1://W
				return 270F;
			case 2://N
				return 0F;
			case 3://E
				return 90F;
			default:
				break;
			}
    	}
    	return 0F;
    }
}
