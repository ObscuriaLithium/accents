package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.PumpkinHatRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class PumpkinHatItem extends FabricVanityArmorItem {

    public PumpkinHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public PumpkinHatRenderer createVanityRenderer() {
        return new PumpkinHatRenderer();
    }
}
