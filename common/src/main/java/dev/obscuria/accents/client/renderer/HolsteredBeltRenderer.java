package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelHolsteredBelt;
import dev.obscuria.accents.content.item.VanityItem;

public final class HolsteredBeltRenderer extends VanityRenderer<VanityItem> {

    public HolsteredBeltRenderer() {
        super(new ModelHolsteredBelt());
    }
}
