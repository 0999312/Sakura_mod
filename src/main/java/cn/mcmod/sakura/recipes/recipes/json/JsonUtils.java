package cn.mcmod.sakura.recipes.recipes.json;

import cn.mcmod.sakura.recipes.recipes.json.serializer.IngredientSerializer;
import cn.mcmod.sakura.recipes.recipes.json.serializer.ItemStackSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * @author DustW
 **/
public enum JsonUtils {
    /** 最 佳 单 例 */
    INSTANCE;
    public final Gson normal;
    public final Gson pretty;
    public final Gson noExpose;

    JsonUtils() {
        GsonBuilder builder = new GsonBuilder()
                // 关闭 html 转义
                .disableHtmlEscaping()
                // 开启复杂 Map 的序列化
                .enableComplexMapKeySerialization()
                // 注册自定义类型的序列化/反序列化器
                .registerTypeAdapter(Ingredient.class, new IngredientSerializer())
                .registerTypeAdapter(ItemStack.class, new ItemStackSerializer());

        // 无视 @Expose 注解的 Gson 实例
        noExpose = builder.create();

        // 要求 *全部*字段都有 @Expose 注解的 Gson 实例
        builder.excludeFieldsWithoutExposeAnnotation();
        normal = builder.create();

        // 输出的字符串漂亮一点的 Gson 实例 -> 输出到 json 文件（例如合成表）的，好看
        builder.setPrettyPrinting();
        pretty = builder.create();
    }
}
