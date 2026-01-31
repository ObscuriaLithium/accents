package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.CowboyHatRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class CowboyHatItem extends FabricVanityArmorItem {

    public CowboyHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public CowboyHatRenderer createVanityRenderer() {
        return new CowboyHatRenderer();
    }
}
