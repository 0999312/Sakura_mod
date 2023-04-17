package cn.mcmod.sakura.loot_modifier;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import cn.mcmod.sakura.item.ItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

public class SeedsDrop {
    public static class SeedDropModifier extends LootModifier {
        protected SeedDropModifier(LootItemCondition[] conditionsIn) {
            super(conditionsIn);
        }

        @Nonnull
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
            List<Item> seeds = Lists.newArrayList(ItemRegistry.CABBAGE_SEEDS.get(), ItemRegistry.EGGPLANT_SEEDS.get(),
                    ItemRegistry.ONION_SEEDS.get(), ItemRegistry.RADISH_SEEDS.get(), ItemRegistry.TOMATO_SEEDS.get(),
                    ItemRegistry.RICE_SEEDS.get(), ItemRegistry.RAPESEEDS.get(), ItemRegistry.TARO.get(), ItemRegistry.BUCKWHEAT.get(),
                    ItemRegistry.SOYBEAN.get(), ItemRegistry.RED_BEAN.get());
            generatedLoot.add(new ItemStack(seeds.get((int) (Math.random() * seeds.size()))));
            return generatedLoot;
        }
    }

    public static class Serializer extends GlobalLootModifierSerializer<SeedDropModifier> {
        @Override
        public SeedDropModifier read(ResourceLocation location, JsonObject object,
                LootItemCondition[] ailootcondition) {
            return new SeedDropModifier(ailootcondition);
        }

        @Override
        public JsonObject write(SeedDropModifier instance) {
            return new JsonObject();
        }
    }

}
