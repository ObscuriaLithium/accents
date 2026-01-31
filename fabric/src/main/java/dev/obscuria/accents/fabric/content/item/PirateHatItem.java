package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.PirateHatRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class PirateHatItem extends FabricVanityArmorItem {

    public PirateHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public PirateHatRenderer createVanityRenderer() {
        return new PirateHatRenderer();
    }
}
