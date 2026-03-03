package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.recipe.SewingRecipe;
import dev.obscuria.fragmentum.registry.Deferred;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;

import java.util.function.Supplier;

public interface AccentsRecipeSerializers {

    Deferred<RecipeSerializer<?>, RecipeSerializer<SewingRecipe>> SEWING = register("sewing", () -> new SingleItemRecipe.Serializer<>(SewingRecipe::new));

    private static <T extends Recipe<?>> Deferred<RecipeSerializer<?>, RecipeSerializer<T>> register(String name, Supplier<RecipeSerializer<T>> supplier) {
        return AccentsRegistries.REGISTRAR.register(Registries.RECIPE_SERIALIZER, Accents.identifier(name), supplier);
    }

    static void init() {}
}
