package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.WizardHatRenderer;
import net.minecraft.world.item.ArmorMaterials;

public final class WizardHatItem extends FabricVanityArmorItem {

    public WizardHatItem() {
        super(ArmorMaterials.LEATHER, Type.HELMET, new Properties());
    }

    @Override
    public WizardHatRenderer createVanityRenderer() {
        return new WizardHatRenderer();
    }
}
