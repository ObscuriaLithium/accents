package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.SombreroRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class SombreroItem extends FabricVanityArmorItem {

    public SombreroItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public SombreroRenderer createVanityRenderer() {
        return new SombreroRenderer();
    }
}
