package dev.obscuria.accents.fabric.compat;

import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import dev.obscuria.accents.content.registry.AccentsItems;
import dev.obscuria.accents.fabric.client.renderer.AutoTrinketRenderer;

public final class TrinketsCompat {

    public static void init() {
        TrinketsApi.registerTrinket(AccentsItems.SHEATHED_KATANA.asItem(), VanityTrinket.SHARED);
        TrinketsApi.registerTrinket(AccentsItems.HOLSTERED_BELT.asItem(), VanityTrinket.SHARED);
        TrinketsApi.registerTrinket(AccentsItems.BANDOLIER.asItem(), VanityTrinket.SHARED);
        TrinketsApi.registerTrinket(AccentsItems.QUIVER.asItem(), VanityTrinket.SHARED);
        TrinketsApi.registerTrinket(AccentsItems.WINGS.asItem(), VanityTrinket.SHARED);
    }

    public static void clientInit() {
        TrinketRendererRegistry.registerRenderer(AccentsItems.SHEATHED_KATANA.asItem(), AutoTrinketRenderer.SHARED);
        TrinketRendererRegistry.registerRenderer(AccentsItems.HOLSTERED_BELT.asItem(), AutoTrinketRenderer.SHARED);
        TrinketRendererRegistry.registerRenderer(AccentsItems.BANDOLIER.asItem(), AutoTrinketRenderer.SHARED);
        TrinketRendererRegistry.registerRenderer(AccentsItems.QUIVER.asItem(), AutoTrinketRenderer.SHARED);
        TrinketRendererRegistry.registerRenderer(AccentsItems.WINGS.asItem(), AutoTrinketRenderer.SHARED);
    }
}
