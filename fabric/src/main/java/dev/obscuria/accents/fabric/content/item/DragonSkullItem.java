package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.DragonSkullRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class DragonSkullItem extends FabricVanityArmorItem {

    public DragonSkullItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public DragonSkullRenderer createVanityRenderer() {
        return new DragonSkullRenderer();
    }
}
