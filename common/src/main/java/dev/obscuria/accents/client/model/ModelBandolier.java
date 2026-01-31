package dev.obscuria.accents.client.model;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public final class ModelBandolier extends GeoModel<VanityItem> {

    @Override
    public ResourceLocation getModelResource(VanityItem object) {
        return Accents.key("geo/bandolier.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VanityItem object) {
        return Accents.key("textures/vanity/bandolier.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VanityItem animatable) {
        return Accents.key("animations/default.json");
    }
}
