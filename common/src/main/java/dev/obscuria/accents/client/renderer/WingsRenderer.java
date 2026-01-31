package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelWings;
import dev.obscuria.accents.content.item.VanityItem;

public final class WingsRenderer extends VanityRenderer<VanityItem> {

    public WingsRenderer() {
        super(new ModelWings());
    }
}
