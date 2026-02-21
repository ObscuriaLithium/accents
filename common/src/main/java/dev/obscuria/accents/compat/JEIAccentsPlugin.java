package dev.obscuria.accents.compat;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.recipe.RecipeAccessExtension;
import dev.obscuria.accents.content.registry.AccentsItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;

import java.util.Objects;

@JeiPlugin
public final class JEIAccentsPlugin implements IModPlugin {

    public static IRecipeType<JEISewingRecipe> SEWING = IRecipeType.create(Accents.identifier("sewing"), JEISewingRecipe.class);

    @Override
    public Identifier getPluginUid() {
        return Accents.identifier("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new JEISewingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(SEWING, AccentsItems.SEWING_STATION.get());
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        var access = Objects.requireNonNull(Minecraft.getInstance().level).recipeAccess();
        var recipes = RecipeAccessExtension.sewingRecipes(access);
        registration.addRecipes(SEWING, recipes.entries().stream().map(JEISewingRecipe::new).toList());
    }
}
