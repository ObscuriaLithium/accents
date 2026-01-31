package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelPirateHat;
import dev.obscuria.accents.content.item.VanityItem;

public final class PirateHatRenderer extends VanityRenderer<VanityItem> {

    public PirateHatRenderer() {
        super(new ModelPirateHat());
    }
}
