package dev.obscuria.accents.forge.client;

import com.google.common.base.Suppliers;
import dev.obscuria.accents.client.AutoVanityRenderer;
import dev.obscuria.accents.forge.content.ForgeVanityItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Supplier;

public record ForgeClientItemExtensions(
        Supplier<AutoVanityRenderer> renderer
) implements IClientItemExtensions {

    public ForgeClientItemExtensions(ForgeVanityItem item) {
        this(Suppliers.memoize(() -> new AutoVanityRenderer(item)));
    }

    @Override
    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> original) {
        this.renderer.get().prepForRender(entity, stack, slot, original);
        return this.renderer.get();
    }
}
