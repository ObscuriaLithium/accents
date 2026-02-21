package dev.obscuria.accents.content.block.entity;

import dev.obscuria.accents.content.registry.AccentsBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public final class SewingStationBlockEntity extends BlockEntity {

    public SewingStationBlockEntity(BlockPos pos, BlockState state) {
        super(AccentsBlockEntities.SEWING_STATION.get(), pos, state);
    }
}
