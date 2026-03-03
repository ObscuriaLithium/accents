package dev.obscuria.accents.fabric.compat;

import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import dev.obscuria.accents.content.registry.AccentsItems;

public final class TrinketsCompat {

    public static void init() {
        TrinketsApi.registerTrinket(AccentsItems.SHEATHED_KATANA.asItem(), VanityTrinket.SHARED);
        TrinketsApi.registerTrinket(AccentsItems.HOLSTERED_BELT.asItem(), VanityTrinket.SHARED);
        TrinketsApi.registerTrinket(AccentsItems.BANDOLIER.asItem(), VanityTrinket.SHARED);
        TrinketsApi.registerTrinket(AccentsItems.QUIVER.asItem(), VanityTrinket.SHARED);
        TrinketsApi.registerTrinket(AccentsItems.WINGS.asItem(), VanityTrinket.SHARED);
        TrinketsApi.registerTrinket(AccentsItems.SCARF.asItem(), VanityTrinket.SHARED);
        TrinketsApi.registerTrinket(AccentsItems.ITEM_SATCHEL.asItem(), VanityTrinket.SHARED);
    }

    public static void clientInit() {
        TrinketRendererRegistry.registerRenderer(AccentsItems.SHEATHED_KATANA.asItem(), VanityTrinketRenderer.SHARED);
        TrinketRendererRegistry.registerRenderer(AccentsItems.HOLSTERED_BELT.asItem(), VanityTrinketRenderer.SHARED);
        TrinketRendererRegistry.registerRenderer(AccentsItems.BANDOLIER.asItem(), VanityTrinketRenderer.SHARED);
        TrinketRendererRegistry.registerRenderer(AccentsItems.QUIVER.asItem(), VanityTrinketRenderer.SHARED);
        TrinketRendererRegistry.registerRenderer(AccentsItems.WINGS.asItem(), VanityTrinketRenderer.SHARED);
        TrinketRendererRegistry.registerRenderer(AccentsItems.SCARF.asItem(), VanityTrinketRenderer.SHARED);
        TrinketRendererRegistry.registerRenderer(AccentsItems.ITEM_SATCHEL.asItem(), VanityTrinketRenderer.SHARED);
    }
}
