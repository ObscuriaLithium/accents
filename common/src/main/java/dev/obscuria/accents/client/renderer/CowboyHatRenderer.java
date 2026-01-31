package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelCowboyHat;
import dev.obscuria.accents.content.item.VanityItem;

public final class CowboyHatRenderer extends VanityRenderer<VanityItem> {

    public CowboyHatRenderer() {
        super(new ModelCowboyHat());
    }
}
