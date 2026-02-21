package dev.obscuria.accents.content.recipe;

import net.minecraft.world.item.crafting.RecipeAccess;
import net.minecraft.world.item.crafting.SelectableRecipe;

public interface RecipeAccessExtension {

    SelectableRecipe.SingleInputSet<SewingRecipe> accents$sewingRecipes();

    static SelectableRecipe.SingleInputSet<SewingRecipe> sewingRecipes(RecipeAccess access) {
        return ((RecipeAccessExtension) access).accents$sewingRecipes();
    }
}
