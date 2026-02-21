package dev.obscuria.accents.client;

import dev.obscuria.accents.content.recipe.SewingRecipe;
import net.minecraft.world.item.crafting.SelectableRecipe;

public final class ClientSewingRecipes {

    private static SelectableRecipe.SingleInputSet<SewingRecipe> recipes = SelectableRecipe.SingleInputSet.empty();

    public static void update(SelectableRecipe.SingleInputSet<SewingRecipe> recipes) {
        ClientSewingRecipes.recipes = recipes;
    }

    public static SelectableRecipe.SingleInputSet<SewingRecipe> sewingRecipes() {
        return recipes;
    }
}
