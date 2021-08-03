package cn.mcmod.sakura.client.particle;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SakuraLeafParticle extends SpriteTexturedParticle {

    public SakuraLeafParticle(ClientWorld world, double xIn, double yIn, double zIn, double motionXIn, double motionYIn, double motionZIn) {
        super(world, xIn, yIn, zIn, motionXIn, motionYIn, motionZIn);
        
        this.xd *= 0.10000000149011612D;
        this.yd *= 0.1D;
        this.zd *= 0.10000000149011612D;

        this.xd += motionXIn;
        this.yd += motionYIn;
        this.zd += motionZIn;

        this.quadSize = 0.96F + 0.02F * world.random.nextInt(8);

        this.lifetime = world.random.nextInt(30) + 120;

        this.alpha = 1.0F;
        this.gravity = 0.02F;
        this.hasPhysics = true;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (age++ >= lifetime) {
            this.remove();
        }

        this.move(this.xd, this.yd, this.zd);
        this.yd -= 0.003000000026077032D;
        this.yd = Math.max(this.yd, -0.14000000059604645D);

        if (onGround) {
            xd *= 0.0D;
            zd *= 0.0D;
        }
    }

    @Override
    public IParticleRenderType getRenderType() {
      return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprite;

        public Factory(IAnimatedSprite sprite) {
            this.sprite = sprite;
        }

        public Particle createParticle(BasicParticleType typeIn, ClientWorld world, double xIn, double yIn, double zIn, double motionXIn, double motionYIn, double motionZIn) {
            SakuraLeafParticle particle = new SakuraLeafParticle(world, xIn, yIn, zIn, motionXIn, motionYIn, motionZIn);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
