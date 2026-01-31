package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelCrown;
import dev.obscuria.accents.content.item.VanityItem;

public final class CrownRenderer extends VanityRenderer<VanityItem> {

    public CrownRenderer() {
        super(new ModelCrown());
    }
}
