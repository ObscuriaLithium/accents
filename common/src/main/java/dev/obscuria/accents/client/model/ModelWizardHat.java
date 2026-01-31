package dev.obscuria.accents.client.model;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public final class ModelWizardHat extends GeoModel<VanityItem> {

    @Override
    public ResourceLocation getModelResource(VanityItem object) {
        return Accents.key("geo/wizard_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VanityItem object) {
        return Accents.key("textures/vanity/wizard_hat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VanityItem animatable) {
        return Accents.key("animations/default.json");
    }
}
