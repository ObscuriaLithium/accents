package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelDragonSkull;
import dev.obscuria.accents.content.item.VanityItem;

public final class DragonSkullRenderer extends VanityRenderer<VanityItem> {

    public DragonSkullRenderer() {
        super(new ModelDragonSkull());
    }
}
