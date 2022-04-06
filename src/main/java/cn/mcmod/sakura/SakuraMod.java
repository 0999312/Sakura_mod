package cn.mcmod.sakura;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.mcmod.sakura.block.BlockItemRegistry;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.entity.BlockEntityRegistry;
import cn.mcmod.sakura.client.particle.ParticleRegistry;
import cn.mcmod.sakura.container.ContainerRegistry;
import cn.mcmod.sakura.fluid.BucketItemRegistry;
import cn.mcmod.sakura.fluid.FluidBlockRegistry;
import cn.mcmod.sakura.fluid.FluidRegistry;
import cn.mcmod.sakura.item.ComposterRegistry;
import cn.mcmod.sakura.item.FoodRegistry;
import cn.mcmod.sakura.item.ItemRegistry;
import cn.mcmod.sakura.item.enums.SakuraFoodSet;
import cn.mcmod.sakura.level.WorldGenerationRegistry;
import cn.mcmod.sakura.level.biome.BiomeRegistryExample;
import cn.mcmod.sakura.loot_modifier.LootModifiterRegistry;
import cn.mcmod.sakura.recipes.RecipeTypeRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SakuraMod.MODID)
public class SakuraMod {
    public static final String MODID = "sakura";
    private static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeModeTab GROUP = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FoodRegistry.FOODSET.get(SakuraFoodSet.ONIGIRI).get());
        }
    };

    public static Item.Properties defaultItemProperties() {
        return new Item.Properties().tab(SakuraMod.GROUP);
    }

    public SakuraMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        BlockRegistry.BLOCKS.register(modEventBus);
        BlockItemRegistry.ITEMS.register(modEventBus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        FoodRegistry.ITEMS.register(modEventBus);
        FluidRegistry.FLUIDS.register(modEventBus);
        FluidBlockRegistry.BLOCKS.register(modEventBus);
        BucketItemRegistry.ITEMS.register(modEventBus);
        ParticleRegistry.PARTICLE_TYPES.register(modEventBus);
        ContainerRegistry.CONTAINER_TYPES.register(modEventBus);
        LootModifiterRegistry.GLM.register(modEventBus);
        RecipeTypeRegistry.RECIPES.register(modEventBus);
        BiomeRegistryExample.BIOMES.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SakuraConfig.COMMON_CONFIG);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            WorldGenerationRegistry.registerGeneration();
            BiomeDictionary.addTypes(BiomeRegistryExample.EXAMPLE_KEY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD);
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL, 
                    new BiomeManager.BiomeEntry(BiomeRegistryExample.EXAMPLE_KEY, 15));
            ComposterRegistry.registerCompost();
        });
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
