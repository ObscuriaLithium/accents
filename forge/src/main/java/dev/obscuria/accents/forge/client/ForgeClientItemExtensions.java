package dev.obscuria.accents.forge.client;

import dev.obscuria.accents.client.renderer.VanityRenderer;
import dev.obscuria.accents.content.item.VanityItem;
import dev.obscuria.accents.forge.content.ForgeVanityItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

public final class ForgeClientItemExtensions implements IClientItemExtensions {

    private final VanityItem item;
    private @Nullable VanityRenderer renderer;

    public ForgeClientItemExtensions(ForgeVanityItem item) {
        this.item = item;
    }

    @Override
    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> original) {
        if (this.renderer == null) this.renderer = item.createVanityRenderer();
        this.renderer.prepForRender(entity, stack, slot, original);
        return this.renderer;
    }
}
