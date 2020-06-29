package cn.mcmod.sakura.gui;

import cn.mcmod.sakura.inventory.ContainerMapleCauldron;
import cn.mcmod.sakura.tileentity.TileEntityMapleCauldron;
import cn.mcmod_mmf.mmlib.util.ClientUtils;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiMapleCauldron extends GuiContainer {

    private static final ResourceLocation GuiTextures = new ResourceLocation("sakura:textures/gui/maple_pot.png");

    private TileEntityMapleCauldron tilePot;

    public GuiMapleCauldron(InventoryPlayer inventory, TileEntityMapleCauldron tile) {
        super(new ContainerMapleCauldron(inventory, tile));
        this.tilePot = tile;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTickTime, int x, int y) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(GuiTextures);

        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
        if(this.tilePot.isBurning()){
        	this.drawTexturedModalRect(k + 71, l + 59, 176, 17, 14, 14);
        }
        
        int l2 = this.getProgressScaled(44);
        this.drawTexturedModalRect(k + 59, l + 36, 176, 0, l2 + 1, 17);
        
        if (this.tilePot.getTank().getFluid() != null) {
            FluidTank fluidTank = this.tilePot.getTank();
            int heightInd = (int) (68 * ((float) fluidTank.getFluidAmount() / (float) fluidTank.getCapacity()));
            if (heightInd > 0) {
                ClientUtils.drawRepeatedFluidSprite(fluidTank.getFluid(), k + 35, l + 78 - heightInd , 16f, heightInd);
            }
        }
    }

    private int getProgressScaled(int pixels) {
        int i = this.tilePot.getField(1);
        return i != 0 ? i * pixels / 1200 : 0;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

}
