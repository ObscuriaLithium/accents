package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.ChristmasHatRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class ChristmasHatItem extends FabricVanityArmorItem {

    public ChristmasHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public ChristmasHatRenderer createVanityRenderer() {
        return new ChristmasHatRenderer();
    }
}
