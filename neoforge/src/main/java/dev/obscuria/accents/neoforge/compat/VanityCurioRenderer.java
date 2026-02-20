package dev.obscuria.accents.neoforge.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.obscuria.accents.client.AutoVanityRenderer;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public final class VanityCurioRenderer implements ICurioRenderer {

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack, SlotContext context, PoseStack pose, RenderLayerParent<T, M> parent,
            MultiBufferSource bufferSource, int light, float limbSwing, float limbSwingAmount,
            float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!(parent.getModel() instanceof HumanoidModel<? extends LivingEntity> humanoidModel)) return;
        if (!(stack.getItem() instanceof VanityItem vanityItem)) return;
        if (!(vanityItem.getRenderProvider() instanceof GeoRenderProvider renderProvider)) return;
        @Nullable var trinketModel = (AutoVanityRenderer) renderProvider.getGeoArmorRenderer(context.entity(), stack, EquipmentSlot.CHEST, (HumanoidModel<LivingEntity>) humanoidModel);
        if (trinketModel == null) return;
        trinketModel.prepForRender(context.entity(), stack, EquipmentSlot.CHEST, humanoidModel, bufferSource, partialTicks, limbSwing, limbSwingAmount, netHeadYaw, headPitch);
        trinketModel.defaultRender(pose, vanityItem, bufferSource, null, null, netHeadYaw, partialTicks, light);
    }
}
