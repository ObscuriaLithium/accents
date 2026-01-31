package dev.obscuria.accents.fabric.content.item;

import dev.obscuria.accents.client.renderer.VanityRenderer;
import dev.obscuria.accents.content.item.VanityItem;
import dev.obscuria.accents.fabric.client.FabricVanityRendererProvider;
import net.minecraft.world.item.ArmorMaterial;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class FabricVanityArmorItem extends VanityItem {

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    protected FabricVanityArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    public abstract VanityRenderer<?> createVanityRenderer();

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new FabricVanityRendererProvider(this));
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }
}
