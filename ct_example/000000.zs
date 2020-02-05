import mods.sakura.Barrel;
import mods.sakura.campfirePot;
import mods.sakura.Distillation;
import mods.sakura.liquid_to_itemStack;
import mods.sakura.stoneMorter;

//all.ClearAllRecipe();

stoneMorter.AddRecipe([<item:minecraft:diamond>,<item:minecraft:diamond>,<item:minecraft:diamond>,<item:minecraft:diamond>],[<item:minecraft:flint>,<item:minecraft:flint>]);
stoneMorter.RemoveRecipe([<item:minecraft:sand>,<item:minecraft:flint>]);

campfirePot.AddRecipe([<item:minecraft:diamond>,<item:minecraft:diamond>,<item:minecraft:diamond>],<item:minecraft:apple>,<liquid:lava> * 1000);
campfirePot.RemoveRecipe(<sakura:foodset>.definition.makeStack(85));

liquid_to_itemStack.AddRecipe(<item:minecraft:diamond>,<item:minecraft:apple>,<liquid:rum> * 1000);
liquid_to_itemStack.RemoveRecipe(<sakura:bottle_alcoholic>.definition.makeStack(3));

Barrel.AddRecipe(<liquid:water> * 1000,[<item:minecraft:diamond>,<item:minecraft:diamond>,<item:minecraft:diamond>],<liquid:lava> * 1000);
Barrel.RemoveRecipe(<liquid:beer>);

Distillation.AddRecipe(<liquid:water> * 1000,[<item:minecraft:diamond>,<item:minecraft:diamond>,<item:minecraft:diamond>],<liquid:food_oil> * 1000);
Distillation.RemoveRecipe(<liquid:whiskey>);