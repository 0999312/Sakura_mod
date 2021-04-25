package cn.mcmod.sakura;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = SakuraMain.MODID)
@Mod.EventBusSubscriber(modid = SakuraMain.MODID)
public class SakuraConfig {
	private final static String config = "sakura.config.";

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
	
	@Config.LangKey(config + "ume_weight")
	@Config.RequiresMcRestart
	@Config.RangeInt(min = 0, max = 2000)
	@Config.Comment("Changes generate rate of Ume. Increase value to gen more Ume.")
	public static int ume_weight = 90;

	@Config.LangKey(config + "iron_sand_amount")
	@Config.RequiresMcRestart
	@Config.RangeInt(min = 1, max = 5120)
	@Config.Comment("Changes generate amount of Iron Sand. Increase value to gen more Iron Sand.")
	public static int iron_sand_amount = 128;

	@Config.LangKey(config + "hotspring_weight")
	@Config.RequiresMcRestart
	@Config.RangeInt(min = 0, max = 5000)
	@Config.Comment("Changes generate rate of Hot Spring. Increase value to gen more Hot Spring.")
	public static int hotspring_weight = 10;

	@Config.LangKey(config + "harder_iron_recipe")
	@Config.RequiresMcRestart
	@Config.Comment("Whether to enable a more difficult iron ingot recipe.")
	public static boolean harder_iron_recipe = false;

	@Config.LangKey(config + "harder_iron_difficult")
	@Config.RequiresMcRestart
	@Config.RangeInt(min = 1, max = 3)
	@Config.Comment("Changes difficult level of harder iron ingot recipe.")
	public static int harder_iron_difficult = 1;

	@Config.LangKey(config + "every_where_sakura_diamond")
	@Config.RequiresMcRestart
	@Config.Comment("Whether to enable spawn sakura diamond in every biome.")
	public static boolean every_where_sakura_diamond = false;

	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(SakuraMain.MODID)) {
			ConfigManager.sync(SakuraMain.MODID, Config.Type.INSTANCE);
		}
	}
}
