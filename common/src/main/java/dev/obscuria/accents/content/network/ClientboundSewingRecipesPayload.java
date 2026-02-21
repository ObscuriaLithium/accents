package dev.obscuria.accents.content.network;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.recipe.SewingRecipe;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.crafting.SelectableRecipe;

public record ClientboundSewingRecipesPayload(
        SelectableRecipe.SingleInputSet<SewingRecipe> recipes
) implements CustomPacketPayload {

    public static final Type<ClientboundSewingRecipesPayload> TYPE;
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundSewingRecipesPayload> STREAM_CODEC;

    @Override
    public Type<ClientboundSewingRecipesPayload> type() {
        return TYPE;
    }

    static {
        TYPE = new Type<>(Accents.identifier("sewing_recipes"));
        STREAM_CODEC = StreamCodec.composite(
                SelectableRecipe.SingleInputSet.noRecipeCodec(),
                ClientboundSewingRecipesPayload::recipes,
                ClientboundSewingRecipesPayload::new);
    }
}
