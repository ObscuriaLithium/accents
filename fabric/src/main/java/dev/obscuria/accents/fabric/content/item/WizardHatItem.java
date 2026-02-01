package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.WizardHatRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class WizardHatItem extends FabricVanityArmorItem {

    public WizardHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, VANITY_MODIFIER, 0.025, AttributeModifier.Operation.MULTIPLY_BASE));
        consumer.accept(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, VANITY_MODIFIER, 0.025, AttributeModifier.Operation.MULTIPLY_BASE));
    }

    @Override
    public WizardHatRenderer createVanityRenderer() {
        return new WizardHatRenderer();
    }
}
