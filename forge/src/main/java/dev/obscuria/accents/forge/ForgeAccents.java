package dev.obscuria.accents.forge;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.compat.AccentsCompats;
import dev.obscuria.accents.forge.client.ForgeAccentsClient;
import dev.obscuria.accents.forge.compat.CuriosCompat;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Accents.MODID)
public final class ForgeAccents {

    public ForgeAccents() {
        Accents.init();
        if (FMLEnvironment.dist.isClient())
            ForgeAccentsClient.init();
        var eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::initCompats);
    }

    private void initCompats(final FMLCommonSetupEvent event) {
        if (AccentsCompats.CURIOS.isLoaded())
            CuriosCompat.init();
    }
}