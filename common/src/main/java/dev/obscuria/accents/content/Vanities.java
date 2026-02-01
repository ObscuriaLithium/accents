package dev.obscuria.accents.content;

import dev.obscuria.accents.client.renderer.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;

public interface Vanities {

    Vanity CAKEMAN_PLUSHIE = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierAddition(Attributes.LUCK, 1)
            .build(() -> CakemanPlushieRenderer::new);
    Vanity CAPTAIN_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.KNOCKBACK_RESISTANCE, 0.05)
            .build(() -> CaptainHatRenderer::new);
    Vanity CHRISTMAS_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierAddition(Attributes.ARMOR_TOUGHNESS, 0.5)
            .build(() -> ChristmasHatRenderer::new);
    Vanity COWBOY_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.MOVEMENT_SPEED, 0.05)
            .build(() -> CowboyHatRenderer::new);
    Vanity CROWN = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.MAX_HEALTH, 0.05)
            .build(() -> CrownRenderer::new);
    Vanity DRAGON_SKULL = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.ATTACK_DAMAGE, 0.05)
            .build(() -> DragonSkullRenderer::new);
    Vanity HERMES_BOOTS = Vanity.simple(ArmorItem.Type.BOOTS)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.MOVEMENT_SPEED, 0.05)
            .build(() -> HermesBootsRenderer::new);
    Vanity HORNS = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.ATTACK_KNOCKBACK, 0.05)
            .build(() -> HornsRenderer::new);
    Vanity KASA_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.KNOCKBACK_RESISTANCE, 0.05)
            .build(() -> KasaHatRenderer::new);
    Vanity OVERTOP_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierAddition(Attributes.LUCK, 2)
            .build(() -> OvertopHatRenderer::new);
    Vanity PICKELHAUBE = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierAddition(Attributes.ARMOR, 1)
            .build(() -> PickelhaubeRenderer::new);
    Vanity PIRATE_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.ATTACK_DAMAGE, 0.05)
            .build(() -> PirateHatRenderer::new);
    Vanity PUMPKIN_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.FOLLOW_RANGE, 0.05)
            .build(() -> PumpkinHatRenderer::new);
    Vanity SKULL = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierAddition(Attributes.ARMOR, 1)
            .build(() -> SkullRenderer::new);
    Vanity SOMBRERO = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.MOVEMENT_SPEED, 0.05)
            .build(() -> SombreroRenderer::new);
    Vanity STRAW_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.ATTACK_SPEED, 0.05)
            .build(() -> StrawHatRenderer::new);
    Vanity TOP_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierAddition(Attributes.LUCK, 1)
            .build(() -> TopHatRenderer::new);
    Vanity WIZARD_HAT = Vanity.simple(ArmorItem.Type.HELMET)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.MOVEMENT_SPEED, 0.025)
            .modifierMultiply(Attributes.ATTACK_DAMAGE, 0.025)
            .build(() -> WizardHatRenderer::new);

    Vanity BANDOLIER = Vanity.trinket(ArmorItem.Type.CHESTPLATE)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.ATTACK_SPEED, 0.05)
            .build(() -> BandolierRenderer::new);
    Vanity HOLSTERED_BELT = Vanity.trinket(ArmorItem.Type.LEGGINGS)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.ATTACK_SPEED, 0.05)
            .build(() -> HolsteredBeltRenderer::new);
    Vanity QUIVER = Vanity.trinket(ArmorItem.Type.CHESTPLATE)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.ATTACK_SPEED, 0.025)
            .modifierMultiply(Attributes.ATTACK_DAMAGE, 0.025)
            .build(() -> QuiverRenderer::new);
    Vanity SHEATHED_KATANA = Vanity.trinket(ArmorItem.Type.CHESTPLATE)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.ATTACK_DAMAGE, 0.05)
            .build(() -> SheathedKatanaRenderer::new);
    Vanity WINGS = Vanity.trinket(ArmorItem.Type.CHESTPLATE)
            .material(ArmorMaterials.LEATHER)
            .modifierMultiply(Attributes.MOVEMENT_SPEED, 0.025)
            .modifierMultiply(Attributes.KNOCKBACK_RESISTANCE, 0.025)
            .build(() -> WingsRenderer::new);
}
