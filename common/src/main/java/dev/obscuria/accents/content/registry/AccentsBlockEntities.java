package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.block.entity.SewingStationBlockEntity;
import dev.obscuria.fragmentum.FragmentumFactory;
import dev.obscuria.fragmentum.content.registry.DeferredBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public interface AccentsBlockEntities {

    DeferredBlockEntity<SewingStationBlockEntity> SEWING_STATION = register("sewing_station", () -> FragmentumFactory.newBlockEntityType(SewingStationBlockEntity::new, AccentsBlocks.SEWING_STATION.get()).build(null));

    private static <T extends BlockEntity> DeferredBlockEntity<T> register(String name, Supplier<BlockEntityType<T>> supplier) {
        return AccentsRegistries.REGISTRAR.registerBlockEntity(Accents.key(name), supplier);
    }

    static void init() {}
}
