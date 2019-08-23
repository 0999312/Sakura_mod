package cn.mcmod.sakura.api.recipes;

import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BarrelRecipes {
    public static final int DEFAULT_DURATION = 9000;
    private static List<BarrelRecipes> recipeRegistry = new ArrayList<>();
    private int duration;
    private FluidStack input;
    private FluidStack output;
    private List<Object> additives;
    private List<ItemStack> transformed;

    public BarrelRecipes(FluidStack input, FluidStack output, Object[] additives, int duration) {
        this.input = input;
        this.output = output;
        this.additives = additives != null ? Arrays.asList(additives) : new ArrayList<>();
        this.duration = duration;
    }

    public BarrelRecipes(FluidStack input, FluidStack output, int duration) {
        this(input, output, null, duration);
    }

    public static void init() {
        register(new BarrelRecipes(new FluidStack(BlockLoader.BEER_FLUID, 1), new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 200), 200));
        register(new BarrelRecipes(new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 1), new FluidStack(BlockLoader.DOBUROKU_FLUID, 100), 9000));
        register(new BarrelRecipes(
                new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 1),
                new FluidStack(BlockLoader.FOODOIL_FLUID, 200),
                new Object[]{new ItemStack(Items.GLASS_BOTTLE)},
                100));
        register(new BarrelRecipes(
                new FluidStack(BlockLoader.CHAMPAGNE_FLUID, 1),
                new FluidStack(BlockLoader.BEER_FLUID, 200),
                new Object[]{new ItemStack(Items.GLASS_BOTTLE), "stone"},
                100));
    }

    public static void register(BarrelRecipes recipes) {
        recipeRegistry.add(recipes);
    }

    public static List<BarrelRecipes> getPossibleRecipes(FluidStack input, List<ItemStack> items) {


        List<BarrelRecipes> result = new ArrayList<>();

        for (BarrelRecipes br : recipeRegistry) {
            List<ItemStack> examine = new ArrayList<>();
            for (ItemStack item : items)
                examine.add(item.copy());

            if (br.getInput().isFluidEqual(input) && br.getInput().amount <= input.amount) {
                boolean matched = true;
                for (Object i : br.getAdditives()) {
                    boolean found = false;
                    for (ItemStack j : examine) {
                        if (i instanceof ItemStack)
                            if (((ItemStack) i).isItemEqual(j) &&
                                    ((ItemStack) i).getCount() <= j.getCount()) {
                                found = true;
                                j.setCount(j.getCount() - ((ItemStack) i).getCount());
                                break;
                            }
                        if (i instanceof String) {
                            NonNullList<ItemStack> ore = OreDictionary.getOres((String) i);
                            if (!ore.isEmpty() && OreDictionary.containsMatch(true, ore, j)) {
                                found = true;
                                j.shrink(1);
                                break;
                            }
                        }

                    }
                    if (!found) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    br.transformed = examine;
                    result.add(br);
                }
            }
        }

        return result;
    }

    public static List<BarrelRecipes> getRecipeRegistry() {
        return recipeRegistry;
    }

    public FluidStack getInput() {
        return input;
    }

    public FluidStack getOutput() {
        return output;
    }

    public int getDuration() {
        return duration;
    }

    public List<Object> getAdditives() {
        return additives;
    }

    public List<ItemStack> getTransformed() {
        return transformed;
    }
}
