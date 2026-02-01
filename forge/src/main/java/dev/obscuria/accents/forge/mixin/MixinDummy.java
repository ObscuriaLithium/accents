package dev.obscuria.accents.forge.mixin;

import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;

// Because of the well-designed Forge (nope)
@Mixin(value = MinecraftForge.class, remap = false)
public abstract class MixinDummy {}
