package cn.mcmod.sakura.block;

import java.util.Random;

import cn.mcmod.sakura.SakuraConfig;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod_mmf.mmlib.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTataraSmelting extends BlockBase {
	public static final PropertyInteger Timer = PropertyInteger.create("timer", 0, 3);
	public BlockTataraSmelting() {
		super(Material.IRON,true);
		this.setDefaultState(this.blockState.getBaseState().withProperty(this.getTimerProperty(), Integer.valueOf(0)));
		this.setTickRandomly(true);
		this.setHarvestLevel("forging_hammer", 1);
	}
    public PropertyInteger getTimerProperty(){
        return Timer;
    }
    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
    		int fortune) {
        drops.clear();
        if(!isFinished(state)){ 
        	drops.add(new ItemStack(BlockLoader.TATARA));
        	return ;
        }
        Random rand = world instanceof World ? ((World)world).rand : RANDOM;
        if (rand.nextInt(9) == 0){
        	for (int i = 0; i < 2 + fortune; ++i){
            	if (rand.nextInt(1) == 0){
            		 drops.add(new ItemStack(ItemLoader.MATERIAL, 1, 55));
                }
            }
           
        } else
        for (int i = 0; i < 9 + fortune; ++i){
        	switch (SakuraConfig.harder_iron_difficult) {
			case 1:
	        	if (rand.nextInt(9) <= 7){
	                drops.add(new ItemStack(ItemLoader.MATERIAL, 1, 54));
	            }
				break;
			case 2:
	        	if (rand.nextInt(9) <= 7){
	                drops.add(new ItemStack(ItemLoader.MATERIAL, 1, 53));
	            }
				break;
			default:
	        	if (rand.nextInt(9) <= 7){
	                drops.add(new ItemStack(ItemLoader.MATERIAL, 1, 52));
	            }
				break;
			}
        }
    }
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
        super.updateTick(worldIn, pos, state, rand);

        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
            int i = this.getTime(state);
            setSmelting(worldIn, pos);
            if (i < this.getFinishTime()){
                if(rand.nextInt(1) == 0){
                    worldIn.setBlockState(pos, this.withTime(i + 1), 2);
                }
            }
    }
    
    public int getFinishTime(){
        return 3;
    }

    protected int getTime(IBlockState state){
        return state.getValue(this.getTimerProperty()).intValue();
    }

    public IBlockState withTime(int age){
        return this.getDefaultState().withProperty(this.getTimerProperty(), Integer.valueOf(age));
    }

    public boolean isFinished(IBlockState state){
        return state.getValue(this.getTimerProperty()).intValue() >= this.getFinishTime();
    }
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.withTime(meta);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return this.getTime(state);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {Timer});
    }
	private void setSmelting(World worldIn, BlockPos pos) {
        if(worldIn.getBlockState(pos.up()).getBlock() == BlockLoader.TATARA)
    		worldIn.setBlockState(pos.up(), this.withTime(0), 2);
        if(worldIn.getBlockState(pos.down()).getBlock() == BlockLoader.TATARA)
    		worldIn.setBlockState(pos.down(), this.withTime(0), 2);
        if(worldIn.getBlockState(pos.east()).getBlock() == BlockLoader.TATARA)
    		worldIn.setBlockState(pos.east(), this.withTime(0), 2);
        if(worldIn.getBlockState(pos.north()).getBlock() == BlockLoader.TATARA)
    		worldIn.setBlockState(pos.north(), this.withTime(0), 2);
        if(worldIn.getBlockState(pos.west()).getBlock() == BlockLoader.TATARA)
    		worldIn.setBlockState(pos.west(), this.withTime(0), 2);
        if(worldIn.getBlockState(pos.south()).getBlock() == BlockLoader.TATARA)
    		worldIn.setBlockState(pos.south(), this.withTime(0), 2);
	}
}
