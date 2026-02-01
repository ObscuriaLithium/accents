package dev.obscuria.accents.forge.content;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import dev.obscuria.accents.compat.AccentsCompats;
import dev.obscuria.accents.content.Vanity;
import dev.obscuria.accents.content.item.VanityItem;
import dev.obscuria.accents.forge.client.ForgeClientItemExtensions;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public final class ForgeVanityItem extends VanityItem {

    public ForgeVanityItem(Vanity vanity, Properties properties) {
        super(vanity, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return vanity.isTrinket() && AccentsCompats.CURIOS.isLoaded()
                ? HashMultimap.create()
                : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new ForgeClientItemExtensions(this));
    }
}
