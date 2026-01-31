package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.block.SewingStationBlock;
import dev.obscuria.fragmentum.registry.DeferredBlock;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface AccentsBlocks {

    DeferredBlock<SewingStationBlock> SEWING_STATION = register("sewing_station", SewingStationBlock::new);

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> supplier) {
        return AccentsRegistries.REGISTRAR.registerBlock(Accents.key(name), supplier);
    }

    static void init() {}
}
