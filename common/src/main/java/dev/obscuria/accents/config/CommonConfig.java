package dev.obscuria.accents.config;

import dev.obscuria.accents.Accents;
import dev.obscuria.fragmentum.config.ConfigBuilder;
import dev.obscuria.fragmentum.config.ConfigValue;

import java.util.List;

public final class CommonConfig {

    public static final ConfigValue<Boolean> MODIFIERS_ENABLED;

    public static final ConfigValue<List<? extends String>> CAKEMAN_PLUSHIE;
    public static final ConfigValue<List<? extends String>> CAPTAIN_HAT;
    public static final ConfigValue<List<? extends String>> CHRISTMAS_HAT;
    public static final ConfigValue<List<? extends String>> COWBOY_HAT;
    public static final ConfigValue<List<? extends String>> CROWN;
    public static final ConfigValue<List<? extends String>> DRAGON_SKULL;
    public static final ConfigValue<List<? extends String>> HERMES_BOOTS;
    public static final ConfigValue<List<? extends String>> HORNS;
    public static final ConfigValue<List<? extends String>> KASA_HAT;
    public static final ConfigValue<List<? extends String>> OVERTOP_HAT;
    public static final ConfigValue<List<? extends String>> PICKELHAUBE;
    public static final ConfigValue<List<? extends String>> PIRATE_HAT;
    public static final ConfigValue<List<? extends String>> PUMPKIN_HAT;
    public static final ConfigValue<List<? extends String>> SKULL;
    public static final ConfigValue<List<? extends String>> SOMBRERO;
    public static final ConfigValue<List<? extends String>> STRAW_HAT;
    public static final ConfigValue<List<? extends String>> TOP_HAT;
    public static final ConfigValue<List<? extends String>> WIZARD_HAT;
    public static final ConfigValue<List<? extends String>> BANDOLIER;
    public static final ConfigValue<List<? extends String>> HOLSTERED_BELT;
    public static final ConfigValue<List<? extends String>> QUIVER;
    public static final ConfigValue<List<? extends String>> SHEATHED_KATANA;
    public static final ConfigValue<List<? extends String>> WINGS;

    private interface Defaults {

        String TEMPLATE = "minecraft:generic.attack_damage addition:0.1";
        List<String> CAKEMAN_PLUSHIE = List.of(
                "minecraft:generic.luck addition:1");
        List<String> CAPTAIN_HAT = List.of(
                "minecraft:generic.knockback_resistance multiply:0.05");
        List<String> CHRISTMAS_HAT = List.of(
                "minecraft:generic.armor_toughness addition:0.5");
        List<String> COWBOY_HAT = List.of(
                "minecraft:generic.movement_speed multiply:0.05");
        List<String> CROWN = List.of(
                "minecraft:generic.max_health multiply:0.05");
        List<String> DRAGON_SKULL = List.of(
                "minecraft:generic.attack_damage multiply:0.05");
        List<String> HERMES_BOOTS = List.of(
                "minecraft:generic.movement_speed multiply:0.05");
        List<String> HORNS = List.of(
                "minecraft:generic.attack_knockback multiply:0.05");
        List<String> KASA_HAT = List.of(
                "minecraft:generic.knockback_resistance multiply:0.05");
        List<String> OVERTOP_HAT = List.of(
                "minecraft:generic.luck addition:2");
        List<String> PICKELHAUBE = List.of(
                "minecraft:generic.armor addition:1");
        List<String> PIRATE_HAT = List.of(
                "minecraft:generic.attack_damage multiply:0.05");
        List<String> PUMPKIN_HAT = List.of(
                "minecraft:generic.follow_range multiply:0.05");
        List<String> SKULL = List.of(
                "minecraft:generic.armor addition:1");
        List<String> SOMBRERO = List.of(
                "minecraft:generic.movement_speed multiply:0.05");
        List<String> STRAW_HAT = List.of(
                "minecraft:generic.attack_speed multiply:0.05");
        List<String> TOP_HAT = List.of(
                "minecraft:generic.luck addition:1");
        List<String> WIZARD_HAT = List.of(
                "minecraft:generic.movement_speed multiply:0.025",
                "minecraft:generic.attack_damage multiply:0.025");
        List<String> BANDOLIER = List.of(
                "minecraft:generic.attack_speed multiply:0.05");
        List<String> HOLSTERED_BELT = List.of(
                "minecraft:generic.attack_speed multiply:0.05");
        List<String> QUIVER = List.of(
                "minecraft:generic.attack_speed multiply:0.025",
                "minecraft:generic.attack_damage multiply:0.025");
        List<String> SHEATHED_KATANA = List.of(
                "minecraft:generic.attack_damage multiply:0.05");
        List<String> WINGS = List.of(
                "minecraft:generic.movement_speed multiply:0.025",
                "minecraft:generic.knockback_resistance multiply:0.025");
    }

    public static void init() {}

    static {
        final var builder = new ConfigBuilder("obscuria/accents-common.toml");

        MODIFIERS_ENABLED = builder
                .comment("Whether vanity items should have attribute modifiers.")
                .defineBoolean("modifiersEnabled", true);

        builder.push("Head");
        CAKEMAN_PLUSHIE = builder.defineList("cakemanPlushie", Defaults.CAKEMAN_PLUSHIE, () -> Defaults.TEMPLATE);
        CAPTAIN_HAT = builder.defineList("captainHat", Defaults.CAPTAIN_HAT, () -> Defaults.TEMPLATE);
        CHRISTMAS_HAT = builder.defineList("christmasHat", Defaults.CHRISTMAS_HAT, () -> Defaults.TEMPLATE);
        COWBOY_HAT = builder.defineList("cowboyHat", Defaults.COWBOY_HAT, () -> Defaults.TEMPLATE);
        CROWN = builder.defineList("crown", Defaults.CROWN, () -> Defaults.TEMPLATE);
        DRAGON_SKULL = builder.defineList("dragonSkull", Defaults.DRAGON_SKULL, () -> Defaults.TEMPLATE);
        HORNS = builder.defineList("horns", Defaults.HORNS, () -> Defaults.TEMPLATE);
        KASA_HAT = builder.defineList("kasaHat", Defaults.KASA_HAT, () -> Defaults.TEMPLATE);
        OVERTOP_HAT = builder.defineList("overtopHat", Defaults.OVERTOP_HAT, () -> Defaults.TEMPLATE);
        PICKELHAUBE = builder.defineList("pickelhaube", Defaults.PICKELHAUBE, () -> Defaults.TEMPLATE);
        PIRATE_HAT = builder.defineList("pirateHat", Defaults.PIRATE_HAT, () -> Defaults.TEMPLATE);
        PUMPKIN_HAT = builder.defineList("pumpkinHat", Defaults.PUMPKIN_HAT, () -> Defaults.TEMPLATE);
        SKULL = builder.defineList("skull", Defaults.SKULL, () -> Defaults.TEMPLATE);
        SOMBRERO = builder.defineList("sombrero", Defaults.SOMBRERO, () -> Defaults.TEMPLATE);
        STRAW_HAT = builder.defineList("strawHat", Defaults.STRAW_HAT, () -> Defaults.TEMPLATE);
        TOP_HAT = builder.defineList("topHat", Defaults.TOP_HAT, () -> Defaults.TEMPLATE);
        WIZARD_HAT = builder.defineList("wizardHat", Defaults.WIZARD_HAT, () -> Defaults.TEMPLATE);
        builder.pop();

        builder.push("Chest");
        BANDOLIER = builder.defineList("bandolier", Defaults.BANDOLIER, () -> Defaults.TEMPLATE);
        QUIVER = builder.defineList("quiver", Defaults.QUIVER, () -> Defaults.TEMPLATE);
        SHEATHED_KATANA = builder.defineList("sheathedKatana", Defaults.SHEATHED_KATANA, () -> Defaults.TEMPLATE);
        WINGS = builder.defineList("wings", Defaults.WINGS, () -> Defaults.TEMPLATE);
        builder.pop();

        builder.push("Legs");
        HOLSTERED_BELT = builder.defineList("holsteredBelt", Defaults.HOLSTERED_BELT, () -> Defaults.TEMPLATE);
        builder.pop();

        builder.push("Feet");
        HERMES_BOOTS = builder.defineList("hermesBoots", Defaults.HERMES_BOOTS, () -> Defaults.TEMPLATE);
        builder.pop();

        builder.buildCommon(Accents.MODID);
    }
}
