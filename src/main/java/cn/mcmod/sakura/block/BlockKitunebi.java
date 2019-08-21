package cn.mcmod.sakura.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockKitunebi extends Block {
	public static final PropertyBool ISVISIBLE = PropertyBool.create("isvisible");
	
	public BlockKitunebi() {
		super(Material.WOOD);
        setTickRandomly(true);
        setHardness(0.0F);
        setLightLevel(1F);
        setDefaultState(this.blockState.getBaseState().withProperty(ISVISIBLE, false));
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
    	return Block.NULL_AABB;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
    	return state.getValue(ISVISIBLE)?Block.FULL_BLOCK_AABB:new AxisAlignedBB(0, 0, 0, 0, 0, 0);
    }

    @Override
    protected BlockStateContainer createBlockState() {
    	return new BlockStateContainer(this,  new IProperty[] {ISVISIBLE});
    }
    
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
    	setVisibleFlg(worldIn, pos, stateIn);
    }
    
    private void setVisibleFlg(World world, BlockPos pos,IBlockState state) {
        world.setBlockState(pos, state.withProperty(ISVISIBLE, false));
    	EntityPlayer player = world.getClosestPlayer((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), 5.0D, false);
    	if(player ==null){
    		world.setBlockState(pos, state.withProperty(ISVISIBLE, false));
    		return;
    	}
        ItemStack is = player.getHeldItemMainhand();
        ItemStack offis =player.getHeldItemOffhand();
        if (!is.isEmpty()||!offis.isEmpty()) {
        	Item mainItem = is.getItem(),offItem=offis.getItem();
            if (mainItem instanceof ItemBlock||offItem instanceof ItemBlock) {
                if (Block.getBlockFromItem(mainItem) == this||Block.getBlockFromItem(offItem) == this) {
                    world.setBlockState(pos, state.withProperty(ISVISIBLE, true));
                }
            }
        }
    }
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(ISVISIBLE, meta>0?true:false);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(ISVISIBLE)?1:0;
    }
}
