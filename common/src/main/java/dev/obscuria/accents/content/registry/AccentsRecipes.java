package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.recipe.SewingRecipe;
import dev.obscuria.fragmentum.registry.Deferred;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface AccentsRecipes {

    Deferred<RecipeType<?>, RecipeType<SewingRecipe>> SEWING = register("sewing");

    private static <T extends Recipe<?>> Deferred<RecipeType<?>, RecipeType<T>> register(String name) {
        return AccentsRegistries.REGISTRAR.register(Registries.RECIPE_TYPE, Accents.key(name), () -> new RecipeType<>() {
            @Override
            public String toString() {
                return name;
            }
        });
    }

    static void init() {}
}
