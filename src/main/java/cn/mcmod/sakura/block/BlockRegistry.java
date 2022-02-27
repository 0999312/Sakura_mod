package cn.mcmod.sakura.block;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.crops.RiceCrop;
import cn.mcmod.sakura.block.crops.RiceCropRoot;
import cn.mcmod.sakura.block.machines.CookingPotBlock;
import cn.mcmod.sakura.block.machines.StoneMortarBlock;
import cn.mcmod.sakura.client.particle.ParticleRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.level.tree.MapleTreeGrower;
import cn.mcmod.sakura.level.tree.SakuraTreeFeatures;
import cn.mcmod.sakura.level.tree.SakuraTreeGrower;
import cn.mcmod_mmf.mmlib.block.Age3CropBlock;
import cn.mcmod_mmf.mmlib.block.BaseCropBlock;
import cn.mcmod_mmf.mmlib.block.HighCropBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            SakuraMod.MODID);

    public static final RegistryObject<Block> SAKURA_LEAVES = BLOCKS.register("sakuraleaves",
            () -> new SakuraLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion(), ParticleRegistry.SAKURA_LEAF));

    public static final RegistryObject<Block> MAPLE_LEAVES_RED = BLOCKS.register("mapleleaves_red",
            () -> new SakuraLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion(), ParticleRegistry.RED_MAPLE_LEAF));
    public static final RegistryObject<Block> MAPLE_LEAVES_GREEN = BLOCKS.register("mapleleaves_green",
            () -> new SakuraLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion(), ParticleRegistry.GREEN_MAPLE_LEAF));
    public static final RegistryObject<Block> MAPLE_LEAVES_YELLOW = BLOCKS.register("mapleleaves_yellow",
            () -> new SakuraLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion(), ParticleRegistry.YELLOW_MAPLE_LEAF));
    public static final RegistryObject<Block> MAPLE_LEAVES_ORANGE = BLOCKS.register("mapleleaves_orange",
            () -> new SakuraLeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks()
                    .sound(SoundType.GRASS).noOcclusion(), ParticleRegistry.ORANGE_MAPLE_LEAF));

    public static final RegistryObject<RotatedPillarBlock> SAKURA_LOG = BLOCKS.register("sakura_log",
            () -> log(MaterialColor.WOOD, MaterialColor.PODZOL));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SAKURA_LOG = BLOCKS.register("stripped_sakura_log",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));

    public static final RegistryObject<RotatedPillarBlock> SAKURA_WOOD = BLOCKS.register("sakura_wood",
            () -> log(MaterialColor.PODZOL, MaterialColor.PODZOL));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SAKURA_WOOD = BLOCKS
            .register("stripped_sakura_wood", () -> log(MaterialColor.WOOD, MaterialColor.WOOD));

    public static final RegistryObject<SaplingBlock> SAKURA_SAPLING = BLOCKS.register("sakura_sapling",
            () -> sapling(new SakuraTreeGrower()));

    public static final RegistryObject<RotatedPillarBlock> MAPLE_LOG = BLOCKS.register("maple_log",
            MapleTreeLogBlock::new);

    public static final RegistryObject<RotatedPillarBlock> MAPLE_SAP_LOG = BLOCKS.register("maple_sap_log",
            MapleTreeSapLogBlock::new);

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_MAPLE_LOG = BLOCKS.register("stripped_maple_log",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));

    public static final RegistryObject<RotatedPillarBlock> MAPLE_WOOD = BLOCKS.register("maple_wood",
            () -> log(MaterialColor.PODZOL, MaterialColor.PODZOL));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_MAPLE_WOOD = BLOCKS.register("stripped_maple_wood",
            () -> log(MaterialColor.WOOD, MaterialColor.WOOD));

    public static final RegistryObject<RotatedPillarBlock> BAMBOO_BLOCK = BLOCKS.register("bamboo_block",
            BambooBlock::new);
    public static final RegistryObject<RotatedPillarBlock> BAMBOO_BLOCK_SUNBURNT = BLOCKS
            .register("bamboo_block_sunburnt", () -> simplebambooBlock(MaterialColor.SAND, MaterialColor.WOOD));
    public static final RegistryObject<RotatedPillarBlock> BAMBOO_CHARCOAL_BLOCK = BLOCKS.register(
            "bamboo_charcoal_block", () -> simplebambooBlock(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_BLACK));

    public static final RegistryObject<Block> MAPLE_SAPLING_RED = BLOCKS.register("maple_sapling_red",
            () -> sapling(new MapleTreeGrower(SakuraTreeFeatures.MAPLE_RED, SakuraTreeFeatures.FANCY_MAPLE_RED)));
    public static final RegistryObject<Block> MAPLE_SAPLING_GREEN = BLOCKS.register("maple_sapling_green",
            () -> sapling(new MapleTreeGrower(SakuraTreeFeatures.MAPLE_GREEN, SakuraTreeFeatures.FANCY_MAPLE_GREEN)));
    public static final RegistryObject<Block> MAPLE_SAPLING_YELLOW = BLOCKS.register("maple_sapling_yellow",
            () -> sapling(new MapleTreeGrower(SakuraTreeFeatures.MAPLE_YELLOW, SakuraTreeFeatures.FANCY_MAPLE_YELLOW)));
    public static final RegistryObject<Block> MAPLE_SAPLING_ORANGE = BLOCKS.register("maple_sapling_orange",
            () -> sapling(new MapleTreeGrower(SakuraTreeFeatures.MAPLE_ORANGE, SakuraTreeFeatures.FANCY_MAPLE_ORANGE)));

    public static final RegistryObject<Block> BAMBOO_PLANT = BLOCKS.register("bamboo_plant", BambooPlant::new);
    public static final RegistryObject<Block> BAMBOOSHOOT = BLOCKS.register("bamboo_shoot", BambooShoot::new);

    public static final RegistryObject<Block> SAKURA_PLANK = BLOCKS.register("plank_sakura",
            () -> plank(MaterialColor.WOOD));
    public static final RegistryObject<Block> MAPLE_PLANK = BLOCKS.register("plank_maple",
            () -> plank(MaterialColor.SAND));
    public static final RegistryObject<Block> BAMBOO_PLANK = BLOCKS.register("plank_bamboo",
            () -> plank(MaterialColor.SAND));

    public static final RegistryObject<Block> RICE_CROP_ROOT = BLOCKS.register("rice_crop_root",
            () -> new RiceCropRoot(Block.Properties.copy(Blocks.WHEAT).strength(0.2F)));
    public static final RegistryObject<Block> RICE_CROP = BLOCKS.register("rice_crop",
            () -> new RiceCrop(Block.Properties.copy(Blocks.WHEAT).strength(0.2F)));

    public static final RegistryObject<Block> CABBAGE_CROP = BLOCKS.register("cabbage_crop",
            () -> new BaseCropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F), ItemRegistry.CABBAGE_SEEDS));

    public static final RegistryObject<Block> RADISH_CROP = BLOCKS.register("radish_crop",
            () -> new Age3CropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F), ItemRegistry.RADISH_SEEDS));

    public static final RegistryObject<Block> ONION_CROP = BLOCKS.register("onion_crop",
            () -> new Age3CropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F), ItemRegistry.ONION_SEEDS));

    public static final RegistryObject<Block> REDBEAN_CROP = BLOCKS.register("redbean_crop",
            () -> new Age3CropBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F), ItemRegistry.RED_BEAN));

    public static final RegistryObject<Block> RAPESEED_CROP = BLOCKS.register("rapeseed_crop",
            () -> new BaseCropBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F), ItemRegistry.RAPESEEDS));

    public static final RegistryObject<Block> BUCKWHEAT_CROP = BLOCKS.register("buckwheat_crop",
            () -> new BaseCropBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F), ItemRegistry.BUCKWHEAT));

    public static final RegistryObject<Block> TARO_CROP = BLOCKS.register("taro_crop",
            () -> new Age3CropBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F), ItemRegistry.TARO));

    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
            () -> new HighCropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F), ItemRegistry.TOMATO_SEEDS));

    public static final RegistryObject<Block> EGGPLANT_CROP = BLOCKS.register("eggplant_crop",
            () -> new HighCropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F), ItemRegistry.EGGPLANT_SEEDS));

    public static final RegistryObject<Block> STONE_MORTAR = BLOCKS.register("stone_mortar", StoneMortarBlock::new);
    public static final RegistryObject<Block> COOKING_POT = BLOCKS.register("cooking_pot", CookingPotBlock::new);

    private static RotatedPillarBlock log(MaterialColor top, MaterialColor bark) {
        return new RotatedPillarBlock(BlockBehaviour.Properties
                .of(Material.WOOD, state -> (state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? top : bark))
                .strength(2.0F).sound(SoundType.WOOD));
    }

    private static SaplingBlock sapling(AbstractTreeGrower tree) {
        return new SaplingBlock(tree, BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks()
                .instabreak().sound(SoundType.GRASS));
    }

    private static RotatedPillarBlock simplebambooBlock(MaterialColor top, MaterialColor bark) {
        return new RotatedPillarBlock(BlockBehaviour.Properties
                .of(Material.BAMBOO,
                        state -> (state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? top : bark))
                .strength(2.0F).sound(SoundType.BAMBOO));
    }

    private static Block plank(MaterialColor material_color) {
        return new Block(
                BlockBehaviour.Properties.of(Material.WOOD, material_color).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }

}
