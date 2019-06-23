package cn.mcmod.sakura.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;

public class ClientUtils {
    static HashMap<String, ResourceLocation> resourceMap = new HashMap<String, ResourceLocation>();

    public static void bindTexture(String path) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(getResource(path));
    }

    public static ResourceLocation getResource(String path) {
        ResourceLocation rl = resourceMap.containsKey(path) ? resourceMap.get(path) : new ResourceLocation(path);
        if (!resourceMap.containsKey(path))
            resourceMap.put(path, rl);
        return rl;
    }

    public static void drawTexturedRect(float x, float y, float w, float h, double... uv) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder worldrenderer = tessellator.getBuffer();
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(x, y + h, 0).tex(uv[0], uv[3]).endVertex();
        worldrenderer.pos(x + w, y + h, 0).tex(uv[1], uv[3]).endVertex();
        worldrenderer.pos(x + w, y, 0).tex(uv[1], uv[2]).endVertex();
        worldrenderer.pos(x, y, 0).tex(uv[0], uv[2]).endVertex();
        tessellator.draw();
    }

    public static void drawRepeatedFluidSprite(FluidStack fluid, float x, float y, float w, float h) {

        bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE.toString());

        TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(fluid.getFluid().getStill(fluid).toString());

        if (sprite != null) {

            int col = fluid.getFluid().getColor(fluid);

            GlStateManager.color((col >> 16 & 255) / 255.0f, (col >> 8 & 255) / 255.0f, (col & 255) / 255.0f, 1);

            int iW = sprite.getIconWidth();

            int iH = sprite.getIconHeight();
            if (iW > 0 && iH > 0)
                drawRepeatedSprite(x, y, w, h, iW, iH, sprite.getMinU(), sprite.getMaxU(), sprite.getMinV(), sprite.getMaxV());
        }
    }

    public static void drawRepeatedSprite(float x, float y, float w, float h, int iconWidth, int iconHeight, float uMin, float uMax, float vMin, float vMax) {

        int iterMaxW = (int) (w / iconWidth);
        int iterMaxH = (int) (h / iconHeight);

        float leftoverW = w % iconWidth;
        float leftoverH = h % iconHeight;
        float leftoverWf = leftoverW / (float) iconWidth;
        float leftoverHf = leftoverH / (float) iconHeight;

        float iconUDif = uMax - uMin;
        float iconVDif = vMax - vMin;

        for (int ww = 0; ww < iterMaxW; ww++) {
            for (int hh = 0; hh < iterMaxH; hh++)
                drawTexturedRect(x + ww * iconWidth, y + hh * iconHeight, iconWidth, iconHeight, uMin, uMax, vMin, vMax);
            drawTexturedRect(x + ww * iconWidth, y + iterMaxH * iconHeight, iconWidth, leftoverH, uMin, uMax, vMin, (vMin + iconVDif * leftoverHf));
        }

        if (leftoverW > 0)

            for (int hh = 0; hh < iterMaxH; hh++)
                drawTexturedRect(x + iterMaxW * iconWidth, y + hh * iconHeight, leftoverW, iconHeight, uMin, (uMin + iconUDif * leftoverWf), vMin, vMax);
        drawTexturedRect(x + iterMaxW * iconWidth, y + iterMaxH * iconHeight, leftoverW, leftoverH, uMin, (uMin + iconUDif * leftoverWf), vMin, (vMin + iconVDif * leftoverHf));
    }
}
