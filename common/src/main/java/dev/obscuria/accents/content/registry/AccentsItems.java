package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.Vanities;
import dev.obscuria.accents.content.item.SewingKitItem;
import dev.obscuria.accents.content.item.VanityItem;
import dev.obscuria.fragmentum.registry.DeferredItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface AccentsItems {

    DeferredItem<BlockItem> SEWING_STATION = register("sewing_station",
            () -> new BlockItem(AccentsBlocks.SEWING_STATION.get(), new Item.Properties()));
    DeferredItem<SewingKitItem> SEWING_KIT = register("sewing_kit",
            () -> new SewingKitItem(new Item.Properties()));

    DeferredItem<VanityItem> CAKEMAN_PLUSHIE = register("cakeman_plushie",
            () -> Accents.FACTORY.create(Vanities.CAKEMAN_PLUSHIE, new Item.Properties()));
    DeferredItem<VanityItem> CAPTAIN_HAT = register("captain_hat",
            () -> Accents.FACTORY.create(Vanities.CAPTAIN_HAT, new Item.Properties()));
    DeferredItem<VanityItem> CHRISTMAS_HAT = register("christmas_hat",
            () -> Accents.FACTORY.create(Vanities.CHRISTMAS_HAT, new Item.Properties()));
    DeferredItem<VanityItem> COWBOY_HAT = register("cowboy_hat",
            () -> Accents.FACTORY.create(Vanities.COWBOY_HAT, new Item.Properties()));
    DeferredItem<VanityItem> CROWN = register("crown",
            () -> Accents.FACTORY.create(Vanities.CROWN, new Item.Properties()));
    DeferredItem<VanityItem> DRAGON_SKULL = register("dragon_skull",
            () -> Accents.FACTORY.create(Vanities.DRAGON_SKULL, new Item.Properties()));
    DeferredItem<VanityItem> HERMES_BOOTS = register("hermes_boots",
            () -> Accents.FACTORY.create(Vanities.HERMES_BOOTS, new Item.Properties()));
    DeferredItem<VanityItem> HOLSTERED_BELT = register("holstered_belt",
            () -> Accents.FACTORY.create(Vanities.HOLSTERED_BELT, new Item.Properties()));
    DeferredItem<VanityItem> HORNS = register("horns",
            () -> Accents.FACTORY.create(Vanities.HORNS, new Item.Properties()));
    DeferredItem<VanityItem> KASA_HAT = register("kasa_hat",
            () -> Accents.FACTORY.create(Vanities.KASA_HAT, new Item.Properties()));
    DeferredItem<VanityItem> OVERTOP_HAT = register("overtop_hat",
            () -> Accents.FACTORY.create(Vanities.OVERTOP_HAT, new Item.Properties()));
    DeferredItem<VanityItem> PICKELHAUBE = register("pickelhaube",
            () -> Accents.FACTORY.create(Vanities.PICKELHAUBE, new Item.Properties()));
    DeferredItem<VanityItem> PIRATE_HAT = register("pirate_hat",
            () -> Accents.FACTORY.create(Vanities.PIRATE_HAT, new Item.Properties()));
    DeferredItem<VanityItem> PUMPKIN_HAT = register("pumpkin_hat",
            () -> Accents.FACTORY.create(true, Vanities.PUMPKIN_HAT, new Item.Properties()));
    DeferredItem<VanityItem> QUIVER = register("quiver",
            () -> Accents.FACTORY.create(Vanities.QUIVER, new Item.Properties()));
    DeferredItem<VanityItem> BANDOLIER = register("bandolier",
            () -> Accents.FACTORY.create(Vanities.BANDOLIER, new Item.Properties()));
    DeferredItem<VanityItem> SHEATHED_KATANA = register("sheathed_katana",
            () -> Accents.FACTORY.create(Vanities.SHEATHED_KATANA, new Item.Properties()));
    DeferredItem<VanityItem> SKULL = register("skull",
            () -> Accents.FACTORY.create(Vanities.SKULL, new Item.Properties()));
    DeferredItem<VanityItem> SOMBRERO = register("sombrero",
            () -> Accents.FACTORY.create(Vanities.SOMBRERO, new Item.Properties()));
    DeferredItem<VanityItem> STRAW_HAT = register("straw_hat",
            () -> Accents.FACTORY.create(Vanities.STRAW_HAT, new Item.Properties()));
    DeferredItem<VanityItem> TOP_HAT = register("top_hat",
            () -> Accents.FACTORY.create(Vanities.TOP_HAT, new Item.Properties()));
    DeferredItem<VanityItem> WINGS = register("wings",
            () -> Accents.FACTORY.create(Vanities.WINGS, new Item.Properties()));
    DeferredItem<VanityItem> WIZARD_HAT = register("wizard_hat",
            () -> Accents.FACTORY.create(Vanities.WIZARD_HAT, new Item.Properties()));
    DeferredItem<VanityItem> KING_MASK = register("king_mask",
            () -> Accents.FACTORY.create(Vanities.KING_MASK, new Item.Properties()));
    DeferredItem<VanityItem> WIDE_BRIM_HAT = register("wide_brim_hat",
            () -> Accents.FACTORY.create(Vanities.WIDE_BRIM_HAT, new Item.Properties()));
    DeferredItem<VanityItem> TUNDRA_HOOD = register("tundra_hood",
            () -> Accents.FACTORY.create(Vanities.TUNDRA_HOOD, new Item.Properties()));
    DeferredItem<VanityItem> SCARF = register("scarf",
            () -> Accents.FACTORY.create(Vanities.SCARF, new Item.Properties()));
    DeferredItem<VanityItem> ITEM_SATCHEL = register("item_satchel",
            () -> Accents.FACTORY.create(Vanities.ITEM_SATCHEL, new Item.Properties()));

    private static <T extends Item> DeferredItem<T> register(String name, Supplier<T> supplier) {
        return AccentsRegistries.REGISTRAR.registerItem(Accents.identifier(name), supplier);
    }

    static void init() {}
}
