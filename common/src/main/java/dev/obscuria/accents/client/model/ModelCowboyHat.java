package dev.obscuria.accents.client.model;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public final class ModelCowboyHat extends GeoModel<VanityItem> {

    @Override
    public ResourceLocation getModelResource(VanityItem object) {
        return Accents.key("geo/cowboy_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VanityItem object) {
        return Accents.key("textures/vanity/cowboy_hat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VanityItem animatable) {
        return Accents.key("animations/default.json");
    }
}
