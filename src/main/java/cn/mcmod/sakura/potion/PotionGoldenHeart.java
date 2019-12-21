package cn.mcmod.sakura.potion;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionGoldenHeart extends Potion {
	public PotionGoldenHeart() {
		super(false, 0xFFDD00);
		setPotionName("sakura.effect.golden_heart");
		setRegistryName(SakuraMain.MODID, "golden_heart");
	}
	  @SideOnly(Side.CLIENT)
	  public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc)
	  {
	    mc.getTextureManager().bindTexture(PotionLoader.res);
	    mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 0, 36, 18, 18);
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha)
	  {
	    mc.getTextureManager().bindTexture(PotionLoader.res);
	    Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 36, 18, 18, 256.0F, 256.0F);
	  }
	  
	  @Override
		public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
		  if(entityLivingBaseIn instanceof EntityPlayer){
			  for(Potion potion : ForgeRegistries.POTIONS.getValuesCollection()){
				  if(potion.isBadEffect()&&potion!=ForgeRegistries.POTIONS.getValue(new ResourceLocation("minecraft", "nausea"))) entityLivingBaseIn.removePotionEffect(potion);
			  }
		  }
		}
	  @Override
	public boolean isReady(int duration, int amplifier) {
		return (duration & 1) == 0;
	}
}
