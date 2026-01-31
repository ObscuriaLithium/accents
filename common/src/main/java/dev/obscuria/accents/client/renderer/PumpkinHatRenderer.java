package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelPumpkinHat;
import dev.obscuria.accents.content.item.VanityItem;

public final class PumpkinHatRenderer extends VanityRenderer<VanityItem> {

    public PumpkinHatRenderer() {
        super(new ModelPumpkinHat(), true);
    }
}
