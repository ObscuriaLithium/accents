package dev.obscuria.accents.mixin;

import dev.obscuria.accents.content.recipe.RecipeAccessExtension;
import net.minecraft.world.item.crafting.RecipeAccess;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RecipeAccess.class)
public interface MixinRecipeAccess extends RecipeAccessExtension {}
