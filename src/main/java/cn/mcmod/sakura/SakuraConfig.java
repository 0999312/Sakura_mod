package cn.mcmod.sakura;

import net.minecraftforge.common.ForgeConfigSpec;

public class SakuraConfig {
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.BooleanValue GENERATE_BAMBOOSHOOT;
    public static ForgeConfigSpec.IntValue CHANCE_BAMBOOSHOOT;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("General settings").push("general");
        GENERATE_BAMBOOSHOOT = COMMON_BUILDER
                .comment("Generate Bambooshoot on cold biomes (temperature between 0.4 and 1.0)")
                .define("genBambooshoot", true);
        CHANCE_BAMBOOSHOOT = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 30, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
