package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.StrawHatRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class StrawHatItem extends FabricVanityArmorItem {

    public StrawHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public StrawHatRenderer createVanityRenderer() {
        return new StrawHatRenderer();
    }
}
