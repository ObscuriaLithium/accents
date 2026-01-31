package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelPickelhaube;
import dev.obscuria.accents.content.item.VanityItem;

public final class PickelhaubeRenderer extends VanityRenderer<VanityItem> {

    public PickelhaubeRenderer() {
        super(new ModelPickelhaube());
    }
}
