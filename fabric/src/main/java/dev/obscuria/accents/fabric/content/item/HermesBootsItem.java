package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.HermesBootsRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class HermesBootsItem extends FabricVanityArmorItem {

    public HermesBootsItem() {
        super(ArmorMaterials.LEATHER, Type.BOOTS, new Properties());
    }

    @Override
    public HermesBootsRenderer createVanityRenderer() {
        return new HermesBootsRenderer();
    }
}
