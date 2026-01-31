package dev.obscuria.accents.fabric.content.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import dev.obscuria.accents.compat.AccentsCompats;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorMaterial;

public abstract class FabricOptionalTrinketItem extends FabricVanityArmorItem {

    protected FabricOptionalTrinketItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return !AccentsCompats.TRINKETS.isLoaded()
                ? super.getDefaultAttributeModifiers(slot)
                : HashMultimap.create();
    }
}
