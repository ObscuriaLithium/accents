package dev.obscuria.accents.compat;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.recipe.SewingRecipe;
import dev.obscuria.accents.content.registry.AccentsItems;
import dev.obscuria.accents.content.registry.AccentsRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;

@JeiPlugin
public final class JEIAccentsPlugin implements IModPlugin {

    public static RecipeType<SewingRecipe> SEWING = new RecipeType<>(Accents.key("sewing"), SewingRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return Accents.key("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new JEISewingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(AccentsItems.SEWING_STATION, SEWING);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        var manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        var recipes = manager.getAllRecipesFor(AccentsRecipes.SEWING.get());
        registration.addRecipes(SEWING, recipes);
    }
}
