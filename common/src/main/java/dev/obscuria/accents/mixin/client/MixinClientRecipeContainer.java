package dev.obscuria.accents.mixin.client;

import dev.obscuria.accents.client.ClientSewingRecipes;
import dev.obscuria.accents.content.recipe.RecipeAccessExtension;
import dev.obscuria.accents.content.recipe.SewingRecipe;
import net.minecraft.client.multiplayer.ClientRecipeContainer;
import net.minecraft.world.item.crafting.SelectableRecipe;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientRecipeContainer.class)
public abstract class MixinClientRecipeContainer implements RecipeAccessExtension {

    @Override
    public SelectableRecipe.SingleInputSet<SewingRecipe> accents$sewingRecipes() {
        return ClientSewingRecipes.sewingRecipes();
    }
}
