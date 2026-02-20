package dev.obscuria.accents.client;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.client.screen.SewingScreen;
import dev.obscuria.accents.content.registry.AccentsItems;
import dev.obscuria.accents.content.registry.AccentsMenus;
import dev.obscuria.fragmentum.client.FragmentumClientRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

public final class AccentsClient {

    public static void init() {
        MenuScreens.register(AccentsMenus.SEWING_STATION, SewingScreen::new);
        var registrar = FragmentumClientRegistry.registrar(Accents.MODID);
        registrar.registerItemColor(AccentsClient::pickVanityColor,
                AccentsItems.CAKEMAN_PLUSHIE,
                AccentsItems.CAPTAIN_HAT,
                AccentsItems.CHRISTMAS_HAT,
                AccentsItems.COWBOY_HAT,
                AccentsItems.SHEATHED_KATANA,
                AccentsItems.DRAGON_SKULL,
                AccentsItems.PIRATE_HAT,
                AccentsItems.PUMPKIN_HAT,
                AccentsItems.SKULL,
                AccentsItems.QUIVER,
                AccentsItems.TOP_HAT,
                AccentsItems.OVERTOP_HAT,
                AccentsItems.PICKELHAUBE,
                AccentsItems.WINGS,
                AccentsItems.WIZARD_HAT,
                AccentsItems.SOMBRERO,
                AccentsItems.HOLSTERED_BELT,
                AccentsItems.STRAW_HAT,
                AccentsItems.KASA_HAT,
                AccentsItems.HERMES_BOOTS,
                AccentsItems.BANDOLIER,
                AccentsItems.CROWN,
                AccentsItems.HORNS);
    }

    private static int pickVanityColor(ItemStack stack, int layer) {
        if (layer != 1) return -1;
        return DyedItemColor.getOrDefault(stack, DyedItemColor.LEATHER_COLOR);
    }
}
