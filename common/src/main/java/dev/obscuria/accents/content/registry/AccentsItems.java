package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.item.SewingKitItem;
import dev.obscuria.accents.content.item.VanityItem;
import dev.obscuria.fragmentum.registry.DeferredItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface AccentsItems {

    DeferredItem<BlockItem> SEWING_STATION = register("sewing_station", () -> new BlockItem(AccentsBlocks.SEWING_STATION.get(), new Item.Properties()));
    DeferredItem<SewingKitItem> SEWING_KIT = register("sewing_kit", () -> new SewingKitItem(new Item.Properties()));
    DeferredItem<VanityItem> CAPTAIN_HAT = register("captain_hat", Accents.FACTORY::createCaptainHat);
    DeferredItem<VanityItem> PUMPKIN_HAT = register("pumpkin_hat", Accents.FACTORY::createPumpkinHat);
    DeferredItem<VanityItem> QUIVER = register("quiver", Accents.FACTORY::createQuiver);
    DeferredItem<VanityItem> BANDOLIER = register("bandolier", Accents.FACTORY::createBandolier);
    DeferredItem<VanityItem> CAKEMAN_PLUSHIE = register("cakeman_plushie", Accents.FACTORY::createCakemanPlushie);
    DeferredItem<VanityItem> CHRISTMAS_HAT = register("christmas_hat", Accents.FACTORY::createChristmasHat);
    DeferredItem<VanityItem> COWBOY_HAT = register("cowboy_hat", Accents.FACTORY::createCowboyHat);
    DeferredItem<VanityItem> CROWN = register("crown", Accents.FACTORY::createCrown);
    DeferredItem<VanityItem> DRAGON_SKULL = register("dragon_skull", Accents.FACTORY::createDragonSkull);
    DeferredItem<VanityItem> HERMES_BOOTS = register("hermes_boots", Accents.FACTORY::createHermesBoots);
    DeferredItem<VanityItem> HOLSTERED_BELT = register("holstered_belt", Accents.FACTORY::createHolsteredBelt);
    DeferredItem<VanityItem> HORNS = register("horns", Accents.FACTORY::createHorns);
    DeferredItem<VanityItem> KASA_HAT = register("kasa_hat", Accents.FACTORY::createKasaHat);
    DeferredItem<VanityItem> OVERTOP_HAT = register("overtop_hat", Accents.FACTORY::createOvertopHat);
    DeferredItem<VanityItem> PICKELHAUBE = register("pickelhaube", Accents.FACTORY::createPickelhaube);
    DeferredItem<VanityItem> PIRATE_HAT = register("pirate_hat", Accents.FACTORY::createPirateHat);
    DeferredItem<VanityItem> SHEATHED_KATANA = register("sheathed_katana", Accents.FACTORY::createSheathedKatana);
    DeferredItem<VanityItem> SKULL = register("skull", Accents.FACTORY::createSkull);
    DeferredItem<VanityItem> SOMBRERO = register("sombrero", Accents.FACTORY::createSombrero);
    DeferredItem<VanityItem> STRAW_HAT = register("straw_hat", Accents.FACTORY::createStrawHat);
    DeferredItem<VanityItem> TOP_HAT = register("top_hat", Accents.FACTORY::createTopHat);
    DeferredItem<VanityItem> WINGS = register("wings", Accents.FACTORY::createWings);
    DeferredItem<VanityItem> WIZARD_HAT = register("wizard_hat", Accents.FACTORY::createWizardHat);

    private static <T extends Item> DeferredItem<T> register(String name, Supplier<T> supplier) {
        return AccentsRegistries.REGISTRAR.registerItem(Accents.key(name), supplier);
    }

    static void init() {}
}
