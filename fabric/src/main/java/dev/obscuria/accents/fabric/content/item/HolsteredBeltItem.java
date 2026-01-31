package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.HolsteredBeltRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class HolsteredBeltItem extends FabricOptionalTrinketItem {

    public HolsteredBeltItem() {
        super(ArmorMaterials.LEATHER, Type.CHESTPLATE, new Properties());
    }

    @Override
    public HolsteredBeltRenderer createVanityRenderer() {
        return new HolsteredBeltRenderer();
    }
}