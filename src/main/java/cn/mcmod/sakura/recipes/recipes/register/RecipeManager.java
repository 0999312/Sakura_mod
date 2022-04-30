package cn.mcmod.sakura.recipes.recipes.register;

import cn.mcmod.sakura.recipes.recipes.base.BaseRecipe;
import cn.mcmod.sakura.recipes.recipes.recipe.FermenterFluidRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DustW
 **/
public class RecipeManager {
    public static <T extends BaseRecipe<T>> List<T> getRecipe(Level level, RecipeType<T> type, List<ItemStack> itemStacks) {
        return level.getRecipeManager().getAllRecipesFor(type).stream().filter(s -> s.matches(itemStacks)).collect(Collectors.toList());
    }

    public static FermenterFluidRecipe getFermenterFuildRecipe(Level level, ItemStack itemStack, FluidStack inputFuild) {
        return level.getRecipeManager().getAllRecipesFor(RecipeTypes.FERMENTER_FLUID.get())
                .stream().filter(s -> s.matches(itemStack, inputFuild)).findFirst().orElse(null);
    }

    public static void register(IEventBus bus) {
        RecipeTypes.register(bus);
        RecipeSerializers.register(bus);
    }
}
