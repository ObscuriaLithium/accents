package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelQuiver;
import dev.obscuria.accents.content.item.VanityItem;

public final class QuiverRenderer extends VanityRenderer<VanityItem> {

    public QuiverRenderer() {
        super(new ModelQuiver());
    }
}
