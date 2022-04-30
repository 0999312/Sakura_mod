package cn.mcmod.sakura.recipes.recipes.json.serializer;

import com.google.gson.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Type;

/**
 * @author DustW
 **/
public class ItemStackSerializer implements JsonSerializer<ItemStack>, JsonDeserializer<ItemStack> {
    @Override
    public ItemStack deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(json.getAsJsonObject().get("item").getAsString()));

        if (item != null) {
            int count = json.getAsJsonObject().get("count").getAsInt();

            return new ItemStack(item, count);
        }

        return ItemStack.EMPTY;
    }

    @Override
    public JsonElement serialize(ItemStack src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.addProperty("item", src.getItem().getRegistryName().toString());
        result.addProperty("count", src.getCount());
        return result;
    }
}
