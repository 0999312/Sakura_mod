package cn.mcmod.sakura.block;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.item.StoneMortarItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SakuraMod.MODID);

    public static final RegistryObject<Item> SAKURA_LEAVES = ITEMS.register("sakuraleaves",
            () -> new BlockItem(BlockRegistry.SAKURA_LEAVES.get(), SakuraMod.defaultItemProperties()));
    
    public static final RegistryObject<Item> MAPLE_LEAVES_RED = ITEMS.register("mapleleaves_red",
            () -> new BlockItem(BlockRegistry.MAPLE_LEAVES_RED.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_LEAVES_YELLOW = ITEMS.register("mapleleaves_yellow",
            () -> new BlockItem(BlockRegistry.MAPLE_LEAVES_YELLOW.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_LEAVES_ORANGE = ITEMS.register("mapleleaves_orange",
            () -> new BlockItem(BlockRegistry.MAPLE_LEAVES_ORANGE.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_LEAVES_GREEN = ITEMS.register("mapleleaves_green",
            () -> new BlockItem(BlockRegistry.MAPLE_LEAVES_GREEN.get(), SakuraMod.defaultItemProperties()));
    
    public static final RegistryObject<Item> SAKURA_LOG = ITEMS.register("sakura_log",
            () -> new BlockItem(BlockRegistry.SAKURA_LOG.get(), SakuraMod.defaultItemProperties()));
    
    public static final RegistryObject<Item> STRIPPED_SAKURA_LOG = ITEMS.register("stripped_sakura_log",
            () -> new BlockItem(BlockRegistry.STRIPPED_SAKURA_LOG.get(), SakuraMod.defaultItemProperties()));
    
    public static final RegistryObject<Item> SAKURA_WOOD = ITEMS.register("sakura_wood",
            () -> new BlockItem(BlockRegistry.SAKURA_WOOD.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> STRIPPED_SAKURA_WOOD = ITEMS.register("stripped_sakura_wood",
            () -> new BlockItem(BlockRegistry.STRIPPED_SAKURA_WOOD.get(), SakuraMod.defaultItemProperties()));
    
    public static final RegistryObject<Item> MAPLE_LOG = ITEMS.register("maple_log",
            () -> new BlockItem(BlockRegistry.MAPLE_LOG.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_LOG = ITEMS.register("stripped_maple_log",
            () -> new BlockItem(BlockRegistry.STRIPPED_MAPLE_LOG.get(), SakuraMod.defaultItemProperties()));
    
    public static final RegistryObject<Item> MAPLE_WOOD = ITEMS.register("maple_wood",
            () -> new BlockItem(BlockRegistry.MAPLE_WOOD.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD = ITEMS.register("stripped_maple_wood",
            () -> new BlockItem(BlockRegistry.STRIPPED_MAPLE_WOOD.get(), SakuraMod.defaultItemProperties()));

    public static final RegistryObject<Item> BAMBOO_BLOCK = ITEMS.register("bamboo_block",
            () -> new BlockItem(BlockRegistry.BAMBOO_BLOCK.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> BAMBOO_BLOCK_SUNBURNT = ITEMS.register("bamboo_block_sunburnt",
            () -> new BlockItem(BlockRegistry.BAMBOO_BLOCK_SUNBURNT.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> BAMBOO_CHARCOAL_BLOCK = ITEMS.register("bamboo_charcoal_block",
            () -> new BlockItem(BlockRegistry.BAMBOO_CHARCOAL_BLOCK.get(), SakuraMod.defaultItemProperties()));

    public static final RegistryObject<Item> SAKURA_PLANK = ITEMS.register("plank_sakura",
            () -> new BlockItem(BlockRegistry.SAKURA_PLANK.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_PLANK = ITEMS.register("plank_maple",
            () -> new BlockItem(BlockRegistry.MAPLE_PLANK.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> BAMBOO_PLANK = ITEMS.register("plank_bamboo",
            () -> new BlockItem(BlockRegistry.BAMBOO_PLANK.get(), SakuraMod.defaultItemProperties()));

    public static final RegistryObject<Item> BAMBOOSHOOT = ITEMS.register("bamboo_shoot",
            () -> new BlockItem(BlockRegistry.BAMBOOSHOOT.get(), SakuraMod.defaultItemProperties()));
    
    public static final RegistryObject<Item> SAKURA_SAPLING = ITEMS.register("sakura_sapling",
            () -> new BlockItem(BlockRegistry.SAKURA_SAPLING.get(), SakuraMod.defaultItemProperties()));
    
    public static final RegistryObject<Item> MAPLE_SAPLING_RED = ITEMS.register("maple_sapling_red",
            () -> new BlockItem(BlockRegistry.MAPLE_SAPLING_RED.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_SAPLING_YELLOW = ITEMS.register("maple_sapling_yellow",
            () -> new BlockItem(BlockRegistry.MAPLE_SAPLING_YELLOW.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_SAPLING_ORANGE = ITEMS.register("maple_sapling_orange",
            () -> new BlockItem(BlockRegistry.MAPLE_SAPLING_ORANGE.get(), SakuraMod.defaultItemProperties()));
    public static final RegistryObject<Item> MAPLE_SAPLING_GREEN = ITEMS.register("maple_sapling_green",
            () -> new BlockItem(BlockRegistry.MAPLE_SAPLING_GREEN.get(), SakuraMod.defaultItemProperties()));
    
    public static final RegistryObject<Item> STONE_MORTAR = ITEMS.register("stone_mortar", StoneMortarItem::new);
    
    public static final RegistryObject<Item> COOKING_POT = ITEMS.register("cooking_pot",
            () -> new BlockItem(BlockRegistry.COOKING_POT.get(), SakuraMod.defaultItemProperties()));
}
