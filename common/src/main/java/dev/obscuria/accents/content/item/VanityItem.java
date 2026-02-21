package dev.obscuria.accents.content.item;

import com.google.common.base.Suppliers;
import dev.obscuria.accents.client.AutoVanityRenderer;
import dev.obscuria.accents.compat.AccentsCompats;
import dev.obscuria.accents.content.Vanity;
import dev.obscuria.fragmentum.content.world.tooltip.TooltipOptions;
import dev.obscuria.fragmentum.content.world.tooltip.Tooltips;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.TooltipDisplay;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.object.PlayState;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class VanityItem extends Item implements GeoItem {

    private static final TooltipOptions FLAVOR;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Vanity vanity;
    private final boolean glowing;

    public VanityItem(Vanity vanity, Properties properties) {
        this(false, vanity, properties);
    }

    public VanityItem(boolean glowing, Vanity vanity, Properties properties) {
        super(properties
                .humanoidArmor(vanity.material(), vanity.type())
                .durability(vanity.type().getDurability(32))
                .attributes(ItemAttributeModifiers.EMPTY));
        this.vanity = vanity;
        this.glowing = glowing;
    }

    @SuppressWarnings("deprecation")
    public ItemAttributeModifiers getVanityAttributeModifiers() {
        if (vanity.isTrinket() && AccentsCompats.trinketsLoaded()) return ItemAttributeModifiers.EMPTY;
        var identifier = builtInRegistryHolder().key().identifier();
        var builder = ItemAttributeModifiers.builder();
        var slotGroup = EquipmentSlotGroup.bySlot(vanity.type().getSlot());
        this.appendVanityModifiers(identifier, (attribute, modifier) -> builder.add(attribute, modifier, slotGroup));
        return builder.build();
    }

    public void appendVanityModifiers(Identifier id, BiConsumer<Holder<Attribute>, AttributeModifier> consumer) {
        this.vanity.appendModifiers(id, consumer);
    }

    public boolean isVanityGlowing() {
        return glowing;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> adder, TooltipFlag flag) {
        var component = Component.translatable(stack.getItem().getDescriptionId() + ".desc");
        Tooltips.process(component, this, FLAVOR).forEach(adder);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar registrar) {
        registrar.add(new AnimationController<>("idle", 20, state -> {
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
            private final Supplier<AutoVanityRenderer<?>> renderer = Suppliers.memoize(() -> new AutoVanityRenderer<>(VanityItem.this));

            @Override
            public GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack stack, EquipmentSlot slot) {
                return renderer.get();
            }
        });
    }

    static {
        FLAVOR = TooltipOptions.builder()
                .withDefaultStyle(Style.EMPTY.withColor(ChatFormatting.LIGHT_PURPLE).withItalic(true))
                .withMaxLineLength(32)
                .build();
    }
}
