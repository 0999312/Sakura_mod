package cn.mcmod.sakura.gui;

import cn.mcmod.sakura.inventory.ContainerStoneMortar;
import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiStoneMortar extends GuiContainer {
    private static final ResourceLocation mortarGuiTextures = new ResourceLocation("sakura:textures/gui/stonemortar.png");

    private TileEntityStoneMortar tileMortar;
    private final IInventory playerInventory;

    public GuiStoneMortar(InventoryPlayer inventory, TileEntityStoneMortar tile) {
        super(new ContainerStoneMortar(inventory, tile));
        this.tileMortar = tile;
        this.playerInventory = inventory;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String s = this.tileMortar.hasCustomName() ? this.tileMortar.getName() : I18n.format(this.tileMortar.getName());
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTickTime, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(mortarGuiTextures);

        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int l2 = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, l2 + 1, 16);
    }

    private int getCookProgressScaled(int pixels) {
        int i = this.tileMortar.getField(0);
        int j = this.tileMortar.getField(1);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

}