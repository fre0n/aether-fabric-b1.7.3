package com.matthewperiut.aether.mixin;

import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(World.class)
public abstract class WorldMixin {
  /** Lower the cascading lighting queue size limit */
  @ModifyConstant(
    method = "queueLightUpdate(Lnet/minecraft/world/LightType;IIIIIIZ)V",
    constant = @Constant(intValue = 1000000)
  )
  private int injected(int value) {
    return 75000;
  }
}
