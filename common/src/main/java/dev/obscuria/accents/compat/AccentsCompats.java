package dev.obscuria.accents.compat;

import dev.obscuria.fragmentum.ModCompat;

public interface AccentsCompats {

    ModCompat CURIOS = new ModCompat("curios");
    ModCompat TRINKETS = new ModCompat("trinkets");

    static boolean trinketsLoaded() {
        return TRINKETS.isLoaded() || CURIOS.isLoaded();
    }
}
