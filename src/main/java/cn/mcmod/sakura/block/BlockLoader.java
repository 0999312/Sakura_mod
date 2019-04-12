package cn.mcmod.sakura.block;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.door.BlockDoorBase;
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

	public BlockLoader(FMLPreInitializationEvent event) {
//		register blocks
		register(BAMBOO, new ItemBlock(BAMBOO), "bamboo");
		register(BAMBOOSHOOT, new ItemBlock(BAMBOOSHOOT), "bamboo_shoot");
		register(BAMBOO_BLOCK, new ItemBlock(BAMBOO_BLOCK), "bamboo_block");
		register(BAMBOO_SLAB, new ItemSlabBase(BAMBOO_SLAB), "bamboo_slab");
		register(BAMBOOLANTERN, new ItemBlock(BAMBOOLANTERN), "bamboo_lantern");
		registerNoItem(BAMBOODOOR, "bamboo_door");
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
		registerRender(BAMBOO_BLOCK);
		registerRender(BAMBOO_SLAB);
		registerRender(BAMBOOSHOOT);
		registerRender(BAMBOOLANTERN);
		registerRender(BAMBOODOOR);
	}

	public static Block registerFluidBlock(Fluid fluid, Block fluidBlock, String name) {
		fluidBlock.setRegistryName(new ResourceLocation(SakuraMain.MODID, name));
		ForgeRegistries.BLOCKS.register(fluidBlock);
		fluid.setBlock(fluidBlock);
		return fluidBlock;
	}

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
