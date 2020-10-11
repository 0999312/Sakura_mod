package cn.mcmod.sakura.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemBuggysMeat extends ItemFood {
    public ItemBuggysMeat(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setUnlocalizedName("sakura.buggys_meat");
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (flagIn.isAdvanced()) {
            tooltip.add("Meat that bagu_chan seems to like UwU");
            tooltip.add("But Syameimaru doesn't OmO");
        }
    }
    
    public int getMaxItemUseDuration(ItemStack stack) {
        return 38;
    }
}
