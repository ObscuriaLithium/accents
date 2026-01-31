package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.HornsRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class HornsItem extends FabricVanityArmorItem {

    public HornsItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public HornsRenderer createVanityRenderer() {
        return new HornsRenderer();
    }
}
