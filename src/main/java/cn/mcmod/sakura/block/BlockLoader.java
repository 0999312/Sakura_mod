package cn.mcmod.sakura.block;

import java.util.Random;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.crop.*;
import cn.mcmod.sakura.block.door.BlockDoorBase;
import cn.mcmod.sakura.block.door.BlockShoji;
import cn.mcmod.sakura.block.fluid.BlockFluidBasic;
import cn.mcmod.sakura.block.fluid.FluidBasic;
import cn.mcmod.sakura.block.foods.BlockTeishokoFinished;
import cn.mcmod.sakura.block.foods.BlockTeishoku;
import cn.mcmod.sakura.block.noodles.BlockPasta;
import cn.mcmod.sakura.block.noodles.BlockRamen;
import cn.mcmod.sakura.block.noodles.BlockSoba;
import cn.mcmod.sakura.block.noodles.BlockUdon;
import cn.mcmod.sakura.block.noodles.BlockUdonUnfinished;
import cn.mcmod.sakura.block.slab.*;
import cn.mcmod.sakura.block.tree.*;
import cn.mcmod_mmf.mmlib.block.BlockBase;
import cn.mcmod_mmf.mmlib.block.BlockFacing;
import cn.mcmod_mmf.mmlib.block.slab.BlockCarpetFacing;
import cn.mcmod_mmf.mmlib.block.slab.BlockHalfFacing;
import cn.mcmod_mmf.mmlib.block.slab.BlockSlabBase;
import cn.mcmod_mmf.mmlib.item.ItemSlabBase;
import cn.mcmod_mmf.mmlib.register.BlockRegister;
import cn.mcmod_mmf.mmlib.util.RecipesUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader {
	public static Fluid FOODOIL_FLUID = new FluidBasic("food_oil");
	public static Block FOODOIL;
	public static Fluid YEAST_FLUID = new FluidBasic("yeast_liquid");
	public static Block YEAST_LIQUID;
	public static Fluid MAPLE_SYRUP_FLUID = new FluidBasic("maple_syrup");
	public static Block MAPLE_SYRUP;
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
	
	public static Fluid HOT_SPRING_WATER_FLUID = new FluidBasic("hot_spring_water");
	public static Block HOT_SPRING_WATER;
	
    public static Block BAMBOO = new BlockPlantBamboo();
    public static Block WINDBELL = new BlockWindBell();
    public static BlockBambooShoot BAMBOOSHOOT = new BlockBambooShoot();
    public static Block BAMBOO_BLOCK = new BlockBambooBlock(Material.WOOD,false).setHardness(1.6F).setResistance(6.0F);
    public static Block BAMBOO_BLOCK_SUNBURNT = new BlockBambooBlock(Material.WOOD,true).setHardness(1.6F).setResistance(5.5F);
    public static Block BAMBOO_CHARCOAL_BLOCK = new BlockBambooBlock(Material.WOOD,true).setHardness(1F).setResistance(5F);
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
	public static Block MAPLE_CAULDRON = new BlockMapleSyrupCauldron();
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
	public static Block PASTA_BLOCK = new BlockPasta();
	
	public static Block STRAW_BLOCK = new BlockBase(Material.CLOTH,true).setSoundType(SoundType.PLANT).setHardness(0.25F).setResistance(0.5F);
	public static Block STRAW_BLOCK_STAIR = new BlockStairBasic(STRAW_BLOCK.getDefaultState());
	public static Block SAKURA_PLANK_STAIR = new BlockStairBasic(SAKURA_PLANK.getDefaultState());
	public static Block BAMBOO_PLANK_STAIR = new BlockStairBasic(BAMBOO_PLANK.getDefaultState());
	public static Block MAPLE_PLANK_STAIR = new BlockStairBasic(MAPLE_PLANK.getDefaultState());
	public static Block BAMBOO_STAIR = new BlockStairBasic(BAMBOO_BLOCK.getDefaultState());
	public static Block BAMBOO_SUNBURNT_STAIR = new BlockStairBasic(BAMBOO_BLOCK_SUNBURNT.getDefaultState());
	
	public static Block STRAW_BLOCK_SLAB = new BlockBambooSlab(Material.WOOD).setSoundType(SoundType.PLANT).setHardness(0.25F).setResistance(0.5F);
	public static Block SAKURA_PLANK_SLAB = new BlockBambooSlab(Material.WOOD);
	public static Block BAMBOO_PLANK_SLAB = new BlockBambooSlab(Material.WOOD);
	public static Block MAPLE_PLANK_SLAB = new BlockBambooSlab(Material.WOOD);
	
	public static Block FALLEN_LEAVES_MAPLE_RED =new BlockFallenLeaves(Material.LEAVES).setSoundType(SoundType.PLANT).setHardness(0.15F).setResistance(0.2F);
	public static Block FALLEN_LEAVES_MAPLE_GREEN =new BlockFallenLeaves(Material.LEAVES).setSoundType(SoundType.PLANT).setHardness(0.15F).setResistance(0.2F);
	public static Block FALLEN_LEAVES_MAPLE_YELLOW =new BlockFallenLeaves(Material.LEAVES).setSoundType(SoundType.PLANT).setHardness(0.15F).setResistance(0.2F);
	public static Block FALLEN_LEAVES_MAPLE_ORANGE =new BlockFallenLeaves(Material.LEAVES).setSoundType(SoundType.PLANT).setHardness(0.15F).setResistance(0.2F);
	
	public static Block MAPLE_SPILE = new BlockMapleSpile();
	public static Block TAIKO = new BlockTaiko();
	public static Block OBON = new BlockOben();
	public static Block TATARA = new BlockTatara().setHardness(1.75F).setResistance(10.0F);
	public static Block TATARA_SMELTING = new BlockTataraSmelting().setHardness(1.75F).setResistance(10.0F);
	public static BlockBase IRON_SAND = (BlockBase) new BlockBase(Material.SAND,true).setSoundType(SoundType.SAND).setHardness(1.25F).setResistance(5.0F);

	public static Block NOREN_WHITE = new BlockNoren();
	public static Block NOREN_BLUE = new BlockNoren();
	public static Block NOREN_PINK = new BlockNoren();
	public static Block FUTON = new BlockFuton();
	public static Block ZABUTON = new BlockZabuton();
	
	public static BlockBase STONE_LANTERN =  (BlockBase)new BlockBase(Material.ROCK,false).setSoundType(SoundType.STONE).setHardness(1.25F).setResistance(5.0F).setLightLevel(1F);
	public static BlockBase MOSSY_STONE_LANTERN =  (BlockBase)new BlockBase(Material.ROCK,false).setSoundType(SoundType.STONE).setHardness(1.25F).setResistance(5.0F).setLightLevel(1F);
	public static BlockBase COBBLESTONE_LANTERN =  (BlockBase)new BlockBase(Material.ROCK,false).setSoundType(SoundType.STONE).setHardness(1.25F).setResistance(5.0F).setLightLevel(1F);
	
	public static Block RED_LANTERN =  new BlockPaperLantern();
	public static Block WHITE_LANTERN =  new BlockPaperLantern();
	
	public static Block TEISHOKO_FISH_COOKED =  new BlockTeishoku(8, 0.8f, false);
	public static Block TEISHOKO_FISH_RAW =  new BlockTeishoku(6, 0.8f, false);
	public static Block TEISHOKO_YAKINIKKU =  new BlockTeishoku(8, 0.8f, false);
	public static Block TEISHOKO_TAMAGOYAKI =  new BlockTeishoku(6, 0.8f, false);
	
	public static Block TEISHOKO_TEMPURA =  new BlockTeishoku(8, 0.8f, false);
	public static Block TEISHOKO_FRIED =  new BlockTeishoku(8, 0.8f, false);
	public static Block TEISHOKO_KATSU =  new BlockTeishoku(10, 0.8f, false);
	public static Block TEISHOKO_BURGER =  new BlockTeishoku(8, 0.8f, false);
	
	public static Block SUSHI_PLATE =  new BlockTeishoku(6, 0.8f, true);
	public static Block TEMPURA_PLATE =  new BlockTeishoku(6, 0.8f, true);
	
	public static Block TEISHOKO_FINISHED =  new BlockTeishokoFinished();
	public static Block MUSHROOM_FALLEN_LEAVES =  new BlockMushroomBush();
	public static Block STRAW_WEB = new BlockStrawWeb();
	
	public static Block HOPS = new BlockHopsCrop();
	public static Block SEAWEED = new BlockSeaweedCrop();
	public BlockLoader(FMLPreInitializationEvent event) {
//		register blocks
//		DON'T REGISTER RENDERS IN THIS VOID,PLEASE!!!

		FluidRegistry.addBucketForFluid(HOT_SPRING_WATER_FLUID);
		HOT_SPRING_WATER=registerFluidBlock(HOT_SPRING_WATER_FLUID, new BlockFluidBasic(HOT_SPRING_WATER_FLUID){
		    @Override
		    public void onEntityCollidedWithBlock(World par1World, BlockPos pos, IBlockState state, Entity par5Entity) {
		        if (!par1World.isRemote) {
		            if (par5Entity instanceof EntityLivingBase) {
		                EntityLivingBase entityLiving = (EntityLivingBase)par5Entity;
		                if (entityLiving.ticksExisted % 20 == 0) {
								entityLiving.heal(0.5f);
		                }
		            }
		        }
		    }
		    
			@Override
			@SideOnly(Side.CLIENT)
			public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
	        if (world.isAirBlock(pos.up())) {
		                double d0 = pos.getX() + rand.nextDouble();
		                double d1 = pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
		                double d2 = pos.getZ() + rand.nextDouble();
		                world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	            }
			}
		}, "hot_spring_water");
		FluidRegistry.addBucketForFluid(FOODOIL_FLUID);
		FOODOIL=registerFluidBlock(FOODOIL_FLUID, new BlockFluidBasic(FOODOIL_FLUID), "foodoil");
		FluidRegistry.addBucketForFluid(YEAST_FLUID);
		YEAST_LIQUID=registerFluidBlock(YEAST_FLUID, new BlockFluidBasic(YEAST_FLUID), "yeast_liquid");
		FluidRegistry.addBucketForFluid(MAPLE_SYRUP_FLUID);
		MAPLE_SYRUP=registerFluidBlock(MAPLE_SYRUP_FLUID, new BlockFluidBasic(MAPLE_SYRUP_FLUID), "maple_syrup");
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
		IRON_SAND.setHarvestLevel("shovel", 1);

		register(IRON_SAND, new ItemBlock(IRON_SAND), "iron_sand");
        register(KAWARA_BLOCK, new ItemBlock(KAWARA_BLOCK), "kawara_block");
        register(KAWARA, new ItemBlock(KAWARA), "kawara");
        register(BAMBOO, new ItemBlock(BAMBOO), "bamboo");
        register(RAMEN_BLOCK, new ItemBlock(RAMEN_BLOCK), "ramen_block");
        register(UDON_UNFINISHED, new ItemBlock(UDON_UNFINISHED), "udon_unfinished_block");
        registerNoItem(UDON_BLOCK, "udon_block");
        register(SOBA_BLOCK, new ItemBlock(SOBA_BLOCK), "soba_block");
        register(PASTA_BLOCK, new ItemBlock(PASTA_BLOCK), "pasta_block");
        register(BAMBOOSHOOT, new ItemBlock(BAMBOOSHOOT), "bamboo_shoot");
        register(BAMBOO_PLANK, new ItemBlock(BAMBOO_PLANK), "plank_bamboo");
        register(BAMBOO_PLANK_STAIR, new ItemBlock(BAMBOO_PLANK_STAIR), "stairs_plank_bamboo");
        register(BAMBOO_PLANK_SLAB, new ItemBlock(BAMBOO_PLANK_SLAB), "slab_plank_bamboo");
        register(BAMBOO_BLOCK, new ItemBlock(BAMBOO_BLOCK), "bamboo_block");
        register(BAMBOO_CHARCOAL_BLOCK, new ItemBlock(BAMBOO_CHARCOAL_BLOCK), "bamboo_charcoal_block");
        register(BAMBOO_BLOCK_SUNBURNT, new ItemBlock(BAMBOO_BLOCK_SUNBURNT), "bamboo_block_sunburnt");
        register(BAMBOO_STAIR, new ItemBlock(BAMBOO_STAIR), "bamboo_stair");
        register(BAMBOO_SUNBURNT_STAIR, new ItemBlock(BAMBOO_SUNBURNT_STAIR), "bamboo_stair_sunburnt");
        register(BAMBOO_SLAB, new ItemSlabBase(BAMBOO_SLAB), "bamboo_slab");
        register(BAMBOO_SLAB_SUNBURNT, new ItemSlabBase(BAMBOO_SLAB_SUNBURNT), "bamboo_slab_sunburnt");
		register(BAMBOO_FENCE, new ItemBlock(BAMBOO_FENCE), "bamboo_fence");
	    register(BAMBOO_FENCE_SUNBURNT, new ItemBlock(BAMBOO_FENCE_SUNBURNT), "bamboo_fence_sunburnt");

        register(BAMBOOLANTERN, new ItemBlock(BAMBOOLANTERN), "bamboo_lantern");
        register(WINDBELL, new ItemBlock(WINDBELL), "windbell");
        register(STONE_LANTERN, new ItemBlock(STONE_LANTERN), "stone_lantern");
        register(COBBLESTONE_LANTERN, new ItemBlock(COBBLESTONE_LANTERN), "cobblestone_lantern");
        register(MOSSY_STONE_LANTERN, new ItemBlock(MOSSY_STONE_LANTERN), "mossy_stone_lantern");
        register(RED_LANTERN, new ItemBlock(RED_LANTERN), "red_lantern");
        register(WHITE_LANTERN, new ItemBlock(WHITE_LANTERN), "white_lantern");
        register(STRAW_BLOCK, new ItemBlock(STRAW_BLOCK), "straw_block");
        register(STRAW_BLOCK_STAIR, new ItemBlock(STRAW_BLOCK_STAIR), "straw_stair");
        register(STRAW_BLOCK_SLAB, new ItemBlock(STRAW_BLOCK_SLAB), "slab_straw_block");
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
		register(MAPLE_CAULDRON, new ItemBlock(MAPLE_CAULDRON), "maple_cauldron");
		register(MAPLE_SAPLING_RED, new ItemBlock(MAPLE_SAPLING_RED), "maple_sapling_red");
		register(MAPLE_LEAVE_RED, new ItemBlock(MAPLE_LEAVE_RED), "maple_leaves_red");
		register(FALLEN_LEAVES_MAPLE_RED, new ItemBlock(FALLEN_LEAVES_MAPLE_RED), "fallen_leaves_red");
		register(MAPLE_SAPLING_YELLOW, new ItemBlock(MAPLE_SAPLING_YELLOW), "maple_sapling_yellow");
		register(MAPLE_LEAVE_YELLOW, new ItemBlock(MAPLE_LEAVE_YELLOW), "maple_leaves_yellow");
		register(FALLEN_LEAVES_MAPLE_YELLOW, new ItemBlock(FALLEN_LEAVES_MAPLE_YELLOW), "fallen_leaves_yellow");
		register(MAPLE_SAPLING_ORANGE, new ItemBlock(MAPLE_SAPLING_ORANGE), "maple_sapling_orange");
		register(MAPLE_LEAVE_ORANGE, new ItemBlock(MAPLE_LEAVE_ORANGE), "maple_leaves_orange");
		register(FALLEN_LEAVES_MAPLE_ORANGE, new ItemBlock(FALLEN_LEAVES_MAPLE_ORANGE), "fallen_leaves_orange");
		register(MAPLE_SAPLING_GREEN, new ItemBlock(MAPLE_SAPLING_GREEN), "maple_sapling_green");
		register(MAPLE_LEAVE_GREEN, new ItemBlock(MAPLE_LEAVE_GREEN), "maple_leaves_green");
		register(FALLEN_LEAVES_MAPLE_GREEN, new ItemBlock(FALLEN_LEAVES_MAPLE_GREEN), "fallen_leaves_green");
		register(MAPLE_LOG, new ItemBlock(MAPLE_LOG), "maple_log");
		register(MAPLE_LOG_SAP, new ItemBlock(MAPLE_LOG_SAP), "maple_log_sap");
        register(MAPLE_PLANK, new ItemBlock(MAPLE_PLANK), "plank_maple");
        register(MAPLE_PLANK_STAIR, new ItemBlock(MAPLE_PLANK_STAIR), "stairs_plank_maple");
        register(MAPLE_PLANK_SLAB, new ItemBlock(MAPLE_PLANK_SLAB), "slab_plank_maple");
        register(SAKURA_LEAVES, new ItemBlock(SAKURA_LEAVES), "sakuraleaves");
		register(SAKURA_SAPLING, new ItemBlock(SAKURA_SAPLING), "sakura_sapling");
		register(SAKURA_LOG, new ItemBlock(SAKURA_LOG), "sakura_log");
        register(SAKURA_PLANK, new ItemBlock(SAKURA_PLANK), "plank_sakura");
        register(SAKURA_PLANK_STAIR, new ItemBlock(SAKURA_PLANK_STAIR), "stairs_plank_sakura");
        register(SAKURA_PLANK_SLAB, new ItemBlock(SAKURA_PLANK_SLAB), "slab_plank_sakura");
        register(TATARA, new ItemBlock(TATARA), "tatara");
        registerNoItem(TATARA_SMELTING,"tatara_smelting");
        register(MAPLE_SPILE, new ItemBlock(MAPLE_SPILE), "maple_spile");
        register(OBON, new ItemBlock(OBON), "obon");
        register(STONEMORTAR, new ItemBlock(STONEMORTAR), "stone_mortar");
        register(STRAW_WEB, new ItemBlock(STRAW_WEB), "straw_web");
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
        register(TAIKO, new ItemBlock(TAIKO), "taiko");
        register(ZABUTON, new ItemBlock(ZABUTON), "zabuton");
        register(NOREN_WHITE, new ItemBlock(NOREN_WHITE), "noren_white");
		register(NOREN_BLUE, new ItemBlock(NOREN_BLUE), "noren_blue");
		register(NOREN_PINK, new ItemBlock(NOREN_PINK), "noren_pink");
		register(SAKURA_DIAMOND_ORE, new ItemBlock(SAKURA_DIAMOND_ORE), "sakura_diamond_ore");
	    register(TEISHOKO_FISH_COOKED, new ItemBlock(TEISHOKO_FISH_COOKED), "teishoku_fish_cooked");
	    register(TEISHOKO_FISH_RAW, new ItemBlock(TEISHOKO_FISH_RAW), "teishoku_fish_raw");
	    register(TEISHOKO_YAKINIKKU, new ItemBlock(TEISHOKO_YAKINIKKU), "teishoku_yakiniku");
	    register(TEISHOKO_TAMAGOYAKI, new ItemBlock(TEISHOKO_TAMAGOYAKI), "teishoku_tamagoyaki");
	    
	    register(TEISHOKO_FRIED, new ItemBlock(TEISHOKO_FRIED), "teishoku_fried");
	    register(TEISHOKO_TEMPURA, new ItemBlock(TEISHOKO_TEMPURA), "teishoku_tempura");
	    register(TEISHOKO_BURGER, new ItemBlock(TEISHOKO_BURGER), "teishoku_burger");
	    register(TEISHOKO_KATSU, new ItemBlock(TEISHOKO_KATSU), "teishoku_katsu");
	    
	    register(SUSHI_PLATE, new ItemBlock(SUSHI_PLATE), "sushi_plate");
	    register(TEMPURA_PLATE, new ItemBlock(TEMPURA_PLATE), "tempura_plate");
	    
	    register(MUSHROOM_FALLEN_LEAVES, new ItemBlock(MUSHROOM_FALLEN_LEAVES), "mushroom_fallen_leaves");
	    
	    registerNoItem(TEISHOKO_FINISHED, "teishoku_finished");
	    registerNoItem(HOPS, "hops");
	    registerNoItem(SEAWEED, "seaweed");
	    registerNoItem(FUTON, "futon");
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
		block.setCreativeTab(CommonProxy.tab);
		BlockRegister.register(SakuraMain.MODID, block, itemBlock, string);
	}

	private static void registerNoItem(Block block, String string) {
		BlockRegister.registerNoItem(SakuraMain.MODID, block, string);
	}

	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
//		please register blocks' renders in THIS void!
		registerRender(MUSHROOM_FALLEN_LEAVES);
		registerRender(STRAW_WEB);
		registerRender(TEISHOKO_FRIED);
		registerRender(TEISHOKO_TEMPURA);
	    registerRender(TEISHOKO_BURGER);
	    registerRender(TEISHOKO_KATSU);
	    registerRender(SUSHI_PLATE);
	    registerRender(TEMPURA_PLATE);
	    
		registerRender(ZABUTON);
		registerRender(TEISHOKO_YAKINIKKU);
		registerRender(TEISHOKO_TAMAGOYAKI);
		registerRender(TEISHOKO_FISH_RAW);
		registerRender(TEISHOKO_FISH_COOKED);
		registerRender(RED_LANTERN);
		registerRender(WHITE_LANTERN);
		registerRender(STONE_LANTERN);
		registerRender(COBBLESTONE_LANTERN);
		registerRender(MOSSY_STONE_LANTERN);
		registerRender(NOREN_WHITE);
		registerRender(NOREN_BLUE);
		registerRender(NOREN_PINK);
		registerRender(IRON_SAND);
		registerRender(PASTA_BLOCK);
		registerRender(TAIKO);
		registerRender(BAMBOO_CHARCOAL_BLOCK);
		registerRender(TATARA);
		registerRender(TATARA_SMELTING);
		registerRender(OBON);
		registerRender(FALLEN_LEAVES_MAPLE_GREEN);
		registerRender(FALLEN_LEAVES_MAPLE_ORANGE);
		registerRender(FALLEN_LEAVES_MAPLE_RED);
		registerRender(FALLEN_LEAVES_MAPLE_YELLOW);
		
		registerRender(MAPLE_SPILE);
		registerRender(STRAW_BLOCK);
		registerRender(STRAW_BLOCK_STAIR);
		registerRender(SAKURA_PLANK_STAIR);
		registerRender(BAMBOO_PLANK_STAIR);
		registerRender(MAPLE_PLANK_STAIR);
		registerRender(BAMBOO_STAIR);
		registerRender(BAMBOO_SUNBURNT_STAIR);
		
		registerRender(STRAW_BLOCK_SLAB);
		registerRender(SAKURA_PLANK_SLAB);
		registerRender(BAMBOO_PLANK_SLAB);
		registerRender(MAPLE_PLANK_SLAB);
		
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
		registerFluidBlockRendering(YEAST_LIQUID, "yeast_liquid");
		registerFluidBlockRendering(LIQUEUR, "liqueur");
		registerFluidBlockRendering(HOT_SPRING_WATER, "hot_spring_water");
		registerFluidBlockRendering(FOODOIL, "food_oil");
		registerFluidBlockRendering(MAPLE_SYRUP, "maple_syrup");
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
		registerRender(MAPLE_CAULDRON);
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
	@SideOnly(Side.CLIENT)
	public static void registerRender(Block block, int i) {
		BlockRegister.registerRender(block,i);
	}

	public static Block registerFluidBlock(Fluid fluid, Block fluidBlock, String name) {
		return BlockRegister.registerFluidBlock(SakuraMain.MODID, fluid, fluidBlock, name);
	}

	@SideOnly(Side.CLIENT)
	public static void registerFluidBlockRendering(Block block, String name) {
		BlockRegister.registerFluidBlockRendering(SakuraMain.MODID, block, name);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRender(Block block) {
		BlockRegister.registerRender(block);
	}

	@SideOnly(Side.CLIENT)
	public static void registerCakeRender(Block block, String name) {
		BlockRegister.registerCakeRender(SakuraMain.MODID, block, name);
	}

	@SideOnly(Side.CLIENT)
	public static void registerRender(Block block, String name) {
		BlockRegister.registerRender(SakuraMain.MODID, block, name);
	}
}
