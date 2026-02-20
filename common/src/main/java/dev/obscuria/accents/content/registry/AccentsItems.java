package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.Vanities;
import dev.obscuria.accents.content.item.SewingKitItem;
import dev.obscuria.accents.content.item.VanityItem;
import dev.obscuria.fragmentum.content.registry.DeferredItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface AccentsItems {

    DeferredItem<BlockItem> SEWING_STATION = register("sewing_station", () -> new BlockItem(AccentsBlocks.SEWING_STATION.get(), new Item.Properties()));
    DeferredItem<SewingKitItem> SEWING_KIT = register("sewing_kit", () -> new SewingKitItem(new Item.Properties()));

    DeferredItem<VanityItem> CAKEMAN_PLUSHIE = register("cakeman_plushie", () -> new VanityItem(Vanities.CAKEMAN_PLUSHIE, new Item.Properties()));
    DeferredItem<VanityItem> CAPTAIN_HAT = register("captain_hat", () -> new VanityItem(Vanities.CAPTAIN_HAT, new Item.Properties()));
    DeferredItem<VanityItem> CHRISTMAS_HAT = register("christmas_hat", () -> new VanityItem(Vanities.CHRISTMAS_HAT, new Item.Properties()));
    DeferredItem<VanityItem> COWBOY_HAT = register("cowboy_hat", () -> new VanityItem(Vanities.COWBOY_HAT, new Item.Properties()));
    DeferredItem<VanityItem> CROWN = register("crown", () -> new VanityItem(Vanities.CROWN, new Item.Properties()));
    DeferredItem<VanityItem> DRAGON_SKULL = register("dragon_skull", () -> new VanityItem(Vanities.DRAGON_SKULL, new Item.Properties()));
    DeferredItem<VanityItem> HERMES_BOOTS = register("hermes_boots", () -> new VanityItem(Vanities.HERMES_BOOTS, new Item.Properties()));
    DeferredItem<VanityItem> HOLSTERED_BELT = register("holstered_belt", () -> new VanityItem(Vanities.HOLSTERED_BELT, new Item.Properties()));
    DeferredItem<VanityItem> HORNS = register("horns", () -> new VanityItem(Vanities.HORNS, new Item.Properties()));
    DeferredItem<VanityItem> KASA_HAT = register("kasa_hat", () -> new VanityItem(Vanities.KASA_HAT, new Item.Properties()));
    DeferredItem<VanityItem> OVERTOP_HAT = register("overtop_hat", () -> new VanityItem(Vanities.OVERTOP_HAT, new Item.Properties()));
    DeferredItem<VanityItem> PICKELHAUBE = register("pickelhaube", () -> new VanityItem(Vanities.PICKELHAUBE, new Item.Properties()));
    DeferredItem<VanityItem> PIRATE_HAT = register("pirate_hat", () -> new VanityItem(Vanities.PIRATE_HAT, new Item.Properties()));
    DeferredItem<VanityItem> PUMPKIN_HAT = register("pumpkin_hat", () -> new VanityItem(true, Vanities.PUMPKIN_HAT, new Item.Properties()));
    DeferredItem<VanityItem> QUIVER = register("quiver", () -> new VanityItem(Vanities.QUIVER, new Item.Properties()));
    DeferredItem<VanityItem> BANDOLIER = register("bandolier", () -> new VanityItem(Vanities.BANDOLIER, new Item.Properties()));
    DeferredItem<VanityItem> SHEATHED_KATANA = register("sheathed_katana", () -> new VanityItem(Vanities.SHEATHED_KATANA, new Item.Properties()));
    DeferredItem<VanityItem> SKULL = register("skull", () -> new VanityItem(Vanities.SKULL, new Item.Properties()));
    DeferredItem<VanityItem> SOMBRERO = register("sombrero", () -> new VanityItem(Vanities.SOMBRERO, new Item.Properties()));
    DeferredItem<VanityItem> STRAW_HAT = register("straw_hat", () -> new VanityItem(Vanities.STRAW_HAT, new Item.Properties()));
    DeferredItem<VanityItem> TOP_HAT = register("top_hat", () -> new VanityItem(Vanities.TOP_HAT, new Item.Properties()));
    DeferredItem<VanityItem> WINGS = register("wings", () -> new VanityItem(Vanities.WINGS, new Item.Properties()));
    DeferredItem<VanityItem> WIZARD_HAT = register("wizard_hat", () -> new VanityItem(Vanities.WIZARD_HAT, new Item.Properties()));

    private static <T extends Item> DeferredItem<T> register(String name, Supplier<T> supplier) {
        return AccentsRegistries.REGISTRAR.registerItem(Accents.key(name), supplier);
    }

    static void init() {}
}
