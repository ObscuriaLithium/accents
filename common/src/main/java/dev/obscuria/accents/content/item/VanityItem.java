package dev.obscuria.accents.content.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import dev.obscuria.accents.content.Vanity;
import dev.obscuria.fragmentum.world.tooltip.TooltipOptions;
import dev.obscuria.fragmentum.world.tooltip.Tooltips;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;

public abstract class VanityItem extends ArmorItem implements GeoItem, DyeableLeatherItem {

    private static final TooltipOptions FLAVOR;

    protected final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    protected final Vanity vanity;
    protected final boolean glowing;

    public VanityItem(boolean glowing, Vanity vanity, Properties properties) {
        super(VanityMaterial.SHARED, vanity.type(), properties);
        this.vanity = vanity;
        this.glowing = glowing;
    }

    public boolean isVanityGlowing() {
        return this.glowing;
    }

    public void appendModifiers(UUID uuid, BiConsumer<Attribute, AttributeModifier> consumer) {
        this.vanity.appendModifiers(uuid, consumer);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        var component = Component.translatable(stack.getDescriptionId() + ".desc");
        tooltip.addAll(Tooltips.process(component, this, FLAVOR));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        if (slot != getEquipmentSlot()) return super.getDefaultAttributeModifiers(slot);
        var uuid = UUID.nameUUIDFromBytes(getClass().getName().getBytes());
        var modifiers = HashMultimap.<Attribute, AttributeModifier>create();
        this.vanity.appendModifiers(uuid, modifiers::put);
        return modifiers;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar registrar) {
        registrar.add(new AnimationController<>(this, 20, state -> {
            state.setAnimation(DefaultAnimations.IDLE);
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    static {
        FLAVOR = TooltipOptions.builder()
                .withDefaultStyle(Style.EMPTY.withColor(ChatFormatting.LIGHT_PURPLE).withItalic(true))
                .withMaxLineLength(32)
                .build();
    }
}
