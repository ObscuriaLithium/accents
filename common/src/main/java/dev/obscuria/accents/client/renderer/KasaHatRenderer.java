package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelKasaHat;
import dev.obscuria.accents.content.item.VanityItem;

public final class KasaHatRenderer extends VanityRenderer<VanityItem> {

    public KasaHatRenderer() {
        super(new ModelKasaHat());
    }
}
