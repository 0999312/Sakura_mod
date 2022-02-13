package cn.mcmod.sakura.block.entity;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, SakuraMod.MODID);

    public static final RegistryObject<BlockEntityType<StoneMortarBlockEntity>> STONE_MORTAR = BLOCK_ENTITIES.register("stone_mortar", 
            () -> BlockEntityType.Builder.of(StoneMortarBlockEntity::new, BlockRegistry.STONE_MORTAR.get()).build(null));
}
