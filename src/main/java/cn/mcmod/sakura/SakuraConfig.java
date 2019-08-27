package cn.mcmod.sakura;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@SuppressWarnings("WeakerAccess")
@Config(modid = SakuraMain.MODID)
@Mod.EventBusSubscriber(modid = SakuraMain.MODID)
public class SakuraConfig {
    private final static String config = SakuraMain.MODID + ".config.";

    @Config.LangKey(config + "vanilla_weight")
    @Config.RequiresMcRestart
    @Config.RangeInt(min = 0, max = 2000)
    @Config.Comment("Changes generate rate of Vanilla. Increase value to gen more Vanilla.")
    public static int vanilla_weight = 90;
    @Config.LangKey(config + "pepper_weight")
    @Config.RequiresMcRestart
    @Config.RangeInt(min = 0, max = 2000)
    @Config.Comment("Changes generate rate of Pepper. Increase value to gen more Pepper.")
    public static int pepper_weight = 90;
    @Config.LangKey(config + "bambooshot_weight")
    @Config.RequiresMcRestart
    @Config.RangeInt(min = 0, max = 2000)
    @Config.Comment("Changes generate rate of BambooShot. Increase value to gen more BambooShot.")
    public static int bambooshot_weight = 90;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(SakuraMain.MODID)) {
            ConfigManager.sync(SakuraMain.MODID, Config.Type.INSTANCE);
        }
    }
}
