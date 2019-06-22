package cn.mcmod.sakura.tileentity;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.client.TileEntityRenderHelper;
import cn.mcmod.sakura.client.render.tileentity.RenderTileEntityCampfire;
import cn.mcmod.sakura.client.render.tileentity.RenderTileEntityCampfirePot;
import cn.mcmod.sakura.client.render.tileentity.RenderTileEntityStoneMortar;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityRegistry {
    private static final TileEntityRenderHelper TEISR = new TileEntityRenderHelper();

    public static void init() {
        registerTileEntity(TileEntityCampfire.class, "campfire");
        registerTileEntity(TileEntityCampfirePot.class, "campfirepot");
        registerTileEntity(TileEntityStoneMortar.class, "stonemortar");
    }

    public static void render() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfire.class, new RenderTileEntityCampfire());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStoneMortar.class, new RenderTileEntityStoneMortar());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfirePot.class, new RenderTileEntityCampfirePot());
        Item.getItemFromBlock(BlockLoader.STONEMORTAR).setTileEntityItemStackRenderer(TEISR);
    }

    private static void registerTileEntity(Class<? extends TileEntity> cls, String baseName) {
        GameRegistry.registerTileEntity(cls, new ResourceLocation(SakuraMain.MODID, baseName));

    }

    private static Item getItem(final Block block) {
        return Item.getItemFromBlock(block);
    }

}
