package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.ChristmasHatRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class ChristmasHatItem extends FabricVanityArmorItem {

    public ChristmasHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, VANITY_MODIFIER, 0.5, AttributeModifier.Operation.ADDITION));
    }

    @Override
    public ChristmasHatRenderer createVanityRenderer() {
        return new ChristmasHatRenderer();
    }
}
