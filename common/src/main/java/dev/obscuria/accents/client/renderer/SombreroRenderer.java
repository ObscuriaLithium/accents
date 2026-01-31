package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelSombrero;
import dev.obscuria.accents.content.item.VanityItem;

public final class SombreroRenderer extends VanityRenderer<VanityItem> {

    public SombreroRenderer() {
        super(new ModelSombrero());
    }
}
