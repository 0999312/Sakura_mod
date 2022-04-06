package cn.mcmod.sakura.loot_modifier;

import cn.mcmod.sakura.SakuraMod;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootModifiterRegistry {
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister
            .create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, SakuraMod.MODID);
    public static final RegistryObject<SeedsDrop.Serializer> SEEDSDROP = GLM.register("grass_drops",
            SeedsDrop.Serializer::new);
    public static final RegistryObject<FishingModifiter.Serializer> FISHING = GLM.register("fishing_modifiter",
            FishingModifiter.Serializer::new);
}
