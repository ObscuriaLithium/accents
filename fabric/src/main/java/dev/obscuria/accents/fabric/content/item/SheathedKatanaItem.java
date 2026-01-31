package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.SheathedKatanaRenderer;
import net.minecraft.world.item.ArmorMaterials;

public class SheathedKatanaItem extends FabricOptionalTrinketItem {

    public SheathedKatanaItem() {
        super(ArmorMaterials.LEATHER, Type.CHESTPLATE, new Properties());
    }

    @Override
    public SheathedKatanaRenderer createVanityRenderer() {
        return new SheathedKatanaRenderer();
    }
}