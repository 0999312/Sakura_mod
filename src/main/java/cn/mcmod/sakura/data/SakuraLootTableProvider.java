package cn.mcmod.sakura.data;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import cn.mcmod.sakura.data.loot.SakuraBlockLoot;
import cn.mcmod_mmf.mmlib.data.AbstractLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class SakuraLootTableProvider extends AbstractLootTableProvider {

    public SakuraLootTableProvider(DataGenerator gen) {
        super(gen);
    }
    
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> tables = ImmutableList.of(Pair.of(SakuraBlockLoot::new, LootContextParamSets.BLOCK));

    @Override
    public String getName() {
        return "Sakura's Loot Tables";
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables() {
        return tables;
    }

}
