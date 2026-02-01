package dev.obscuria.accents.fabric.compat;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public final class VanityTrinket implements Trinket {

    public static final VanityTrinket SHARED = new VanityTrinket();

    @Override
    public Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = Trinket.super.getModifiers(stack, slot, entity, uuid);
        if (stack.getItem() instanceof VanityItem vanity) {
            vanity.collectModifiers(uuid, modifiers::put);
        }
        return modifiers;
    }
}
