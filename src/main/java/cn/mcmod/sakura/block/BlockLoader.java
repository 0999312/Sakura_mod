package cn.mcmod.sakura.block;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.crop.*;
import cn.mcmod.sakura.block.door.BlockDoorBase;
import cn.mcmod.sakura.block.door.BlockShoji;
import cn.mcmod.sakura.block.fluid.BlockFluidBasic;
import cn.mcmod.sakura.block.fluid.FluidBasic;
import cn.mcmod.sakura.block.noodles.BlockRamen;
import cn.mcmod.sakura.block.noodles.BlockSoba;
import cn.mcmod.sakura.block.noodles.BlockUdon;
import cn.mcmod.sakura.block.noodles.BlockUdonUnfinished;
import cn.mcmod.sakura.block.slab.*;
import cn.mcmod.sakura.block.tree.*;
import cn.mcmod.sakura.item.ItemSlabBase;
import cn.mcmod.sakura.util.JSON_Creator;
import cn.mcmod.sakura.util.RecipesUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader {
	public static Fluid FOODOIL_FLUID = new FluidBasic("food_oil");
	public static Block FOODOIL;
	public static Fluid GRAPE_FLUID = new FluidBasic("grape_fluid");
	public static Block GRAPE_FLUID_BLOCK;
	public static Fluid RED_WINE_FLUID = new FluidBasic("red_wine");
	public static Block RED_WINE;
	public static Fluid GREEN_GRAPE_FLUID = new FluidBasic("green_grape_fluid");
	public static Block GREEN_GRAPE_FLUID_BLOCK;
	public static Fluid WHITE_WINE_FLUID = new FluidBasic("white_wine");
	public static Block WHITE_WINE;
	public static Fluid CHAMPAGNE_FLUID = new FluidBasic("champagne");
	public static Block CHAMPAGNE;
	public static Fluid RUM_FLUID = new FluidBasic("rum");
	public static Block RUM;
	public static Fluid DOBUROKU_FLUID = new FluidBasic("doburoku");
	public static Block DOBUROKU;
	public static Fluid SAKE_FLUID = new FluidBasic("sake");
	public static Block SAKE;
	public static Fluid SHOUCHU_FLUID = new FluidBasic("shouchu");
	public static Block SHOUCHU;
	public static Fluid BEER_FLUID = new FluidBasic("beer");
	public static Block BEER;
	public static Fluid VODKA_FLUID = new FluidBasic("vodka");
	public static Block VODKA;
	
	public static Fluid BRANDY_FLUID = new FluidBasic("brandy");
	public static Block BRANDY;
	public static Fluid WHISKEY_FLUID = new FluidBasic("whiskey");
	public static Block WHISKEY;
	
	public static Fluid LIQUEUR_FLUID = new FluidBasic("liqueur");
	public static Block LIQUEUR;
	public static Fluid COCOA_LIQUEUR_FLUID = new FluidBasic("cocoa_liqueur");
	public static Block COCOA_LIQUEUR;
	
    public static Block BAMBOO = new BlockPlantBamboo();
    public static Block WINDBELL = new BlockWindBell();
    public static BlockBambooShoot BAMBOOSHOOT = new BlockBambooShoot();
    public static Block BAMBOO_BLOCK = new BlockBambooBlock(Material.WOOD).setHardness(1.6F).setResistance(6.0F);
    public static Block BAMBOO_BLOCK_SUNBURNT = new BlockBambooBlock(Material.WOOD).setHardness(1.6F).setResistance(5.5F);
    public static BlockSlabBase BAMBOO_SLAB = new BlockBambooSlab(Material.WOOD);
    public static BlockSlabBase BAMBOO_SLAB_SUNBURNT = new BlockBambooSlab(Material.WOOD);
    public static Block BAMBOOLANTERN = new BlockBambooLantern();
    public static BlockDoorBase BAMBOODOOR = new BlockDoorBase(Material.WOOD);
	public static Block MAPLE_SAPLING_RED = new BlockMapleSaplingRed();
	public static Block MAPLE_LEAVE_RED = new BlockMapleLeaveRed();
	public static Block MAPLE_SAPLING_YELLOW = new BlockMapleSaplingYellow();
	public static Block MAPLE_LEAVE_YELLOW = new BlockMapleLeaveYellow();
	public static Block MAPLE_SAPLING_ORANGE = new BlockMapleSaplingOrange();
	public static Block MAPLE_LEAVE_ORANGE = new BlockMapleLeaveOrange();
	public static Block MAPLE_SAPLING_GREEN = new BlockMapleSaplingGreen();
	public static Block MAPLE_LEAVE_GREEN = new BlockMapleLeaveGreen();
	public static Block MAPLE_LOG = new BlockMapleLog();
	public static Block MAPLE_LOG_SAP = new BlockMapleSapLog();
    public static Block BAMBOO_PLANK = new BlockSakuraPlank(Material.WOOD);
    public static Block MAPLE_PLANK = new BlockSakuraPlank(Material.WOOD);
//	public static Block MAPLE_SYRUP_CAUDRON = new BlockMapleSyrupCauldron();
	public static Block CAMPFIRE_IDLE = new BlockCampfire(false);
	public static Block CAMPFIRE_LIT = new BlockCampfire(true);
    public static Block CAMPFIRE_POT_IDLE = new BlockCampfirePot(false);
    public static Block CAMPFIRE_POT_LIT = new BlockCampfirePot(true);
	public static Block RICECROP = new BlockRiceCrop();
	public static Block STONEMORTAR = new BlockStoneMortar();
	public static Block BARREL = new BlockBarrel();
	public static Block BARREL_DISTILLATION = new BlockBarrelDistillation();
	public static Block TOMATOCROP = new BlockTomatoCrop();
	public static Block EGGPLANTCROP = new BlockEggplantCrop();
	public static Block CABBAGECROP = new BlockCabbageCrop();
	public static Block RADISHCROP = new BlockRadishCrop();
	public static Block REDBEANCROP = new BlockRedBeanCrop();
	public static Block BUCKWHEATCROP = new BlockBuckwheatCrop();
	public static Block RAPESEEDCROP = new BlockRapeseedCrop();
	public static Block ONIONCROP = new BlockOnionCrop();
	public static Block CHESTNUTBURR = new BlockChestnut();
	public static Block SAKURA_LOG = new BlockMapleLog();
    public static Block SAKURA_PLANK = new BlockSakuraPlank(Material.WOOD);
	public static Block SAKURA_LEAVES = new BlockSakuraLeave();
	public static Block SAKURA_SAPLING = new BlockSakuraSapling();
	public static Block PEPPER_SPLINT = new BlockPepperSplint();
	public static Block PEPPERCROP = new BlockPepperCrop();
	public static Block VANILLA_SPLINT = new BlockVanillaSplint();
	public static Block VANILLACROP = new BlockVanillaCrop();
	public static Block GRAPE_SPLINT_STAND = new BlockGrapeSplintStand();
	public static Block GRAPE_VINE = new BlockGrapeVine();
	public static Block GRAPE_SPLINT = new BlockGrapeSplint();
	public static BlockGrapeLeaves GRAPE_LEAVES = new BlockGrapeLeaves();
	public static Block SHOJI =new BlockShoji();
	public static Block ANDON =new BlockAndon();

	public static Block KAWARA_BLOCK = new BlockFacing(Material.ROCK,true).setHardness(1.5F).setResistance(10.0F);
	public static Block KAWARA = new BlockKawara();
	
	public static BlockFacing TATAMI_TAN=(BlockFacing) new BlockFacing(Material.GRASS,true).setSoundType(SoundType.PLANT).setHardness(0.5F).setResistance(0.5F);
	public static BlockFacing TATAMI_TAN_NS=(BlockFacing) new BlockFacing(Material.GRASS,true).setSoundType(SoundType.PLANT).setHardness(0.5F).setResistance(0.5F);
    public static Block TATAMI = new BlockTatami(false);
    public static Block TATAMI_NS = new BlockTatami(true);
    
	public static BlockFacing TATAMI_TAN_HALF=(BlockFacing) new BlockHalfFacing(Material.GRASS).setSoundType(SoundType.PLANT).setHardness(0.25F).setResistance(0.5F);
	public static BlockFacing TATAMI_TAN_NS_HALF=(BlockFacing) new BlockHalfFacing(Material.GRASS).setSoundType(SoundType.PLANT).setHardness(0.25F).setResistance(0.5F);
    public static Block TATAMI_HALF = new BlockHalfTatami(false);
    public static Block TATAMI_NS_HALF = new BlockHalfTatami(true);
    
	public static BlockFacing TATAMI_TAN_CARPET=(BlockFacing) new BlockCarpetFacing(Material.GRASS).setSoundType(SoundType.PLANT).setHardness(0.15F).setResistance(0.5F);
	public static BlockFacing TATAMI_TAN_NS_CARPET=(BlockFacing) new BlockCarpetFacing(Material.GRASS).setSoundType(SoundType.PLANT).setHardness(0.15F).setResistance(0.5F);
    public static Block TATAMI_CARPET = new BlockCarpetTatami(false);
    public static Block TATAMI_NS_CARPET = new BlockCarpetTatami(true);

	public static Block SAKURA_DIAMOND_ORE = new BlockSakuraDiamondOre();
	public static Block KITUNEBI = new BlockKitunebi();
	
	public static Block BAMBOO_FENCE = new BlockBambooFence();
	public static Block BAMBOO_FENCE_SUNBURNT = new BlockBambooFence();
	
	public static Block UDON_UNFINISHED = new BlockUdonUnfinished();
	public static Block UDON_BLOCK = new BlockUdon();
	public static Block RAMEN_BLOCK = new BlockRamen();
	public static Block SOBA_BLOCK = new BlockSoba();
	public BlockLoader(FMLPreInitializationEvent event) {
//		register blocks
//		DON'T REGISTER RENDERS IN THIS VOID,PLEASE!!!

		FluidRegistry.addBucketForFluid(FOODOIL_FLUID);
		FOODOIL=registerFluidBlock(FOODOIL_FLUID, new BlockFluidBasic(FOODOIL_FLUID), "foodoil");
		FluidRegistry.addBucketForFluid(GRAPE_FLUID);
		GRAPE_FLUID_BLOCK=registerFluidBlock(GRAPE_FLUID, new BlockFluidBasic(GRAPE_FLUID), "grape_fluid");
		FluidRegistry.addBucketForFluid(RED_WINE_FLUID);
		RED_WINE=registerFluidBlock(RED_WINE_FLUID, new BlockFluidBasic(RED_WINE_FLUID), "red_wine");
		FluidRegistry.addBucketForFluid(GREEN_GRAPE_FLUID);
		GREEN_GRAPE_FLUID_BLOCK=registerFluidBlock(GREEN_GRAPE_FLUID, new BlockFluidBasic(GREEN_GRAPE_FLUID), "green_grape_fluid");
		FluidRegistry.addBucketForFluid(WHITE_WINE_FLUID);
		WHITE_WINE=registerFluidBlock(WHITE_WINE_FLUID, new BlockFluidBasic(WHITE_WINE_FLUID), "white_wine");
		FluidRegistry.addBucketForFluid(CHAMPAGNE_FLUID);
		CHAMPAGNE=registerFluidBlock(CHAMPAGNE_FLUID, new BlockFluidBasic(CHAMPAGNE_FLUID), "champagne");
		FluidRegistry.addBucketForFluid(RUM_FLUID);
		RUM=registerFluidBlock(RUM_FLUID, new BlockFluidBasic(RUM_FLUID), "rum");
		FluidRegistry.addBucketForFluid(DOBUROKU_FLUID);
		DOBUROKU=registerFluidBlock(DOBUROKU_FLUID, new BlockFluidBasic(DOBUROKU_FLUID), "doburoku");
		FluidRegistry.addBucketForFluid(SAKE_FLUID);
		SAKE=registerFluidBlock(SAKE_FLUID, new BlockFluidBasic(SAKE_FLUID), "sake");
		
		FluidRegistry.addBucketForFluid(SHOUCHU_FLUID);
		SHOUCHU=registerFluidBlock(SHOUCHU_FLUID, new BlockFluidBasic(SHOUCHU_FLUID), "shouchu");
		FluidRegistry.addBucketForFluid(BEER_FLUID);
		BEER=registerFluidBlock(BEER_FLUID, new BlockFluidBasic(BEER_FLUID), "beer");
		FluidRegistry.addBucketForFluid(VODKA_FLUID);
		VODKA=registerFluidBlock(VODKA_FLUID, new BlockFluidBasic(VODKA_FLUID), "vodka");
		
		FluidRegistry.addBucketForFluid(BRANDY_FLUID);
		BRANDY=registerFluidBlock(BRANDY_FLUID, new BlockFluidBasic(BRANDY_FLUID), "brandy");
		FluidRegistry.addBucketForFluid(WHISKEY_FLUID);
		WHISKEY=registerFluidBlock(WHISKEY_FLUID, new BlockFluidBasic(WHISKEY_FLUID), "whiskey");
		
		FluidRegistry.addBucketForFluid(LIQUEUR_FLUID);
		LIQUEUR=registerFluidBlock(LIQUEUR_FLUID, new BlockFluidBasic(LIQUEUR_FLUID), "liqueur");
		FluidRegistry.addBucketForFluid(COCOA_LIQUEUR_FLUID);
		COCOA_LIQUEUR=registerFluidBlock(COCOA_LIQUEUR_FLUID, new BlockFluidBasic(COCOA_LIQUEUR_FLUID), "cocoa_liqueur");
		
        register(KAWARA_BLOCK, new ItemBlock(KAWARA_BLOCK), "kawara_block");
        register(KAWARA, new ItemBlock(KAWARA), "kawara");
        register(BAMBOO, new ItemBlock(BAMBOO), "bamboo");
        register(RAMEN_BLOCK, new ItemBlock(RAMEN_BLOCK), "ramen_block");
        register(UDON_UNFINISHED, new ItemBlock(UDON_UNFINISHED), "udon_unfinished_block");
        registerNoItem(UDON_BLOCK, "udon_block");
        register(SOBA_BLOCK, new ItemBlock(SOBA_BLOCK), "soba_block");
        register(BAMBOOSHOOT, new ItemBlock(BAMBOOSHOOT), "bamboo_shoot");
        register(BAMBOO_PLANK, new ItemBlock(BAMBOO_PLANK), "plank_bamboo");
        register(BAMBOO_BLOCK, new ItemBlock(BAMBOO_BLOCK), "bamboo_block");
        register(BAMBOO_BLOCK_SUNBURNT, new ItemBlock(BAMBOO_BLOCK_SUNBURNT), "bamboo_block_sunburnt");
        register(BAMBOO_SLAB, new ItemSlabBase(BAMBOO_SLAB), "bamboo_slab");
        register(BAMBOO_SLAB_SUNBURNT, new ItemSlabBase(BAMBOO_SLAB_SUNBURNT), "bamboo_slab_sunburnt");
		register(BAMBOO_FENCE, new ItemBlock(BAMBOO_FENCE), "bamboo_fence");
	    register(BAMBOO_FENCE_SUNBURNT, new ItemBlock(BAMBOO_FENCE_SUNBURNT), "bamboo_fence_sunburnt");
		
        register(BAMBOOLANTERN, new ItemBlock(BAMBOOLANTERN), "bamboo_lantern");
        register(WINDBELL, new ItemBlock(WINDBELL), "windbell");
        register(TATAMI_TAN, new ItemBlock(TATAMI_TAN), "tatami_tan");
        register(TATAMI, new ItemBlock(TATAMI), "tatami");
        register(TATAMI_TAN_NS, new ItemBlock(TATAMI_TAN_NS), "tatami_tan_ns");
        register(TATAMI_NS, new ItemBlock(TATAMI_NS), "tatami_ns");
        
        register(TATAMI_TAN_HALF, new ItemBlock(TATAMI_TAN_HALF), "tatami_tan_half");
        register(TATAMI_HALF, new ItemBlock(TATAMI_HALF), "tatami_half");
        register(TATAMI_TAN_NS_HALF, new ItemBlock(TATAMI_TAN_NS_HALF), "tatami_tan_ns_half");
        register(TATAMI_NS_HALF, new ItemBlock(TATAMI_NS_HALF), "tatami_ns_half");
        
        register(TATAMI_TAN_CARPET, new ItemBlock(TATAMI_TAN_CARPET), "tatami_tan_carpet");
        register(TATAMI_CARPET, new ItemBlock(TATAMI_CARPET), "tatami_carpet");
        register(TATAMI_TAN_NS_CARPET, new ItemBlock(TATAMI_TAN_NS_CARPET), "tatami_tan_ns_carpet");
        register(TATAMI_NS_CARPET, new ItemBlock(TATAMI_NS_CARPET), "tatami_ns_carpet");
        
		registerNoItem(BAMBOODOOR, "bamboo_door");
		register(MAPLE_SAPLING_RED, new ItemBlock(MAPLE_SAPLING_RED), "maple_sapling_red");
		register(MAPLE_LEAVE_RED, new ItemBlock(MAPLE_LEAVE_RED), "maple_leaves_red");
		register(MAPLE_SAPLING_YELLOW, new ItemBlock(MAPLE_SAPLING_YELLOW), "maple_sapling_yellow");
		register(MAPLE_LEAVE_YELLOW, new ItemBlock(MAPLE_LEAVE_YELLOW), "maple_leaves_yellow");
		register(MAPLE_SAPLING_ORANGE, new ItemBlock(MAPLE_SAPLING_ORANGE), "maple_sapling_orange");
		register(MAPLE_LEAVE_ORANGE, new ItemBlock(MAPLE_LEAVE_ORANGE), "maple_leaves_orange");
		register(MAPLE_SAPLING_GREEN, new ItemBlock(MAPLE_SAPLING_GREEN), "maple_sapling_green");
		register(MAPLE_LEAVE_GREEN, new ItemBlock(MAPLE_LEAVE_GREEN), "maple_leaves_green");
		register(MAPLE_LOG, new ItemBlock(MAPLE_LOG), "maple_log");
		register(MAPLE_LOG_SAP, new ItemBlock(MAPLE_LOG_SAP), "maple_log_sap");
        register(MAPLE_PLANK, new ItemBlock(MAPLE_PLANK), "plank_maple");
		register(SAKURA_LEAVES, new ItemBlock(SAKURA_LEAVES), "sakuraleaves");
		register(SAKURA_SAPLING, new ItemBlock(SAKURA_SAPLING), "sakura_sapling");
		register(SAKURA_LOG, new ItemBlock(SAKURA_LOG), "sakura_log");
        register(SAKURA_PLANK, new ItemBlock(SAKURA_PLANK), "plank_sakura");
		register(STONEMORTAR, new ItemBlock(STONEMORTAR), "stone_mortar");
		register(BARREL, new ItemBlock(BARREL), "barrel");
		register(BARREL_DISTILLATION, new ItemBlock(BARREL_DISTILLATION), "barrel_distillation");
		register(CAMPFIRE_IDLE, new ItemBlock(CAMPFIRE_IDLE), "campfire_idle");
		register(PEPPER_SPLINT, new ItemBlock(PEPPER_SPLINT), "pepper_splint");
		register(VANILLA_SPLINT, new ItemBlock(VANILLA_SPLINT), "vanilla_splint");
		register(GRAPE_SPLINT_STAND, new ItemBlock(GRAPE_SPLINT_STAND), "grape_splint_stand");
		register(GRAPE_SPLINT, new ItemBlock(GRAPE_SPLINT), "grape_splint");
		register(KITUNEBI, new ItemBlock(KITUNEBI), "kitunebi");
		register(SHOJI, new ItemBlock(SHOJI), "shoji");
		register(ANDON, new ItemBlock(ANDON), "andon");
		register(SAKURA_DIAMOND_ORE, new ItemBlock(SAKURA_DIAMOND_ORE), "sakura_diamond_ore");
		registerNoItem(CAMPFIRE_LIT,"campfire_lit");
		registerNoItem(CAMPFIRE_POT_IDLE, "campfire_pot_idle");
        registerNoItem(CAMPFIRE_POT_LIT, "campfire_pot_lit");
		registerNoItem(RICECROP, "ricecrop");
		registerNoItem(ONIONCROP, "onioncrop");
		registerNoItem(RAPESEEDCROP, "rapeseedcrop");
		registerNoItem(CHESTNUTBURR, "chestnut_burr");
		registerNoItem(TOMATOCROP, "tomatocrop");
		registerNoItem(EGGPLANTCROP, "eggplantcrop");
		registerNoItem(CABBAGECROP, "cabbagecrop");
		registerNoItem(RADISHCROP, "radishcrop");
		registerNoItem(REDBEANCROP, "redbeancrop");
		registerNoItem(BUCKWHEATCROP, "buckwheatcrop");
		registerNoItem(PEPPERCROP,"peppercrop");
		registerNoItem(VANILLACROP,"vanillacrop");
		registerNoItem(GRAPE_VINE,"grapevine");
		registerNoItem(GRAPE_LEAVES, "grapeleaves");

		Blocks.FIRE.setFireInfo(SAKURA_PLANK, 5, 20);
		Blocks.FIRE.setFireInfo(MAPLE_PLANK, 5, 20);
		Blocks.FIRE.setFireInfo(MAPLE_LOG, 5, 5);
		Blocks.FIRE.setFireInfo(MAPLE_LOG_SAP, 5, 5);
		Blocks.FIRE.setFireInfo(BAMBOO_BLOCK, 5, 5);
		Blocks.FIRE.setFireInfo(BAMBOO, 5, 20);
		
    }

	private static void register(Block block, Item itemBlock, String string) {
		block.setRegistryName(string);
		block.setUnlocalizedName(SakuraMain.MODID+"."+string);
		block.setCreativeTab(CommonProxy.tab);
		ForgeRegistries.BLOCKS.register(block);
		if (itemBlock != null) {
			itemBlock.setRegistryName(string);
			itemBlock.setUnlocalizedName(SakuraMain.MODID+"."+string);
			ForgeRegistries.ITEMS.register(itemBlock);
		}
	}

	private static void registerNoItem(Block block, String string) {
		block.setRegistryName(string);
		block.setUnlocalizedName(SakuraMain.MODID+"."+string);

		ForgeRegistries.BLOCKS.register(block);
	}

	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
//		please register blocks' renders in THIS void!
		registerRender(WINDBELL);
		registerRender(BARREL_DISTILLATION);
		registerRender(UDON_UNFINISHED);
		registerRender(SOBA_BLOCK);
		registerRender(RAMEN_BLOCK);
		registerRender(TATAMI_TAN);
		registerRender(TATAMI);
		registerRender(TATAMI_TAN_NS);
		registerRender(TATAMI_NS);
		registerRender(BAMBOO_PLANK);
		registerRender(TATAMI_TAN_HALF);
		registerRender(TATAMI_HALF);
		registerRender(TATAMI_TAN_NS_HALF);
		registerRender(TATAMI_NS_HALF);
		
		registerRender(TATAMI_TAN_CARPET);
		registerRender(TATAMI_CARPET);
		registerRender(TATAMI_TAN_NS_CARPET);
		registerRender(TATAMI_NS_CARPET);
		registerRender(KITUNEBI);
		registerRender(BAMBOO_BLOCK_SUNBURNT);
		
		registerFluidBlockRendering(COCOA_LIQUEUR, "cocoa_liqueur");
		registerFluidBlockRendering(LIQUEUR, "liqueur");
		
		registerFluidBlockRendering(FOODOIL, "food_oil");
		registerFluidBlockRendering(GRAPE_FLUID_BLOCK, "grape_fluid");
		registerFluidBlockRendering(GREEN_GRAPE_FLUID_BLOCK, "green_grape_fluid");
		registerFluidBlockRendering(RED_WINE, "red_wine");
		registerFluidBlockRendering(WHITE_WINE, "white_wine");
		registerFluidBlockRendering(CHAMPAGNE, "champagne");
		registerFluidBlockRendering(DOBUROKU, "doburoku");
		registerFluidBlockRendering(SAKE, "sake");
		registerFluidBlockRendering(RUM, "rum");
		registerFluidBlockRendering(BEER, "beer");
		registerFluidBlockRendering(SHOUCHU, "shouchu");
		registerFluidBlockRendering(VODKA, "vodka");
		registerFluidBlockRendering(BRANDY, "brandy");
		registerFluidBlockRendering(WHISKEY, "whiskey");
		
		registerRender(BAMBOO_FENCE);
		registerRender(BAMBOO_FENCE_SUNBURNT);
		registerRender(KAWARA_BLOCK);
		registerRender(KAWARA);
		registerRender(ANDON);
		registerRender(BAMBOO);
		registerRender(BAMBOOSHOOT);
        registerRender(BAMBOOLANTERN);
        registerRender(BAMBOODOOR);
        registerRender(BAMBOO_BLOCK);
        registerRender(BAMBOO_SLAB);
        registerRender(BAMBOO_SLAB_SUNBURNT);
		registerRender(SAKURA_LEAVES);
		registerRender(SAKURA_LOG);
        registerRender(SAKURA_PLANK);
		registerRender(SAKURA_SAPLING);
		registerRender(MAPLE_SAPLING_RED);
		registerRender(MAPLE_LEAVE_RED);
		registerRender(MAPLE_SAPLING_YELLOW);
		registerRender(MAPLE_LEAVE_YELLOW);
		registerRender(MAPLE_SAPLING_ORANGE);
		registerRender(MAPLE_LEAVE_ORANGE);
		registerRender(MAPLE_SAPLING_GREEN);
		registerRender(MAPLE_LEAVE_GREEN);
		registerRender(MAPLE_LOG);
		registerRender(MAPLE_LOG_SAP);
        registerRender(MAPLE_PLANK);
		registerRender(STONEMORTAR);
		registerRender(BARREL);
		registerRender(CAMPFIRE_IDLE);

		registerRender(PEPPER_SPLINT);
		registerRender(VANILLA_SPLINT);
		registerRender(VANILLACROP);
		registerRender(GRAPE_LEAVES);
		registerRender(GRAPE_SPLINT);
        registerRender(GRAPE_SPLINT_STAND);
        registerRender(GRAPE_VINE);
		registerRender(SAKURA_DIAMOND_ORE);
		
        ModelResourceLocation icons_0 = new ModelResourceLocation(SHOJI.getRegistryName() + "_0", "inventory");
        ModelResourceLocation icons_1 = new ModelResourceLocation(SHOJI.getRegistryName() + "_1", "inventory");
        ModelResourceLocation icons_2 = new ModelResourceLocation(SHOJI.getRegistryName() + "_2", "inventory");
        ModelResourceLocation icons_3 = new ModelResourceLocation(SHOJI.getRegistryName() + "_3", "inventory");
        ModelResourceLocation icons_4 = new ModelResourceLocation(SHOJI.getRegistryName() + "_4", "inventory");
        ModelResourceLocation icons_5 = new ModelResourceLocation(SHOJI.getRegistryName() + "_5", "inventory");
        ModelBakery.registerItemVariants(Item.getItemFromBlock(SHOJI),
        		icons_0,
        		icons_1,
        		icons_2,
        		icons_3,
        		icons_4,
        		icons_5
        		);
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(SHOJI), stack -> {
            switch (RecipesUtil.getItemTagCompound(stack).getInteger("type")) {
                case 0:
                default:
                    return icons_0;
                case 1:
                    return icons_1;
                case 2:
                    return icons_2;
                case 3:
                    return icons_3;
                case 4:
                    return icons_4;
                case 5:
                    return icons_5;    
            }
        });
		
	}

	public static Block registerFluidBlock(Fluid fluid, Block fluidBlock, String name) {
		fluidBlock.setRegistryName(new ResourceLocation(SakuraMain.MODID, name));
		ForgeRegistries.BLOCKS.register(fluidBlock);
		fluid.setBlock(fluidBlock);
		return fluidBlock;
	}

	@SideOnly(Side.CLIENT)
	public static void registerFluidBlockRendering(Block block, String name) {
		final ModelResourceLocation fluidLocation = new ModelResourceLocation(SakuraMain.MODID + ":fluids", name);
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return fluidLocation;
			}
		});
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRender(Block block) {
		ModelResourceLocation model = new ModelResourceLocation(SakuraMain.MODID + ":" + block.getRegistryName().getResourcePath(), "inventory");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
	}


	@SideOnly(Side.CLIENT)
	public static void registerCakeRender(Block block, String name) {
		JSON_Creator.genCake(block.getRegistryName().toString().substring(1 + SakuraMain.MODID.length()), name, "json_create");
		ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
	}

	@SideOnly(Side.CLIENT)
	public static void registerRender(Block block, String name) {
		JSON_Creator.genBlock(block.getRegistryName().toString().substring(1 + SakuraMain.MODID.length()), name, "json_create");
		ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
	}
}
