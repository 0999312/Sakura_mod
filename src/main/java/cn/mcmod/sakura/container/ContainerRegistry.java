package cn.mcmod.sakura.container;

import cn.mcmod.sakura.SakuraMod;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ContainerRegistry {
    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister
            .create(ForgeRegistries.CONTAINERS, SakuraMod.MODID);

    public static final RegistryObject<MenuType<StoneMortarContainer>> STONE_MORTAR = CONTAINER_TYPES
            .register("stone_mortar", () -> IForgeMenuType.create(StoneMortarContainer::new));

    public static final RegistryObject<MenuType<CookingPotContainer>> COOKING_POT = CONTAINER_TYPES
            .register("cooking_pot", () -> IForgeMenuType.create(CookingPotContainer::new));
    
    public static final RegistryObject<MenuType<FermenterContainer>> FERMENTER = CONTAINER_TYPES
            .register("fermenter", () -> IForgeMenuType.create(FermenterContainer::new));
    
    public static final RegistryObject<MenuType<DistillerContainer>> DISTILLER = CONTAINER_TYPES
            .register("distiller", () -> IForgeMenuType.create(DistillerContainer::new));
}
