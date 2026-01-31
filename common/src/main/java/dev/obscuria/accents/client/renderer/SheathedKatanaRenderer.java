package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelSheathedKatana;
import dev.obscuria.accents.content.item.VanityItem;

public final class SheathedKatanaRenderer extends VanityRenderer<VanityItem> {

    public SheathedKatanaRenderer() {
        super(new ModelSheathedKatana());
    }
}
