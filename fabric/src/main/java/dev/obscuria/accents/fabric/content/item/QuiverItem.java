package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.QuiverRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class QuiverItem extends FabricOptionalTrinketItem {

    public QuiverItem() {
        super(ArmorMaterials.LEATHER, Type.CHESTPLATE, new Properties());
    }

    @Override
    public QuiverRenderer createVanityRenderer() {
        return new QuiverRenderer();
    }
}