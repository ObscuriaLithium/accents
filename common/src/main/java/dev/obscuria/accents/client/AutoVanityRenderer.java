package dev.obscuria.accents.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.util.Color;

public class AutoVanityRenderer extends GeoArmorRenderer<VanityItem> {

    public AutoVanityRenderer(VanityItem item) {
        super(new AutoVanityModel(item));
        addRenderLayer(new OverlayLayer(this));
    }

    public ItemStack stack() {
        return currentStack;
    }

    @Override
    public Color getRenderColor(VanityItem animatable, float partialTick, int packedLight) {
        return Color.WHITE;
    }

    public static final class OverlayLayer extends GeoRenderLayer<VanityItem> {

        private final AutoVanityRenderer vanity;
        private final ResourceLocation texture;

        public OverlayLayer(AutoVanityRenderer renderer) {
            super(renderer);
            this.texture = this.getTextureResource(renderer.getAnimatable()).withPath(this::pathToOverlay);
            this.vanity = renderer;
        }

        @Override
        public void render(
                PoseStack poseStack, VanityItem animatable, BakedGeoModel bakedModel,
                @Nullable RenderType renderType, MultiBufferSource bufferSource,
                @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
            @Nullable var overlayRenderType = getRenderType(animatable, bufferSource, partialTick);
            if (overlayRenderType == null) return;
            var light = animatable.isVanityGlowing() ? LightTexture.FULL_BRIGHT : packedLight;
            var color = DyedItemColor.getOrDefault(vanity.stack(), DyedItemColor.LEATHER_COLOR);
            this.getRenderer().reRender(
                    bakedModel, poseStack, bufferSource, animatable, overlayRenderType,
                    bufferSource.getBuffer(overlayRenderType), partialTick, light,
                    OverlayTexture.NO_OVERLAY, color);
        }

        private @Nullable RenderType getRenderType(VanityItem animatable, MultiBufferSource bufferSource, float partialTick) {
            return animatable.isVanityGlowing()
                    ? RenderType.eyes(texture)
                    : renderer.getRenderType(animatable, texture, bufferSource, partialTick);
        }

        private String pathToOverlay(String path) {
            return path.replace(".png", "_overlay.png");
        }
    }
}
