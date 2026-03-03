package dev.obscuria.accents.fabric.content;

import dev.obscuria.accents.content.IVanityProvider;
import dev.obscuria.accents.content.Vanity;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.world.item.Item;

public final class FabricVanityProvider implements IVanityProvider {

    @Override
    public VanityItem create(boolean glowing, Vanity vanity, Item.Properties properties) {
        return new FabricVanityItem(glowing, vanity, properties);
    }
}
