package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelStrawHat;
import dev.obscuria.accents.content.item.VanityItem;

public final class StrawHatRenderer extends VanityRenderer<VanityItem> {

    public StrawHatRenderer() {
        super(new ModelStrawHat());
    }
}
