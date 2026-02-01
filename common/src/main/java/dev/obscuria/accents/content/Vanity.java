package dev.obscuria.accents.content;

import dev.obscuria.accents.client.renderer.VanityRenderer;
import dev.obscuria.accents.config.CommonConfig;
import dev.obscuria.fragmentum.config.ConfigValue;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public record Vanity(
        ArmorItem.Type type,
        ArmorMaterial material,
        ConfigValue<List<? extends String>> modifiers,
        Supplier<Supplier<VanityRenderer>> renderer,
        boolean isTrinket
) {
    private static final String TEMPLATE_SEPARATOR = " ";
    private static final String MODIFIER_SEPARATOR = ":";
    private static final String ADDITION = "addition";

    public static Builder simple(ArmorItem.Type type) {
        return new Builder(type, false);
    }

    public static Builder trinket(ArmorItem.Type type) {
        return new Builder(type, true);
    }

    public void appendModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        if (!CommonConfig.MODIFIERS_ENABLED.get()) return;
        for (var template : modifiers.get()) {
            var parts = template.split(TEMPLATE_SEPARATOR);
            if (parts.length != 2) continue;
            @Nullable var attribute = parseAttribute(parts[0]);
            if (attribute == null) continue;
            @Nullable var modifier = parseModifier(parts[1], uuid);
            if (modifier == null) continue;
            consumer.accept(attribute, modifier);
        }
    }

    public VanityRenderer createRenderer() {
        return renderer.get().get();
    }

    private @Nullable Attribute parseAttribute(String input) {
        @Nullable var id = ResourceLocation.tryParse(input);
        return id == null ? null : BuiltInRegistries.ATTRIBUTE.get(id);
    }

    private @Nullable AttributeModifier parseModifier(String input, UUID uuid) {
        var parts = input.split(MODIFIER_SEPARATOR);
        if (parts.length != 2) return null;
        try {
            var operation = parts[0].equals(ADDITION)
                    ? AttributeModifier.Operation.ADDITION
                    : AttributeModifier.Operation.MULTIPLY_BASE;
            var value = Double.parseDouble(parts[1]);
            return new AttributeModifier(uuid, "vanity_modifier", value, operation);
        } catch (Exception ignored) {
            return null;
        }
    }

    public static final class Builder {

        private final ArmorItem.Type type;
        private final boolean isTrinket;
        private @Nullable ConfigValue<List<? extends String>> modifiers;
        private ArmorMaterial material = ArmorMaterials.LEATHER;

        private Builder(ArmorItem.Type type, boolean isTrinket) {
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

        public Vanity build(Supplier<Supplier<VanityRenderer>> renderer) {
            Objects.requireNonNull(modifiers, "Vanity modifiers must be set");
            return new Vanity(type, material, modifiers, renderer, isTrinket);
        }
    }
}
