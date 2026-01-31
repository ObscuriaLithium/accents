package dev.obscuria.accents.fabric.content.item.trinket;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public final class BandolierTrinket implements Trinket {

    public static final BandolierTrinket SHARED = new BandolierTrinket();

    @Override
    public Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = Trinket.super.getModifiers(stack, slot, entity, uuid);
        modifiers.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, "trinket_modifier", 0.1, AttributeModifier.Operation.MULTIPLY_BASE));
        return modifiers;
    }
}
