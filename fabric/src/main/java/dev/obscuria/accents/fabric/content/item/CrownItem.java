package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.CrownRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class CrownItem extends FabricVanityArmorItem {

    public CrownItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public CrownRenderer createVanityRenderer() {
        return new CrownRenderer();
    }
}
