package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.QuiverRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class QuiverItem extends FabricOptionalTrinketItem {

    public QuiverItem() {
        super(ArmorMaterials.LEATHER, Type.CHESTPLATE, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.ATTACK_SPEED, new AttributeModifier(uuid, VANITY_MODIFIER, 0.025, AttributeModifier.Operation.MULTIPLY_BASE));
        consumer.accept(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, VANITY_MODIFIER, 0.025, AttributeModifier.Operation.MULTIPLY_BASE));
    }

    @Override
    public QuiverRenderer createVanityRenderer() {
        return new QuiverRenderer();
    }
}