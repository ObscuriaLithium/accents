package dev.obscuria.accents.fabric.client;

import com.google.common.base.Suppliers;
import dev.obscuria.accents.client.AutoVanityRenderer;
import dev.obscuria.accents.fabric.content.FabricVanityItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.client.RenderProvider;

import java.util.function.Supplier;

public record FabricVanityRendererProvider(
        Supplier<AutoVanityRenderer> renderer
) implements RenderProvider {

    public FabricVanityRendererProvider(FabricVanityItem renderer) {
        this(Suppliers.memoize(() -> new AutoVanityRenderer(renderer)));
    }

    @Override
    @SuppressWarnings("unchecked")
    public HumanoidModel<LivingEntity> getHumanoidArmorModel(
            LivingEntity entity, ItemStack stack, EquipmentSlot slot,
            HumanoidModel<LivingEntity> original) {
        this.renderer.get().prepForRender(entity, stack, slot, original);
        return this.renderer.get();
    }
}
