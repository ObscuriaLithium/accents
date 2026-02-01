package dev.obscuria.accents.fabric;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.compat.AccentsCompats;
import dev.obscuria.accents.fabric.compat.TrinketsCompat;
import net.fabricmc.api.ModInitializer;

public final class FabricAccents implements ModInitializer {

    @Override
    public void onInitialize() {
        Accents.init();
        if (AccentsCompats.TRINKETS.isLoaded()) {
            TrinketsCompat.init();
        }
    }
}