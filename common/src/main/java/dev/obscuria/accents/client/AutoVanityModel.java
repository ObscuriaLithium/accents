package dev.obscuria.accents.client;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public final class AutoVanityModel extends GeoModel<VanityItem> {

    private final ResourceLocation model;
    private final ResourceLocation texture;
    private final ResourceLocation animation;

    @SuppressWarnings("deprecation")
    public AutoVanityModel(VanityItem animatable) {
        final var id = animatable.builtInRegistryHolder().key().location();
        this.model = Accents.identifier("geo/%s.geo.json".formatted(id.getPath()));
        this.texture = Accents.identifier("textures/vanity/%s.png".formatted(id.getPath()));
        this.animation = Accents.identifier("animations/default.json");
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
        return animation;
    }
}
