package dev.obscuria.accents.client;

import dev.obscuria.accents.content.network.ClientboundSewingRecipesPayload;
import net.minecraft.world.entity.player.Player;

public final class ClientPayloadListener {

    public static void handle(Player player, ClientboundSewingRecipesPayload payload) {
        ClientSewingRecipes.update(payload.recipes());
    }
}
