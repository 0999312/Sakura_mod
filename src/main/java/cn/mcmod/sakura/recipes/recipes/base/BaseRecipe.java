package cn.mcmod.sakura.recipes.recipes.base;

import com.google.gson.annotations.Expose;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * @author DustW
 **/
public abstract class BaseRecipe<SELF extends BaseRecipe<SELF>> implements Recipe<Container> {
    @Expose(deserialize = false, serialize = false)
    ResourceLocation id;
    @Expose
    public String type;

    public abstract boolean matches(List<ItemStack> inputs);

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return false;
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return false;
    }

    public SELF setID(ResourceLocation id) {
        this.id = id;
        return self();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    private SELF self() {
        return (SELF) this;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BaseRecipe recipe && recipe.id.equals(id);
    }
}
