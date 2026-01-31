package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.OvertopHatRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class OvertopHatItem extends FabricVanityArmorItem {

    public OvertopHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public OvertopHatRenderer createVanityRenderer() {
        return new OvertopHatRenderer();
    }
}
