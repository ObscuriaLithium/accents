package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.SkullRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class SkullItem extends FabricVanityArmorItem {

    public SkullItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public SkullRenderer createVanityRenderer() {
        return new SkullRenderer();
    }
}
