package dev.obscuria.accents.content.item;

import dev.obscuria.accents.client.AutoVanityRenderer;
import dev.obscuria.accents.compat.AccentsCompats;
import dev.obscuria.accents.content.Vanity;
import dev.obscuria.fragmentum.content.world.tooltip.TooltipOptions;
import dev.obscuria.fragmentum.content.world.tooltip.Tooltips;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class VanityItem extends ArmorItem implements GeoItem {

    private static final TooltipOptions FLAVOR;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Vanity vanity;
    private final boolean glowing;

    public VanityItem(Vanity vanity, Properties properties) {
        this(false, vanity, properties);
    }

    public VanityItem(boolean glowing, Vanity vanity, Properties properties) {
        super(vanity.material(), vanity.type(), properties.durability(vanity.type().getDurability(32)));
        this.vanity = vanity;
        this.glowing = glowing;
    }

    public boolean isVanityGlowing() {
        return glowing;
    }

    public void appendVanityModifiers(ResourceLocation id, BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        this.vanity.appendModifiers(id, consumer);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
        var component = Component.translatable(stack.getDescriptionId() + ".desc");
        tooltip.addAll(Tooltips.process(component, this, FLAVOR));
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return vanity.isTrinket() && AccentsCompats.trinketsLoaded()
                ? ItemAttributeModifiers.EMPTY
                : this.getVanityAttributeModifiers();
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

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private @Nullable AutoVanityRenderer renderer;

            @Override
            public <T extends LivingEntity> AutoVanityRenderer getGeoArmorRenderer(
                    @Nullable T entity, ItemStack stack,
                    @Nullable EquipmentSlot slot,
                    @Nullable HumanoidModel<T> original) {
                if (this.renderer == null) this.renderer = new AutoVanityRenderer(VanityItem.this);
                return this.renderer;
            }
        });
    }

    @SuppressWarnings("deprecation")
    private ItemAttributeModifiers getVanityAttributeModifiers() {
        var builder = ItemAttributeModifiers.builder();
        var id = builtInRegistryHolder().key().location();
        var slotGroup = EquipmentSlotGroup.bySlot(getEquipmentSlot());
        this.appendVanityModifiers(id, (attribute, modifier) -> builder.add(attribute, modifier, slotGroup));
        return builder.build();
    }

    static {
        FLAVOR = TooltipOptions.builder()
                .withDefaultStyle(Style.EMPTY.withColor(ChatFormatting.LIGHT_PURPLE).withItalic(true))
                .withMaxLineLength(32)
                .build();
    }
}
