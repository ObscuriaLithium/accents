package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.SheathedKatanaRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterials;

import java.util.UUID;
import java.util.function.BiConsumer;

public class SheathedKatanaItem extends FabricOptionalTrinketItem {

    public SheathedKatanaItem() {
        super(ArmorMaterials.LEATHER, Type.CHESTPLATE, new Properties());
    }

    @Override
    public void collectModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        consumer.accept(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, "vanity_modifier", 0.05, AttributeModifier.Operation.MULTIPLY_BASE));
    }

    @Override
    public SheathedKatanaRenderer createVanityRenderer() {
        return new SheathedKatanaRenderer();
    }
}