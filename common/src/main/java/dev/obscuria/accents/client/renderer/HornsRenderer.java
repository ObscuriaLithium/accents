package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelHorns;
import dev.obscuria.accents.content.item.VanityItem;

public final class HornsRenderer extends VanityRenderer<VanityItem> {

    public HornsRenderer() {
        super(new ModelHorns());
    }
}
