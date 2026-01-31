package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.PickelhaubeRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class PickelhaubeItem extends FabricVanityArmorItem {

    public PickelhaubeItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public PickelhaubeRenderer createVanityRenderer() {
        return new PickelhaubeRenderer();
    }
}
