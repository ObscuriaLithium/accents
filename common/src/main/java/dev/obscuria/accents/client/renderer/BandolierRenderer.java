package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelBandolier;
import dev.obscuria.accents.content.item.VanityItem;

public final class BandolierRenderer extends VanityRenderer<VanityItem> {

    public BandolierRenderer() {
        super(new ModelBandolier());
    }
}
