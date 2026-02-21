package dev.obscuria.accents.content.inventory;

import dev.obscuria.accents.content.recipe.RecipeAccessExtension;
import dev.obscuria.accents.content.recipe.SewingRecipe;
import dev.obscuria.accents.content.registry.AccentsBlocks;
import dev.obscuria.accents.content.registry.AccentsMenus;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SelectableRecipe;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;

public final class SewingMenu extends AbstractContainerMenu {

    private final ContainerLevelAccess access;
    final DataSlot selectedRecipeIndex;
    private final Level level;
    private SelectableRecipe.SingleInputSet<SewingRecipe> recipesForInput;
    private ItemStack input;
    long lastSoundTime;
    final Slot inputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener;
    public final Container container;
    final ResultContainer resultContainer;

    public SewingMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, ContainerLevelAccess.NULL);
    }

    public SewingMenu(int containerId, Inventory playerInventory, final ContainerLevelAccess access) {
        super(AccentsMenus.SEWING, containerId);
        this.selectedRecipeIndex = DataSlot.standalone();
        this.recipesForInput = SelectableRecipe.SingleInputSet.empty();
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
        this.level = playerInventory.player.level();
        this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            public boolean mayPlace(ItemStack p_40362_) {
                return false;
            }

            public void onTake(Player p_150672_, ItemStack p_150673_) {
                p_150673_.onCraftedBy(p_150672_, p_150673_.getCount());
                SewingMenu.this.resultContainer.awardUsedRecipes(p_150672_, this.getRelevantItems());
                ItemStack itemstack = SewingMenu.this.inputSlot.remove(1);
                if (!itemstack.isEmpty()) {
                    SewingMenu.this.setupResultSlot(SewingMenu.this.selectedRecipeIndex.get());
                }

                access.execute((level, pos) -> {
                    long i = level.getGameTime();
                    if (SewingMenu.this.lastSoundTime != i) {
                        level.playSound(null, pos, SoundEvents.SHEARS_SNIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                        SewingMenu.this.lastSoundTime = i;
                    }

                });
                super.onTake(p_150672_, p_150673_);
            }

            private List<ItemStack> getRelevantItems() {
                return List.of(SewingMenu.this.inputSlot.getItem());
            }
        });
        this.addStandardInventorySlots(playerInventory, 8, 84);
        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public SelectableRecipe.SingleInputSet<SewingRecipe> getVisibleRecipes() {
        return this.recipesForInput;
    }

    public int getNumberOfVisibleRecipes() {
        return this.recipesForInput.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipesForInput.isEmpty();
    }

    public boolean stillValid(Player player) {
        return stillValid(this.access, player, AccentsBlocks.SEWING_STATION.get());
    }

    public boolean clickMenuButton(Player player, int id) {
        if (this.selectedRecipeIndex.get() == id) {
            return false;
        } else {
            if (this.isValidRecipeIndex(id)) {
                this.selectedRecipeIndex.set(id);
                this.setupResultSlot(id);
            }

            return true;
        }
    }

    private boolean isValidRecipeIndex(int recipeIndex) {
        return recipeIndex >= 0 && recipeIndex < this.recipesForInput.size();
    }

    public void slotsChanged(Container inventory) {
        ItemStack itemstack = this.inputSlot.getItem();
        if (!itemstack.is(this.input.getItem())) {
            this.input = itemstack.copy();
            this.setupRecipeList(itemstack);
        }

    }

    private void setupRecipeList(ItemStack stack) {
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            this.recipesForInput = RecipeAccessExtension.sewingRecipes(this.level.recipeAccess()).selectByInput(stack);
        } else {
            this.recipesForInput = SelectableRecipe.SingleInputSet.empty();
        }
    }

    void setupResultSlot(int id) {
        Optional<RecipeHolder<SewingRecipe>> optional;
        if (!this.recipesForInput.isEmpty() && this.isValidRecipeIndex(id)) {
            var recipe = this.recipesForInput.entries().get(id);
            optional = recipe.recipe().recipe();
        } else {
            optional = Optional.empty();
        }

        optional.ifPresentOrElse((holder) -> {
            this.resultContainer.setRecipeUsed(holder);
            this.resultSlot.set(holder.value().assemble(new SingleRecipeInput(this.container.getItem(0)), this.level.registryAccess()));
        }, () -> {
            this.resultSlot.set(ItemStack.EMPTY);
            this.resultContainer.setRecipeUsed(null);
        });
        this.broadcastChanges();
    }

    public MenuType<?> getType() {
        return AccentsMenus.SEWING;
    }

    public void registerUpdateListener(Runnable listener) {
        this.slotUpdateListener = listener;
    }

    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    public ItemStack quickMoveStack(Player player, int index) {
        var itemstack = ItemStack.EMPTY;
        var slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            var itemstack1 = slot.getItem();
            var item = itemstack1.getItem();
            itemstack = itemstack1.copy();
            if (index == 1) {
                item.onCraftedBy(itemstack1, player);
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (index == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (RecipeAccessExtension.sewingRecipes(this.level.recipeAccess()).acceptsInput(itemstack1)) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 2 && index < 29) {
                if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 29 && index < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
            if (index == 1) {
                player.drop(itemstack1, false);
            }

            this.broadcastChanges();
        }

        return itemstack;
    }

    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((level, pos) -> this.clearContainer(player, this.container));
    }
}
