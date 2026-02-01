package dev.obscuria.accents.forge.compat;

import com.google.common.collect.Multimap;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public final class VanityCurio implements ICurioItem {

    public static final VanityCurio SHARED = new VanityCurio();

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext context, UUID uuid, ItemStack stack) {
        var modifiers = ICurioItem.super.getAttributeModifiers(context, uuid, stack);
        if (stack.getItem() instanceof VanityItem vanity)
            vanity.appendModifiers(uuid, modifiers::put);
        return modifiers;
    }
}
