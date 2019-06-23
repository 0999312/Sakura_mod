package cn.mcmod.sakura.block;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.door.BlockDoorBase;
import cn.mcmod.sakura.block.maple.*;
import cn.mcmod.sakura.block.slab.BlockBambooSlab;
import cn.mcmod.sakura.block.slab.BlockSlabBase;
import cn.mcmod.sakura.item.ItemSlabBase;
import cn.mcmod.sakura.util.JSON_Creator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.GameData;

public class BlockLoader {
    public static Block BAMBOO = new BlockPlantBamboo();
    public static BlockBambooShoot BAMBOOSHOOT = new BlockBambooShoot();
    public static Block BAMBOO_BLOCK = new BlockBase(Material.WOOD).setHardness(1.6F).setResistance(6.0F);
    public static BlockSlabBase BAMBOO_SLAB = new BlockBambooSlab(Material.WOOD);
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
	public static Block MAPLE_SYRUP_CAUDRON = new BlockMapleSyrupCauldron();
	public static Block CAMPFIRE_IDLE = new BlockCampfire(false);
	public static Block CAMPFIRE_LIT = new BlockCampfire(true);
    public static Block CAMPFIRE_POT_IDLE = new BlockCampfirePot(false);
    public static Block CAMPFIRE_POT_LIT = new BlockCampfirePot(true);
	public static Block RICECROP = new BlockRiceCrop();
	public static Block STONEMORTAR = new BlockStoneMortar();
	public static Block TOMATOCROP = new BlockTomatoCrop();
	public static Block EGGPLANTCROP = new BlockEggplantCrop();
	public static Block CABBAGECROP = new BlockCabbageCrop();
	public static Block RADISHCROP = new BlockRadishCrop();
	public static Block REDBEANCROP = new BlockRedBeanCrop();
	public static Block BUCKWHEATCROP = new BlockBuckwheatCrop();
	
	public static Block CHESTNUTBURR = new BlockChestnut();
    public BlockLoader(FMLPreInitializationEvent event) {
//		register blocks
//		DON'T REGISTER RENDERS IN THIS VOID,PLEASE!!!
        register(BAMBOO, new ItemBlock(BAMBOO), "bamboo");
        register(BAMBOOSHOOT, new ItemBlock(BAMBOOSHOOT), "bamboo_shoot");
        register(BAMBOO_BLOCK, new ItemBlock(BAMBOO_BLOCK), "bamboo_block");
        register(BAMBOO_SLAB, new ItemSlabBase(BAMBOO_SLAB), "bamboo_slab");
        register(BAMBOOLANTERN, new ItemBlock(BAMBOOLANTERN), "bamboo_lantern");
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
		register(STONEMORTAR, new ItemBlock(STONEMORTAR), "stone_mortar");
		register(CAMPFIRE_IDLE, new ItemBlock(CAMPFIRE_IDLE), "campfire_idle");
		registerNoItem(CAMPFIRE_LIT,"campfire_lit");
        register(CAMPFIRE_POT_IDLE,new ItemBlock(CAMPFIRE_POT_IDLE), "campfire_pot_idle");
        registerNoItem(CAMPFIRE_POT_LIT, "campfire_pot_lit");
		registerNoItem(RICECROP, "ricecrop");
		registerNoItem(CHESTNUTBURR, "chestnut_burr");
		registerNoItem(TOMATOCROP, "tomatocrop");
		registerNoItem(EGGPLANTCROP, "eggplantcrop");
		registerNoItem(CABBAGECROP, "cabbagecrop");
		registerNoItem(RADISHCROP, "radishcrop");
		registerNoItem(REDBEANCROP, "redbeancrop");
		registerNoItem(BUCKWHEATCROP, "buckwheatcrop");
		registerNoItem(MAPLE_SYRUP_CAUDRON, "maple_syrup_caudron");
    }

	private static void register(Block block, Item itemBlock, String string) {
		block.setRegistryName(string);
		block.setUnlocalizedName(SakuraMain.MODID+"."+string);

		ForgeRegistries.BLOCKS.register(block);
		if (itemBlock != null) {
			itemBlock.setRegistryName(string);
			itemBlock.setUnlocalizedName(SakuraMain.MODID+"."+string);
			ForgeRegistries.ITEMS.register(itemBlock);
		}
		GameData.getBlockItemMap().put(block, itemBlock);
	}

	private static void registerNoItem(Block block, String string) {
		block.setRegistryName(string);
		block.setUnlocalizedName(SakuraMain.MODID+"."+string);

		ForgeRegistries.BLOCKS.register(block);
	}

	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
//		please register blocks' renders in THIS void!
		registerRender(BAMBOO);
		registerRender(BAMBOOSHOOT);
        registerRender(BAMBOOLANTERN);
        registerRender(BAMBOODOOR);
        registerRender(BAMBOO_BLOCK);
        registerRender(BAMBOO_SLAB);
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
		registerRender(MAPLE_SYRUP_CAUDRON);
		registerRender(STONEMORTAR);
		registerRender(CAMPFIRE_IDLE);
		registerRender(CAMPFIRE_LIT);
        registerRender(CAMPFIRE_POT_IDLE);
        registerRender(CAMPFIRE_POT_LIT);
		registerRender(RICECROP);
		registerRender(TOMATOCROP);
		registerRender(EGGPLANTCROP);
		registerRender(RADISHCROP);
		registerRender(REDBEANCROP);
		registerRender(BUCKWHEATCROP);
		registerRender(CHESTNUTBURR);
	}

	public static Block registerFluidBlock(Fluid fluid, Block fluidBlock, String name) {
		fluidBlock.setRegistryName(new ResourceLocation(SakuraMain.MODID, name));
		ForgeRegistries.BLOCKS.register(fluidBlock);
		fluid.setBlock(fluidBlock);
		return fluidBlock;
	}

	@SideOnly(Side.CLIENT)
	public static void registerFluidBlockRendering(Block block, String name) {
		final ModelResourceLocation fluidLocation = new ModelResourceLocation(SakuraMain.MODID.toLowerCase() + ":fluids", name);
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
