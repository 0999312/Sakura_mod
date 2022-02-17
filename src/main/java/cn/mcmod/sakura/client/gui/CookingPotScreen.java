package cn.mcmod.sakura.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.container.CookingPotContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidTank;

public class CookingPotScreen extends AbstractContainerScreen<CookingPotContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(SakuraMod.MODID, "textures/gui/pot.png");
    
    public CookingPotScreen(CookingPotContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }
    
    @Override
    public void render(PoseStack ms, final int mouseX, final int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
    }

    @Override
    protected void renderLabels(PoseStack ms, int mouseX, int mouseY) {
        super.renderLabels(ms, mouseX, mouseY);
        this.font.draw(ms, this.playerInventoryTitle, 8.0f, (float) (this.imageHeight - 96 + 2), 4210752);
    }

    @Override
    protected void renderBg(PoseStack ms, float partialTicks, int mouseX, int mouseY) {
        // Render UI background
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.minecraft == null)
            return;

        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        
        this.menu.tileEntity.getFluidTank().ifPresent(fluidTank->{
            if(!fluidTank.isEmpty()) {
                int heightInd = (int) (52.0F * fluidTank.getFluidAmount() / fluidTank.getCapacity());
                if (heightInd > 0)
                    renderFluidStack(this.leftPos + 17, this.topPos + 68 - heightInd, 16, heightInd, 0.0F, fluidTank.getFluid());
                }
        });
        if(this.menu.isHeated())
            this.blit(ms, this.leftPos + 101, this.topPos + 52, 176, 0, 18, 18);
        // Render progress arrow
        int l = this.menu.getCookProgressionScaled();
        this.blit(ms, this.leftPos + 98, this.topPos + 34, 176, 18, l+1, 17);
    }

    @SuppressWarnings("deprecation")
    public static void renderFluidStack(int x, int y, int width, int height, float depth, FluidStack fluidStack) {
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_BLOCKS);

        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(fluidStack.getFluid().getAttributes().getStillTexture());
        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuilder();
        float u1 = sprite.getU0();
        float v1 = sprite.getV0();
        do {
            int currentHeight = Math.min(sprite.getHeight(), height);
            height -= currentHeight;
            float v2 = sprite.getV((16 * currentHeight) / (float) sprite.getHeight());
            int x2 = x;
            int width2 = width;
            do {
                int currentWidth = Math.min(sprite.getWidth(), width2);
                width2 -= currentWidth;
                float u2 = sprite.getU((16 * currentWidth) / (float) sprite.getWidth());
                bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
                bufferbuilder.vertex(x2, y, depth).uv(u1, v1).color(255, 255, 255, 255).endVertex();
                bufferbuilder.vertex(x2, y + currentHeight, depth).uv(u1, v2).color(255, 255, 255, 255).endVertex();
                bufferbuilder.vertex(x2 + currentWidth, y + currentHeight, depth).uv(u2, v2).color(255, 255, 255, 255).endVertex();
                bufferbuilder.vertex(x2 + currentWidth, y, depth).uv(u2, v1).color(255, 255, 255, 255).endVertex();
                tessellator.end();
                x2 += currentWidth;
            } while (width2 > 0);

            y += currentHeight;
        } while (height > 0);
    }
}
