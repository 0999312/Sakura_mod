package cn.mcmod.sakura.block.door;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockDoorBase extends BlockDoor {
    public BlockDoorBase(Material materialIn) {
        super(materialIn);
        this.setCreativeTab(CommonProxy.tab);
        this.setHardness(1.6F);
        this.setResistance(6.0F);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : this.getItem();
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this.getItem());
    }


    private Item getItem()
    {
        if(this == BlockLoader.BAMBOODOOR){
            return ItemLoader.BAMBOO_DOOR;
        }else {
            return ItemLoader.BAMBOO_DOOR;
        }
    }
}
