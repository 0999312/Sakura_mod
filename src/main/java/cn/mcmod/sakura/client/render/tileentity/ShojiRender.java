package cn.mcmod.sakura.client.render.tileentity;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.client.model.tileentity.ShojiModel;
import cn.mcmod.sakura.tileentity.TileEntityShoji;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class ShojiRender extends TileEntitySpecialRenderer<TileEntityShoji> {
    private final ShojiModel model = new ShojiModel();

    @Override
    public void render(TileEntityShoji te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        final ResourceLocation resource = new ResourceLocation(SakuraMain.MODID,
                "textures/entity/block/shoji_type_" + te.getType() + ".png");
        this.bindTexture(resource);

        float time = (te.getAnimation() == 0) ? 0 : te.getAnimation() - partialTicks;

        GlStateManager.pushMatrix();

        switch (te.getFacing()) {
            case NORTH:
            default:
                if (te.isOpen()) {
                    GlStateManager.translate(x + 0.5 + (0.8 - time * 0.08), y, z + 0.5);
                } else {
                    GlStateManager.translate(x + 0.5 + time * 0.08, y, z + 0.5);
                }
                GlStateManager.rotate(180, 0, 1, 0);
                break;
            case SOUTH:
                if (te.isOpen()) {
                    GlStateManager.translate(x + 0.5 - (0.8 - time * 0.08), y, z + 0.5);
                } else {
                    GlStateManager.translate(x + 0.5 - time * 0.08, y, z + 0.5);
                }
                break;
            case WEST:
                if (te.isOpen()) {
                    GlStateManager.translate(x + 0.5, y, z + 0.5 - (0.8 - time * 0.08));
                } else {
                    GlStateManager.translate(x + 0.5, y, z + 0.5 - time * 0.08);
                }
                GlStateManager.rotate(270, 0, 1, 0);
                break;
            case EAST:
                if (te.isOpen()) {
                    GlStateManager.translate(x + 0.5, y, z + 0.5 + (0.8 - time * 0.08));
                } else {
                    GlStateManager.translate(x + 0.5, y, z + 0.5 + time * 0.08);
                }
                GlStateManager.rotate(90, 0, 1, 0);
                break;
        }
        GlStateManager.scale(0.0625, 0.0625, 0.0625);
        GlStateManager.rotate(180, 0, 0, 1);
        GlStateManager.rotate(90, 0, 1, 0);
        model.render(1.0f);
        GlStateManager.popMatrix();
    }
}
