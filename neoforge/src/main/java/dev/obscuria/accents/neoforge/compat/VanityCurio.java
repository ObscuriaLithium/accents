package dev.obscuria.accents.neoforge.compat;

import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CurioAttributeModifiers;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public final class VanityCurio implements ICurioItem {

    public static final VanityCurio SHARED = new VanityCurio();

    @Override
    @SuppressWarnings("deprecation")
    public CurioAttributeModifiers getDefaultCurioAttributeModifiers(ItemStack stack) {
        var identifier = stack.getItem().builtInRegistryHolder().key().identifier();
        var builder = CurioAttributeModifiers.builder();
        if (stack.getItem() instanceof VanityItem vanity)
            vanity.appendVanityModifiers(identifier, builder::addModifier);
        return builder.build();
    }
}
