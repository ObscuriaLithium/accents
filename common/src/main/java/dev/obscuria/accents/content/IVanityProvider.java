package dev.obscuria.accents.content;

import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.world.item.Item;

public interface IVanityProvider {

    VanityItem create(Vanity vanity, Item.Properties properties);
}
