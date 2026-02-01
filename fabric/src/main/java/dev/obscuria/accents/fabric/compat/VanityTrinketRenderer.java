package dev.obscuria.accents.fabric.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.client.RenderProvider;

public final class VanityTrinketRenderer implements TrinketRenderer {

    public static final VanityTrinketRenderer SHARED = new VanityTrinketRenderer();

    @Override
    public void render(ItemStack stack, SlotReference reference, EntityModel<? extends LivingEntity> model,
                       PoseStack pose, MultiBufferSource bufferSource, int light, LivingEntity entity,
                       float limbAngle, float limbDistance, float tickDelta,
                       float animationProgress, float headYaw, float headPitch) {
        if (!(model instanceof HumanoidModel<? extends LivingEntity> humanoidModel)) return;
        if (!(stack.getItem() instanceof VanityItem vanityItem)) return;
        if (!(vanityItem.getRenderProvider().get() instanceof RenderProvider renderProvider)) return;
        var trinketModel = renderProvider.getHumanoidArmorModel(entity, stack, EquipmentSlot.CHEST, (HumanoidModel<LivingEntity>) humanoidModel);
        trinketModel.renderToBuffer(pose, bufferSource.getBuffer(RenderType.LINES), light, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
    }
}
