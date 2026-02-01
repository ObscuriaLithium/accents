package dev.obscuria.accents;

import dev.obscuria.accents.config.CommonConfig;
import dev.obscuria.accents.content.IVanityProvider;
import dev.obscuria.accents.content.registry.AccentsRegistries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

import java.util.ServiceLoader;

public final class Accents {

    public static final String MODID = "accents";
    public static final String DISPLAY_NAME = "Accents";
    public static final Logger LOGGER = LoggerFactory.getLogger(DISPLAY_NAME);
    public static final IVanityProvider FACTORY;

    public static ResourceLocation key(String name) {
        return new ResourceLocation(MODID, name);
    }

    public static void init() {
        CommonConfig.init();
        AccentsRegistries.init();
        GeckoLib.initialize();
    }

    static {
        FACTORY = ServiceLoader.load(IVanityProvider.class).findFirst().orElseThrow();
    }
}
