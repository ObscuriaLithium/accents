package dev.obscuria.accents.content.inventory;

import com.google.common.collect.Lists;
import dev.obscuria.accents.content.recipe.SewingRecipe;
import dev.obscuria.accents.content.registry.AccentsBlocks;
import dev.obscuria.accents.content.registry.AccentsMenus;
import dev.obscuria.accents.content.registry.AccentsRecipes;
import lombok.Getter;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public final class SewingMenu extends AbstractContainerMenu {

    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;

    public final Container container;

    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex;
    private final Level level;
    private final Slot inputSlot;
    private final Slot resultSlot;
    private final ResultContainer resultContainer;

    @Getter private List<SewingRecipe> recipes;
    private Runnable slotUpdateListener;
    private long lastSoundTime;
    private ItemStack input;

    public SewingMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public SewingMenu(int containerId, Inventory inventory, final ContainerLevelAccess access) {
        super(AccentsMenus.SEWING_STATION.get(), containerId);

        this.selectedRecipeIndex = DataSlot.standalone();
        this.recipes = Lists.newArrayList();
        this.input = ItemStack.EMPTY;
        this.slotUpdateListener = () -> {};
        this.container = new SimpleContainer(1) {
            public void setChanged() {
                super.setChanged();
                SewingMenu.this.slotsChanged(this);
                SewingMenu.this.slotUpdateListener.run();
            }
        };

        this.resultContainer = new ResultContainer();
        this.access = access;
        this.level = inventory.player.level();
        this.inputSlot = this.addSlot(new Slot(this.container, INPUT_SLOT, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, RESULT_SLOT, 143, 33) {

            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            public void onTake(Player player, ItemStack stack) {

                stack.onCraftedBy(player.level(), player, stack.getCount());
                SewingMenu.this.resultContainer.awardUsedRecipes(player, this.getRelevantItems());
                ItemStack itemstack = SewingMenu.this.inputSlot.remove(1);
                if (!itemstack.isEmpty()) {
                    SewingMenu.this.setupResultSlot();
                }

                access.execute((level, pos) -> {
                    var gameTime = level.getGameTime();
                    if (SewingMenu.this.lastSoundTime != gameTime) {
                        level.playSound(null, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
                        SewingMenu.this.lastSoundTime = gameTime;
                    }

                });

                super.onTake(player, stack);
            }

            private List<ItemStack> getRelevantItems() {
                return List.of(SewingMenu.this.inputSlot.getItem());
            }
        });

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    public boolean stillValid(Player player) {
        return stillValid(this.access, player, AccentsBlocks.SEWING_STATION.get());
    }

    public boolean clickMenuButton(Player player, int id) {
        if (this.isValidRecipeIndex(id)) {
            this.selectedRecipeIndex.set(id);
            this.setupResultSlot();
        }

        return true;
    }

    public void slotsChanged(Container inventory) {
        var stack = this.inputSlot.getItem();
        if (!stack.is(this.input.getItem())) {
            this.input = stack.copy();
            this.setupRecipeList(inventory, stack);
        }
    }

    public MenuType<?> getType() {
        return AccentsMenus.SEWING_STATION.get();
    }

    public void registerUpdateListener(Runnable listener) {
        this.slotUpdateListener = listener;
    }

    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    public ItemStack quickMoveStack(Player player, int index) {
        var result = ItemStack.EMPTY;
        var slot = this.slots.get(index);
        if (slot.hasItem()) {
            var stack = slot.getItem();
            var item = stack.getItem();
            result = stack.copy();
            if (index == 1) {
                item.onCraftedBy(stack, player.level(), player);
                if (!this.moveItemStackTo(stack, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(stack, result);
            } else if (index == 0) {
                if (!this.moveItemStackTo(stack, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(AccentsRecipes.SEWING.get(), new SimpleContainer(stack), this.level).isPresent()) {
                if (!this.moveItemStackTo(stack, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 2 && index < 29) {
                if (!this.moveItemStackTo(stack, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 29 && index < 38 && !this.moveItemStackTo(stack, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (stack.getCount() == result.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, stack);
            this.broadcastChanges();
        }

        return result;
    }

    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((level, pos) -> this.clearContainer(player, this.container));
    }

    private boolean isValidRecipeIndex(int recipeIndex) {
        return recipeIndex >= 0 && recipeIndex < this.recipes.size();
    }

    private void setupRecipeList(Container container, ItemStack stack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(AccentsRecipes.SEWING.get(), container, this.level);
        }
    }

    private void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            var recipe = this.recipes.get(this.selectedRecipeIndex.get());
            var stack = recipe.assemble(this.container, this.level.registryAccess());
            if (stack.isItemEnabled(this.level.enabledFeatures())) {
                this.resultContainer.setRecipeUsed(recipe);
                this.resultSlot.set(stack);
            } else {
                this.resultSlot.set(ItemStack.EMPTY);
            }
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }
}
