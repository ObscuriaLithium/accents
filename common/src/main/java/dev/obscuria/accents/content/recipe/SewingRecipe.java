package dev.obscuria.accents.content.recipe;

import dev.obscuria.accents.content.registry.AccentsItems;
import dev.obscuria.accents.content.registry.AccentsRecipeSerializers;
import dev.obscuria.accents.content.registry.AccentsRecipes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public final class SewingRecipe extends SingleItemRecipe {

    public SewingRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
        super(AccentsRecipes.SEWING.get(), AccentsRecipeSerializers.SEWING.get(), id, group, ingredient, result);
    }

    public boolean matches(Container container, Level level) {
        return this.ingredient.test(container.getItem(0));
    }

    public ItemStack getToastSymbol() {
        return AccentsItems.SEWING_STATION.instantiate();
    }
}
