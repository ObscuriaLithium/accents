package dev.obscuria.accents.content.recipe;

import dev.obscuria.accents.content.registry.AccentsItems;
import dev.obscuria.accents.content.registry.AccentsRecipeSerializers;
import dev.obscuria.accents.content.registry.AccentsRecipes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public final class SewingRecipe extends SingleItemRecipe {

    public SewingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(AccentsRecipes.SEWING.get(), AccentsRecipeSerializers.SEWING.get(), group, ingredient, result);
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return this.ingredient.test(input.item());
    }

    public ItemStack getToastSymbol() {
        return AccentsItems.SEWING_STATION.instantiate();
    }
}
