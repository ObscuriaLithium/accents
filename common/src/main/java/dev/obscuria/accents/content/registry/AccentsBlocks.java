package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.block.SewingStationBlock;
import dev.obscuria.fragmentum.content.registry.Deferred;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

public interface AccentsBlocks {

    Deferred<SewingStationBlock> SEWING_STATION = register("sewing_station", SewingStationBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).strength(3f));

    private static <T extends Block> Deferred<T> register(String name, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties properties) {
        var identifier = Accents.identifier(name);
        Supplier<T> supplier = () -> factory.apply(properties.setId(ResourceKey.create(Registries.BLOCK, identifier)));
        return AccentsRegistries.REGISTRAR.register(Registries.BLOCK, identifier, supplier);
    }

    static void init() {}
}
