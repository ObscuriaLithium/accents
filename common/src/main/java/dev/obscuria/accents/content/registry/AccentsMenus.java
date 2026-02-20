package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.inventory.SewingMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public interface AccentsMenus {

    MenuType<SewingMenu> SEWING_STATION = register("sewing_station", SewingMenu::new);

    private static <T extends AbstractContainerMenu> MenuType<T> register(String name, MenuType.MenuSupplier<T> supplier) {
        var type = new MenuType<>(supplier, FeatureFlags.VANILLA_SET);
        AccentsRegistries.REGISTRAR.register(Registries.MENU, Accents.key(name), () -> type);
        return type;
    }

    static void init() {}
}
