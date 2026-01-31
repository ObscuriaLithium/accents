package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.WingsRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class WingsItem extends FabricOptionalTrinketItem {

    public WingsItem() {
        super(ArmorMaterials.LEATHER, Type.CHESTPLATE, new Properties());
    }

    @Override
    public WingsRenderer createVanityRenderer() {
        return new WingsRenderer();
    }
}