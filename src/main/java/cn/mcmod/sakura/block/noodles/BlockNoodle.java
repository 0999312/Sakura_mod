package cn.mcmod.sakura.block.noodles;

import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockNoodle extends Block {

	public static final PropertyInteger CUTTING = PropertyInteger.create("cut", 0, 7);
	public static final AxisAlignedBB Noodle_AABB = new AxisAlignedBB(0.0625F, 0, 0.0625F, 0.9375F, 0.25F, 0.9375F);
	public BlockNoodle() {
		super(Material.CAKE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return Noodle_AABB;
	}
	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
		return Noodle_AABB;
	}
	
    protected PropertyInteger getAgeProperty()
    {
        return CUTTING;
    }
	
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState downState = worldIn.getBlockState(pos.down());
        return (downState.isTopSolid() || downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID) && super.canPlaceBlockAt(worldIn, pos);
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        IBlockState downState = worldIn.getBlockState(pos.down());
        return downState.isTopSolid() || downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID;
    }
    
    public boolean isReady(IBlockState state)
    {
        return state.getValue(this.getAgeProperty()).intValue() >= 7;
    }
    
    public abstract ItemStack getNoodle();
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
    		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	if (worldIn.isRemote) {
            return true;
        }
		int i = this.getCutting(state);
		ItemStack stack = playerIn.getHeldItem(hand);
		if(!isReady(state)){
		    if(stack.getItem()==ItemLoader.KNIFE_NOODLE||stack.getItem()==ItemLoader.SAKURA_KNIFE_NOODLE){
		    	if(!playerIn.isCreative()) stack.damageItem(1, playerIn);
		    	 if (worldIn.rand.nextInt(8) == 0) {
		    		 worldIn.setBlockState(pos, this.withCutting(i + 1), 2);
		    		 return true;
		    	 }
		    }
		}else{
			worldIn.setBlockToAir(pos);
			spawnAsEntity(worldIn, pos, getNoodle());
		}
		return true;
    }
    
    /**
     * Spawns the given ItemStack as an EntityItem into the World at the given position
     */
    public static void spawnAsEntity(World worldIn, BlockPos pos, ItemStack stack)
    {
        if (!worldIn.isRemote && !stack.isEmpty() && worldIn.getGameRules().getBoolean("doTileDrops")&& !worldIn.restoringBlockSnapshots) // do not drop items while restoring blockstates, prevents item dupe
        {
            if (captureDrops.get()){
                capturedDrops.get().add(stack);
                return;
            }
            double d0 = worldIn.rand.nextFloat() * 0.5F + 0.25D;
            double d1 = worldIn.rand.nextFloat() * 0.5F + 0.25D;
            double d2 = worldIn.rand.nextFloat() * 0.5F + 0.25D;
            EntityItem entityitem = new EntityItem(worldIn, pos.getX() + d0, pos.getY() + d1, pos.getZ() + d2, stack);
            entityitem.setDefaultPickupDelay();
            worldIn.spawnEntity(entityitem);
        }
    }

    
    protected int getCutting(IBlockState state)
    {
        return state.getValue(this.getAgeProperty()).intValue();
    }

    public IBlockState withCutting(int age)
    {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
    }
	
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.withCutting(meta);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return this.getCutting(state);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CUTTING});
    }
	@Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
