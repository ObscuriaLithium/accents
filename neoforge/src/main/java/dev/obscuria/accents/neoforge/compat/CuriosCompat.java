package dev.obscuria.accents.neoforge.compat;

import dev.obscuria.accents.content.registry.AccentsItems;
import net.neoforged.fml.loading.FMLEnvironment;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public final class CuriosCompat {

    public static void init() {
        CuriosApi.registerCurio(AccentsItems.SHEATHED_KATANA.get(), VanityCurio.SHARED);
        CuriosApi.registerCurio(AccentsItems.HOLSTERED_BELT.get(), VanityCurio.SHARED);
        CuriosApi.registerCurio(AccentsItems.BANDOLIER.get(), VanityCurio.SHARED);
        CuriosApi.registerCurio(AccentsItems.QUIVER.get(), VanityCurio.SHARED);
        CuriosApi.registerCurio(AccentsItems.WINGS.get(), VanityCurio.SHARED);

        if (FMLEnvironment.getDist().isClient())
            clientInit();
    }

    public static void clientInit() {
        ICurioRenderer.register(AccentsItems.SHEATHED_KATANA.get(), VanityCurioRenderer::new);
        ICurioRenderer.register(AccentsItems.HOLSTERED_BELT.get(), VanityCurioRenderer::new);
        ICurioRenderer.register(AccentsItems.BANDOLIER.get(), VanityCurioRenderer::new);
        ICurioRenderer.register(AccentsItems.QUIVER.get(), VanityCurioRenderer::new);
        ICurioRenderer.register(AccentsItems.WINGS.get(), VanityCurioRenderer::new);
    }
}
