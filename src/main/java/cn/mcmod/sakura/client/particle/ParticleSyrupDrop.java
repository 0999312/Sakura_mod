package cn.mcmod.sakura.client.particle;

import cn.mcmod.sakura.ClientProxy;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleSyrupDrop extends Particle {

    public ParticleSyrupDrop(World world, double xCoordIn, double yCoordIn, double zCoordIn, double motionXIn, double motionYIn, double motionZIn) {
        super(world, xCoordIn, yCoordIn, zCoordIn, motionXIn, motionYIn, motionZIn);
        this.particleTextureIndexX = 0;
        this.particleTextureIndexY = 1;

        this.motionX *= 0.0D;
        this.motionY *= 0.1D;
        this.motionZ *= 0.0D;

        this.motionX += motionXIn;
        this.motionY += motionYIn;
        this.motionZ += motionZIn;

        this.particleScale = 0.96F + 0.02F * world.rand.nextInt(8);

        this.particleMaxAge = world.rand.nextInt(30) + 120;

        this.particleAlpha = 1.0F;
        this.particleGravity = 0.02F;
        this.canCollide = true;
    }

    @Override
    public int getFXLayer() {
        return 2;
    }

    @Override
    public void renderParticle(BufferBuilder buffer, Entity entity, float partialTicks, float rotX, float rotXZ, float rotZ, float rotYZ, float rotXY) {
        // EffectRenderer will by default bind the vanilla particles texture, override with our own
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(ClientProxy.leafTexture);

        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 1);

        super.renderParticle(buffer, entity, partialTicks, rotX, rotXZ, rotZ, rotYZ, rotXY);

        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
    }

    @Override
    public void onUpdate() {

        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;

        if (particleAge++ >= particleMaxAge) {
            this.setExpired();
        }

        this.move(this.motionX, this.motionY, this.motionZ);
        this.motionY -= 0.003000000026077032D;
        this.motionY = Math.max(this.motionY, -0.14000000059604645D);

        if (onGround) {
            motionX *= 0.0D;
            motionZ *= 0.0D;
        }
    }
}