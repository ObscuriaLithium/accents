package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelCaptainHat;
import dev.obscuria.accents.content.item.VanityItem;

public final class CaptainHatRenderer extends VanityRenderer<VanityItem> {

    public CaptainHatRenderer() {
        super(new ModelCaptainHat());
    }
}
