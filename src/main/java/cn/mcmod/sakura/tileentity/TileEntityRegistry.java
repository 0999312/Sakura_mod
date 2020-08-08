package cn.mcmod.sakura.tileentity;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.client.TileEntityRenderHelper;
import cn.mcmod.sakura.client.render.tileentity.RenderTileEntityCampfire;
import cn.mcmod.sakura.client.render.tileentity.RenderTileEntityCampfirePot;
import cn.mcmod.sakura.client.render.tileentity.RenderTileEntityMapleCauldron;
import cn.mcmod.sakura.client.render.tileentity.RenderTileEntityOben;
import cn.mcmod.sakura.client.render.tileentity.RenderTileEntityStoneMortar;
import cn.mcmod.sakura.client.render.tileentity.RenderTileEntityWeb;
import cn.mcmod.sakura.client.render.tileentity.ShojiRender;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityRegistry {
	private static final TileEntityRegistry instance = new TileEntityRegistry();
	private TileEntityRegistry() {
	}
    public void init() {
        registerTileEntity(TileEntityCampfire.class, "campfire");
        registerTileEntity(TileEntityCampfirePot.class, "campfirepot");
        registerTileEntity(TileEntityStoneMortar.class, "stonemortar");
        registerTileEntity(TileEntityShoji.class, "shoji");
        registerTileEntity(TileEntityBarrel.class, "barrel");
        registerTileEntity(TileEntityDistillation.class, "barrel_distillation");
        registerTileEntity(TileEntityMapleCauldron.class, "maple_cauldron");
        registerTileEntity(TileEntityOben.class, "oben");
        registerTileEntity(TileEntityWeb.class, "straw_web");
    }

    @SideOnly(Side.CLIENT)
    public void render() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfire.class, new RenderTileEntityCampfire());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStoneMortar.class, new RenderTileEntityStoneMortar());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfirePot.class, new RenderTileEntityCampfirePot());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMapleCauldron.class, new RenderTileEntityMapleCauldron());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShoji.class, new ShojiRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOben.class, new RenderTileEntityOben());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWeb.class, new RenderTileEntityWeb());
        getItem(BlockLoader.STONEMORTAR).setTileEntityItemStackRenderer(new TileEntityRenderHelper());
    }

    private void registerTileEntity(Class<? extends TileEntity> cls, String baseName) {
        GameRegistry.registerTileEntity(cls, new ResourceLocation(SakuraMain.MODID, baseName));

    }

    private Item getItem(final Block block) {
        return Item.getItemFromBlock(block);
    }
	public static TileEntityRegistry getInstance() {
		return instance;
	}

}
