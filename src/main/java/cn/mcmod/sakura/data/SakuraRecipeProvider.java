package cn.mcmod.sakura.data;

import java.util.function.Consumer;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.data.builder.CookingPotRecipeBuilder;
import cn.mcmod.sakura.data.builder.StoneMortarRecipeBuilder;
import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.tags.SakuraItemTags;
import cn.mcmod_mmf.mmlib.data.AbstractRecipeProvider;
import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

public class SakuraRecipeProvider extends AbstractRecipeProvider {

    public SakuraRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        StoneMortarRecipeBuilder.mortar(Items.BONE_MEAL, 3).addResult(Items.BONE_MEAL, 3).requires(Tags.Items.BONES)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "bonemeal_from_mortar"));

        StoneMortarRecipeBuilder.mortar(ItemRegistry.MATERIALS.get("brown_rice").get(), 1)
                .requires(SakuraItemTags.SEEDS_RICE)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "brown_rice_from_mortar"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                        FoodRegistry.getFood(FoodRegistry.FOODSET, "brown_rice_cooked").get())
                .requires(ItemRegistry.MATERIALS.get("brown_rice").get())
                .requires(ItemRegistry.MATERIALS.get("brown_rice").get())
                .requires(ItemRegistry.MATERIALS.get("brown_rice").get())
                .requires(ItemRegistry.MATERIALS.get("brown_rice").get())
                .requires(ItemRegistry.MATERIALS.get("brown_rice").get())
                .requires(ItemRegistry.MATERIALS.get("brown_rice").get())
                .requires(ItemRegistry.MATERIALS.get("brown_rice").get())
                .requires(ItemRegistry.MATERIALS.get("brown_rice").get())
                .requires(ItemRegistry.MATERIALS.get("brown_rice").get())
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "brown_rice_cooking"));
    }
}
