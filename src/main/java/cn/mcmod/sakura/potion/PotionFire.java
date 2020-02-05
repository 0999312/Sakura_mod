package cn.mcmod.sakura.potion;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionFire extends Potion {

	protected PotionFire() {
		super(false, 0Xff2222);
		setPotionName("sakura.effect.fire_blade");
		setRegistryName(SakuraMain.MODID, "fire_blade");

	}
	@SubscribeEvent
	public void onAttacking(AttackEntityEvent event) {
		if(event.getTarget() instanceof EntityLivingBase){
			EntityLivingBase target = (EntityLivingBase) event.getTarget();
			EntityPlayer player = event.getEntityPlayer();
			if(player.isPotionActive(this)){
				target.setFire(600);
			}
		}
	}
	  @SideOnly(Side.CLIENT)
	  public void renderInventoryEffect(int ix, int iy, PotionEffect effect, Minecraft mc)
	  {
	    mc.getTextureManager().bindTexture(PotionLoader.res);
	    mc.currentScreen.drawTexturedModalRect(ix + 6, iy + 7, 36, 18, 18, 18);
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public void renderHUDEffect(int ix, int iy, PotionEffect effect, Minecraft mc, float alpha)
	  {
	    mc.getTextureManager().bindTexture(PotionLoader.res);
	    Gui.drawModalRectWithCustomSizedTexture(ix + 3, iy + 3, 36, 18, 18, 18, 256.0F, 256.0F);
	  }
	  
}
