package dev.obscuria.accents.content.item;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;

public final class VanityMaterial implements ArmorMaterial {

    public static final VanityMaterial SHARED = new VanityMaterial();
    private static final EnumMap<ArmorItem.Type, Integer> DURABILITY_BY_TYPE;

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return DURABILITY_BY_TYPE.get(type) * 35;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return ArmorMaterials.LEATHER.getDefenseForType(type);
    }

    @Override
    public int getEnchantmentValue() {
        return ArmorMaterials.LEATHER.getEnchantmentValue();
    }

    @Override
    public SoundEvent getEquipSound() {
        return ArmorMaterials.LEATHER.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return ArmorMaterials.LEATHER.getRepairIngredient();
    }

    @Override
    public String getName() {
        return ArmorMaterials.LEATHER.getName();
    }

    @Override
    public float getToughness() {
        return ArmorMaterials.LEATHER.getToughness();
    }

    @Override
    public float getKnockbackResistance() {
        return ArmorMaterials.LEATHER.getKnockbackResistance();
    }

    static {
        DURABILITY_BY_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), builder -> {
            builder.put(ArmorItem.Type.BOOTS, 13);
            builder.put(ArmorItem.Type.LEGGINGS, 15);
            builder.put(ArmorItem.Type.CHESTPLATE, 16);
            builder.put(ArmorItem.Type.HELMET, 11);
        });
    }
}
