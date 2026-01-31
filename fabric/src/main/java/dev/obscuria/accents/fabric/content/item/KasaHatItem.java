package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.KasaHatRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class KasaHatItem extends FabricVanityArmorItem {

    public KasaHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public KasaHatRenderer createVanityRenderer() {
        return new KasaHatRenderer();
    }
}
