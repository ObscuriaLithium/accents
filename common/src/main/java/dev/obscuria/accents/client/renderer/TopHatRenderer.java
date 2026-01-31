package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelTopHat;
import dev.obscuria.accents.content.item.VanityItem;

public final class TopHatRenderer extends VanityRenderer<VanityItem> {

    public TopHatRenderer() {
        super(new ModelTopHat());
    }
}
