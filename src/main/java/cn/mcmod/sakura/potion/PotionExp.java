package cn.mcmod.sakura.potion;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionExp extends Potion {

	protected PotionExp() {
		super(false, 0xff00ff);
		setPotionName("sakura.effect.exp_up");
		setRegistryName(SakuraMain.MODID, "exp_up");
	}
	@SubscribeEvent
	public void onDropExp(LivingExperienceDropEvent event) {
		if(event.getAttackingPlayer()!=null){
			EntityPlayer player = event.getAttackingPlayer();
			if(player.isPotionActive(this)){
				int exp =(event.getOriginalExperience()/2)*player.getActivePotionEffect(this).getAmplifier();
				event.setDroppedExperience(event.getOriginalExperience()+exp);
			}
		}
	}
	  @SideOnly(Side.CLIENT)
	  public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc)
	  {
	    mc.getTextureManager().bindTexture(PotionLoader.res);
	    mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 0, 0, 18, 18);
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha)
	  {
	    mc.getTextureManager().bindTexture(PotionLoader.res);
	    Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 256.0F, 256.0F);
	  }
	  
}
