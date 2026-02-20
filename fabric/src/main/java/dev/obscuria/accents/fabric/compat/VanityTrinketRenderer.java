package dev.obscuria.accents.fabric.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.obscuria.accents.client.AutoVanityRenderer;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;

public final class VanityTrinketRenderer implements TrinketRenderer {

    public static final VanityTrinketRenderer SHARED = new VanityTrinketRenderer();

    @Override
    @SuppressWarnings("unchecked")
    public void render(ItemStack stack, SlotReference reference, EntityModel<? extends LivingEntity> model,
                       PoseStack pose, MultiBufferSource bufferSource, int light, LivingEntity entity,
                       float limbAngle, float limbDistance, float tickDelta,
                       float animationProgress, float headYaw, float headPitch) {
        if (!(model instanceof HumanoidModel<? extends LivingEntity> humanoidModel)) return;
        if (!(stack.getItem() instanceof VanityItem vanityItem)) return;
        if (!(vanityItem.getRenderProvider() instanceof GeoRenderProvider renderProvider)) return;
        @Nullable var trinketModel = (AutoVanityRenderer) renderProvider.getGeoArmorRenderer(entity, stack, EquipmentSlot.CHEST, (HumanoidModel<LivingEntity>) humanoidModel);
        if (trinketModel == null) return;
        trinketModel.prepForRender(entity, stack, EquipmentSlot.CHEST, humanoidModel, bufferSource, tickDelta, limbAngle, limbDistance, headYaw, headPitch);
        trinketModel.defaultRender(pose, vanityItem, bufferSource, null, null, headYaw, tickDelta, light);
    }
}
