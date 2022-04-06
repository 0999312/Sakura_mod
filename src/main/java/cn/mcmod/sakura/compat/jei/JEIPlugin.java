package cn.mcmod.sakura.compat.jei;

import java.util.List;
import java.util.stream.Collectors;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.client.gui.CookingPotScreen;
import cn.mcmod.sakura.client.gui.StoneMortarScreen;
import cn.mcmod.sakura.compat.jei.category.CookingPotCategory;
import cn.mcmod.sakura.compat.jei.category.StoneMortarCategory;
import cn.mcmod.sakura.container.CookingPotContainer;
import cn.mcmod.sakura.container.StoneMortarContainer;
import cn.mcmod.sakura.recipes.CookingPotRecipe;
import cn.mcmod.sakura.recipes.StoneMortarRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    public static final ResourceLocation PLUGIN_ID = new ResourceLocation(SakuraMod.MODID, "jei_plugin");

    private static final Minecraft MC = Minecraft.getInstance();

    private static List<Recipe<?>> findRecipesByType(RecipeType<?> type) {
        return MC.level.getRecipeManager().getRecipes().stream().filter(r -> r.getType() == type)
                .collect(Collectors.toList());
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new CookingPotCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new StoneMortarCategory(registry.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(findRecipesByType(CookingPotRecipe.TYPE), CookingPotCategory.UID);
        registration.addRecipes(findRecipesByType(StoneMortarRecipe.TYPE), StoneMortarCategory.UID);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.COOKING_POT.get()), CookingPotCategory.UID);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.STONE_MORTAR.get()), StoneMortarCategory.UID);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CookingPotScreen.class, 94, 16, 32, 54, CookingPotCategory.UID);
        registration.addRecipeClickArea(StoneMortarScreen.class, 79, 32, 18, 24, StoneMortarCategory.UID);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(CookingPotContainer.class, CookingPotCategory.UID, 0, 9, 10, 36);
        registration.addRecipeTransferHandler(StoneMortarContainer.class, StoneMortarCategory.UID, 0, 4, 6, 36);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

}
