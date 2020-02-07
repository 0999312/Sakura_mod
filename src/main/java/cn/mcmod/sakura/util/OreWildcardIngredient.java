package cn.mcmod.sakura.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntComparators;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.client.util.RecipeItemHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;

public class OreWildcardIngredient extends OreIngredient {
    private NonNullList<ItemStack> ores;
    private IntList itemIds = null;
    private ItemStack[] array = null;
    private int lastSizeA = -1, lastSizeL = -1;

    public OreWildcardIngredient(String ore){
        super(ore);
        ores = OreDictionary.getOres(ore);
    }

    @Override
    @Nonnull
    public ItemStack[] getMatchingStacks() {
        if (array == null || this.lastSizeA != ores.size()) {
            NonNullList<ItemStack> lst = NonNullList.create();
            for (ItemStack itemstack : this.ores){
                    lst.add(itemstack);
            }
            this.array = lst.toArray(new ItemStack[lst.size()]);
            this.lastSizeA = ores.size();
        }
        return this.array;
    }


    @Override
    @Nonnull
    public IntList getValidItemStacksPacked() {
        if (this.itemIds == null || this.lastSizeL != ores.size()) {
            this.itemIds = new IntArrayList(this.ores.size());

            for (ItemStack itemstack : this.ores) {
             this.itemIds.add(RecipeItemHelper.pack(itemstack));
            }

            this.itemIds.sort(IntComparators.NATURAL_COMPARATOR);
            this.lastSizeL = ores.size();
        }

        return this.itemIds;
    }


    @Override
    public boolean apply(@Nullable ItemStack input) {
        if (input == null)
            return false;

        for (ItemStack target : this.ores)
            if (RecipesUtil.itemMatches(target, input, false))
                return true;

        return false;
    }

    @Override
    protected void invalidate() {
        this.itemIds = null;
        this.array = null;
    }

    @Override
    public boolean isSimple() {
        return false;
    }
}