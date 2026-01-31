package dev.obscuria.accents.client;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.client.screen.SewingScreen;
import dev.obscuria.accents.content.registry.AccentsItems;
import dev.obscuria.accents.content.registry.AccentsMenus;
import dev.obscuria.fragmentum.client.FragmentumClientRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public final class AccentsClient {

    public static void init() {
        MenuScreens.register(AccentsMenus.SEWING_STATION.get(), SewingScreen::new);
        var registrar = FragmentumClientRegistry.registrar(Accents.MODID);
        registrar.registerItemColor(AccentsClient::pickVanityColor,
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
                AccentsItems.KASA_HAT);
    }

    private static int pickVanityColor(ItemStack stack, int layer) {
        if (layer != 1) return -1;
        return stack.getItem() instanceof DyeableLeatherItem item
                ? item.getColor(stack)
                : 0xFFFFFF;
    }
}
