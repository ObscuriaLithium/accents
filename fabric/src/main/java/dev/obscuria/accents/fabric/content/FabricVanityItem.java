package dev.obscuria.accents.fabric.content;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import dev.obscuria.accents.compat.AccentsCompats;
import dev.obscuria.accents.content.Vanity;
import dev.obscuria.accents.content.item.VanityItem;
import dev.obscuria.accents.fabric.client.FabricVanityRendererProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class FabricVanityItem extends VanityItem {

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public FabricVanityItem(boolean glowing, Vanity vanity, Properties properties) {
        super(glowing, vanity, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return vanity.isTrinket() && AccentsCompats.TRINKETS.isLoaded()
                ? HashMultimap.create()
                : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new FabricVanityRendererProvider(this));
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }
}
