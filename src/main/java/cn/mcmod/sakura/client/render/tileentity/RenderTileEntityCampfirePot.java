package cn.mcmod.sakura.client.render.tileentity;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.client.model.tileentity.ModelPot;
import cn.mcmod.sakura.tileentity.TileEntityCampfirePot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTileEntityCampfirePot extends TileEntitySpecialRenderer<TileEntityCampfirePot> {

    private static final ResourceLocation TEXTURES = new ResourceLocation(SakuraMain.MODID, "textures/entity/tileentity/pot.png");


    private final ModelPot model = new ModelPot();

    protected ItemStack renderItemStack = ItemStack.EMPTY;
    protected EntityItem renderItemEntity = null;
    protected ItemStack renderItemStack2 = ItemStack.EMPTY;
    protected EntityItem renderItemEntity2 = null;
    protected ItemStack renderItemStack3 = ItemStack.EMPTY;
    protected EntityItem renderItemEntity3 = null;
    protected ItemStack renderItemStack4 = ItemStack.EMPTY;
    protected EntityItem renderItemEntity4 = null;
    protected ItemStack renderItemStack5 = ItemStack.EMPTY;
    protected EntityItem renderItemEntity5 = null;

    @Override
    public void render(TileEntityCampfirePot te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        super.render(te, x, y, z, partialTicks, destroyStage, alpha);
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
        GlStateManager.disableCull();

        if (destroyStage >= 0) {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        } else {
            this.bindTexture(TEXTURES);
        }

        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();

        if (destroyStage < 0) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
        }

        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
        GlStateManager.translate(0.0F, 1.0F, 0.0F);
        GlStateManager.scale(0.9995F, 0.9995F, 0.9995F);
        GlStateManager.translate(0.0F, -1.0F, 0.0F);

        this.model.ironBar3.render(0.0625F);
        this.model.ironBar2.render(0.0625F);
        this.model.base.render(0.0625F);
        this.model.ironBar.render(0.0625F);
        this.model.ironBar4.render(0.0625F);
        this.model.pot1.render(0.0625F);
        GlStateManager.enableCull();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        if (destroyStage >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }

        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y, (float) z + 0.5F);
        renderItem(te, x, y, z, partialTicks);
        GlStateManager.popMatrix();

        FluidStack fluid = te.getFluidForRendering(partialTicks);

        if (fluid != null) {

            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.pushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder buffer = tessellator.getBuffer();
            buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);
            TextureAtlasSprite still = Minecraft.getMinecraft().getTextureMapBlocks().getTextureExtry(fluid.getFluid().getStill(fluid).toString());
            if (still == null) {
                still = Minecraft.getMinecraft().getTextureMapBlocks().getMissingSprite();
            }

            int brightness = Minecraft.getMinecraft().world.getCombinedLight(te.getPos(), fluid.getFluid().getLuminosity(fluid));
            int lx = brightness >> 0x10 & 0xFFFF;
            int ly = brightness & 0xFFFF;

            int color = fluid.getFluid().getColor(fluid);
            int r = color >> 16 & 0xFF;
            int g = color >> 8 & 0xFF;
            int b = color & 0xFF;
            int a = color >> 24 & 0xFF;

            double height = 0.6 + 0.4 * ((double) fluid.amount / te.tank.getCapacity());

            GlStateManager.translate(x + 0.1, y, z + 0.1);
            GlStateManager.scale(0.8, 0.8, 0.8);

            buffer.pos(0.0625, height, 0.0625).color(r, g, b, a).tex(still.getMinU(), still.getMinV()).lightmap(lx, ly).endVertex();
            buffer.pos(0.0625, height, 0.9375).color(r, g, b, a).tex(still.getMinU(), still.getMaxV()).lightmap(lx, ly).endVertex();
            buffer.pos(0.9375, height, 0.9375).color(r, g, b, a).tex(still.getMaxU(), still.getMaxV()).lightmap(lx, ly).endVertex();
            buffer.pos(0.9375, height, 0.0625).color(r, g, b, a).tex(still.getMaxU(), still.getMinV()).lightmap(lx, ly).endVertex();

            tessellator.draw();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
            RenderHelper.enableStandardItemLighting();
        }
    }

    protected void renderItem(TileEntityCampfirePot te, double posX, double posY, double posZ, float partialTicks) {

        ItemStack itemstack = te.getStackInSlot(0);
        if (itemstack != ItemStack.EMPTY) {
            GlStateManager.pushMatrix();
            if (itemstack != renderItemStack) {
                renderItemStack = itemstack;
                renderItemEntity = new EntityItem(te.getWorld());
                renderItemEntity.setItem(itemstack.copy());

                //これを設定しないとEntityItemがあらぶる
                renderItemEntity.hoverStart = 0;
            }

            float scale = 1.0F;

            GlStateManager.scale(scale, scale, scale);
            GlStateManager.translate(-0.2F, 0.45F - 0.1F, 0.0F);
            float rot = te.getWorld().getTotalWorldTime() % 360;
            rot = rot * 2;
            GlStateManager.rotate(rot, 0.0F, 1.0F, 0.0F);

            partialTicks = 0;

            Minecraft.getMinecraft().getRenderManager().renderEntity(renderItemEntity, 0.0D, 0.0D, 0.0D, 0.0F, partialTicks, false);
            GlStateManager.popMatrix();
        }

        ItemStack itemstack2 = te.getStackInSlot(1);
        if (itemstack2 != ItemStack.EMPTY) {
            GlStateManager.pushMatrix();

            if (itemstack2 != renderItemStack2) {
                renderItemStack2 = itemstack2;
                renderItemEntity2 = new EntityItem(te.getWorld());
                renderItemEntity2.setItem(itemstack2.copy());

                //これを設定しないとEntityItemがあらぶる
                renderItemEntity2.hoverStart = 0;
            }

            float scale = 1.0F;

            GlStateManager.scale(scale, scale, scale);
            GlStateManager.translate(0.2F, 0.45F - 0.1F, 0.0F);
            float rot = te.getWorld().getTotalWorldTime() % 360;
            rot = rot * 2;
            GlStateManager.rotate(rot, 0.0F, 1.0F, 0.0F);

            partialTicks = 0;

            Minecraft.getMinecraft().getRenderManager().renderEntity(renderItemEntity2, 0.0D, 0.0D, 0.0D, 0.0F, partialTicks, false);

            GlStateManager.popMatrix();
        }

        ItemStack itemstack3 = te.getStackInSlot(2);
        if (itemstack3 != ItemStack.EMPTY) {
            GlStateManager.pushMatrix();

            if (itemstack3 != renderItemStack3) {
                renderItemStack3 = itemstack3;
                renderItemEntity3 = new EntityItem(te.getWorld());
                renderItemEntity3.setItem(itemstack3.copy());

                //これを設定しないとEntityItemがあらぶる
                renderItemEntity3.hoverStart = 0;
            }

            float scale = 1.0F;

            GlStateManager.scale(scale, scale, scale);
            GlStateManager.translate(0.0F, 0.45F - 0.1F, 0.2F);
            float rot = te.getWorld().getTotalWorldTime() % 360;
            rot = rot * 2;
            GlStateManager.rotate(rot, 0.0F, 1.0F, 0.0F);

            partialTicks = 0;

            Minecraft.getMinecraft().getRenderManager().renderEntity(renderItemEntity3, 0.0D, 0.0D, 0.0D, 0.0F, partialTicks, false);

            GlStateManager.popMatrix();
        }

        ItemStack itemstack4 = te.getStackInSlot(3);
        if (itemstack4 != ItemStack.EMPTY) {
            GlStateManager.pushMatrix();

            if (itemstack4 != renderItemStack4) {
                renderItemStack4 = itemstack4;
                renderItemEntity4 = new EntityItem(te.getWorld());
                renderItemEntity4.setItem(itemstack4.copy());

                //これを設定しないとEntityItemがあらぶる
                renderItemEntity4.hoverStart = 0;
            }

            float scale = 1.0F;

            GlStateManager.scale(scale, scale, scale);
            GlStateManager.translate(0.0F, 0.45F - 0.1F, -0.2F);
            float rot = te.getWorld().getTotalWorldTime() % 360;
            rot = rot * 2;
            GlStateManager.rotate(rot, 0.0F, 1.0F, 0.0F);

            partialTicks = 0;

            Minecraft.getMinecraft().getRenderManager().renderEntity(renderItemEntity4, 0.0D, 0.0D, 0.0D, 0.0F, partialTicks, false);

            GlStateManager.popMatrix();
        }

        ItemStack itemstack5 = te.getStackInSlot(4);
        if (itemstack5 != ItemStack.EMPTY) {
            GlStateManager.pushMatrix();

            if (itemstack5 != renderItemStack5) {
                renderItemStack5 = itemstack5;
                renderItemEntity5 = new EntityItem(te.getWorld());
                renderItemEntity5.setItem(itemstack5.copy());

                //これを設定しないとEntityItemがあらぶる
                renderItemEntity5.hoverStart = 0;
            }

            float scale = 1.0F;

            GlStateManager.scale(scale, scale, scale);
            GlStateManager.translate(0.0F, 0.45F - 0.1F, 0.0F);
            float rot = te.getWorld().getTotalWorldTime() % 360;
            rot = rot * 2;
            GlStateManager.rotate(rot, 0.0F, 1.0F, 0.0F);

            partialTicks = 0;

            Minecraft.getMinecraft().getRenderManager().renderEntity(renderItemEntity5, 0.0D, 0.0D, 0.0D, 0.0F, partialTicks, false);

            GlStateManager.popMatrix();
        }
    }

}