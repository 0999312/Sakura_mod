package cn.mcmod.sakura.client.render;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.client.model.ModelDeer;
import cn.mcmod.sakura.entity.EntityDeer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDeer extends RenderLiving<EntityDeer>
{
    private static final ResourceLocation DEER_TEXTURES = new ResourceLocation(SakuraMain.MODID,"textures/entity/deer.png");

    public RenderDeer(RenderManager p_i47187_1_)
    {
        super(p_i47187_1_, new ModelDeer(), 0.5F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityDeer entity)
    {

        return DEER_TEXTURES;
    }
}