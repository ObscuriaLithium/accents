package dev.obscuria.accents.forge.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
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
        if (!(vanityItem.getRenderPropertiesInternal() instanceof IClientItemExtensions extensions)) return;
        var trinketModel = extensions.getHumanoidArmorModel(context.entity(), stack, EquipmentSlot.CHEST, humanoidModel);
        trinketModel.renderToBuffer(pose, bufferSource.getBuffer(RenderType.LINES), light, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
    }
}
