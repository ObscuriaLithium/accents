package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.DragonSkullRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public final class DragonSkullItem extends FabricVanityArmorItem {

    public DragonSkullItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, VANITY_MODIFIER, 0.05, AttributeModifier.Operation.MULTIPLY_BASE));
    }

    @Override
    public DragonSkullRenderer createVanityRenderer() {
        return new DragonSkullRenderer();
    }
}
