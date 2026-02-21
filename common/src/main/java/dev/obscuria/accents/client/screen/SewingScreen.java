package dev.obscuria.accents.client.screen;

import dev.obscuria.accents.content.inventory.SewingMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public final class SewingScreen extends AbstractContainerScreen<SewingMenu> {

    private static final ResourceLocation SCROLLER_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/scroller");
    private static final ResourceLocation SCROLLER_DISABLED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/scroller_disabled");
    private static final ResourceLocation RECIPE_SELECTED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe_selected");
    private static final ResourceLocation RECIPE_HIGHLIGHTED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe_highlighted");
    private static final ResourceLocation RECIPE_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe");
    private static final ResourceLocation BG = ResourceLocation.withDefaultNamespace("textures/gui/container/stonecutter.png");

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    public SewingScreen(SewingMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        menu.registerUpdateListener(this::containerChanged);
        --this.titleLabelY;
    }

    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        var i = leftPos;
        var j = topPos;
        graphics.blit(BG, i, j, 0, 0, imageWidth, imageHeight);
        var k = (int) (41.0F * scrollOffs);
        var scrollSprite = this.isScrollBarActive() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE;
        graphics.blitSprite(scrollSprite, i + 119, j + 15 + k, 12, 15);
        var l = leftPos + 52;
        var i1 = topPos + 14;
        var j1 = startIndex + 12;
        this.renderButtons(graphics, mouseX, mouseY, l, i1, j1);
        this.renderRecipes(graphics, l, i1, j1);
    }

    protected void renderTooltip(GuiGraphics graphics, int x, int y) {
        super.renderTooltip(graphics, x, y);
        if (this.displayRecipes) {
            int i = this.leftPos + 52;
            int j = this.topPos + 14;
            int k = this.startIndex + 12;
            var list = menu.getRecipes();

            for (int l = this.startIndex; l < k && l < menu.getNumRecipes(); ++l) {
                int i1 = l - this.startIndex;
                int j1 = i + i1 % 4 * 16;
                int k1 = j + i1 / 4 * 18 + 2;
                if (x >= j1 && x < j1 + 16 && y >= k1 && y < k1 + 18) {
                    graphics.renderTooltip(this.font, list.get(l).value().getResultItem(this.minecraft.level.registryAccess()), x, y);
                }
            }
        }

    }

    private void renderButtons(GuiGraphics graphics, int mouseX, int mouseY, int x, int y, int lastVisibleElementIndex) {
        for (int i = startIndex; i < lastVisibleElementIndex && i < menu.getNumRecipes(); ++i) {
            var j = i - startIndex;
            var k = x + j % 4 * 16;
            var l = j / 4;
            var i1 = y + l * 18 + 2;
            var sprite = i == menu.getSelectedRecipeIndex()
                    ? RECIPE_SELECTED_SPRITE
                    : mouseX >= k && mouseY >= i1 && mouseX < k + 16 && mouseY < i1 + 18
                    ? RECIPE_HIGHLIGHTED_SPRITE
                    : RECIPE_SPRITE;
            graphics.blitSprite(sprite, k, i1 - 1, 16, 18);
        }
    }

    private void renderRecipes(GuiGraphics graphics, int x, int y, int startIndex) {
        var list = menu.getRecipes();

        for (int i = this.startIndex; i < startIndex && i < menu.getNumRecipes(); ++i) {
            int j = i - this.startIndex;
            int k = x + j % 4 * 16;
            int l = j / 4;
            int i1 = y + l * 18 + 2;
            graphics.renderItem(list.get(i).value().getResultItem(this.minecraft.level.registryAccess()), k, i1);
        }

    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;
        if (this.displayRecipes) {
            int i = this.leftPos + 52;
            int j = this.topPos + 14;
            int k = this.startIndex + 12;

            for(int l = this.startIndex; l < k; ++l) {
                int i1 = l - this.startIndex;
                double d0 = mouseX - (double)(i + i1 % 4 * 16);
                double d1 = mouseY - (double)(j + i1 / 4 * 18);
                if (d0 >= (double)0.0F && d1 >= (double)0.0F && d0 < (double)16.0F && d1 < (double)18.0F && this.menu.clickMenuButton(this.minecraft.player, l)) {
                    Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, l);
                    return true;
                }
            }

            i = this.leftPos + 119;
            j = this.topPos + 9;
            if (mouseX >= (double)i && mouseX < (double)(i + 12) && mouseY >= (double)j && mouseY < (double)(j + 54)) {
                this.scrolling = true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (this.scrolling && this.isScrollBarActive()) {
            int i = this.topPos + 14;
            int j = i + 54;
            this.scrollOffs = ((float)mouseY - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollOffs * (float)this.getOffscreenRows()) + (double)0.5F) * 4;
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
        }
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (this.isScrollBarActive()) {
            int i = this.getOffscreenRows();
            float f = (float)scrollY / (float)i;
            this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollOffs * (float)i) + (double)0.5F) * 4;
        }

        return true;
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && menu.getNumRecipes() > 12;
    }

    private int getOffscreenRows() {
        return (menu.getNumRecipes() + 4 - 1) / 4 - 3;
    }

    private void containerChanged() {
        this.displayRecipes = menu.hasInputItem();
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
        }
    }
}
