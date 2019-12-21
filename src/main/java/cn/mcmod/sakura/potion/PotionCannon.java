package cn.mcmod.sakura.potion;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionCannon extends Potion {

	protected PotionCannon() {
		super(false, 0x000000);
		setPotionName("sakura.effect.cannon");
		setRegistryName(SakuraMain.MODID, "cannon");
	}
	@SubscribeEvent
	public void onAttacking(ArrowLooseEvent event) {
		EntityPlayer player = event.getEntityPlayer();
		if(player.isPotionActive(this)){
			event.setCharge(event.getCharge()+player.getActivePotionEffect(this).getAmplifier()*25);
			event.setResult(Result.ALLOW);
		}
	
	}
	  @SideOnly(Side.CLIENT)
	  public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc)
	  {
	    mc.getTextureManager().bindTexture(PotionLoader.res);
	    mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 0, 54, 18, 18);
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha)
	  {
	    mc.getTextureManager().bindTexture(PotionLoader.res);
	    Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 54, 18, 18, 256.0F, 256.0F);
	  }
	  
}
