package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.BandolierRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class BandolierItem extends FabricOptionalTrinketItem {

    public BandolierItem() {
        super(ArmorMaterials.LEATHER, Type.CHESTPLATE, new Properties());
    }

    @Override
    public BandolierRenderer createVanityRenderer() {
        return new BandolierRenderer();
    }
}