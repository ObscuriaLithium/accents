package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.KasaHatRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class KasaHatItem extends FabricVanityArmorItem {

    public KasaHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, VANITY_MODIFIER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE));
    }

    @Override
    public KasaHatRenderer createVanityRenderer() {
        return new KasaHatRenderer();
    }
}
