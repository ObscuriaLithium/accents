package dev.obscuria.accents.fabric.client;

import dev.obscuria.accents.client.AccentsClient;
import net.fabricmc.api.ClientModInitializer;

public final class FabricAccentsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AccentsClient.init();
    }
}
