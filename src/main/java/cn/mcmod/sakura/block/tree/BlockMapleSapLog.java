package cn.mcmod.sakura.block.tree;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMapleSapLog extends Block {
    public static final PropertyInteger SAP_AGE = PropertyInteger.create("sap_age", 0, 5);

    public BlockMapleSapLog() {
        super(Material.WOOD);
        this.setCreativeTab(CommonProxy.tab);
        this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(SAP_AGE, 0));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        }
		int j = state.getValue(SAP_AGE).intValue();
		ItemStack stack = playerIn.getHeldItem(hand);
		if (stack.getItem() == Items.GLASS_BOTTLE&& j < 5) {
		    ItemStack itemstack3 =new ItemStack(ItemLoader.MAPLE_SYRUP);
		    if (!playerIn.capabilities.isCreativeMode) {
		        stack.shrink(1);
		    }

		    if (stack.isEmpty()) {
		        playerIn.setHeldItem(hand, itemstack3);
		    } else if (!playerIn.inventory.addItemStackToInventory(itemstack3)) {
		        playerIn.dropItem(itemstack3, false);
		    } else if (playerIn instanceof EntityPlayerMP) {
		        ((EntityPlayerMP) playerIn).sendContainerToPlayer(playerIn.inventoryContainer);
		    }

		    if(worldIn.rand.nextInt(2) == 0) {
		        worldIn.setBlockState(pos, state.withProperty(SAP_AGE, Integer.valueOf(j + 1)), 4);
		    }
		    worldIn.playSound((EntityPlayer) null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

		    return true;
		}
		return true;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockLoader.MAPLE_LOG);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(SAP_AGE, Integer.valueOf(meta));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, SAP_AGE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(SAP_AGE).intValue();
    }

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return true;
    }

    @Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 5;
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 5;
    }
}
