package dev.obscuria.accents.content;

import dev.obscuria.accents.config.CommonConfig;
import net.minecraft.world.item.ArmorItem;

public interface Vanities {

    Vanity CAKEMAN_PLUSHIE = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.CAKEMAN_PLUSHIE).build();
    Vanity CAPTAIN_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.CAPTAIN_HAT).build();
    Vanity CHRISTMAS_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.CHRISTMAS_HAT).build();
    Vanity COWBOY_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.COWBOY_HAT).build();
    Vanity CROWN = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.CROWN).build();
    Vanity DRAGON_SKULL = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.DRAGON_SKULL).build();
    Vanity HERMES_BOOTS = Vanity.simple(ArmorItem.Type.BOOTS).modifiers(CommonConfig.HERMES_BOOTS).build();
    Vanity HORNS = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.HORNS).build();
    Vanity KASA_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.KASA_HAT).build();
    Vanity OVERTOP_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.OVERTOP_HAT).build();
    Vanity PICKELHAUBE = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.PICKELHAUBE).build();
    Vanity PIRATE_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.PIRATE_HAT).build();
    Vanity PUMPKIN_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.PUMPKIN_HAT).build();
    Vanity SKULL = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.SKULL).build();
    Vanity SOMBRERO = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.SOMBRERO).build();
    Vanity STRAW_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.STRAW_HAT).build();
    Vanity TOP_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.TOP_HAT).build();
    Vanity WIZARD_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.WIZARD_HAT).build();
    Vanity KING_MASK = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.KING_MASK).build();
    Vanity WIDE_BRIM_HAT = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.WIDE_BRIM_HAT).build();
    Vanity TUNDRA_HOOD = Vanity.simple(ArmorItem.Type.HELMET).modifiers(CommonConfig.TUNDRA_HOOD).build();

    Vanity SCARF = Vanity.trinket(ArmorItem.Type.HELMET).modifiers(CommonConfig.SCARF).build();
    Vanity ITEM_SATCHEL = Vanity.trinket(ArmorItem.Type.CHESTPLATE).modifiers(CommonConfig.ITEM_SATCHEL).build();
    Vanity BANDOLIER = Vanity.trinket(ArmorItem.Type.CHESTPLATE).modifiers(CommonConfig.BANDOLIER).build();
    Vanity HOLSTERED_BELT = Vanity.trinket(ArmorItem.Type.CHESTPLATE).modifiers(CommonConfig.HOLSTERED_BELT).build();
    Vanity QUIVER = Vanity.trinket(ArmorItem.Type.CHESTPLATE).modifiers(CommonConfig.QUIVER).build();
    Vanity SHEATHED_KATANA = Vanity.trinket(ArmorItem.Type.CHESTPLATE).modifiers(CommonConfig.SHEATHED_KATANA).build();
    Vanity WINGS = Vanity.trinket(ArmorItem.Type.CHESTPLATE).modifiers(CommonConfig.WINGS).build();
}
