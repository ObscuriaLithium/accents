package dev.obscuria.accents.content;

import dev.obscuria.accents.config.CommonConfig;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;

public interface Vanities {

    Vanity CAKEMAN_PLUSHIE = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.CAKEMAN_PLUSHIE).build();
    Vanity CAPTAIN_HAT = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.CAPTAIN_HAT).build();
    Vanity CHRISTMAS_HAT = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.CHRISTMAS_HAT).build();
    Vanity COWBOY_HAT = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.COWBOY_HAT).build();
    Vanity CROWN = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.CROWN).build();
    Vanity DRAGON_SKULL = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.DRAGON_SKULL).build();
    Vanity HERMES_BOOTS = Vanity.simple(ArmorItem.Type.BOOTS).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.HERMES_BOOTS).build();
    Vanity HORNS = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.HORNS).build();
    Vanity KASA_HAT = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.KASA_HAT).build();
    Vanity OVERTOP_HAT = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.OVERTOP_HAT).build();
    Vanity PICKELHAUBE = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.PICKELHAUBE).build();
    Vanity PIRATE_HAT = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.PIRATE_HAT).build();
    Vanity PUMPKIN_HAT = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.PUMPKIN_HAT).build();
    Vanity SKULL = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.SKULL).build();
    Vanity SOMBRERO = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.SOMBRERO).build();
    Vanity STRAW_HAT = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.STRAW_HAT).build();
    Vanity TOP_HAT = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.TOP_HAT).build();
    Vanity WIZARD_HAT = Vanity.simple(ArmorItem.Type.HELMET).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.WIZARD_HAT).build();

    Vanity BANDOLIER = Vanity.trinket(ArmorItem.Type.CHESTPLATE).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.BANDOLIER).build();
    Vanity HOLSTERED_BELT = Vanity.trinket(ArmorItem.Type.CHESTPLATE).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.HOLSTERED_BELT).build();
    Vanity QUIVER = Vanity.trinket(ArmorItem.Type.CHESTPLATE).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.QUIVER).build();
    Vanity SHEATHED_KATANA = Vanity.trinket(ArmorItem.Type.CHESTPLATE).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.SHEATHED_KATANA).build();
    Vanity WINGS = Vanity.trinket(ArmorItem.Type.CHESTPLATE).material(ArmorMaterials.LEATHER).modifiers(CommonConfig.WINGS).build();
}
