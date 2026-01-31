package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.CaptainHatRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class CaptainHatItem extends FabricVanityArmorItem {

    public CaptainHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public CaptainHatRenderer createVanityRenderer() {
        return new CaptainHatRenderer();
    }
}
