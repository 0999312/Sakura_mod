package cn.mcmod.sakura.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import java.util.HashMap;

public class ClientUtils {
    static HashMap<String, ResourceLocation> resourceMap = new HashMap<String, ResourceLocation>();
	public static float sysPartialTicks =0F;

    public static void bindTexture(String path) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(getResource(path));
    }

    public static ResourceLocation getResource(String path) {
        ResourceLocation rl = resourceMap.containsKey(path) ? resourceMap.get(path) : new ResourceLocation(path);
        if (!resourceMap.containsKey(path))
            resourceMap.put(path, rl);
        return rl;
    }

    public static void drawTexturedRect(float x, float y, float w, float h, double... uv) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder worldrenderer = tessellator.getBuffer();
        worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(x, y + h, 0).tex(uv[0], uv[3]).endVertex();
        worldrenderer.pos(x + w, y + h, 0).tex(uv[1], uv[3]).endVertex();
        worldrenderer.pos(x + w, y, 0).tex(uv[1], uv[2]).endVertex();
        worldrenderer.pos(x, y, 0).tex(uv[0], uv[2]).endVertex();
        tessellator.draw();
    }

    public static void drawRepeatedFluidSprite(FluidStack fluid, float x, float y, float w, float h) {

        bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE.toString());

        TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(fluid.getFluid().getStill(fluid).toString());

        if (sprite != null) {
            int col = fluid.getFluid().getColor(fluid);

            GlStateManager.color((col >> 16 & 255) / 255.0f, (col >> 8 & 255) / 255.0f, (col & 255) / 255.0f, 1);

            int iW = sprite.getIconWidth();

            int iH = sprite.getIconHeight();
            if (iW > 0 && iH > 0)
                drawRepeatedSprite(x, y, w, h, iW, iH, sprite.getMinU(), sprite.getMaxU(), sprite.getMinV(), sprite.getMaxV());
        }
    }

    public static void drawRepeatedSprite(float x, float y, float w, float h, int iconWidth, int iconHeight, float uMin, float uMax, float vMin, float vMax) {

        int iterMaxW = (int) (w / iconWidth);
        int iterMaxH = (int) (h / iconHeight);

        float leftoverW = w % iconWidth;
        float leftoverH = h % iconHeight;
        float leftoverWf = leftoverW / (float) iconWidth;
        float leftoverHf = leftoverH / (float) iconHeight;

        float iconUDif = uMax - uMin;
        float iconVDif = vMax - vMin;

        for (int ww = 0; ww < iterMaxW; ww++) {
            for (int hh = 0; hh < iterMaxH; hh++)
                drawTexturedRect(x + ww * iconWidth, y + hh * iconHeight, iconWidth, iconHeight, uMin, uMax, vMin, vMax);
            drawTexturedRect(x + ww * iconWidth, y + iterMaxH * iconHeight, iconWidth, leftoverH, uMin, uMax, vMin, (vMin + iconVDif * leftoverHf));
        }

        if (leftoverW > 0)

            for (int hh = 0; hh < iterMaxH; hh++)
                drawTexturedRect(x + iterMaxW * iconWidth, y + hh * iconHeight, leftoverW, iconHeight, uMin, (uMin + iconUDif * leftoverWf), vMin, vMax);
        drawTexturedRect(x + iterMaxW * iconWidth, y + iterMaxH * iconHeight, leftoverW, leftoverH, uMin, (uMin + iconUDif * leftoverWf), vMin, (vMin + iconVDif * leftoverHf));
    }
    @SideOnly(Side.CLIENT)
    public static ModelBiped getCustomArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped model, ModelBiped model1, ModelBiped model2)
      {
        if (model == null)
        {
          EntityEquipmentSlot type = ((ItemArmor)itemStack.getItem()).armorType;
          if ((type == EntityEquipmentSlot.CHEST) || (type == EntityEquipmentSlot.FEET)) {
            model = model1;
          } else {
            model = model2;
          }
        }
        if (model != null)
        {
          model.bipedHead.showModel = (armorSlot == EntityEquipmentSlot.HEAD);
          model.bipedHeadwear.showModel = (armorSlot == EntityEquipmentSlot.HEAD);
          model.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
          model.bipedRightArm.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
          model.bipedLeftArm.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
          model.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
          model.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
          model.isSneak = entityLiving.isSneaking();
          
          model.isRiding = entityLiving.isRiding();
          model.isChild = entityLiving.isChild();
          ItemStack itemstack = entityLiving.getHeldItemMainhand();
          ItemStack itemstack1 = entityLiving.getHeldItemOffhand();
          ModelBiped.ArmPose modelbiped$armpose = ModelBiped.ArmPose.EMPTY;
          ModelBiped.ArmPose modelbiped$armpose1 = ModelBiped.ArmPose.EMPTY;
          if ((itemstack != null) && (!itemstack.isEmpty()))
          {
            modelbiped$armpose = ModelBiped.ArmPose.ITEM;
            if (entityLiving.getItemInUseCount() > 0)
            {
              EnumAction enumaction = itemstack.getItemUseAction();
              if (enumaction == EnumAction.BLOCK) {
                modelbiped$armpose = ModelBiped.ArmPose.BLOCK;
              } else if (enumaction == EnumAction.BOW) {
                modelbiped$armpose = ModelBiped.ArmPose.BOW_AND_ARROW;
              }
            }
          }
          if ((itemstack1 != null) && (!itemstack1.isEmpty()))
          {
            modelbiped$armpose1 = ModelBiped.ArmPose.ITEM;
            if (entityLiving.getItemInUseCount() > 0)
            {
              EnumAction enumaction1 = itemstack1.getItemUseAction();
              if (enumaction1 == EnumAction.BLOCK) {
                modelbiped$armpose1 = ModelBiped.ArmPose.BLOCK;
              }
            }
          }
          if (entityLiving.getPrimaryHand() == EnumHandSide.RIGHT)
          {
            model.rightArmPose = modelbiped$armpose;
            model.leftArmPose = modelbiped$armpose1;
          }
          else
          {
            model.rightArmPose = modelbiped$armpose1;
            model.leftArmPose = modelbiped$armpose;
          }
        }
        return model;
      }
}
