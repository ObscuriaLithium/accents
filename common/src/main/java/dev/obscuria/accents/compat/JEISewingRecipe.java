package dev.obscuria.accents.compat;

import dev.obscuria.accents.content.recipe.SewingRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SelectableRecipe;
import net.minecraft.world.item.crafting.display.SlotDisplayContext;

public record JEISewingRecipe(SelectableRecipe.SingleInputEntry<SewingRecipe> recipe) {

    public Ingredient input() {
        return recipe.input();
    }

    @SuppressWarnings("all")
    public ItemStack result() {
        var contextMap = SlotDisplayContext.fromLevel(Minecraft.getInstance().level);
        return recipe.recipe().optionDisplay().resolveForFirstStack(contextMap);
    }

    @SuppressWarnings("deprecation")
    public Identifier identifier() {
        return result().getItem().builtInRegistryHolder().key().identifier();
    }
}
