package cn.mcmod.sakura.fluid;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BucketItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SakuraMod.MODID);
    public static final RegistryObject<Item> FOOD_OIL_BUCKET = ITEMS.register("food_oil_bucket", () -> 
        new BucketItem(FluidRegistry.FOOD_OIL, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<Item> DOBUROKU_BUCKET = ITEMS.register("doburoku_bucket", () -> 
        new BucketItem(FluidRegistry.DOBUROKU, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> SAKE_BUCKET = ITEMS.register("sake_bucket", () -> 
        new BucketItem(FluidRegistry.SAKE, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> SHOUCHU_BUCKET = ITEMS.register("shouchu_bucket", () -> 
        new BucketItem(FluidRegistry.SHOUCHU, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));
    
    public static final RegistryObject<Item> BEER_BUCKET = ITEMS.register("beer_bucket", () -> 
        new BucketItem(FluidRegistry.BEER, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));
    
    public static final RegistryObject<Item> WHISKEY_BUCKET = ITEMS.register("whiskey_bucket", () -> 
        new BucketItem(FluidRegistry.WHISKEY, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> RED_WINE_BUCKET = ITEMS.register("red_wine_bucket", () -> 
        new BucketItem(FluidRegistry.RED_WINE, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> WHITE_WINE_BUCKET = ITEMS.register("white_wine_bucket", () -> 
        new BucketItem(FluidRegistry.WHITE_WINE, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> CHAMPAGNE_BUCKET = ITEMS.register("champagne_bucket", () -> 
        new BucketItem(FluidRegistry.CHAMPAGNE, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));
    
    public static final RegistryObject<Item> RUM_BUCKET = ITEMS.register("rum_bucket", () -> 
        new BucketItem(FluidRegistry.RUM, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> BRANDY_BUCKET = ITEMS.register("brandy_bucket", () -> 
        new BucketItem(FluidRegistry.BRANDY, new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET)));
}
