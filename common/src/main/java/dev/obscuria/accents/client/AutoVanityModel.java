package dev.obscuria.accents.client;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public final class AutoVanityModel extends GeoModel<VanityItem> {

    private final Identifier model;
    private final Identifier texture;

    @SuppressWarnings("deprecation")
    public AutoVanityModel(VanityItem item) {
        final var id = item.builtInRegistryHolder().key().identifier();
        this.model = id;
        this.texture = Accents.identifier("textures/vanity/" + id.getPath() + "_overlay.png");
    }

    @Override
    public Identifier getModelResource(GeoRenderState state) {
        return model;
    }

    @Override
    public Identifier getTextureResource(GeoRenderState state) {
        return texture;
    }

    @Override
    public Identifier getAnimationResource(VanityItem animatable) {
        return Accents.identifier("default");
    }
}
