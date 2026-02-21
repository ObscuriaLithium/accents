package dev.obscuria.accents.client.screen;

import com.mojang.blaze3d.platform.cursor.CursorTypes;
import dev.obscuria.accents.content.inventory.SewingMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.display.SlotDisplayContext;

public final class SewingScreen extends AbstractContainerScreen<SewingMenu> {

    private static final Identifier SCROLLER_SPRITE = Identifier.withDefaultNamespace("container/stonecutter/scroller");
    private static final Identifier SCROLLER_DISABLED_SPRITE = Identifier.withDefaultNamespace("container/stonecutter/scroller_disabled");
    private static final Identifier RECIPE_SELECTED_SPRITE = Identifier.withDefaultNamespace("container/stonecutter/recipe_selected");
    private static final Identifier RECIPE_HIGHLIGHTED_SPRITE = Identifier.withDefaultNamespace("container/stonecutter/recipe_highlighted");
    private static final Identifier RECIPE_SPRITE = Identifier.withDefaultNamespace("container/stonecutter/recipe");
    private static final Identifier BG_LOCATION = Identifier.withDefaultNamespace("textures/gui/container/stonecutter.png");

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    public SewingScreen(SewingMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        menu.registerUpdateListener(this::containerChanged);
        --this.titleLabelY;
    }

    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        var i = this.leftPos;
        var j = this.topPos;
        graphics.blit(RenderPipelines.GUI_TEXTURED, BG_LOCATION, i, j, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        var k = (int) (41.0F * this.scrollOffs);
        Identifier identifier = this.isScrollBarActive() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE;
        var l = i + 119;
        var i1 = j + 15 + k;
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, identifier, l, i1, 12, 15);
        if (mouseX >= l && mouseX < l + 12 && mouseY >= i1 && mouseY < i1 + 15) {
            graphics.requestCursor(this.scrolling ? CursorTypes.RESIZE_NS : CursorTypes.POINTING_HAND);
        }

        var j1 = this.leftPos + 52;
        var k1 = this.topPos + 14;
        var l1 = this.startIndex + 12;
        this.renderButtons(graphics, mouseX, mouseY, j1, k1, l1);
        this.renderRecipes(graphics, j1, k1, l1);
    }

    protected void renderTooltip(GuiGraphics graphics, int mouseX, int mouseY) {
        super.renderTooltip(graphics, mouseX, mouseY);
        if (minecraft.level == null) return;
        if (this.displayRecipes) {
            var i = this.leftPos + 52;
            var j = this.topPos + 14;
            var k = this.startIndex + 12;
            var recipes = this.menu.getVisibleRecipes();

            for (var l = this.startIndex; l < k && l < recipes.size(); ++l) {
                var i1 = l - this.startIndex;
                var j1 = i + i1 % 4 * 16;
                var k1 = j + i1 / 4 * 18 + 2;
                if (mouseX >= j1 && mouseX < j1 + 16 && mouseY >= k1 && mouseY < k1 + 18) {
                    var contextMap = SlotDisplayContext.fromLevel(minecraft.level);
                    var slotDisplay = recipes.entries().get(l).recipe().optionDisplay();
                    graphics.setTooltipForNextFrame(this.font, slotDisplay.resolveForFirstStack(contextMap), mouseX, mouseY);
                }
            }
        }
    }

    private void renderButtons(GuiGraphics graphics, int mouseX, int mouseY, int x, int y, int lastVisibleElementIndex) {
        for (var i = this.startIndex; i < lastVisibleElementIndex && i < menu.getNumberOfVisibleRecipes(); ++i) {
            var j = i - this.startIndex;
            var k = x + j % 4 * 16;
            var l = j / 4;
            var i1 = y + l * 18 + 2;
            Identifier identifier;
            if (i == menu.getSelectedRecipeIndex()) {
                identifier = RECIPE_SELECTED_SPRITE;
            } else if (mouseX >= k && mouseY >= i1 && mouseX < k + 16 && mouseY < i1 + 18) {
                identifier = RECIPE_HIGHLIGHTED_SPRITE;
            } else {
                identifier = RECIPE_SPRITE;
            }

            var j1 = i1 - 1;
            graphics.blitSprite(RenderPipelines.GUI_TEXTURED, identifier, k, j1, 16, 18);
            if (mouseX >= k && mouseY >= j1 && mouseX < k + 16 && mouseY < j1 + 18) {
                graphics.requestCursor(CursorTypes.POINTING_HAND);
            }
        }
    }

    private void renderRecipes(GuiGraphics graphics, int x, int y, int startIndex) {
        if (minecraft.level == null) return;
        var recipes = menu.getVisibleRecipes();
        var contextMap = SlotDisplayContext.fromLevel(minecraft.level);

        for (var i = this.startIndex; i < startIndex && i < recipes.size(); ++i) {
            var j = i - this.startIndex;
            var k = x + j % 4 * 16;
            var l = j / 4;
            var i1 = y + l * 18 + 2;
            var slotDisplay = recipes.entries().get(i).recipe().optionDisplay();
            graphics.renderItem(slotDisplay.resolveForFirstStack(contextMap), k, i1);
        }
    }

    public boolean mouseClicked(MouseButtonEvent event, boolean flag) {
        if (displayRecipes && minecraft.player != null && minecraft.gameMode != null) {
            var i = this.leftPos + 52;
            var j = this.topPos + 14;
            var k = this.startIndex + 12;

            for (var l = this.startIndex; l < k; ++l) {
                var i1 = l - this.startIndex;
                var d0 = event.x() - (double) (i + i1 % 4 * 16);
                var d1 = event.y() - (double) (j + i1 / 4 * 18);
                if (d0 >= 0.0F && d1 >= 0.0F && d0 < 16.0F && d1 < 18.0F && menu.clickMenuButton(minecraft.player, l)) {
                    Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, l);
                    return true;
                }
            }

            i = this.leftPos + 119;
            j = this.topPos + 9;
            if (event.x() >= (double) i && event.x() < (double) (i + 12) && event.y() >= (double) j && event.y() < (double) (j + 54)) {
                this.scrolling = true;
            }
        }

        return super.mouseClicked(event, flag);
    }

    public boolean mouseDragged(MouseButtonEvent event, double deltaX, double deltaY) {
        if (this.scrolling && this.isScrollBarActive()) {
            var i = this.topPos + 14;
            var j = i + 54;
            this.scrollOffs = ((float) event.y() - (float) i - 7.5F) / ((float) (j - i) - 15.0F);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int) ((double) (this.scrollOffs * (float) this.getOffscreenRows()) + (double) 0.5F) * 4;
            return true;
        } else {
            return super.mouseDragged(event, deltaX, deltaY);
        }
    }

    public boolean mouseReleased(MouseButtonEvent mouseButtonEvent) {
        this.scrolling = false;
        return super.mouseReleased(mouseButtonEvent);
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double deltaX, double deltaY) {
        if (super.mouseScrolled(mouseX, mouseY, deltaX, deltaY)) {
            return true;
        } else {
            if (this.isScrollBarActive()) {
                var i = this.getOffscreenRows();
                float f = (float) deltaY / (float) i;
                this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0F, 1.0F);
                this.startIndex = (int) ((double) (this.scrollOffs * (float) i) + (double) 0.5F) * 4;
            }

            return true;
        }
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && this.menu.getNumberOfVisibleRecipes() > 12;
    }

    private int getOffscreenRows() {
        return (this.menu.getNumberOfVisibleRecipes() + 4 - 1) / 4 - 3;
    }

    private void containerChanged() {
        this.displayRecipes = this.menu.hasInputItem();
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
        }
    }
}
