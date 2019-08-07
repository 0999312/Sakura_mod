package cn.mcmod.sakura.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSakuraPlank extends Block {
    public BlockSakuraPlank(Material wood) {
        super(wood);
        this.setSoundType(SoundType.WOOD);
    }
}
