package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelCakemanPlushie;
import dev.obscuria.accents.content.item.VanityItem;

public final class CakemanPlushieRenderer extends VanityRenderer<VanityItem> {

    public CakemanPlushieRenderer() {
        super(new ModelCakemanPlushie());
    }
}
