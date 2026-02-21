package dev.obscuria.accents.content.recipe;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class SewingRecipeManager {

    private static final List<SelectableRecipe.SingleInputEntry<SewingRecipe>> processed = new ArrayList<>();
    private static SelectableRecipe.SingleInputSet<SewingRecipe> recipes = SelectableRecipe.SingleInputSet.empty();

    public static SelectableRecipe.SingleInputSet<SewingRecipe> sewingRecipes() {
        return recipes;
    }

    public static void prepareLoading() {
        processed.clear();
    }

    @SuppressWarnings("unchecked")
    public static void processRecipe(FeatureFlagSet enabledFeatures, RecipeHolder<?> holder, SewingRecipe recipe) {
        if (!RecipeManager.isIngredientEnabled(enabledFeatures, recipe.input())) return;
        if (!recipe.resultDisplay().isEnabled(enabledFeatures)) return;
        processed.add(new SelectableRecipe.SingleInputEntry<>(recipe.input(),
                new SelectableRecipe<>(
                        recipe.resultDisplay(),
                        Optional.of((RecipeHolder<SewingRecipe>) holder))));
    }

    public static void finalizeLoading() {
        recipes = new SelectableRecipe.SingleInputSet<>(processed);
    }
}
