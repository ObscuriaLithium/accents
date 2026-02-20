package dev.obscuria.accents.neoforge.compat;

import com.google.common.collect.Multimap;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public final class VanityCurio implements ICurioItem {

    public static final VanityCurio SHARED = new VanityCurio();

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext context, ResourceLocation id, ItemStack stack) {
        var modifiers = ICurioItem.super.getAttributeModifiers(context, id, stack);
        if (stack.getItem() instanceof VanityItem vanity)
            vanity.appendVanityModifiers(id, modifiers::put);
        return modifiers;
    }
}
