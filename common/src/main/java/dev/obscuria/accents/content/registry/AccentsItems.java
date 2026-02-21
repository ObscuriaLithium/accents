package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.Vanities;
import dev.obscuria.accents.content.Vanity;
import dev.obscuria.accents.content.item.SewingKitItem;
import dev.obscuria.accents.content.item.VanityItem;
import dev.obscuria.fragmentum.content.registry.Deferred;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;
import java.util.function.Supplier;

public interface AccentsItems {

    Deferred<BlockItem> SEWING_STATION = register("sewing_station", AccentsBlocks.SEWING_STATION);
    Deferred<SewingKitItem> SEWING_KIT = register("sewing_kit", SewingKitItem::new);

    Deferred<VanityItem> CAKEMAN_PLUSHIE = register("cakeman_plushie", Vanities.CAKEMAN_PLUSHIE);
    Deferred<VanityItem> CAPTAIN_HAT = register("captain_hat", Vanities.CAPTAIN_HAT);
    Deferred<VanityItem> CHRISTMAS_HAT = register("christmas_hat", Vanities.CHRISTMAS_HAT);
    Deferred<VanityItem> COWBOY_HAT = register("cowboy_hat", Vanities.COWBOY_HAT);
    Deferred<VanityItem> CROWN = register("crown", Vanities.CROWN);
    Deferred<VanityItem> DRAGON_SKULL = register("dragon_skull", Vanities.DRAGON_SKULL);
    Deferred<VanityItem> HERMES_BOOTS = register("hermes_boots", Vanities.HERMES_BOOTS);
    Deferred<VanityItem> HOLSTERED_BELT = register("holstered_belt", Vanities.HOLSTERED_BELT);
    Deferred<VanityItem> HORNS = register("horns", Vanities.HORNS);
    Deferred<VanityItem> KASA_HAT = register("kasa_hat", Vanities.KASA_HAT);
    Deferred<VanityItem> OVERTOP_HAT = register("overtop_hat", Vanities.OVERTOP_HAT);
    Deferred<VanityItem> PICKELHAUBE = register("pickelhaube", Vanities.PICKELHAUBE);
    Deferred<VanityItem> PIRATE_HAT = register("pirate_hat", Vanities.PIRATE_HAT);
    Deferred<VanityItem> PUMPKIN_HAT = register("pumpkin_hat", Vanities.PUMPKIN_HAT, true);
    Deferred<VanityItem> QUIVER = register("quiver", Vanities.QUIVER);
    Deferred<VanityItem> BANDOLIER = register("bandolier", Vanities.BANDOLIER);
    Deferred<VanityItem> SHEATHED_KATANA = register("sheathed_katana", Vanities.SHEATHED_KATANA);
    Deferred<VanityItem> SKULL = register("skull", Vanities.SKULL);
    Deferred<VanityItem> SOMBRERO = register("sombrero", Vanities.SOMBRERO);
    Deferred<VanityItem> STRAW_HAT = register("straw_hat", Vanities.STRAW_HAT);
    Deferred<VanityItem> TOP_HAT = register("top_hat", Vanities.TOP_HAT);
    Deferred<VanityItem> WINGS = register("wings", Vanities.WINGS);
    Deferred<VanityItem> WIZARD_HAT = register("wizard_hat", Vanities.WIZARD_HAT);

    private static Deferred<VanityItem> register(String name, Vanity vanity) {
        return register(name, properties -> new VanityItem(vanity, properties));
    }

    private static Deferred<VanityItem> register(String name, Vanity vanity, boolean glowing) {
        return register(name, properties -> new VanityItem(glowing, vanity, properties));
    }

    private static Deferred<BlockItem> register(String name, Deferred<? extends Block> deferredBlock) {
        return register(name, properties -> new BlockItem(deferredBlock.get(), properties));
    }

    private static <T extends Item> Deferred<T> register(String name, Function<Item.Properties, T> factory) {
        return register(name, factory, new Item.Properties());
    }

    private static <T extends Item> Deferred<T> register(String name, Function<Item.Properties, T> factory, Item.Properties properties) {
        var identifier = Accents.identifier(name);
        Supplier<T> supplier = () -> factory.apply(properties.setId(ResourceKey.create(Registries.ITEM, identifier)));
        return AccentsRegistries.REGISTRAR.register(Registries.ITEM, identifier, supplier);
    }

    static void init() {}
}
