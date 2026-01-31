package dev.obscuria.accents.fabric.client;

import dev.obscuria.accents.client.AccentsClient;
import dev.obscuria.accents.compat.AccentsCompats;
import dev.obscuria.accents.fabric.compat.TrinketsCompat;
import net.fabricmc.api.ClientModInitializer;

public final class FabricAccentsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AccentsClient.init();
        if (AccentsCompats.TRINKETS.isLoaded()) {
            TrinketsCompat.clientInit();
        }
    }
}
