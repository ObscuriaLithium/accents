package dev.obscuria.accents.forge.content;

import dev.obscuria.accents.content.IVanityProvider;
import dev.obscuria.accents.content.Vanity;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.world.item.Item;

public final class ForgeVanityProvider implements IVanityProvider {

    @Override
    public VanityItem create(Vanity vanity, Item.Properties properties) {
        return new ForgeVanityItem(vanity, properties);
    }
}
