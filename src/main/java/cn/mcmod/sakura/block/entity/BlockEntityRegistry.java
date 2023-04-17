package cn.mcmod.sakura.block.entity;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITIES, SakuraMod.MODID);

    public static final RegistryObject<BlockEntityType<StoneMortarBlockEntity>> STONE_MORTAR = BLOCK_ENTITIES
            .register("stone_mortar", () -> BlockEntityType.Builder
                    .of(StoneMortarBlockEntity::new, BlockRegistry.STONE_MORTAR.get()).build(null));

    public static final RegistryObject<BlockEntityType<CookingPotBlockEntity>> COOKING_POT = BLOCK_ENTITIES.register(
            "cooking_pot",
            () -> BlockEntityType.Builder.of(CookingPotBlockEntity::new, BlockRegistry.COOKING_POT.get()).build(null));
    
    public static final RegistryObject<BlockEntityType<FermenterBlockEntity>> FERMENTER = BLOCK_ENTITIES.register(
            "fermenter",
            () -> BlockEntityType.Builder.of(FermenterBlockEntity::new, BlockRegistry.FERMENTER.get()).build(null));
    
    public static final RegistryObject<BlockEntityType<DistillerBlockEntity>> DISTILLER = BLOCK_ENTITIES.register(
            "distiller",
            () -> BlockEntityType.Builder.of(DistillerBlockEntity::new, BlockRegistry.DISTILLER.get()).build(null));
    
    public static final RegistryObject<BlockEntityType<ObonBlockEntity>> OBON = BLOCK_ENTITIES.register(
            "obon",
            () -> BlockEntityType.Builder.of(ObonBlockEntity::new, BlockRegistry.OBON.get()).build(null));
    
    public static final RegistryObject<BlockEntityType<ChoppingBoardBlockEntity>> CHOPPING_BOARD = BLOCK_ENTITIES.register(
            "chopping_board",
            () -> BlockEntityType.Builder.of(ChoppingBoardBlockEntity::new, BlockRegistry.CHOPPING_BOARD.get()).build(null));
}
