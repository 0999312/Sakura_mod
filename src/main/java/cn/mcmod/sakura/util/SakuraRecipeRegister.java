package cn.mcmod.sakura.util;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.tileentity.TileEntityCampfirePot;
import cn.mcmod.sakura.tileentity.TileEntityStoneMortar;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class SakuraRecipeRegister {
    public static void furnaceRegister() {
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 17), new ItemStack(ItemLoader.FOODSET, 1, 2), 0.1F);
    }

    public static void mortarRegister() {
        TileEntityStoneMortar.MortarRecipes.addMortarRecipe(new TileEntityStoneMortar.MortarRecipes(
                new ItemStack(ItemLoader.MATERIAL, 1, 1), new ItemStack(ItemLoader.RICE_SEEDS)));
        TileEntityStoneMortar.MortarRecipes.addMortarRecipe(new TileEntityStoneMortar.MortarRecipes(
                new ItemStack(ItemLoader.MATERIAL, 2, 4), new ItemStack(Items.WHEAT)));
        TileEntityStoneMortar.MortarRecipes.addMortarRecipe(new TileEntityStoneMortar.MortarRecipes(
                new ItemStack(ItemLoader.MATERIAL, 1, 16), new ItemStack(ItemLoader.MATERIAL, 1, 1)));
    }

    public static void potRegister() {
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 90),
                        "listAllbeefraw",
                        new Object[]{
                                "bamboo"
                        },
                        new FluidStack(FluidRegistry.WATER, 0)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 91),
                        new ItemStack(Items.CHICKEN),
                        new Object[]{
                                "bamboo"
                        },
                        new FluidStack(FluidRegistry.WATER, 0)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 92),
                        new ItemStack(Items.PORKCHOP),
                        new Object[]{
                                "bamboo"
                        },
                        new FluidStack(FluidRegistry.WATER, 0)));

        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 7),
                        "cropRice",
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 10),
                        "cropRice",
                        new Object[]{
                                "listAllbeefraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 8),
                        "cropRice",
                        new Object[]{
                                "cropBambooshoot"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 9),
                        "cropRice",
                        new Object[]{
                                "listAllfishraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 11),
                        "cropRice",
                        new Object[]{
                                "listAllporkraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 12),
                        "cropRice",
                        new Object[]{
                                "listAllmushroom"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 13),
                        "cropRice",
                        new Object[]{
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 14),
                        "cropRice",
                        new Object[]{
                                "listAllbeefraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 15),
                        "cropRice",
                        new Object[]{
                                "listAllbeefraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 16),
                        "cropRice",
                        new Object[]{
                                new ItemStack(ItemLoader.FOODSET, 1, 6),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 17),
                        "cropRice",
                        new Object[]{
                                "listAllchickenraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 18),
                        "cropRice",
                        new Object[]{
                                "listAllfishraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));

        /*
         * RAMEN
         */
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 19),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 20),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(Items.BEEF, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 21),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(Items.EGG, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 22),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 23),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 24),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 25),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(Items.BEEF, 1),
                                new ItemStack(Items.EGG, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        /*
         * UDON
         */
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 27),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(Items.BEEF, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 28),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(Items.EGG, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 29),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 30),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 31),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 32),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6),
                                new ItemStack(Items.EGG, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        /*
         * SOBA
         */
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 35),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(Items.BEEF, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 36),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(Items.EGG, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 37),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 38),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 39),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 40),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6),
                                new ItemStack(Items.EGG, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));


        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 26),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 1, 34),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 3),
                        new ItemStack(ItemLoader.RED_BEAN, 1),
                        new Object[]{
                                "listAllsugar",
                                "listAllsugar"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 6),
                        "listAllporkraw",
                        new Object[]{
                                "foodFlour",
                                "listAllegg",
                                "foodBreadcrumbs",
                                "dustSalt",
                                "foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));

    }
}
