package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.SkullRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class SkullItem extends FabricVanityArmorItem {

    public SkullItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.ARMOR, new AttributeModifier(uuid, VANITY_MODIFIER, 1, AttributeModifier.Operation.ADDITION));
    }

    @Override
    public SkullRenderer createVanityRenderer() {
        return new SkullRenderer();
    }
}
