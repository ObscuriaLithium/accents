package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelWizardHat;
import dev.obscuria.accents.content.item.VanityItem;

public final class WizardHatRenderer extends VanityRenderer<VanityItem> {

    public WizardHatRenderer() {
        super(new ModelWizardHat());
    }
}
