package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.TopHatRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class TopHatItem extends FabricVanityArmorItem {

    public TopHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public TopHatRenderer createVanityRenderer() {
        return new TopHatRenderer();
    }
}
