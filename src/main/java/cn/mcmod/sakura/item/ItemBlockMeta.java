package cn.mcmod.sakura.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockMeta extends ItemBlock {
	
	public ItemBlockMeta(Block block) {
		super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}
    /**
     * Converts the given ItemStack damage value into a metadata value to be placed in the world when this Item is
     * placed as a Block (mostly used with ItemBlocks).
     */
	@Override
    public int getMetadata(int damage)
    {
        return damage;
    }

}
