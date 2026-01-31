package dev.obscuria.accents.fabric.client;

import dev.obscuria.accents.client.renderer.VanityRenderer;
import dev.obscuria.accents.fabric.content.item.FabricVanityArmorItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.client.RenderProvider;

public final class FabricVanityRendererProvider implements RenderProvider {

    private final FabricVanityArmorItem item;
    private @Nullable VanityRenderer<?> renderer;

    public FabricVanityRendererProvider(FabricVanityArmorItem item) {
        this.item = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<LivingEntity> original) {
        if (this.renderer == null) this.renderer = item.createVanityRenderer();
        this.renderer.prepForRender(entity, stack, slot, original);
        return this.renderer;
    }
}
