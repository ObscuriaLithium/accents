package dev.obscuria.accents.client;

import dev.obscuria.accents.client.screen.SewingScreen;
import dev.obscuria.accents.content.registry.AccentsMenus;
import net.minecraft.client.gui.screens.MenuScreens;

public final class AccentsClient {

    public static void init() {
        MenuScreens.register(AccentsMenus.SEWING, SewingScreen::new);
    }
}
