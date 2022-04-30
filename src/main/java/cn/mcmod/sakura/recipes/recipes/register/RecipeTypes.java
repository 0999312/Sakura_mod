package cn.mcmod.sakura.recipes.recipes.register;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.recipes.recipes.base.BaseRecipe;
import cn.mcmod.sakura.recipes.recipes.recipe.FermenterFluidRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author DustW
 **/
public class RecipeTypes {
    private static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(Registry.RECIPE_TYPE.key(), SakuraMod.MODID);

    public static final RegistryObject<RecipeType<FermenterFluidRecipe>> FERMENTER_FLUID = register("fermenter_fluid");

    private static <TYPE extends BaseRecipe<TYPE>> RegistryObject<RecipeType<TYPE>> register(String name) {
        return TYPES.register(name, () -> new RecipeType<>() {
            @Override
            public String toString() {
                return new ResourceLocation(SakuraMod.MODID, name).toString();
            }
        });
    }

    public static void register(IEventBus bus) {
        TYPES.register(bus);
    }
}
