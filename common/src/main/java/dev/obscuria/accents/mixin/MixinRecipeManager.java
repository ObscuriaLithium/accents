package dev.obscuria.accents.mixin;

import dev.obscuria.accents.content.recipe.RecipeAccessExtension;
import dev.obscuria.accents.content.recipe.SewingRecipe;
import dev.obscuria.accents.content.recipe.SewingRecipeManager;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeManager.class)
public abstract class MixinRecipeManager implements RecipeAccessExtension {

    @Shadow private RecipeMap recipes;

    @Override
    public SelectableRecipe.SingleInputSet<SewingRecipe> accents$sewingRecipes() {
        return SewingRecipeManager.sewingRecipes();
    }

    @Inject(method = "finalizeRecipeLoading", at = @At("HEAD"))
    private void injectSewingRecipes(FeatureFlagSet enabledFeatures, CallbackInfo info) {
        SewingRecipeManager.prepareLoading();
        this.recipes.values().forEach(holder -> {
            var recipe = holder.value();
            if (!recipe.isSpecial() && recipe.placementInfo().isImpossibleToPlace()) return;
            if (!(recipe instanceof SewingRecipe sewingRecipe)) return;
            SewingRecipeManager.processRecipe(enabledFeatures, holder, sewingRecipe);
        });
        SewingRecipeManager.finalizeLoading();
    }
}
