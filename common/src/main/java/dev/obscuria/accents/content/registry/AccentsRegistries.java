package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.fragmentum.content.registry.FragmentumRegistry;
import dev.obscuria.fragmentum.content.registry.Registrar;

public final class AccentsRegistries {

    static final Registrar REGISTRAR = FragmentumRegistry.registrar(Accents.MODID);

    public static void init() {
        AccentsBlocks.init();
        AccentsItems.init();
        AccentsBlockEntities.init();
        AccentsCreativeTabs.init();
        AccentsRecipes.init();
        AccentsRecipeSerializers.init();
        AccentsMenus.init();
    }
}
