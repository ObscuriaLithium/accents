package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.HornsRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class HornsItem extends FabricVanityArmorItem {

    public HornsItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public HornsRenderer createVanityRenderer() {
        return new HornsRenderer();
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(uuid, VANITY_MODIFIER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE));
    }
}
