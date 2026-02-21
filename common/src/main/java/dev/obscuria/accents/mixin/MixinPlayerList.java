package dev.obscuria.accents.mixin;

import dev.obscuria.accents.content.network.ClientboundSewingRecipesPayload;
import dev.obscuria.accents.content.recipe.SewingRecipeManager;
import dev.obscuria.fragmentum.content.network.FragmentumNetworking;
import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(PlayerList.class)
public abstract class MixinPlayerList {

    @Shadow @Final private List<ServerPlayer> players;

    @Inject(method = "placeNewPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;getRecipeManager()Lnet/minecraft/world/item/crafting/RecipeManager;"))
    private void syncOnNewPlayer(Connection connection, ServerPlayer player, CommonListenerCookie cookie, CallbackInfo info) {
        var payload = new ClientboundSewingRecipesPayload(SewingRecipeManager.sewingRecipes());
        FragmentumNetworking.sendTo(player, payload);
    }

    @Inject(method = "reloadResources", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;getRecipeManager()Lnet/minecraft/world/item/crafting/RecipeManager;"))
    private void syncOnReload(CallbackInfo info) {
        var payload = new ClientboundSewingRecipesPayload(SewingRecipeManager.sewingRecipes());
        for (var player : players) {
            FragmentumNetworking.sendTo(player, payload);
        }
    }
}
