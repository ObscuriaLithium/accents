package dev.obscuria.accents.neoforge.compat;

import dev.obscuria.accents.content.registry.AccentsItems;
import net.neoforged.fml.loading.FMLEnvironment;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public final class CuriosCompat {

    public static void init() {
        CuriosApi.registerCurio(AccentsItems.SHEATHED_KATANA.asItem(), VanityCurio.SHARED);
        CuriosApi.registerCurio(AccentsItems.HOLSTERED_BELT.asItem(), VanityCurio.SHARED);
        CuriosApi.registerCurio(AccentsItems.BANDOLIER.asItem(), VanityCurio.SHARED);
        CuriosApi.registerCurio(AccentsItems.QUIVER.asItem(), VanityCurio.SHARED);
        CuriosApi.registerCurio(AccentsItems.WINGS.asItem(), VanityCurio.SHARED);

        if (FMLEnvironment.dist.isClient())
            clientInit();
    }

    public static void clientInit() {
        CuriosRendererRegistry.register(AccentsItems.SHEATHED_KATANA.asItem(), VanityCurioRenderer::new);
        CuriosRendererRegistry.register(AccentsItems.HOLSTERED_BELT.asItem(), VanityCurioRenderer::new);
        CuriosRendererRegistry.register(AccentsItems.BANDOLIER.asItem(), VanityCurioRenderer::new);
        CuriosRendererRegistry.register(AccentsItems.QUIVER.asItem(), VanityCurioRenderer::new);
        CuriosRendererRegistry.register(AccentsItems.WINGS.asItem(), VanityCurioRenderer::new);
    }
}
