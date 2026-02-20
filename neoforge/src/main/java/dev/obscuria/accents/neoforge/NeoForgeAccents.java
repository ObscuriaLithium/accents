package dev.obscuria.accents.neoforge;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.compat.AccentsCompats;
import dev.obscuria.accents.neoforge.client.NeoForgeAccentsClient;
import dev.obscuria.accents.neoforge.compat.CuriosCompat;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(Accents.MODID)
public final class NeoForgeAccents {

    public NeoForgeAccents(IEventBus eventBus) {
        Accents.init();
        if (FMLEnvironment.dist.isClient())
            NeoForgeAccentsClient.init();
        eventBus.addListener(this::initCompats);
    }

    private void initCompats(final FMLCommonSetupEvent event) {
        if (AccentsCompats.CURIOS.isLoaded())
            CuriosCompat.init();
    }
}