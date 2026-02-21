package dev.obscuria.accents.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.RenderPassInfo;
import software.bernie.geckolib.renderer.layer.builtin.TextureLayerGeoLayer;

public class AutoVanityRenderer<R extends HumanoidRenderState & GeoRenderState> extends GeoArmorRenderer<VanityItem, R> {

    private final VanityItem animatable;

    public AutoVanityRenderer(VanityItem animatable) {
        super(new AutoVanityModel(animatable));
        withRenderLayer(new OverlayLayer<>(this, animatable));
        this.animatable = animatable;
    }

    @SuppressWarnings("all")
    public void render(ItemStack stack, LivingEntity entity, PoseStack poseStack, SubmitNodeCollector renderTasks, HumanoidModel<?> humanoidModel, float partialTick) {
        var cameraState = Minecraft.getInstance().gameRenderer.getLevelRenderState().cameraRenderState;
        var relatedObject = new RenderData(stack, EquipmentSlot.CHEST, entity, humanoidModel);
        var renderState = (R) new AvatarRenderState();
        fillRenderState(animatable, relatedObject, renderState, partialTick);
        performRenderPass(renderState, poseStack, renderTasks, cameraState);
    }

    @Override
    public int getRenderColor(VanityItem animatable, @Nullable RenderData data, float partialTick) {
        if (data == null) return DyedItemColor.LEATHER_COLOR;
        return DyedItemColor.getOrDefault(data.itemStack(), DyedItemColor.LEATHER_COLOR);
    }

    @Override
    public @Nullable RenderType getRenderType(R renderState, Identifier texture) {
        return animatable.isVanityGlowing()
                ? RenderTypes.eyes(texture)
                : super.getRenderType(renderState, texture);
    }

    public static final class OverlayLayer<R extends HumanoidRenderState & GeoRenderState> extends TextureLayerGeoLayer<VanityItem, RenderData, R> {

        public OverlayLayer(AutoVanityRenderer<R> renderer, VanityItem animatable) {
            super(renderer, getOverlayTexture(animatable));
        }

        @Override
        protected RenderType getRenderType(R renderState) {
            return RenderTypes.armorCutoutNoCull(texture);
        }

        @SuppressWarnings("deprecation")
        private static Identifier getOverlayTexture(VanityItem animatable) {
            final var id = animatable.builtInRegistryHolder().key().identifier();
            return Accents.identifier("textures/vanity/" + id.getPath() + ".png");
        }

        @Override
        public void submitRenderTask(RenderPassInfo<R> renderPassInfo, SubmitNodeCollector renderTasks) {
            renderPassInfo.renderState().addGeckolibData(DataTickets.RENDER_COLOR, 0xFFFFFFFF);
            super.submitRenderTask(renderPassInfo, renderTasks);
        }
    }
}
