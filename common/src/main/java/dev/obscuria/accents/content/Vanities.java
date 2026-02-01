package dev.obscuria.accents.content;

import dev.obscuria.accents.client.renderer.*;
import dev.obscuria.accents.config.CommonConfig;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;

public interface Vanities {

    Vanity CAKEMAN_PLUSHIE = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.CAKEMAN_PLUSHIE)
            .build(() -> CakemanPlushieRenderer::new);
    Vanity CAPTAIN_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.CAPTAIN_HAT)
            .build(() -> CaptainHatRenderer::new);
    Vanity CHRISTMAS_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.CHRISTMAS_HAT)
            .build(() -> ChristmasHatRenderer::new);
    Vanity COWBOY_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.COWBOY_HAT)
            .build(() -> CowboyHatRenderer::new);
    Vanity CROWN = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.CROWN)
            .build(() -> CrownRenderer::new);
    Vanity DRAGON_SKULL = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.DRAGON_SKULL)
            .build(() -> DragonSkullRenderer::new);
    Vanity HERMES_BOOTS = Vanity.simple(ArmorItem.Type.BOOTS)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.HERMES_BOOTS)
            .build(() -> HermesBootsRenderer::new);
    Vanity HORNS = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.HORNS)
            .build(() -> HornsRenderer::new);
    Vanity KASA_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.KASA_HAT)
            .build(() -> KasaHatRenderer::new);
    Vanity OVERTOP_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.OVERTOP_HAT)
            .build(() -> OvertopHatRenderer::new);
    Vanity PICKELHAUBE = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.PICKELHAUBE)
            .build(() -> PickelhaubeRenderer::new);
    Vanity PIRATE_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.PIRATE_HAT)
            .build(() -> PirateHatRenderer::new);
    Vanity PUMPKIN_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.PUMPKIN_HAT)
            .build(() -> PumpkinHatRenderer::new);
    Vanity SKULL = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.SKULL)
            .build(() -> SkullRenderer::new);
    Vanity SOMBRERO = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.SOMBRERO)
            .build(() -> SombreroRenderer::new);
    Vanity STRAW_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.STRAW_HAT)
            .build(() -> StrawHatRenderer::new);
    Vanity TOP_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.TOP_HAT)
            .build(() -> TopHatRenderer::new);
    Vanity WIZARD_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.WIZARD_HAT)
            .build(() -> WizardHatRenderer::new);

    Vanity BANDOLIER = Vanity.trinket(ArmorItem.Type.CHESTPLATE)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.BANDOLIER)
            .build(() -> BandolierRenderer::new);
    Vanity HOLSTERED_BELT = Vanity.trinket(ArmorItem.Type.CHESTPLATE)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.HOLSTERED_BELT)
            .build(() -> HolsteredBeltRenderer::new);
    Vanity QUIVER = Vanity.trinket(ArmorItem.Type.CHESTPLATE)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.QUIVER)
            .build(() -> QuiverRenderer::new);
    Vanity SHEATHED_KATANA = Vanity.trinket(ArmorItem.Type.CHESTPLATE)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.SHEATHED_KATANA)
            .build(() -> SheathedKatanaRenderer::new);
    Vanity WINGS = Vanity.trinket(ArmorItem.Type.CHESTPLATE)
            .material(ArmorMaterials.LEATHER)
            .modifiers(CommonConfig.WINGS)
            .build(() -> WingsRenderer::new);
}
