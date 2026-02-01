package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.PumpkinHatRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class PumpkinHatItem extends FabricVanityArmorItem {

    public PumpkinHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.FOLLOW_RANGE, new AttributeModifier(uuid, "vanity_modifier", 0.05, AttributeModifier.Operation.MULTIPLY_BASE));
    }

    @Override
    public PumpkinHatRenderer createVanityRenderer() {
        return new PumpkinHatRenderer();
    }
}
