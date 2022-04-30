package cn.mcmod.sakura.recipes.recipes.register;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.recipes.recipes.base.BaseSerializer;
import cn.mcmod.sakura.recipes.recipes.recipe.FermenterFluidRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author DustW
 **/
public class RecipeSerializers {
    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SakuraMod.MODID);

    public static final RegistryObject<BaseSerializer<?>> PLATE_RECIPE =
            SERIALIZER.register("fermenter", () -> new BaseSerializer<>(FermenterFluidRecipe.class));

    public static void register(IEventBus bus) {
        SERIALIZER.register(bus);
    }
}
