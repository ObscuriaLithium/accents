package dev.obscuria.accents.content;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.config.CommonConfig;
import dev.obscuria.fragmentum.config.ConfigValue;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

public record Vanity(
        ArmorType type,
        ArmorMaterial material,
        ConfigValue<List<? extends String>> modifiers,
        boolean isTrinket
) {
    private static final String TEMPLATE_SEPARATOR = " ";
    private static final String MODIFIER_SEPARATOR = ":";
    private static final String ADDITION = "addition";

    public static Builder simple(ArmorType type) {
        return new Builder(type, false);
    }

    public static Builder trinket(ArmorType type) {
        return new Builder(type, true);
    }

    public void appendModifiers(Identifier id, BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        if (!CommonConfig.MODIFIERS_ENABLED.get()) return;
        for (var template : modifiers.get()) {
            var parts = template.split(TEMPLATE_SEPARATOR);
            if (parts.length != 2) continue;
            @Nullable var attribute = parseAttribute(parts[0]);
            if (attribute == null) continue;
            @Nullable var modifier = parseModifier(parts[1], id);
            if (modifier == null) continue;
            consumer.accept(attribute, modifier);
        }
    }

    private @Nullable Holder<Attribute> parseAttribute(String input) {
        @Nullable var id = Identifier.tryParse(input);
        if (id == null) return null;
        var attribute = BuiltInRegistries.ATTRIBUTE.get(id);
        if (attribute.isEmpty()) {
            Accents.LOGGER.error("Vanity attribute '{}' not found", id);
            return null;
        }
        return attribute.get();
    }

    private @Nullable AttributeModifier parseModifier(String input, Identifier id) {
        var parts = input.split(MODIFIER_SEPARATOR);
        if (parts.length != 2) return null;
        try {
            var operation = parts[0].equals(ADDITION)
                    ? AttributeModifier.Operation.ADD_VALUE
                    : AttributeModifier.Operation.ADD_MULTIPLIED_BASE;
            var value = Double.parseDouble(parts[1]);
            return new AttributeModifier(id, value, operation);
        } catch (Exception ignored) {
            return null;
        }
    }

    public static final class Builder {

        private final ArmorType type;
        private final boolean isTrinket;
        private @Nullable ConfigValue<List<? extends String>> modifiers;
        private ArmorMaterial material = ArmorMaterials.LEATHER;

        private Builder(ArmorType type, boolean isTrinket) {
            this.type = type;
            this.isTrinket = isTrinket;
        }

        public Builder material(ArmorMaterial material) {
            this.material = material;
            return this;
        }

        public Builder modifiers(ConfigValue<List<? extends String>> source) {
            this.modifiers = source;
            return this;
        }

        public Vanity build() {
            Objects.requireNonNull(modifiers, "Vanity modifiers must be set");
            return new Vanity(type, material, modifiers, isTrinket);
        }
    }
}
