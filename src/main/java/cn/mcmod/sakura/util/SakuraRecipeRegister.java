package cn.mcmod.sakura.util;

import cn.mcmod.sakura.SakuraOreDictLoader;
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
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.EGGPLANT, 1), new ItemStack(ItemLoader.FOODSET, 1, 87), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 17), new ItemStack(ItemLoader.FOODSET, 1, 2), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.FOODSET, 1, 48), new ItemStack(ItemLoader.FOODSET, 1, 49), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.FOODSET, 1, 58), new ItemStack(ItemLoader.FOODSET, 1, 59), 0.1F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 6), new ItemStack(ItemLoader.FOODSET, 1, 4), 0.1F);

        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ItemLoader.MATERIAL, 1, 31), new ItemStack(ItemLoader.FOODSET, 1, 73), 0.1F);
    }

    public static void mortarRegister() {
        TileEntityStoneMortar.MortarRecipes.addMortarRecipe(new TileEntityStoneMortar.MortarRecipes(
                new ItemStack(ItemLoader.MATERIAL, 1, 1), new ItemStack(ItemLoader.RICE_SEEDS)));
        TileEntityStoneMortar.MortarRecipes.addMortarRecipe(new TileEntityStoneMortar.MortarRecipes(
                new ItemStack(ItemLoader.MATERIAL, 1, 5), new ItemStack(ItemLoader.BUCKWHEAT)));
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
                        "listAllchickenraw",
                        new Object[]{
                                "bamboo"
                        },
                        new FluidStack(FluidRegistry.WATER, 0)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 92),
                        "listAllporkraw",
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
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 65),
                        "cropRice",
                        new Object[]{
                        "foodNatto",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 64),
                        "cropRice",
                        new Object[]{
                        "foodNatto"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        /*
         * RAMEN
         */
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 19),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 20),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllbeefraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 21),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 22),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 23),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 24),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 25),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllmeatraw",
                                "listAllveggie",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 93),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 96),
                        new ItemStack(ItemLoader.MATERIAL, 1, 8),
                        new Object[]{
                        		"listAllchickenraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        /*
         * UDON
         */
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 94),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 26),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 27),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllbeefraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 28),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 29),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 30),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 31),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 32),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllmeatraw",
                                "listAllveggie",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 97),
                        new ItemStack(ItemLoader.MATERIAL, 1, 9),
                        new Object[]{
                        		"listAllchickenraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        /*
         * SOBA
         */
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 95),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 98),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                        		"listAllchickenraw",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 34),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 35),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllbeefraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 36),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 37),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 79)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 38),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 81)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 39),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                new ItemStack(ItemLoader.FOODSET, 1, 6)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 40),
                        new ItemStack(ItemLoader.MATERIAL, 1, 10),
                        new Object[]{
                                new ItemStack(ItemLoader.MATERIAL, 1, 32),
                                "listAllmeatraw",
                                "listAllveggie",
                                "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
       
        //others
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
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 88),
                        "listAllchickencooked",
                        new Object[]{
                                "foodFlour",
                                "listAllegg",
                                "foodBreadcrumbs",
                                "dustSalt",
                                "foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 4, 62),
                        new ItemStack(ItemLoader.FOODSET, 1, 48),
                        new Object[]{
                        		 new ItemStack(ItemLoader.FOODSET, 1, 57),
                                "listAllegg",
                                "dustSalt",
                                "foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 79),
                        new ItemStack(ItemLoader.FOODSET, 1, 78),
                        new Object[]{
                        new ItemStack(ItemLoader.MATERIAL, 1, 14),
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 68),
                        "cropRice",
                        new Object[]{
                        		"listAllmeatraw",
                        		"listAllegg",
                        		"listAllveggie"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 107),
                        "cropPotato",
                        new Object[]{
                        		"dustSalt",
                        		"foodBlackpepper"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 4, 57),
                        "cropPotato",
                        new Object[]{
                        		"cropPotato",
                        		"dustSalt"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 105),
                        "cropRice",
                        new Object[]{	
                        new ItemStack(ItemLoader.FOODSET, 1, 3),
                        "dustSalt",
                        "listAllsugar"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 67),
                        "cropRice",
                        new Object[]{
                        "cropTomato",
                        "listAllmeatraw",
                        "foodKetchup"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 77),
                        "cropRice",
                        new Object[]{
                        "listAllegg",
                        "foodWhitepepper",
                        "foodSoysauce",
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 66),
                        "listAllbeefraw",
                        new Object[]{
                        "cropPotato",
                        "cropCarrot",
                        "foodSoysauce",
                        "listAllsugar"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 74),
                        new ItemStack(ItemLoader.FOODSET, 1, 59),
                        new Object[]{
                        new ItemStack(ItemLoader.RED_BEAN, 1)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 83),
                        "stickWood",
                        new Object[]{
                        new ItemStack(ItemLoader.FOODSET, 1, 80),
                        "cropRadish",
                        "listAllegg"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 2, 11),
                        new ItemStack(ItemLoader.MATERIAL, 1, 3),
                        new Object[]{
                        "cropOnion",
                        "cropTomato",
                        "cropPotato",
                        "cropCarrot",
                        "listAllmeatraw"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 79),
                        new ItemStack(ItemLoader.FOODSET, 1, 78),
                        new Object[]{
                        new ItemStack(ItemLoader.MATERIAL, 1, 14)
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 2, 13),
                        "listAllmilk",
                        new Object[]{
                        "foodFlour",
                        "dustSalt",
                        "foodWhitepepper"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 110),
                        new ItemStack(ItemLoader.MATERIAL, 1, 13),
                        new Object[]{
                        "listAllchickenraw",
                        "cropCarrot",
                        "cropPotato",
                        "listAllmushroom"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 109),
                        "cropCabbage",
                        new Object[]{
                        new ItemStack(ItemLoader.FOODSET, 1, 48),
                        "dustSalt",
                        "foodKetchup",
                        "foodWhitepepper"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 108),
                        "cropRadish",
                        new Object[]{
                        new ItemStack(ItemLoader.MATERIAL, 1, 29),
                        "dustSalt"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 103),
                        "listAllmilk",
                        new Object[]{
                        "listAllsugar",
                        "listAllegg",
                        "foodVanilla"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 104),
                        "listAllmilk",
                        new Object[]{
                        "listAllsugar",
                        "listAllegg",
                        "foodVanilla",
                        SakuraOreDictLoader.MAPLE_SYRUP
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.FOODSET, 2, 106),
                        "listAllfishfresh",
                        new Object[]{
                        "foodSoysauce",
                        "listAllsugar",
                        "dustSalt"
                        },
                        new FluidStack(BlockLoader.FOODOIL_FLUID, 200)));

        TileEntityCampfirePot.PotRecipes.addPotRecipe(
                new TileEntityCampfirePot.PotRecipes(
                        new ItemStack(ItemLoader.MATERIAL, 2, 32),
                        "foodSoysauce",
                        new Object[]{
                                "listAllsugar",
                                "dustSalt"
                        },
                        new FluidStack(FluidRegistry.WATER, 200)));
    }
}
