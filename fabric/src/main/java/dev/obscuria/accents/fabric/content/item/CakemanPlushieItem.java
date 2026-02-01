package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.CakemanPlushieRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class CakemanPlushieItem extends FabricVanityArmorItem {

    public CakemanPlushieItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.LUCK, new AttributeModifier(uuid, VANITY_MODIFIER, 1, AttributeModifier.Operation.ADDITION));
    }

    @Override
    public CakemanPlushieRenderer createVanityRenderer() {
        return new CakemanPlushieRenderer();
    }
}
