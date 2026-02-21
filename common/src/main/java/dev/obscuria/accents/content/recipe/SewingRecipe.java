package dev.obscuria.accents.content.recipe;

import dev.obscuria.accents.content.registry.AccentsItems;
import dev.obscuria.accents.content.registry.AccentsRecipeSerializers;
import dev.obscuria.accents.content.registry.AccentsRecipes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.item.crafting.display.StonecutterRecipeDisplay;

import java.util.List;

public final class SewingRecipe extends SingleItemRecipe {

    public SewingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(group, ingredient, result);
    }

    public SlotDisplay resultDisplay() {
        return new SlotDisplay.ItemStackSlotDisplay(result());
    }

    public List<RecipeDisplay> display() {
        return List.of(new StonecutterRecipeDisplay(
                this.input().display(), this.resultDisplay(),
                new SlotDisplay.ItemSlotDisplay(AccentsItems.SEWING_STATION.get())));
    }

    @Override
    public RecipeType<SewingRecipe> getType() {
        return AccentsRecipes.SEWING.get();
    }

    @Override
    public RecipeSerializer<SewingRecipe> getSerializer() {
        return AccentsRecipeSerializers.SEWING.get();
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.STONECUTTER;
    }
}
