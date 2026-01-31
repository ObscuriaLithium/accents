package dev.obscuria.accents.client.renderer;

import dev.obscuria.accents.client.model.ModelSkull;
import dev.obscuria.accents.content.item.VanityItem;
import software.bernie.geckolib.core.object.Color;

public final class SkullRenderer extends VanityRenderer<VanityItem> {

    public SkullRenderer() {
        super(new ModelSkull());
    }

    @Override
    public Color getRenderColor(VanityItem animatable, float partialTick, int packedLight) {
        return Color.ofOpaque(animatable.getColor(currentStack));
    }
}
