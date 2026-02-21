package dev.obscuria.accents.compat;

import dev.obscuria.accents.content.registry.AccentsItems;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class JEISewingRecipeCategory extends AbstractRecipeCategory<JEISewingRecipe> {

    public JEISewingRecipeCategory(IGuiHelper helper) {
        super(
                JEIAccentsPlugin.SEWING,
                Component.translatable("gui.jei.category.accents/sewing"),
                helper.createDrawableItemLike(AccentsItems.SEWING_STATION.get()),
                82, 34);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, JEISewingRecipe recipe, IFocusGroup focuses) {
        builder.addInputSlot(1, 9).setStandardSlotBackground().add(recipe.input());
        builder.addOutputSlot(61, 9).setOutputSlotBackground().add(recipe.result());
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, JEISewingRecipe recipe, IFocusGroup focuses) {
        builder.addRecipeArrow().setPosition(26, 9);
    }

    @Override
    public Identifier getIdentifier(JEISewingRecipe recipe) {
        return recipe.identifier();
    }
}
