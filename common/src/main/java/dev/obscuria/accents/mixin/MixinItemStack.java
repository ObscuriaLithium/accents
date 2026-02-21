package dev.obscuria.accents.mixin;

import dev.obscuria.accents.content.item.VanityItem;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.apache.commons.lang3.function.TriConsumer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiConsumer;

@Mixin(ItemStack.class)
public abstract class MixinItemStack {

    @Inject(method = "forEachModifier(Lnet/minecraft/world/entity/EquipmentSlot;Ljava/util/function/BiConsumer;)V", at = @At("TAIL"))
    private void injectVanityAttributes(EquipmentSlot slot, BiConsumer<Holder<Attribute>, AttributeModifier> action, CallbackInfo info) {
        var self = (ItemStack) (Object) this;
        if (self.getItem() instanceof VanityItem vanityItem) {
            vanityItem.getVanityAttributeModifiers().forEach(slot, action);
        }
    }

    @Inject(method = "forEachModifier(Lnet/minecraft/world/entity/EquipmentSlotGroup;Lorg/apache/commons/lang3/function/TriConsumer;)V", at = @At("TAIL"))
    private void injectVanityAttributes(EquipmentSlotGroup slot, TriConsumer<Holder<Attribute>, AttributeModifier, ItemAttributeModifiers.Display> action, CallbackInfo info) {
        var self = (ItemStack) (Object) this;
        if (self.getItem() instanceof VanityItem vanityItem) {
            vanityItem.getVanityAttributeModifiers().forEach(slot, action);
        }
    }
}
