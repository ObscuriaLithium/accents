package dev.obscuria.accents.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public abstract class VanityRenderer extends GeoArmorRenderer<VanityItem> {

    public VanityRenderer(GeoModel<VanityItem> model) {
        super(model);
        addRenderLayer(new OverlayLayer(this, false));
    }

    public VanityRenderer(GeoModel<VanityItem> model, boolean glowing) {
        super(model);
        addRenderLayer(new OverlayLayer(this, glowing));
    }

    public ItemStack stack() {
        return currentStack;
    }

    public static final class OverlayLayer extends GeoRenderLayer<VanityItem> {

        private final VanityRenderer vanity;
        private final ResourceLocation texture;
        private final boolean glowing;

        public OverlayLayer(VanityRenderer renderer, boolean glowing) {
            super(renderer);
            this.texture = this.getTextureResource(renderer.getAnimatable()).withPath(this::pathToOverlay);
            this.vanity = renderer;
            this.glowing = glowing;
        }

        @Override
        public void render(
                PoseStack poseStack, VanityItem animatable, BakedGeoModel bakedModel, RenderType renderType,
                MultiBufferSource bufferSource, VertexConsumer buffer,
                float partialTick, int packedLight, int packedOverlay) {
            var overlayRenderType = getRenderType(animatable, bufferSource, partialTick);
            var light = glowing ? LightTexture.FULL_BRIGHT : packedLight;
            var color = animatable.getColor(vanity.stack());
            var r = FastColor.ARGB32.red(color) / 255f;
            var g = FastColor.ARGB32.green(color) / 255f;
            var b = FastColor.ARGB32.blue(color) / 255f;
            this.getRenderer().reRender(
                    bakedModel, poseStack, bufferSource, animatable, overlayRenderType,
                    bufferSource.getBuffer(overlayRenderType), partialTick, light,
                    OverlayTexture.NO_OVERLAY, r, g, b, 1.0F);
        }

        private RenderType getRenderType(VanityItem animatable, MultiBufferSource bufferSource, float partialTick) {
            return glowing
                    ? RenderType.eyes(texture)
                    : renderer.getRenderType(animatable, texture, bufferSource, partialTick);
        }

        private String pathToOverlay(String path) {
            return path.replace(".png", "_overlay.png");
        }
    }
}
