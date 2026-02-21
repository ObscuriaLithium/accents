package dev.obscuria.accents.fabric;

import dev.obscuria.accents.Accents;
import net.fabricmc.api.ModInitializer;

public final class FabricAccents implements ModInitializer {

    @Override
    public void onInitialize() {
        Accents.init();
    }
}