package cn.mcmod.sakura.client.particle;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleRegistry {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister
            .create(ForgeRegistries.PARTICLE_TYPES, SakuraMod.MODID);
    public static final RegistryObject<SimpleParticleType> SAKURA_LEAF = PARTICLE_TYPES.register("sakura",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> RED_MAPLE_LEAF = PARTICLE_TYPES.register("red_maple",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> YELLOW_MAPLE_LEAF = PARTICLE_TYPES.register("yellow_maple",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> GREEN_MAPLE_LEAF = PARTICLE_TYPES.register("green_maple",
            () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> ORANGE_MAPLE_LEAF = PARTICLE_TYPES.register("orange_maple",
            () -> new SimpleParticleType(false));
}
