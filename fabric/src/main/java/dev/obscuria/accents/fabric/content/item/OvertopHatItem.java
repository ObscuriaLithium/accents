package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.OvertopHatRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class OvertopHatItem extends FabricVanityArmorItem {

    public OvertopHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.LUCK, new AttributeModifier(uuid, VANITY_MODIFIER, 2, AttributeModifier.Operation.ADDITION));
    }

    @Override
    public OvertopHatRenderer createVanityRenderer() {
        return new OvertopHatRenderer();
    }
}
