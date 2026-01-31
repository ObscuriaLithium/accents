package dev.obscuria.accents.content.item;

import dev.obscuria.fragmentum.world.tooltip.TooltipOptions;
import dev.obscuria.fragmentum.world.tooltip.Tooltips;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
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

public abstract class VanityItem extends ArmorItem implements GeoItem, DyeableLeatherItem {

    private static final TooltipOptions FLAVOR;
    protected AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);

    public VanityItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        var component = Component.translatable(stack.getDescriptionId() + ".desc");
        tooltip.addAll(Tooltips.process(component, this, FLAVOR));
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
        return animatableInstanceCache;
    }

    static {
        FLAVOR = TooltipOptions.builder()
                .withDefaultStyle(Style.EMPTY.withColor(ChatFormatting.GOLD).withItalic(true))
                .withMaxLineLength(32)
                .build();
    }
}
