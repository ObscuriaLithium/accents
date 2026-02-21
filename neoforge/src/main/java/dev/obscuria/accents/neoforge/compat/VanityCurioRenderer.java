package dev.obscuria.accents.neoforge.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.obscuria.accents.client.AutoVanityRenderer;
import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public final class VanityCurioRenderer implements ICurioRenderer {

    @Override
    public <S extends LivingEntityRenderState, M extends EntityModel<? super S>> void render(
            ItemStack stack, SlotContext slotContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector,
            int packedLight, S renderState, RenderLayerParent<S, M> renderLayerParent,
            EntityRendererProvider.Context context, float yRotation, float xRotation) {
        if (!(renderLayerParent.getModel() instanceof HumanoidModel<?> humanoidModel)) return;
        if (!(stack.getItem() instanceof VanityItem vanityItem)) return;
        if (!(vanityItem.getRenderProvider() instanceof GeoRenderProvider renderProvider)) return;
        if (!(renderProvider.getGeoArmorRenderer(stack, EquipmentSlot.CHEST) instanceof AutoVanityRenderer<?> model)) return;
        model.render(stack, slotContext.entity(), poseStack, submitNodeCollector, humanoidModel, renderState.partialTick);
    }
}
