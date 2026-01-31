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
import org.jetbrains.annotations.Nullable;

public class JEISewingRecipeCategory extends AbstractRecipeCategory<SewingRecipe> {

    public JEISewingRecipeCategory(IGuiHelper helper) {
        super(
                JEIAccentsPlugin.SEWING,
                Component.translatable("gui.jei.category.accents/sewing"),
                helper.createDrawableItemLike(AccentsItems.SEWING_STATION),
                82, 34);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SewingRecipe recipe, IFocusGroup focuses) {
        builder.addInputSlot(1, 9)
                .setStandardSlotBackground()
                .addIngredients(recipe.getIngredients().get(0));
        builder.addOutputSlot(61, 9)
                .setOutputSlotBackground()
                .addItemStack(recipe.getResultItem(null));
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, SewingRecipe recipe, IFocusGroup focuses) {
        builder.addRecipeArrow().setPosition(26, 9);
    }

    @Override
    public boolean isHandled(SewingRecipe recipe) {
        return !recipe.isSpecial();
    }

    @Override
    public @Nullable ResourceLocation getRegistryName(SewingRecipe recipe) {
        return recipe.getId();
    }
}
