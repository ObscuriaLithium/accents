package dev.obscuria.accents.fabric.compat;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

public final class VanityTrinket implements Trinket {

    public static final VanityTrinket SHARED = new VanityTrinket();

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, ResourceLocation id) {
        var modifiers = Trinket.super.getModifiers(stack, slot, entity, id);
        if (stack.getItem() instanceof VanityItem vanity)
            vanity.appendVanityModifiers(id, modifiers::put);
        return modifiers;
    }
}
