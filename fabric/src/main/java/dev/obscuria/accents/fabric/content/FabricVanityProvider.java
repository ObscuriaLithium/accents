package dev.obscuria.accents.fabric.content;

import dev.obscuria.accents.content.IVanityProvider;
import dev.obscuria.accents.content.Vanity;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.world.item.Item;

public final class FabricVanityProvider implements IVanityProvider {

    @Override
    public VanityItem create(Vanity vanity, Item.Properties properties) {
        return new FabricVanityItem(vanity, properties);
    }
}
