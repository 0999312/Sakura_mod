package cn.mcmod.sakura.block.slab;

import net.minecraft.block.material.Material;

public class BlockBambooSlab extends BlockSlabBase{
    public BlockBambooSlab(Material material) {
        super(material);
        this.setHardness(1.6F);
        this.setResistance(6.0F);
    }
}
