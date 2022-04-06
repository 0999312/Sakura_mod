package cn.mcmod.sakura.loot_modifier;

import java.util.List;

import com.google.gson.JsonObject;

import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.enums.SakuraFoodSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

public class FishingModifiter extends LootModifier{

    protected FishingModifiter(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(FoodRegistry.FOODSET.get(SakuraFoodSet.SHRIMP).get()));
        return generatedLoot;
    }
    
    public static class Serializer extends GlobalLootModifierSerializer<FishingModifiter> {
        @Override
        public FishingModifiter read(ResourceLocation location, JsonObject object,
                LootItemCondition[] ailootcondition) {
            return new FishingModifiter(ailootcondition);
        }

        @Override
        public JsonObject write(FishingModifiter instance) {
            return new JsonObject();
        }
    }

}
