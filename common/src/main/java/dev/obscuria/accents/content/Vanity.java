package dev.obscuria.accents.content;

import dev.obscuria.accents.client.renderer.VanityRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public record Vanity(
        ArmorItem.Type type,
        ArmorMaterial material,
        List<Modifier> modifiers,
        Supplier<Supplier<VanityRenderer>> renderer,
        boolean isTrinket
) {

    public static Builder simple(ArmorItem.Type type) {
        return new Builder(type, false);
    }

    public static Builder trinket(ArmorItem.Type type) {
        return new Builder(type, true);
    }

    public void appendModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        for (var template : modifiers) {
            var modifier = new AttributeModifier(uuid, "vanity_modifier", template.value, template.operation);
            consumer.accept(template.attribute, modifier);
        }
    }

    public VanityRenderer createRenderer() {
        return renderer.get().get();
    }

    public record Modifier(Attribute attribute, double value, AttributeModifier.Operation operation) {}

    public static final class Builder {

        private final ArmorItem.Type type;
        private final boolean isTrinket;
        private final List<Modifier> modifiers = new ArrayList<>();
        private ArmorMaterial material = ArmorMaterials.LEATHER;

        private Builder(ArmorItem.Type type, boolean isTrinket) {
            this.type = type;
            this.isTrinket = isTrinket;
        }

        public Builder material(ArmorMaterial material) {
            this.material = material;
            return this;
        }

        public Builder modifierAddition(Attribute attribute, double value) {
            this.modifiers.add(new Modifier(attribute, value, AttributeModifier.Operation.ADDITION));
            return this;
        }

        public Builder modifierMultiply(Attribute attribute, double value) {
            this.modifiers.add(new Modifier(attribute, value, AttributeModifier.Operation.MULTIPLY_BASE));
            return this;
        }

        public Vanity build(Supplier<Supplier<VanityRenderer>> renderer) {
            return new Vanity(type, material, modifiers, renderer, isTrinket);
        }
    }
}
