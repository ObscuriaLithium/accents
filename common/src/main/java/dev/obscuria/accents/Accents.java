package dev.obscuria.accents;

import dev.obscuria.accents.config.CommonConfig;
import dev.obscuria.accents.content.registry.AccentsRegistries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Accents {

    public static final String MODID = "accents";
    public static final String DISPLAY_NAME = "Accents";
    public static final Logger LOGGER = LoggerFactory.getLogger(DISPLAY_NAME);

    public static ResourceLocation key(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }

    public static void init() {
        CommonConfig.init();
        AccentsRegistries.init();
    }
}
