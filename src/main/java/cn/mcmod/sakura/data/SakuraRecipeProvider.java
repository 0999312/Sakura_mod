package cn.mcmod.sakura.data;

import java.util.function.Consumer;
import java.util.function.Supplier;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.data.builder.CookingPotRecipeBuilder;
import cn.mcmod.sakura.data.builder.StoneMortarRecipeBuilder;
import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.item.enums.SakuraFoodSet;
import cn.mcmod.sakura.item.enums.SakuraNormalItemSet;
import cn.mcmod.sakura.tags.SakuraItemTags;
import cn.mcmod_mmf.mmlib.data.AbstractRecipeProvider;
import cn.mcmod_mmf.mmlib.fluid.FluidIngredient;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class SakuraRecipeProvider extends AbstractRecipeProvider {

    public SakuraRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(BlockRegistry.COOKING_POT.get())
            .pattern("#L#").pattern("###")
            .define('#', Tags.Items.INGOTS_IRON)
            .define('L', SakuraItemTags.LUMBER)
            .unlockedBy("has_item", has(SakuraItemTags.LUMBER))
            .save(consumer);
        
        ShapedRecipeBuilder.shaped(BlockRegistry.STONE_MORTAR.get())
            .pattern("L  ")
            .pattern("###")
            .pattern("###")
            .define('#', Tags.Items.COBBLESTONE)
            .define('L', SakuraItemTags.LUMBER)
            .unlockedBy("has_item", has(SakuraItemTags.LUMBER))
            .save(consumer);
        
        foodSmeltingRecipes("eggplant_bake", 
                FoodRegistry.FOODSET.get(SakuraFoodSet.EGGPLANT).get(), 
                FoodRegistry.FOODSET.get(SakuraFoodSet.EGGPLANT_BAKED).get(), 
                0.5F, consumer);
        foodSmeltingRecipes("taro_bake", 
                ItemRegistry.TARO.get(), 
                FoodRegistry.FOODSET.get(SakuraFoodSet.TARO_BAKED).get(), 
                0.5F, consumer);
        
        ShapelessRecipeBuilder.shapeless(BlockRegistry.SAKURA_SAPLING.get())
            .requires(ItemTags.SAPLINGS).requires(Tags.Items.DYES_PINK)
            .unlockedBy("has_sapling", has(ItemTags.SAPLINGS))
            .save(consumer);
        ShapelessRecipeBuilder.shapeless(BlockRegistry.MAPLE_SAPLING_RED.get())
            .requires(ItemTags.SAPLINGS).requires(Tags.Items.DYES_RED)
            .unlockedBy("has_sapling", has(ItemTags.SAPLINGS))
            .save(consumer);
        ShapelessRecipeBuilder.shapeless(BlockRegistry.MAPLE_SAPLING_GREEN.get())
            .requires(ItemTags.SAPLINGS).requires(Tags.Items.DYES_GREEN)
            .unlockedBy("has_sapling", has(ItemTags.SAPLINGS))
            .save(consumer);
        ShapelessRecipeBuilder.shapeless(BlockRegistry.MAPLE_SAPLING_YELLOW.get())
            .requires(ItemTags.SAPLINGS).requires(Tags.Items.DYES_YELLOW)
            .unlockedBy("has_sapling", has(ItemTags.SAPLINGS))
            .save(consumer);
        ShapelessRecipeBuilder.shapeless(BlockRegistry.MAPLE_SAPLING_ORANGE.get())
            .requires(ItemTags.SAPLINGS).requires(Tags.Items.DYES_ORANGE)
            .unlockedBy("has_sapling", has(ItemTags.SAPLINGS))
            .save(consumer);
        
        makeIngotToBlock(BlockRegistry.BAMBOO_BLOCK, ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO))
                .unlockedBy("has_item", has(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO).get()))
                .save(consumer);
        makeIngotToBlock(BlockRegistry.BAMBOO_BLOCK, ()->Items.BAMBOO)
                .unlockedBy("has_item", has(Items.BAMBOO))
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "bamboo_block_from_vanilla_bamboo"));
        makeIngotToBlock(BlockRegistry.BAMBOO_BLOCK_SUNBURNT, 
                ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_SUNBURNT))
                .unlockedBy("has_item",has(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_SUNBURNT).get()))
                .save(consumer);
        makeIngotToBlock(BlockRegistry.BAMBOO_CHARCOAL_BLOCK, 
                ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_CHARCOAL))
                .unlockedBy("has_item", has(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_CHARCOAL).get()))
                .save(consumer);
        
        makeBlockToIngot(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO), 
                BlockRegistry.BAMBOO_BLOCK).save(consumer);
        makeBlockToIngot(()->Items.BAMBOO, BlockRegistry.BAMBOO_BLOCK)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "bamboo_block_to_vanilla_bamboo"));
        makeBlockToIngot(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_CHARCOAL),
                BlockRegistry.BAMBOO_CHARCOAL_BLOCK)
                .save(consumer);
        makeBlockToIngot(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_SUNBURNT),
                BlockRegistry.BAMBOO_BLOCK_SUNBURNT)
                .save(consumer);
        
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.LUMBER_BAMBOO), 
                Ingredient.of(SakuraItemTags.BAMBOO))
                .unlockedBy("has_item", has(SakuraItemTags.BAMBOO))
                .save(consumer);
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.LUMBER_MAPLE), 
                Ingredient.of(BlockRegistry.MAPLE_LOG.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.MAPLE_LOG.get())).save(consumer);
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.LUMBER_SAKURA), 
                Ingredient.of(BlockRegistry.SAKURA_LOG.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.SAKURA_LOG.get())).save(consumer);
        
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.LUMBER_MAPLE), 
                Ingredient.of(BlockRegistry.MAPLE_WOOD.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.MAPLE_LOG.get()))
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "maple_lumber_from_wood"));
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.LUMBER_SAKURA), 
                Ingredient.of(BlockRegistry.SAKURA_WOOD.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.SAKURA_LOG.get()))
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "sakura_lumber_from_wood"));
        
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.LUMBER_MAPLE), 
                Ingredient.of(BlockRegistry.STRIPPED_MAPLE_LOG.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.MAPLE_LOG.get()))
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "maple_lumber_from_stripped"));
        makeLumber(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.LUMBER_SAKURA), 
                Ingredient.of(BlockRegistry.STRIPPED_SAKURA_LOG.get()))
                .unlockedBy("has_item", has(BlockItemRegistry.SAKURA_LOG.get()))
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "sakura_lumber_from_stripped"));
        
        makeLumberToPlank(BlockRegistry.BAMBOO_PLANK, 
                Ingredient.of(SakuraItemTags.LUMBER_BAMBOO))
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);
        makeLumberToPlank(BlockRegistry.MAPLE_PLANK,
                Ingredient.of(SakuraItemTags.LUMBER_MAPLE))
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);
        makeLumberToPlank(BlockRegistry.SAKURA_PLANK,
                Ingredient.of(SakuraItemTags.LUMBER_SAKURA))
                .unlockedBy("has_item", has(SakuraItemTags.LUMBER)).save(consumer);
        
        smeltingRecipe(
                BlockRegistry.BAMBOO_CHARCOAL_BLOCK.get(), 
                BlockRegistry.BAMBOO_BLOCK.get(),
                0.5F).save(consumer, new ResourceLocation(SakuraMod.MODID, "bamboo_charcoal_block_from_smelt"));
        
        smeltingRecipe(
                BlockRegistry.BAMBOO_CHARCOAL_BLOCK.get(), 
                BlockRegistry.BAMBOO_BLOCK_SUNBURNT.get(),
                0.5F).save(consumer, new ResourceLocation(SakuraMod.MODID, "bamboo_charcoal_block_from_sunburnt_smelt"));
        
        smeltingRecipe(
                ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_CHARCOAL).get(), 
                ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO).get(),
                0.5F).save(consumer, new ResourceLocation(SakuraMod.MODID, "bamboo_charcoal_from_smelt"));
        
        smeltingRecipe(
                ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_CHARCOAL).get(), 
                ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BAMBOO_SUNBURNT).get(),
                0.5F).save(consumer, new ResourceLocation(SakuraMod.MODID, "bamboo_charcoal_from_sunburnt_smelt"));
        
        
        StoneMortarRecipeBuilder.mortar(Items.BONE_MEAL, 3).addResult(Items.BONE_MEAL, 3).requires(Tags.Items.BONES)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "bonemeal_from_mortar"));

        StoneMortarRecipeBuilder.mortar(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.BROWN_RICE).get(), 2)
                .requires(SakuraItemTags.SEEDS_RICE)
                .requires(SakuraItemTags.SEEDS_RICE)
                .requires(SakuraItemTags.SEEDS_RICE)
                .requires(SakuraItemTags.SEEDS_RICE)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "brown_rice_from_mortar"));
        
        StoneMortarRecipeBuilder.mortar(ItemRegistry.MATERIALS.get(SakuraNormalItemSet.RICE).get(), 1)
            .requires(SakuraItemTags.RICE_BROWN)
            .requires(SakuraItemTags.RICE_BROWN)
        .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_from_mortar"));

        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                        FoodRegistry.FOODSET.get(SakuraFoodSet.BROWN_RICE_COOKED).get())
                .requires(SakuraItemTags.RICE_BROWN)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "brown_rice_cooking"));
        
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                    FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_COOKED).get())
                .requires(SakuraItemTags.RICE_RICE)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_cooking"));
        
        CookingPotRecipeBuilder
            .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_REDBEAN).get())
            .requires(SakuraItemTags.RICE_RICE)
            .requires(SakuraItemTags.CROPS_REDBEAN)
            .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_redbean_cooking"));
        
        CookingPotRecipeBuilder
            .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_BAMBOO).get())
            .requires(SakuraItemTags.RICE_RICE)
            .requires(BlockRegistry.BAMBOOSHOOT.get())
            .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_bamboo_cooking"));
        
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                    FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_BEEF).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(SakuraItemTags.RAW_BEEF)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_beef_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                    FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_PORK).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(SakuraItemTags.RAW_PORK)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_pork_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                    FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_FISH).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(SakuraItemTags.RAW_FISHES)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_fish_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                    FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_EGG).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_eggs_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                    FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_BEEF_EGG).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(SakuraItemTags.RAW_BEEF)
                .requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_beef_eggs_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                    FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_PORK_EGG).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(SakuraItemTags.RAW_PORK)
                .requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_pork_eggs_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                    FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_OYAKO).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(SakuraItemTags.RAW_CHICKEN)
                .requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_oyako_cooking"));
        CookingPotRecipeBuilder
                .cooking(FluidIngredient.fromTag(FluidTags.WATER, 50),
                    FoodRegistry.FOODSET.get(SakuraFoodSet.RICE_OYAKO_FISH).get())
                .requires(SakuraItemTags.RICE_RICE)
                .requires(SakuraItemTags.RAW_FISHES)
                .requires(SakuraItemTags.EGGS)
                .save(consumer, new ResourceLocation(SakuraMod.MODID, "rice_oyako_fish_cooking"));
    }
    
    private void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, Consumer<FinishedRecipe> consumer) {
        String namePrefix = new ResourceLocation(SakuraMod.MODID, name).toString();
        smeltingRecipe(result, ingredient, experience).save(consumer);
        campfireRecipe(result, ingredient, experience).save(consumer, namePrefix + "_from_campfire_cooking");
        smokingRecipe(result, ingredient, experience).save(consumer, namePrefix + "_from_smoking");
    }
    
    public ShapedRecipeBuilder makeLumberToPlank(Supplier<? extends Block> blockOut, Ingredient ingreIn) {
        return ShapedRecipeBuilder.shaped(blockOut.get()).pattern("##").pattern("##")
                .define('#', ingreIn);
    }

    public ShapelessRecipeBuilder makeLumber(Supplier<? extends Item> ingotOut,
            Ingredient ingreIn) {
        return ShapelessRecipeBuilder.shapeless(ingotOut.get(), 8).requires(ingreIn);
    }
}
