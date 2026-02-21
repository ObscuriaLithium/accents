package dev.obscuria.accents;

import dev.obscuria.accents.client.ClientPayloadListener;
import dev.obscuria.accents.config.CommonConfig;
import dev.obscuria.accents.content.network.ClientboundSewingRecipesPayload;
import dev.obscuria.accents.content.registry.AccentsRegistries;
import dev.obscuria.fragmentum.content.network.FragmentumNetworking;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Accents {

    public static final String MODID = "accents";
    public static final String DISPLAY_NAME = "Accents";
    public static final Logger LOGGER = LoggerFactory.getLogger(DISPLAY_NAME);

    public static Identifier identifier(String name) {
        return Identifier.fromNamespaceAndPath(MODID, name);
    }

    public static void init() {
        CommonConfig.init();
        AccentsRegistries.init();
        registerPayloads();
    }

    private static void registerPayloads() {
        final var registrar = FragmentumNetworking.registrar(MODID);
        registrar.registerClientbound(
                ClientboundSewingRecipesPayload.class,
                ClientboundSewingRecipesPayload.TYPE,
                ClientboundSewingRecipesPayload.STREAM_CODEC,
                ClientPayloadListener::handle);
    }
}
