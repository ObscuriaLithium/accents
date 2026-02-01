package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.SombreroRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class SombreroItem extends FabricVanityArmorItem {

    public SombreroItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, VANITY_MODIFIER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE));
    }

    @Override
    public SombreroRenderer createVanityRenderer() {
        return new SombreroRenderer();
    }
}
