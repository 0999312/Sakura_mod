package cn.mcmod.sakura.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.container.FermenterContainer;
import cn.mcmod_mmf.mmlib.client.RenderUtils;
import cn.mcmod_mmf.mmlib.utils.ClientUtil;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class FermenterScreen extends AbstractContainerScreen<FermenterContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(SakuraMod.MODID,
            "textures/gui/barrel.png");

    public FermenterScreen(FermenterContainer screenContainer, Inventory inv, Component titleIn) {
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
        this.renderTooltip(ms, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(PoseStack ms, int mouseX, int mouseY) {
        super.renderLabels(ms, mouseX, mouseY);
        this.font.draw(ms, this.playerInventoryTitle, 8.0f, this.imageHeight - 96 + 2, 4210752);
    }

    @Override
    protected void renderBg(PoseStack ms, float partialTicks, int mouseX, int mouseY) {
        // Render UI background
        if (this.minecraft == null) {
            return;
        }
        RenderUtils.setup(BACKGROUND_TEXTURE);
        this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        // Render progress arrow
        int l = this.menu.getCookProgressionScaled();
        this.blit(ms, this.leftPos + 75, this.topPos + 45, 176, 0, l + 1, 17);

        int m = this.menu.getWorking();
        this.blit(ms, this.leftPos + 78, this.topPos + 44 - m, 176, 53 - m, 18, m);
        
        this.menu.tileEntity.getInputFluidTank().ifPresent(fluidTank -> {
            int heightInd = (int) (64.0F * ((float)fluidTank.getFluidAmount() / (float)fluidTank.getCapacity()));
            if (heightInd > 0) {
                ClientUtil.renderFluidStack(this.leftPos + 33, this.topPos + 75 - heightInd, 16, heightInd, 0.0F,
                        fluidTank.getFluid());
            }
        });
        this.menu.tileEntity.getOutputFluidTank().ifPresent(fluidTank -> {
            int heightInd = (int) (64.0F * ((float)fluidTank.getFluidAmount() / (float)fluidTank.getCapacity()));
            if (heightInd > 0) {
                ClientUtil.renderFluidStack(this.leftPos + 125, this.topPos + 75 - heightInd, 16, heightInd, 0.0F,
                        fluidTank.getFluid());
            }
        });
    }
}
