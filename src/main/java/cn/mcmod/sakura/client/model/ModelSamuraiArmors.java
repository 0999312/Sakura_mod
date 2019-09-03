package cn.mcmod.sakura.client.model;

//Made with Blockbench
//Paste this code into your mod.

import org.lwjgl.opengl.GL11;

import cn.mcmod.sakura.util.ClientUtils;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelSamuraiArmors extends ModelBiped {
	private final ModelRenderer head;
	private final ModelRenderer bone30;
	private final ModelRenderer bone31;
	private final ModelRenderer bone39;
	private final ModelRenderer bone40;
	private final ModelRenderer bone7;
	private final ModelRenderer bone32;
	private final ModelRenderer bone41;
	private final ModelRenderer bone42;
	private final ModelRenderer bone10;
	private final ModelRenderer bone33;
	private final ModelRenderer bone43;
	private final ModelRenderer bone44;
	private final ModelRenderer bone46;
	private final ModelRenderer bone45;
	private final ModelRenderer bone34;
	private final ModelRenderer bone17;
	private final ModelRenderer bone29;
	private final ModelRenderer body;
	private final ModelRenderer bone35;
	private final ModelRenderer bone6;
	private final ModelRenderer bone36;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone16;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone37;
	private final ModelRenderer bone18;
	private final ModelRenderer bone19;
	private final ModelRenderer bone20;
	private final ModelRenderer rightLeg;
	private final ModelRenderer bone38;
	private final ModelRenderer bone25;
	private final ModelRenderer bone26;
	private final ModelRenderer bone;
	private final ModelRenderer leftLeg;
	private final ModelRenderer bone22;
	private final ModelRenderer bone27;
	private final ModelRenderer bone28;
	private final ModelRenderer bone21;
	private final ModelRenderer rightArm;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer leftArm;
	private final ModelRenderer bone23;
	private final ModelRenderer bone24;

	public ModelSamuraiArmors(float f) {
		super(f, 0, 128, 128);
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 28, 0, -4.5F, -8.5F, -4.5F, 9, 9, 9, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 32, 18, -3.9948F, -9.0F, -3.9948F, 8, 1, 8, 0.0F, false));

		bone30 = new ModelRenderer(this);
		bone30.setRotationPoint(0.0052F, -5.0F, -4.9948F);
		setRotation(bone30, 0.2618F, 0.0F, 0.0F);
		head.addChild(bone30);
		bone30.cubeList.add(new ModelBox(bone30, 44, 28, -4.0F, -0.5F, -1.0F, 8, 1, 2, 0.0F, false));

		bone31 = new ModelRenderer(this);
		bone31.setRotationPoint(4.5052F, -6.0F, 0.0052F);
		setRotation(bone31, 0.0F, 0.0F, -0.6109F);
		head.addChild(bone31);
		bone31.cubeList.add(new ModelBox(bone31, 46, 32, -1.2506F, 0.0001F, -3.7552F, 1, 4, 8, 0.0F, false));

		bone39 = new ModelRenderer(this);
		bone39.setRotationPoint(-1.25F, 0.0F, -3.5F);
		setRotation(bone39, 0.0F, -0.6109F, 0.0F);
		bone31.addChild(bone39);
		bone39.cubeList.add(new ModelBox(bone39, 46, 32, -0.1439F, 0.0001F, -2.2097F, 1, 4, 2, 0.0F, false));

		bone40 = new ModelRenderer(this);
		bone40.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotation(bone40, 0.0F, -0.6109F, 0.0F);
		bone39.addChild(bone40);
		bone40.cubeList.add(new ModelBox(bone40, 46, 32, -1.3853F, 0.0001F, -3.7275F, 1, 4, 2, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-1.0F, 1.0F, 0.0F);
		setRotation(bone7, 0.0F, 0.0F, 0.1745F);
		bone31.addChild(bone7);
		bone7.cubeList.add(new ModelBox(bone7, 46, 44, -1.0006F, 0.5002F, -3.7552F, 1, 5, 8, 0.0F, false));

		bone32 = new ModelRenderer(this);
		bone32.setRotationPoint(-4.5052F, -6.0F, 0.0052F);
		setRotation(bone32, 0.0F, 0.0F, 0.6109F);
		head.addChild(bone32);
		bone32.cubeList.add(new ModelBox(bone32, 46, 32, 0.2499F, 0.0006F, -3.7552F, 1, 4, 8, 0.0F, true));

		bone41 = new ModelRenderer(this);
		bone41.setRotationPoint(1.25F, 0.0F, -3.5F);
		setRotation(bone41, 0.0F, 0.6109F, 0.0F);
		bone32.addChild(bone41);
		bone41.cubeList.add(new ModelBox(bone41, 46, 32, -0.8567F, 0.0006F, -2.2101F, 1, 4, 2, 0.0F, true));

		bone42 = new ModelRenderer(this);
		bone42.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotation(bone42, 0.0F, 0.6109F, 0.0F);
		bone41.addChild(bone42);
		bone42.cubeList.add(new ModelBox(bone42, 46, 32, 0.385F, 0.0006F, -3.7282F, 1, 4, 2, 0.0F, true));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(1.0F, 1.0F, 0.0F);
		setRotation(bone10, 0.0F, 0.0F, -0.1745F);
		bone32.addChild(bone10);
		bone10.cubeList.add(new ModelBox(bone10, 46, 44, -0.0002F, 0.5006F, -3.7552F, 1, 5, 8, 0.0F, true));

		bone33 = new ModelRenderer(this);
		bone33.setRotationPoint(0.0F, -7.5F, -5.2448F);
		setRotation(bone33, -0.1745F, 0.0F, 0.0F);
		head.addChild(bone33);
		bone33.cubeList.add(new ModelBox(bone33, 34, 31, -1.0F, -0.5F, -0.5F, 2, 2, 2, 0.0F, false));
		bone33.cubeList.add(new ModelBox(bone33, 34, 28, -1.5F, 1.0F, 0.0F, 3, 1, 1, 0.0F, false));

		bone43 = new ModelRenderer(this);
		bone43.setRotationPoint(1.5F, -0.5F, 0.5F);
		setRotation(bone43, 0.0F, 0.0F, 0.2618F);
		bone33.addChild(bone43);
		bone43.cubeList.add(new ModelBox(bone43, 40, 36, -0.3529F, -4.5852F, -0.5F, 1, 7, 1, 0.0F, false));

		bone44 = new ModelRenderer(this);
		bone44.setRotationPoint(0.6471F, -4.0852F, 0.0F);
		setRotation(bone44, 0.0F, 0.0F, -0.6109F);
		bone43.addChild(bone44);
		bone44.cubeList.add(new ModelBox(bone44, 35, 28, -1.5F, 0.9F, -0.5F, 2, 1, 1, 0.0F, false));

		bone46 = new ModelRenderer(this);
		bone46.setRotationPoint(-1.5F, -0.5F, 0.5F);
		setRotation(bone46, 0.0F, 0.0F, -0.2618F);
		bone33.addChild(bone46);
		bone46.cubeList.add(new ModelBox(bone46, 40, 36, -0.6471F, -4.5852F, -0.5F, 1, 7, 1, 0.0F, true));

		bone45 = new ModelRenderer(this);
		bone45.setRotationPoint(-0.6471F, -4.0852F, 0.0F);
		setRotation(bone45, 0.0F, 0.0F, 0.6109F);
		bone46.addChild(bone45);
		bone45.cubeList.add(new ModelBox(bone45, 35, 28, -0.5F, 0.9F, -0.5F, 2, 1, 1, 0.0F, true));

		bone34 = new ModelRenderer(this);
		bone34.setRotationPoint(0.0F, -6.25F, 4.0F);
		setRotation(bone34, 0.5236F, 0.0F, 0.0F);
		head.addChild(bone34);
		bone34.cubeList.add(new ModelBox(bone34, 28, 45, -3.9912F, 0.007F, -0.7343F, 8, 4, 1, 0.0F, false));

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotation(bone17, -0.0873F, 0.0F, 0.0F);
		bone34.addChild(bone17);
		bone17.cubeList.add(new ModelBox(bone17, 28, 51, -3.9906F, 2.1261F, -1.4052F, 8, 5, 1, 0.0F, false));

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(0.0F, 0.5F, -2.0F);
		setRotation(bone29, -0.5236F, 0.0F, 0.0F);
		head.addChild(bone29);
		bone29.cubeList.add(new ModelBox(bone29, 54, 6, -1.5F, 0.007F, 0.0079F, 1, 1, 0, 0.0F, false));
		bone29.cubeList.add(new ModelBox(bone29, 54, 6, 0.5F, 0.007F, 0.0079F, 1, 1, 0, 0.0F, true));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 12.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 64, 55, -5.0F, -2.5F, -3.0F, 10, 3, 6, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 64, 37, -4.5F, -12.5F, -2.5F, 9, 7, 5, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 96, 55, -5.0F, -6.5F, -3.0F, 10, 3, 6, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 99, 49, -4.5F, -3.5F, -2.5F, 9, 1, 5, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 70, 49, -4.5F, -12.0F, 2.25F, 9, 5, 1, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 93, 51, -1.0F, -4.0F, -3.5F, 2, 2, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 92, 47, -1.0F, -4.0F, 2.5F, 2, 2, 2, 0.0F, false));

		bone35 = new ModelRenderer(this);
		bone35.setRotationPoint(0.0F, 5.0F, -1.0F);
		setRotation(bone35, 0.5236F, 0.0F, 0.0F);
		body.addChild(bone35);
		bone35.cubeList.add(new ModelBox(bone35, 105, 36, -4.5F, -13.7533F, 4.2235F, 9, 4, 2, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(1.75F, -1.1445F, -0.4015F);
		setRotation(bone6, -1.0472F, 0.0F, 0.0F);
		bone35.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 105, 30, -6.25F, -14.3098F, -8.6071F, 9, 4, 2, 0.0F, false));

		bone36 = new ModelRenderer(this);
		bone36.setRotationPoint(0.5F, 9.0F, 4.0F);
		setRotation(bone36, 0.2618F, -0.2618F, -0.6109F);
		body.addChild(bone36);
		bone36.cubeList.add(new ModelBox(bone36, 94, 40, 9.1484F, -11.9559F, 0.0734F, 1, 4, 1, 0.0F, false));
		bone36.cubeList.add(new ModelBox(bone36, 94, 33, 5.6484F, -9.9559F, 0.0734F, 1, 6, 1, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(2.5F, -2.0F, 0.0F);
		setRotation(bone8, 0.0F, 0.0F, -0.4363F);
		bone36.addChild(bone8);
		bone8.cubeList.add(new ModelBox(bone8, 92, 45, 7.2331F, -6.2134F, 0.0734F, 3, 1, 1, 0.0F, false));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(2.5F, 2.0F, -0.25F);
		setRotation(bone9, 0.0F, 0.0F, 0.4363F);
		bone36.addChild(bone9);
		bone9.cubeList.add(new ModelBox(bone9, 92, 45, -1.1821F, -12.8329F, 0.3234F, 3, 1, 1, 0.0F, false));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-0.5F, 9.0F, 4.0F);
		setRotation(bone11, 0.2618F, 0.2618F, 0.6109F);
		body.addChild(bone11);
		bone11.cubeList.add(new ModelBox(bone11, 94, 40, -10.1484F, -11.9559F, 0.0734F, 1, 4, 1, 0.0F, true));
		bone11.cubeList.add(new ModelBox(bone11, 94, 33, -6.6484F, -9.9559F, 0.0734F, 1, 6, 1, 0.0F, false));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-2.5F, -2.0F, 0.0F);
		setRotation(bone12, 0.0F, 0.0F, 0.4363F);
		bone11.addChild(bone12);
		bone12.cubeList.add(new ModelBox(bone12, 92, 45, -10.2331F, -6.2134F, 0.0734F, 3, 1, 1, 0.0F, true));

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(-2.5F, 2.0F, -0.25F);
		setRotation(bone13, 0.0F, 0.0F, -0.4363F);
		bone11.addChild(bone13);
		bone13.cubeList.add(new ModelBox(bone13, 92, 45, -1.8179F, -12.8329F, 0.3234F, 3, 1, 1, 0.0F, true));

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, 0.35F, -3.0F);
		setRotation(bone16, -0.3491F, 0.0F, 0.0F);
		body.addChild(bone16);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotation(bone14, 0.0F, 0.2618F, 0.0F);
		bone16.addChild(bone14);
		bone14.cubeList.add(new ModelBox(bone14, 110, 27, -2.6439F, -11.8107F, -5.3018F, 4, 1, 2, 0.0F, false));

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotation(bone15, 0.0F, -0.2618F, 0.0F);
		bone16.addChild(bone15);
		bone15.cubeList.add(new ModelBox(bone15, 110, 27, -1.4765F, -11.8107F, -5.2695F, 4, 1, 2, 0.0F, true));

		bone37 = new ModelRenderer(this);
		bone37.setRotationPoint(0.0F, 12.0F, -2.5F);
		setRotation(bone37, -0.4363F, 0.0F, 0.0F);
		body.addChild(bone37);
		bone37.cubeList.add(new ModelBox(bone37, 64, 0, -2.5F, -10.8757F, -5.0714F, 5, 2, 1, 0.0F, false));
		bone37.cubeList.add(new ModelBox(bone37, 64, 3, -2.0F, -8.8757F, -5.0714F, 4, 2, 1, 0.0F, false));
		bone37.cubeList.add(new ModelBox(bone37, 64, 6, -1.5F, -6.8757F, -5.0714F, 3, 2, 1, 0.0F, false));

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, 12.0F, 2.5F);
		setRotation(bone18, 0.4363F, 0.0F, 0.0F);
		body.addChild(bone18);
		bone18.cubeList.add(new ModelBox(bone18, 64, 25, -3.5F, -10.8757F, 4.3214F, 7, 3, 1, 0.0F, false));
		bone18.cubeList.add(new ModelBox(bone18, 64, 29, -4.0F, -7.8757F, 4.3214F, 8, 3, 1, 0.0F, false));
		bone18.cubeList.add(new ModelBox(bone18, 64, 33, -4.5F, -4.8757F, 4.3214F, 9, 3, 1, 0.0F, false));

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(-4.0F, 12.0F, 0.0F);
		setRotation(bone19, 0.0F, 0.0F, 0.4363F);
		body.addChild(bone19);
		bone19.cubeList.add(new ModelBox(bone19, 91, 0, -5.8214F, -10.8757F, -2.0F, 1, 2, 4, 0.0F, false));
		bone19.cubeList.add(new ModelBox(bone19, 90, 6, -5.8214F, -8.8757F, -2.5F, 1, 2, 5, 0.0F, false));
		bone19.cubeList.add(new ModelBox(bone19, 89, 13, -5.8214F, -6.8757F, -3.0F, 1, 2, 6, 0.0F, false));
		bone19.cubeList.add(new ModelBox(bone19, 90, 21, -5.8214F, -4.8757F, -2.5F, 1, 2, 5, 0.0F, false));
		bone19.cubeList.add(new ModelBox(bone19, 91, 28, -5.8214F, -2.8757F, -2.0F, 1, 1, 4, 0.0F, false));

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(4.0F, 12.0F, 0.0F);
		setRotation(bone20, 0.0F, 0.0F, -0.4363F);
		body.addChild(bone20);
		bone20.cubeList.add(new ModelBox(bone20, 91, 0, 4.8214F, -10.8757F, -2.0F, 1, 2, 4, 0.0F, true));
		bone20.cubeList.add(new ModelBox(bone20, 90, 6, 4.8214F, -8.8757F, -2.5F, 1, 2, 5, 0.0F, true));
		bone20.cubeList.add(new ModelBox(bone20, 89, 13, 4.8214F, -6.8757F, -3.0F, 1, 2, 6, 0.0F, true));
		bone20.cubeList.add(new ModelBox(bone20, 90, 21, 4.8214F, -4.8757F, -2.5F, 1, 2, 5, 0.0F, true));
		bone20.cubeList.add(new ModelBox(bone20, 91, 28, 4.8214F, -2.8757F, -2.0F, 1, 1, 4, 0.0F, true));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(9.0F, -1.5F, 0.0F);

		bone38 = new ModelRenderer(this);
		bone38.setRotationPoint(3.0F, 10.0F, 0.0F);
		setRotation(bone38, 0.0F, 0.0F, 0.2618F);
		rightLeg.addChild(bone38);
		bone38.cubeList.add(new ModelBox(bone38, 104, 0, -3.8082F, -11.979F, -2.5F, 7, 1, 5, 0.0F, false));

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(2.6667F, 1.25F, 0.0F);
		setRotation(bone25, 0.0F, 0.0F, 0.0873F);
		rightLeg.addChild(bone25);
		bone25.cubeList.add(new ModelBox(bone25, 106, 6, -1.6667F, -2.0F, -3.0F, 4, 1, 6, 0.0F, false));
		bone25.cubeList.add(new ModelBox(bone25, 106, 13, -3.1667F, -1.5F, -2.5F, 5, 3, 5, 0.0F, false));
		bone25.cubeList.add(new ModelBox(bone25, 106, 6, -1.6667F, 1.0F, -3.0F, 4, 1, 6, 0.0F, false));

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(2.6667F, 5.5F, 0.0F);
		setRotation(bone26, 0.0F, 0.0F, -0.0873F);
		rightLeg.addChild(bone26);
		bone26.cubeList.add(new ModelBox(bone26, 106, 6, -1.6667F, -2.0F, -3.0F, 4, 1, 6, 0.0F, false));
		bone26.cubeList.add(new ModelBox(bone26, 106, 13, -3.1667F, -1.5F, -2.5F, 5, 3, 5, 0.0F, false));
		bone26.cubeList.add(new ModelBox(bone26, 106, 6, -1.6667F, 1.0F, -3.0F, 4, 1, 6, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(1.75F, 8.25F, 0.0F);
		setRotation(bone, 0.0F, 0.0F, 0.2618F);
		rightLeg.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 108, 21, -0.5F, -0.5F, -2.5F, 3, 1, 5, 0.0F, false));

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-9.0F, -1.5F, 0.0F);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(-3.0F, 10.0F, 0.0F);
		setRotation(bone22, 0.0F, 0.0F, -0.2618F);
		leftLeg.addChild(bone22);
		bone22.cubeList.add(new ModelBox(bone22, 104, 0, -3.1918F, -11.979F, -2.5F, 7, 1, 5, 0.0F, true));

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(-2.6667F, 1.25F, 0.0F);
		setRotation(bone27, 0.0F, 0.0F, -0.0873F);
		leftLeg.addChild(bone27);
		bone27.cubeList.add(new ModelBox(bone27, 106, 6, -2.3333F, 1.0F, -3.0F, 4, 1, 6, 0.0F, true));
		bone27.cubeList.add(new ModelBox(bone27, 106, 13, -1.8333F, -1.5F, -2.5F, 5, 3, 5, 0.0F, true));
		bone27.cubeList.add(new ModelBox(bone27, 106, 6, -2.3333F, -2.0F, -3.0F, 4, 1, 6, 0.0F, true));

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(-2.6667F, 5.5F, 0.0F);
		setRotation(bone28, 0.0F, 0.0F, 0.0873F);
		leftLeg.addChild(bone28);
		bone28.cubeList.add(new ModelBox(bone28, 106, 6, -2.3333F, -2.0F, -3.0F, 4, 1, 6, 0.0F, true));
		bone28.cubeList.add(new ModelBox(bone28, 106, 13, -1.8333F, -1.5F, -2.5F, 5, 3, 5, 0.0F, true));
		bone28.cubeList.add(new ModelBox(bone28, 106, 6, -2.3333F, 1.0F, -3.0F, 4, 1, 6, 0.0F, true));

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(-1.75F, 8.25F, 0.0F);
		setRotation(bone21, 0.0F, 0.0F, -0.2618F);
		leftLeg.addChild(bone21);
		bone21.cubeList.add(new ModelBox(bone21, 108, 21, -2.5F, -0.5F, -2.5F, 3, 1, 5, 0.0F, true));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(4.25F, 12.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 42, 78, -2.2531F, -7.0F, -3.253F, 5, 1, 6, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 44, 72, -2.2531F, -4.75F, -2.503F, 5, 1, 5, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 44, 72, -2.2531F, -9.25F, -2.503F, 5, 1, 5, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 44, 85, -2.2531F, -3.0F, -2.503F, 5, 3, 5, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 52, 93, -2.2531F, -1.0F, -3.503F, 5, 1, 1, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 44, 64, -2.2531F, -12.5F, -2.503F, 5, 3, 5, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 7.0F, 0.0F);
		setRotation(bone2, -1.3963F, 0.0F, 0.4363F);
		rightArm.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 46, 95, -7.1801F, -0.4185F, -17.5643F, 4, 1, 5, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-0.0017F, 6.75F, -2.0017F);
		setRotation(bone3, -0.2618F, 0.0F, -0.1745F);
		rightArm.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 54, 101, 0.6183F, -12.1527F, -4.1247F, 4, 4, 1, 0.0F, false));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-4.25F, 12.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 42, 78, -2.7469F, -7.0F, -3.253F, 5, 1, 6, 0.0F, true));
		leftArm.cubeList.add(new ModelBox(leftArm, 44, 72, -2.7469F, -4.75F, -2.503F, 5, 1, 5, 0.0F, true));
		leftArm.cubeList.add(new ModelBox(leftArm, 44, 72, -2.7469F, -9.25F, -2.503F, 5, 1, 5, 0.0F, true));
		leftArm.cubeList.add(new ModelBox(leftArm, 44, 85, -2.7469F, -3.0F, -2.503F, 5, 3, 5, 0.0F, true));
		leftArm.cubeList.add(new ModelBox(leftArm, 52, 93, -2.7469F, -1.0F, -3.503F, 5, 1, 1, 0.0F, true));
		leftArm.cubeList.add(new ModelBox(leftArm, 44, 64, -2.7469F, -12.5F, -2.503F, 5, 3, 5, 0.0F, true));

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(0.0F, 7.0F, 0.0F);
		setRotation(bone23, -1.3963F, 0.0F, -0.4363F);
		leftArm.addChild(bone23);
		bone23.cubeList.add(new ModelBox(bone23, 46, 95, 3.1801F, -0.4185F, -17.5643F, 4, 1, 5, 0.0F, true));

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0017F, 6.75F, -2.0017F);
		setRotation(bone24, -0.2618F, 0.0F, 0.1745F);
		leftArm.addChild(bone24);
		bone24.cubeList.add(new ModelBox(bone24, 54, 101, -4.6183F, -12.1527F, -4.1247F, 4, 4, 1, 0.0F, true));
		this.bipedHeadwear.cubeList.clear();
	    this.bipedHead.cubeList.clear();
	    this.bipedHead.addChild(head);
	    this.bipedBody.cubeList.clear();
	    this.bipedBody.addChild(body);
	    
	    this.bipedLeftArm.cubeList.clear();
	    this.bipedRightArm.cubeList.clear();
	    this.bipedLeftLeg.cubeList.clear();
	    this.bipedRightLeg.cubeList.clear();
	    
	    this.bipedLeftArm.addChild(leftLeg);
	    this.bipedRightArm.addChild(rightLeg);
	    this.bipedLeftLeg.addChild(leftArm);
	    this.bipedRightLeg.addChild(rightArm);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		   setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		    if (this.isChild)
		    {
		      float f6 = 2.0F;
		      GL11.glPushMatrix();
		      GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
		      GL11.glTranslatef(0.0F, 16.0F * f5, 0.0F);
		      this.bipedHead.render(f5);
		      GL11.glPopMatrix();
		      GL11.glPushMatrix();
		      GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
		      GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
		      this.bipedBody.render(f5);
		      this.bipedRightArm.render(f5);
		      this.bipedLeftArm.render(f5);
		      this.bipedRightLeg.render(f5);
		      this.bipedLeftLeg.render(f5);
		      this.bipedHeadwear.render(f5);
		      GL11.glPopMatrix();
		    }
		    else
		    {
		      GL11.glPushMatrix();
		      GL11.glScalef(1.01F, 1.01F, 1.01F);
		      this.bipedHead.render(f5);
		      GL11.glPopMatrix();
		      this.bipedBody.render(f5);
		      this.bipedRightArm.render(f5);
		      this.bipedLeftArm.render(f5);
		      this.bipedRightLeg.render(f5);
		      this.bipedLeftLeg.render(f5);
		      this.bipedHeadwear.render(f5);
		    }
	}
	
	public void setRotation(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	  @SuppressWarnings("incomplete-switch")
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	  {
	    if ((entityIn instanceof EntityLivingBase)) {
	      this.swingProgress = ((EntityLivingBase)entityIn).getSwingProgress(ClientUtils.sysPartialTicks);
	    }
	    if ((entityIn instanceof EntityArmorStand))
	    {
	      setRotationAnglesStand(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	    }
	    else if (((entityIn instanceof EntitySkeleton)) || ((entityIn instanceof EntityZombie)))
	    {
	      setRotationAnglesZombie(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	    }
	    else
	    {
	      boolean flag = ((entityIn instanceof EntityLivingBase)) && (((EntityLivingBase)entityIn).getTicksElytraFlying() > 4);
	      this.bipedHead.rotateAngleY = (netHeadYaw * 0.017453292F);
	      if (flag) {
	        this.bipedHead.rotateAngleX = -0.7853982F;
	      } else {
	        this.bipedHead.rotateAngleX = (headPitch * 0.017453292F);
	      }
	      this.bipedBody.rotateAngleY = 0.0F;
	      this.bipedRightArm.rotationPointZ = 0.0F;
	      this.bipedRightArm.rotationPointX = -5.0F;
	      this.bipedLeftArm.rotationPointZ = 0.0F;
	      this.bipedLeftArm.rotationPointX = 5.0F;
	      float f = 1.0F;
	      if (flag)
	      {
	        f = (float)(entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
	        f /= 0.2F;
	        f = f * f * f;
	      }
	      if (f < 1.0F) {
	        f = 1.0F;
	      }
	      this.bipedRightArm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F / f);
	      this.bipedLeftArm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f);
	      this.bipedRightArm.rotateAngleZ = 0.0F;
	      this.bipedLeftArm.rotateAngleZ = 0.0F;
	      this.bipedRightLeg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f);
	      this.bipedLeftLeg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / f);
	      this.bipedRightLeg.rotateAngleY = 0.0F;
	      this.bipedLeftLeg.rotateAngleY = 0.0F;
	      this.bipedRightLeg.rotateAngleZ = 0.0F;
	      this.bipedLeftLeg.rotateAngleZ = 0.0F;
	      if (this.isRiding)
	      {
	        this.bipedRightArm.rotateAngleX += -0.62831855F;
	        this.bipedLeftArm.rotateAngleX += -0.62831855F;
	        this.bipedRightLeg.rotateAngleX = -1.4137167F;
	        this.bipedRightLeg.rotateAngleY = 0.31415927F;
	        this.bipedRightLeg.rotateAngleZ = 0.07853982F;
	        this.bipedLeftLeg.rotateAngleX = -1.4137167F;
	        this.bipedLeftLeg.rotateAngleY = -0.31415927F;
	        this.bipedLeftLeg.rotateAngleZ = -0.07853982F;
	      }
	      this.bipedRightArm.rotateAngleY = 0.0F;
	      this.bipedRightArm.rotateAngleZ = 0.0F;
	      switch (this.leftArmPose)
	      {
	      case EMPTY: 
	        this.bipedLeftArm.rotateAngleY = 0.0F;
	        break;
	      case BLOCK: 
	        this.bipedLeftArm.rotateAngleX = (this.bipedLeftArm.rotateAngleX * 0.5F - 0.9424779F);
	        this.bipedLeftArm.rotateAngleY = 0.5235988F;
	        break;
	      case ITEM: 
	        this.bipedLeftArm.rotateAngleX = (this.bipedLeftArm.rotateAngleX * 0.5F - 0.31415927F);
	        this.bipedLeftArm.rotateAngleY = 0.0F;
	      }
	      switch (this.rightArmPose)
	      {
	      case EMPTY: 
	        this.bipedRightArm.rotateAngleY = 0.0F;
	        break;
	      case BLOCK: 
	        this.bipedRightArm.rotateAngleX = (this.bipedRightArm.rotateAngleX * 0.5F - 0.9424779F);
	        this.bipedRightArm.rotateAngleY = -0.5235988F;
	        break;
	      case ITEM: 
	        this.bipedRightArm.rotateAngleX = (this.bipedRightArm.rotateAngleX * 0.5F - 0.31415927F);
	        this.bipedRightArm.rotateAngleY = 0.0F;
	      }
	      if (this.swingProgress > 0.0F)
	      {
	        EnumHandSide enumhandside = getMainHand(entityIn);
	        ModelRenderer modelrenderer = getArmForSide(enumhandside);
	        float f1 = this.swingProgress;
	        this.bipedBody.rotateAngleY = (MathHelper.sin(MathHelper.sqrt(f1) * 6.2831855F) * 0.2F);
	        if (enumhandside == EnumHandSide.LEFT) {
	          this.bipedBody.rotateAngleY *= -1.0F;
	        }
	        this.bipedRightArm.rotationPointZ = (MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F);
	        this.bipedRightArm.rotationPointX = (-MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F);
	        this.bipedLeftArm.rotationPointZ = (-MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F);
	        this.bipedLeftArm.rotationPointX = (MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F);
	        this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
	        this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
	        this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
	        f1 = 1.0F - this.swingProgress;
	        f1 *= f1;
	        f1 *= f1;
	        f1 = 1.0F - f1;
	        float f2 = MathHelper.sin(f1 * 3.1415927F);
	        float f3 = MathHelper.sin(this.swingProgress * 3.1415927F) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
	        modelrenderer.rotateAngleX = ((float)(modelrenderer.rotateAngleX - (f2 * 1.2D + f3)));
	        modelrenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
	        modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * 3.1415927F) * -0.4F;
	      }
	      if (this.isSneak)
	      {
	        this.bipedBody.rotateAngleX = 0.5F;
	        this.bipedRightArm.rotateAngleX += 0.4F;
	        this.bipedLeftArm.rotateAngleX += 0.4F;
	        this.bipedRightLeg.rotationPointZ = 4.0F;
	        this.bipedLeftLeg.rotationPointZ = 4.0F;
	        this.bipedRightLeg.rotationPointY = 13.0F;
	        this.bipedLeftLeg.rotationPointY = 13.0F;
	        this.bipedHead.rotationPointY = 4.5F;
	        
	        this.bipedBody.rotationPointY = 4.5F;
	        this.bipedRightArm.rotationPointY = 5.0F;
	        this.bipedLeftArm.rotationPointY = 5.0F;
	      }
	      else
	      {
	        this.bipedBody.rotateAngleX = 0.0F;
	        this.bipedRightLeg.rotationPointZ = 0.1F;
	        this.bipedLeftLeg.rotationPointZ = 0.1F;
	        this.bipedRightLeg.rotationPointY = 12.0F;
	        this.bipedLeftLeg.rotationPointY = 12.0F;
	        this.bipedHead.rotationPointY = 0.0F;
	        
	        this.bipedBody.rotationPointY = 0.0F;
	        this.bipedRightArm.rotationPointY = 2.0F;
	        this.bipedLeftArm.rotationPointY = 2.0F;
	      }
	      this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	      this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	      this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	      this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	      if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
	      {
	        this.bipedRightArm.rotateAngleY = (-0.1F + this.bipedHead.rotateAngleY);
	        this.bipedLeftArm.rotateAngleY = (0.1F + this.bipedHead.rotateAngleY + 0.4F);
	        this.bipedRightArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
	        this.bipedLeftArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
	      }
	      else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
	      {
	        this.bipedRightArm.rotateAngleY = (-0.1F + this.bipedHead.rotateAngleY - 0.4F);
	        this.bipedLeftArm.rotateAngleY = (0.1F + this.bipedHead.rotateAngleY);
	        this.bipedRightArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
	        this.bipedLeftArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
	      }
	      copyModelAngles(this.bipedHead, this.bipedHeadwear);
	    }
	  }
	  
	  public void setRotationAnglesZombie(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	  {
	    super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	    
	    boolean flag = ((entityIn instanceof EntityZombie)) && (((EntityZombie)entityIn).isArmsRaised());
	    float f = MathHelper.sin(this.swingProgress * 3.1415927F);
	    float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * 3.1415927F);
	    this.bipedRightArm.rotateAngleZ = 0.0F;
	    this.bipedLeftArm.rotateAngleZ = 0.0F;
	    this.bipedRightArm.rotateAngleY = (-(0.1F - f * 0.6F));
	    this.bipedLeftArm.rotateAngleY = (0.1F - f * 0.6F);
	    float f2 = -3.1415927F / (flag ? 1.5F : 2.25F);
	    this.bipedRightArm.rotateAngleX = f2;
	    this.bipedLeftArm.rotateAngleX = f2;
	    this.bipedRightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
	    this.bipedLeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
	    this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	    this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	    this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	    this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	  }
	  
	  public void setRotationAnglesStand(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	  {
	    if ((entityIn instanceof EntityArmorStand))
	    {
	      EntityArmorStand entityarmorstand = (EntityArmorStand)entityIn;
	      this.bipedHead.rotateAngleX = (0.017453292F * entityarmorstand.getHeadRotation().getX());
	      this.bipedHead.rotateAngleY = (0.017453292F * entityarmorstand.getHeadRotation().getY());
	      this.bipedHead.rotateAngleZ = (0.017453292F * entityarmorstand.getHeadRotation().getZ());
	      this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
	      this.bipedBody.rotateAngleX = (0.017453292F * entityarmorstand.getBodyRotation().getX());
	      this.bipedBody.rotateAngleY = (0.017453292F * entityarmorstand.getBodyRotation().getY());
	      this.bipedBody.rotateAngleZ = (0.017453292F * entityarmorstand.getBodyRotation().getZ());
	      this.bipedLeftArm.rotateAngleX = (0.017453292F * entityarmorstand.getLeftArmRotation().getX());
	      this.bipedLeftArm.rotateAngleY = (0.017453292F * entityarmorstand.getLeftArmRotation().getY());
	      this.bipedLeftArm.rotateAngleZ = (0.017453292F * entityarmorstand.getLeftArmRotation().getZ());
	      this.bipedRightArm.rotateAngleX = (0.017453292F * entityarmorstand.getRightArmRotation().getX());
	      this.bipedRightArm.rotateAngleY = (0.017453292F * entityarmorstand.getRightArmRotation().getY());
	      this.bipedRightArm.rotateAngleZ = (0.017453292F * entityarmorstand.getRightArmRotation().getZ());
	      this.bipedLeftLeg.rotateAngleX = (0.017453292F * entityarmorstand.getLeftLegRotation().getX());
	      this.bipedLeftLeg.rotateAngleY = (0.017453292F * entityarmorstand.getLeftLegRotation().getY());
	      this.bipedLeftLeg.rotateAngleZ = (0.017453292F * entityarmorstand.getLeftLegRotation().getZ());
	      this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
	      this.bipedRightLeg.rotateAngleX = (0.017453292F * entityarmorstand.getRightLegRotation().getX());
	      this.bipedRightLeg.rotateAngleY = (0.017453292F * entityarmorstand.getRightLegRotation().getY());
	      this.bipedRightLeg.rotateAngleZ = (0.017453292F * entityarmorstand.getRightLegRotation().getZ());
	      this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
	      copyModelAngles(this.bipedHead, this.bipedHeadwear);
	    }
	  }
}