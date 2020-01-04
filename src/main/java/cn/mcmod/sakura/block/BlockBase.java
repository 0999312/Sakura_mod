package cn.mcmod.sakura.block;

import cn.mcmod.sakura.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBase extends Block{
    public BlockBase(Material material) {
        super(material);
        this.setCreativeTab(CommonProxy.tab);
    }
    
	@Override
	public Block setSoundType(SoundType sound) {
		return super.setSoundType(sound);
	}
}
