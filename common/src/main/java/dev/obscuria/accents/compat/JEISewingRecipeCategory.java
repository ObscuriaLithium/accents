package dev.obscuria.accents.compat;

import dev.obscuria.accents.content.recipe.SewingRecipe;
import dev.obscuria.accents.content.registry.AccentsItems;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

public class JEISewingRecipeCategory extends AbstractRecipeCategory<RecipeHolder<SewingRecipe>> {

    public JEISewingRecipeCategory(IGuiHelper helper) {
        super(
                JEIAccentsPlugin.SEWING,
                Component.translatable("gui.jei.category.accents/sewing"),
                helper.createDrawableItemLike(AccentsItems.SEWING_STATION),
                82, 34);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<SewingRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(1, 9)
                .setStandardSlotBackground()
                .addIngredients(recipe.value().getIngredients().get(0));
        builder.addOutputSlot(61, 9)
                .setOutputSlotBackground()
                .addItemStack(recipe.value().getResultItem(null));
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, RecipeHolder<SewingRecipe> recipe, IFocusGroup focuses) {
        builder.addRecipeArrow().setPosition(26, 9);
    }

    @Override
    public boolean isHandled(RecipeHolder<SewingRecipe> recipe) {
        return !recipe.value().isSpecial();
    }

    @Override
    public @Nullable ResourceLocation getRegistryName(RecipeHolder<SewingRecipe> recipe) {
        return recipe.id();
    }
}
