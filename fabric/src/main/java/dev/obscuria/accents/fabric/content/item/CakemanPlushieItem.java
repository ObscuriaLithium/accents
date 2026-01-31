package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.CakemanPlushieRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class CakemanPlushieItem extends FabricVanityArmorItem {

    public CakemanPlushieItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public CakemanPlushieRenderer createVanityRenderer() {
        return new CakemanPlushieRenderer();
    }
}
