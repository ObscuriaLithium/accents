package dev.obscuria.accents.client;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public final class AutoVanityModel extends GeoModel<VanityItem> {

    private final ResourceLocation model;
    private final ResourceLocation texture;

    @SuppressWarnings("deprecation")
    public AutoVanityModel(VanityItem item) {
        final var id = item.builtInRegistryHolder().key().location();
        this.model = Accents.key("geo/" + id.getPath() + ".geo.json");
        this.texture = Accents.key("textures/vanity/" + id.getPath() + ".png");
    }

    @Override
    public ResourceLocation getModelResource(VanityItem animatable) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(VanityItem animatable) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(VanityItem animatable) {
        return Accents.key("animations/default.animation.json");
    }
}
